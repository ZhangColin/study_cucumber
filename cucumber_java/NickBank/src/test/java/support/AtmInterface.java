package support;

import nickbank.Teller;

public interface AtmInterface extends Teller {
    void type(int amount);
    boolean isDisplaying(String message);
}
