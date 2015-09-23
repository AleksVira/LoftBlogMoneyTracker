package p.loftblogmoneytracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    final static String LOG_TAG = MainActivity.class.getSimpleName();

    private DrawerLayout drawerLayout;
    private View container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        container = findViewById(R.id.frame_container);
        Log.d(LOG_TAG, "onCreate() запущен");

        initToolbar();
        setupDrawerLayout();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new ExpensesFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView view = (NavigationView) findViewById(R.id.navigation_view);
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerNavigation(menuItem);
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                Snackbar.make(container, menuItem.getTitle() + " pressed", Snackbar.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void drawerNavigation(MenuItem menuItem) {
        Fragment myFragment;

        switch (menuItem.getItemId()) {
            case R.id.drawer_expenses:
                myFragment = new ExpensesFragment();
                break;
            case R.id.drawer_categories:
                myFragment = new CategoriesFragment();
                break;
            case R.id.drawer_statistics:
                myFragment = new StatisticsFragment();
                break;
            case R.id.drawer_settings:
                myFragment = new SettingsFragment();
                break;
            default:
                myFragment = new ExpensesFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, myFragment).addToBackStack(null).commit();

    }

}
