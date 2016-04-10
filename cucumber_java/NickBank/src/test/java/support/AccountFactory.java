package support;

import nickbank.Account;
import nickbank.AccountRepository;

public class AccountFactory {
    public static Account createTestAccount(){
        return AccountRepository.get(1234);
    }
}
