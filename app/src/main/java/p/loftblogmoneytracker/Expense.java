package p.loftblogmoneytracker;

import java.util.Date;

public class Expense {

    public String title;
    public int sum;
    public Date curDate;

    public Expense(String title, int sum, Date curDate) {
        this.title = title;
        this.sum = sum;
        this.curDate = curDate;
    }

}
