package com.padcmyanmar.simplehabit.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.adapters.SeriesAdapter;
import com.padcmyanmar.simplehabit.adapters.SimpleHabitAdapter;
import com.padcmyanmar.simplehabit.events.HomeReadyEvent;
import com.padcmyanmar.simplehabit.fragments.OnTheGoFragment;
import com.padcmyanmar.simplehabit.fragments.SeriesFragment;
import com.padcmyanmar.simplehabit.fragments.TeacherFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_simple_habit)
    ViewPager vpSimpleHabit;

    @BindView(R.id.tb_simple_habit)
    TabLayout tbSimpleHabit;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    private SimpleHabitAdapter mSimpleHabitAdapter;

    private SeriesAdapter seriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle(R.string.title_simple_habit);
        }
        mSimpleHabitAdapter=new SimpleHabitAdapter(getSupportFragmentManager());
        vpSimpleHabit.setAdapter(mSimpleHabitAdapter);

        mSimpleHabitAdapter.addTab("ON THE GO",new OnTheGoFragment());
        mSimpleHabitAdapter.addTab("SERIES",new SeriesFragment());
        mSimpleHabitAdapter.addTab("TEACHERS",new TeacherFragment());

        tbSimpleHabit.setupWithViewPager(vpSimpleHabit);
        vpSimpleHabit.setOffscreenPageLimit(mSimpleHabitAdapter.getCount());

        Menu menu=bottomNavigationView.getMenu();
        MenuItem menuItem=menu.getItem(0);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_meditate:

                        break;
                    case R.id.action_me:
                        Intent intent_me=new Intent(MainActivity.this,MeActivity.class);
                        startActivity(intent_me);
                        break;
                    case R.id.action_more:
                        Intent intent_more=new Intent(MainActivity.this,MoreActivity.class);
                        startActivity(intent_more);
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
