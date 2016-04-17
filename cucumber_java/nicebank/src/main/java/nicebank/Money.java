package nicebank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Money {
    private int _yuans;
    private int _cents;

    public Money(){
        this._yuans=0;
        this._cents=0;
    }

    public Money(String amount){
        Pattern pattern = Pattern.compile("^[^\\d]*([\\d]+)\\.([\\d][\\d])$");
        Matcher matcher = pattern.matcher(amount);

        matcher.find();
        this._yuans = Integer.parseInt(matcher.group(1));
        this._cents = Integer.parseInt(matcher.group(2));
    }

    public Money(int yuans, int cents) {
        _yuans = yuans;
        _cents = cents;
    }

    public int yuans(){
        return _yuans;
    }

    public int cents(){
        return _cents;
    }

    public Money add(Money amount){
        int newYuans = _yuans+amount.yuans();
        int newCents = _cents+amount.cents();

        if (newCents>=100){
            newCents-=100;
            newYuans++;
        }

        return new Money(newYuans, newCents);
    }

    public Money minus(Money amount){
        int newCents = _cents-amount.cents();
        int newYuans = _yuans-amount.yuans();

        if (newCents<0){
            newCents+=100;
            newYuans--;
        }

        return new Money(newYuans, newCents);
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;

        if (obj instanceof Money) {
            Money other = (Money) obj;
            equal = other.yuans() == this.yuans()
                    && other.cents() == this.cents();
        }

        return equal;
    }

    @Override
    public String toString() {
        return String.format("$%01d.%02d", this.yuans(), this.cents());
    }
}
