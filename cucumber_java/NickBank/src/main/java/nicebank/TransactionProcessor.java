package nicebank;

public class TransactionProcessor {
    private TransactionQueue queue = new TransactionQueue();

    public void process(){
        do {
            String message = queue.read();

            if (message!=null && message.length()>0){
                String[] parts = message.split(",");

                Account account = AccountRepository.get(Integer.parseInt(parts[1]));

                if (account==null){
                    throw new RuntimeException("Account number not found: "+parts[1]);
                }

                Money transactionAmount = new Money(parts[0]);

                if (isCreditTransaction(message)){
                    account.setBalance(account.getBalance().add(transactionAmount));
                }
                else {
                    account.setBalance(account.getBalance().minus(transactionAmount));
                }
                AccountRepository.update(account);
            }
        }while (true);
    }

    private boolean isCreditTransaction(String message) {
        return !message.startsWith("-");
    }
}
