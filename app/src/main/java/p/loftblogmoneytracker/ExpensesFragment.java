package p.loftblogmoneytracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExpensesFragment extends Fragment {
    private ExpensesAdapter expensesAdapter;
    FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;

//    final static String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expenses_fragment, container, false);
        List<Expense> adapterData = getDataList();
        expensesAdapter = new ExpensesAdapter(adapterData);

        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_content);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(expensesAdapter);
        getActivity().setTitle(R.string.nav_drawer_expenses);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(recyclerView, "pressed", Snackbar.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private List<Expense> getDataList() {
        List<Expense> data = new ArrayList<>();
//        data.add(new Expense("Telephone", 2000));
//        data.add(new Expense("T-Shirts", 3000));
//        data.add(new Expense("Jeans", 1000));
//        data.add(new Expense("Snickers", 2000));
//        data.add(new Expense("Bar", 3000));
//        data.add(new Expense("Cafe", 1000));
//        data.add(new Expense("Telephone1", 2000));
//        data.add(new Expense("T-Shirts1", 3000));
//        data.add(new Expense("Jeans1", 1000));
//        data.add(new Expense("Snickers1", 2000));
//        data.add(new Expense("Bar1", 3000));
//        data.add(new Expense("Cafe1", 1000));
//        data.add(new Expense("Telephone2", 2000));
//        data.add(new Expense("T-Shirts2", 3000));
//        data.add(new Expense("Jeans2", 1000));
//        data.add(new Expense("Snickers2", 2000));
//        data.add(new Expense("Bar2", 3000));
//        data.add(new Expense("Cafe2", 1000));
//        data.add(new Expense("Telephone3", 2000));
//        data.add(new Expense("T-Shirts3", 3000));
//        data.add(new Expense("Jeans3", 1000));
//        data.add(new Expense("Snickers3", 2000));
//        data.add(new Expense("Bar3", 3000));
//        data.add(new Expense("Cafe3", 1000));


        Calendar myCalendar = Calendar.getInstance();

        for (int i = 1; i < 101; i++) {
            data.add(new Expense("Telephone" + i, i * 1000, myCalendar.getTime()));
            myCalendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        return data;
    }

}
