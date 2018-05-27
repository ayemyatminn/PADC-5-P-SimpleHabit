package com.padcmyanmar.simplehabit.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.padcmyanmar.simplehabit.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/17/2018.
 */

public class OnTheGoFragment extends BaseFragment {
    @BindView(R.id.pc_on_the_go)
    PieChart pcOnTheGo;

    int showmode[]={R.drawable.le, R.drawable.le, R.drawable.le, R.drawable.le, R.drawable.le, R.drawable.le,
            R.drawable.le, R.drawable.le, R.drawable.le, R.drawable.le};

    String dailyroute[]={"Morning","Taking A Break","Commute","Walking","At Work","Big Event","SOS","Tough Day",
            "After Work","Sleep"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_on_the_go,container,false);
        ButterKnife.bind(this,view);

        List<PieEntry> pieEntries=new ArrayList<>();
        for (int i=0;i<dailyroute.length;i++){
            pieEntries.add(new PieEntry(showmode[i],dailyroute[i]));
        }

        PieDataSet pieDataSet=new PieDataSet(pieEntries,"Showing Testing");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData=new PieData(pieDataSet);

        pcOnTheGo.setData(pieData);
        pcOnTheGo.setCenterText("What are you doing?");
        
        pcOnTheGo.invalidate();
        pcOnTheGo.animateY(1000);

        return view;
    }
}
