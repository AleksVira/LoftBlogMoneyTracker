package p.loftblogmoneytracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CategoriesFragment extends Fragment {
    private ListView listView;
    private SimpleTransactionAdapter transactionAdapter;
    private FloatingActionButton floatingActionButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categories_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.listview);
        List<Expense> adapterData = getDataList();
        transactionAdapter = new SimpleTransactionAdapter(getActivity(), adapterData);
        listView.setAdapter(transactionAdapter);
        getActivity().setTitle(R.string.nav_drawer_categories);

        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab2);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(listView, "pressed", Snackbar.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    private List<Expense> getDataList() {
        List<Expense> data = new ArrayList<>();
        Calendar myCalendar = Calendar.getInstance();
        data.add(new Expense("Поле 1", 111, myCalendar.getTime()));
        data.add(new Expense("Поле 2", 222, myCalendar.getTime()));
        data.add(new Expense("Поле 3", 333, myCalendar.getTime()));
        data.add(new Expense("Поле 4", 111, myCalendar.getTime()));
        data.add(new Expense("Поле 5", 222, myCalendar.getTime()));
        data.add(new Expense("Поле 6", 333, myCalendar.getTime()));
        data.add(new Expense("Поле 7", 111, myCalendar.getTime()));
        data.add(new Expense("Поле 8", 222, myCalendar.getTime()));
        data.add(new Expense("Поле 9", 333, myCalendar.getTime()));
        data.add(new Expense("Поле 10", 111, myCalendar.getTime()));
        data.add(new Expense("Поле 11", 222, myCalendar.getTime()));
        data.add(new Expense("Поле 12", 333, myCalendar.getTime()));
        data.add(new Expense("Поле 13", 111, myCalendar.getTime()));
        data.add(new Expense("Поле 14", 222, myCalendar.getTime()));
        data.add(new Expense("Поле 15", 333, myCalendar.getTime()));
        data.add(new Expense("Поле 16", 111, myCalendar.getTime()));
        data.add(new Expense("Поле 17", 222, myCalendar.getTime()));
        data.add(new Expense("Поле 18", 333, myCalendar.getTime()));
        return data;
    }

}
