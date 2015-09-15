package p.loftblogmoneytracker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Aleks on 06.09.2015.
 */
public class TransactionAdapter extends ArrayAdapter<Transaction> {
    private List<Transaction> transactions;
    public TransactionAdapter(Context context, List<Transaction> transactions) {
        super(context, 0, transactions);
        this.transactions = transactions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Transaction transaction = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView textTitle = (TextView) convertView.findViewById(R.id.name_text);
        TextView sumTitle = (TextView) convertView.findViewById(R.id.sum_text);
        TextView dateTitle = (TextView) convertView.findViewById(R.id.date_text);

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        textTitle.setText(transaction.title);
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        int randomColor = Color.rgb(r, g, b);
        textTitle.setBackgroundColor(randomColor);
        sumTitle.setText(Integer.toString(transaction.sum));
        sumTitle.setBackgroundResource(R.color.slate_blue);
        dateTitle.setText(formatter.format(transaction.curDate.getTime()));
        dateTitle.setBackgroundResource(R.color.sky_blue);

        return convertView;
    }
}
