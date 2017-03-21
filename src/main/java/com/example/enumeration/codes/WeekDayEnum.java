package example.enumeration.codes;

/**
 * Created by root on 17-1-10.
 */
//Define the Enumeration Example.
public enum WeekDayEnum {
    Mon(1), Tue(2), Wed(3), Thu(4), Fri(5), Sat(6), Sun(7);

    private int index;

    WeekDayEnum(int inx) {
        this.index = inx;
    }

    public int getIndex() {
        return this.index;
    }
}