package support;


import nickbank.CashSlot;

public class TestCashSlot extends CashSlot {
    private boolean faulty;

    public TestCashSlot() {
        super.load(1000);
    }

    public void inijectFault(){
        faulty = true;
    }

    @Override
    public void dispense(int requested) {
        if (faulty){
            throw new RuntimeException("Out of order");
        }
        else {
            super.dispense(requested);
        }
    }
}
