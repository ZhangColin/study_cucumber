package nickbank;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.javalite.activejdbc.Base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/26.
 */
public class TransactionProcessor {
    private TransactionQueue queue = new TransactionQueue();

    public void process(){
        /*if (!Base.hasConnection()){
            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/bank", "teller", "password");
        }*/
        do {
            String message = queue.read();

            if (message.length()>0){
                String[] parts = message.split(",");

                //Account account = Account.findFirst("number = ?", parts[1]);

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
