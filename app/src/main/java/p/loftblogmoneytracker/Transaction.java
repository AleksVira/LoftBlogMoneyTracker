package p.loftblogmoneytracker;

import java.util.Date;

/**
 * Created by Aleks on 06.09.2015.
 */
public class Transaction {

    public String title;
    public int sum;
    public Date curDate;

    public Transaction(String title, int sum, Date curDate) {
        this.title = title;
        this.sum = sum;
        this.curDate = curDate;
    }

}
