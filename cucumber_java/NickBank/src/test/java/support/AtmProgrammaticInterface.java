package support;

import nickbank.Account;
import nickbank.AutomatedTeller;
import nickbank.CashSlot;
import org.springframework.beans.factory.annotation.Autowired;

public class AtmProgrammaticInterface implements AtmInterface {
    @Autowired
    private CashSlot cashSlot;

    private RuntimeException runtimeException;

    @Override
    public void type(int amount) {

    }

    @Override
    public boolean isDisplaying(String message) {
        return true;
    }

    @Override
    public void withdrawFrom(Account myAccount, int yuans) {
        try {
            AutomatedTeller.withdrawFrom(cashSlot, myAccount, yuans);
        }
        catch (RuntimeException e){
            runtimeException = e;
        }
    }
}
