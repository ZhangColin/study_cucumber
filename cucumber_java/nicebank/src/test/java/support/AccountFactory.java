package support;

import nicebank.Account;
import nicebank.AccountRepository;

public class AccountFactory {
    public static Account createTestAccount(){
        return AccountRepository.get(1234);
    }
}
