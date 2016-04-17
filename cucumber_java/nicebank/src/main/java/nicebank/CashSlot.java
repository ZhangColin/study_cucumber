package nicebank;

public class CashSlot {
    private int _contents;
    private int _available;

    public void load(int dollars){
        _available = dollars;
    }

    public int getContents() {
        return _contents;
    }

    public void dispense(int requested) {
        if (_available >=requested){
            _contents = requested;
            _available -=requested;
        }
        else {
            throw new RuntimeException("Insufficient ATM funds");
        }
    }

    public boolean canDispense(int requested){
        return requested<=_available;
    }
}
