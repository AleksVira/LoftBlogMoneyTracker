package p.loftblogmoneytracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class SimpleTransactionAdapter extends ArrayAdapter<Expense> {
    private List<Expense> transactionses;
    public SimpleTransactionAdapter(Context context, List<Expense> transactionses) {
        super(context, 0, transactionses);
        this.transactionses = transactionses;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Expense transactions = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView textTitle = (TextView) convertView.findViewById(R.id.name_text);
        TextView sumTitle = (TextView) convertView.findViewById(R.id.sum_text);
        TextView dateTitle = (TextView) convertView.findViewById(R.id.date_text);

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        textTitle.setText(transactions.title);
        textTitle.setTextColor(getContext().getResources().getColor(R.color.primary));
        sumTitle.setText(Integer.toString(transactions.sum));
        sumTitle.setTextColor(getContext().getResources().getColor(R.color.dark_primary));
        dateTitle.setText(formatter.format(transactions.curDate.getTime()));
        dateTitle.setTextColor(getContext().getResources().getColor(R.color.dark_primary));

        return convertView;
    }
}
