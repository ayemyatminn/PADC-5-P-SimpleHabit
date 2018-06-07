package com.padcmyanmar.simplehabit.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;

import com.padcmyanmar.simplehabit.R;
import com.padcmyanmar.simplehabit.SimpleHabitApp;
import com.padcmyanmar.simplehabit.adapters.SessionAdapter;
import com.padcmyanmar.simplehabit.data.model.SimpleHabitModel;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramVO;
import com.padcmyanmar.simplehabit.data.vo.ProgramVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/30/2018.
 */

public class ProgramDetailActivity extends BaseActivity {

    @BindView(R.id.rv_session)
    RecyclerView rvSession;

    @BindView(R.id.tv_meditation_title)
    TextView tvMeditationTitle;

    @BindView(R.id.tv_meditation_brief)
    TextView tvMeditationBrief;

    @BindView(R.id.fab_meditation)
    FloatingActionButton fabMeditation;

    private SessionAdapter mSessionAdapter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ProgramDetailActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE, SimpleHabitApp.CURRENT_PROGRAM);
        return intent;
    }

    public static Intent newIntent(Context context, String categoryId, String categoryProgramId) {
        Intent intent = new Intent(context, ProgramDetailActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_detail);
        ButterKnife.bind(this, this);

        mSessionAdapter = new SessionAdapter(getApplicationContext());
        LinearLayoutManager linearLayoutManagerSession = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvSession.setAdapter(mSessionAdapter);
        rvSession.setLayoutManager(linearLayoutManagerSession);

        if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CURRENT_PROGRAM)) {
            CurrentProgramVO currentProgram = SimpleHabitModel.getSobjInstance().getCurrentProgram();
            mSessionAdapter.setData(currentProgram.getSession());
            tvMeditationTitle.setText(currentProgram.getTitle());
            tvMeditationBrief.setText(currentProgram.getDescription());
        } else if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CATEGORY)) {
            String categoryId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_ID);
            String categoryProgramId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID);
            ProgramVO categoryProgram = SimpleHabitModel.getSobjInstance().getProgram(categoryId, categoryProgramId);
            mSessionAdapter.setData(categoryProgram.getSessions());
            tvMeditationTitle.setText(categoryProgram.getTitle());
            tvMeditationBrief.setText(categoryProgram.getDescription());

        }
    }


}
