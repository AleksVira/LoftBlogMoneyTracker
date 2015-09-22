package p.loftblogmoneytracker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.CardViewHolder> {
    List<Expense> expenses;

//    final static String LOG_TAG = MainActivity.class.getSimpleName();

    public ExpensesAdapter(List<Expense> expenses) {
        this.expenses = expenses;
    }

    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CardViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Expense expense = expenses.get(position);
        holder.name.setText(expense.title);
        holder.sum.setText(expense.sum + "");
        holder.date.setText(formatter.format(expense.curDate.getTime()));
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }


    public class CardViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView sum;
        protected TextView date;

        public CardViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name_text);
            sum = (TextView) itemView.findViewById(R.id.sum_text);
            date = (TextView) itemView.findViewById(R.id.date_text);

            Random rand = new Random();
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            int randomColor = Color.rgb(r, g, b);
            name.setTextColor(randomColor);
            sum.setTextColor(sum.getResources().getColor(R.color.dark_primary));
            date.setTextColor(date.getResources().getColor(R.color.dark_primary));
        }
    }

}
