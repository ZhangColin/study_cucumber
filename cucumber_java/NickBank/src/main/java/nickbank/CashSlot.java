package nickbank;

/**
 * Created by Administrator on 2016/3/19.
 */
public class CashSlot {
    private int _contents;

    public int getContents() {
        return _contents;
    }

    public void dispense(int yuans) {
        _contents = yuans;
    }
}
