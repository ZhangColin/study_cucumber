package support;

import nickbank.Account;
import nickbank.AccountRepository;

/**
 * Created by Administrator on 2016/3/31.
 */
public class AccountFactory {
    public static Account createTestAccount(){
        return AccountRepository.get(1234);
    }
}
