package p.loftblogmoneytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d(LOG_TAG, "onCreate() method called!");
        Button firstButtonFragment = (Button) findViewById(R.id.button_first);
        Button secondButtonFragment = (Button) findViewById(R.id.button_second);

        firstButtonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d(LOG_TAG, "First onClick() method called!!");
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new FirstFragment()).commit();
//                Log.d(LOG_TAG, "First onClick() method called!!!");


            }
        });

        secondButtonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new SecondFragment()).commit();
            }
        });

    }


}
