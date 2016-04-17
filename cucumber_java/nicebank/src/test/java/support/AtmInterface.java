package support;

import nicebank.Teller;

public interface AtmInterface extends Teller {
    void type(int amount);
    boolean isDisplaying(String message);
}
