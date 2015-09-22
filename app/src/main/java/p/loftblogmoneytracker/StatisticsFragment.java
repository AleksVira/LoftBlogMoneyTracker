package p.loftblogmoneytracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StatisticsFragment extends Fragment {
    private ListView listView;
    private SimpleTransactionAdapter transactionAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.statistics_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.listview);
        List<Expense> adapterData = getDataList();
        transactionAdapter = new SimpleTransactionAdapter(getActivity(), adapterData);
        listView.setAdapter(transactionAdapter);
        getActivity().setTitle(R.string.nav_drawer_statistics);
        return view;
    }

    private List<Expense> getDataList() {
        List<Expense> data = new ArrayList<>();
        Calendar myCalendar = Calendar.getInstance();
        data.add(new Expense("Поле 4", 444, myCalendar.getTime()));
        data.add(new Expense("Поле 5", 555, myCalendar.getTime()));
        data.add(new Expense("Поле 6", 666, myCalendar.getTime()));
        return data;
    }

}
