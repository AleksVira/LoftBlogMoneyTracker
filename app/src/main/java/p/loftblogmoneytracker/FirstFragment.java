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

/**
 * Created by Aleks on 09.09.2015.
 */
public class FirstFragment extends Fragment {

    private List<Transaction> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        ListView listView = (ListView) view.findViewById(R.id.main_listView);
        List<Transaction> adapterData = getDataList();
        getActivity().setTitle("First Fragment");
        TransactionAdapter transactionAdapter = new TransactionAdapter(getActivity(), adapterData);
        listView.setAdapter(transactionAdapter);
        return view;

    }

    private List<Transaction> getDataList() {
        Calendar myCalendar = Calendar.getInstance();
        for (int i = 1; i < 6; i++) {
            data.add(new Transaction("Telephone" + i, i * 1000, myCalendar.getTime()));
            myCalendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        return data;
    }

}
