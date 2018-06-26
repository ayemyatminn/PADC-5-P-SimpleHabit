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
import com.padcmyanmar.simplehabit.mvp.presenters.DetailScreenPresenter;
import com.padcmyanmar.simplehabit.mvp.views.DetailScreenView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 5/30/2018.
 */

public class ProgramDetailActivity extends BaseActivity implements DetailScreenView{

    @BindView(R.id.rv_session)
    RecyclerView rvSession;

    @BindView(R.id.tv_meditation_title)
    TextView tvMeditationTitle;

    @BindView(R.id.tv_meditation_brief)
    TextView tvMeditationBrief;

    @BindView(R.id.fab_meditation)
    FloatingActionButton fabMeditation;

    private SessionAdapter mSessionAdapter;

    private DetailScreenPresenter mPresenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ProgramDetailActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE, SimpleHabitApp.CURRENT_PROGRAM);
        return intent;
    }

    public static Intent newIntent(Context context, String categoryId, String categoryProgramId) {
        Intent intent = new Intent(context, ProgramDetailActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE,SimpleHabitApp.CATEGORY_ID);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE,SimpleHabitApp.PROGRAM_ID);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_detail);
        ButterKnife.bind(this, this);

        mPresenter=new DetailScreenPresenter(this);
        mPresenter.onCreate();

        mSessionAdapter = new SessionAdapter(getApplicationContext());
        LinearLayoutManager linearLayoutManagerSession = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvSession.setAdapter(mSessionAdapter);
        rvSession.setLayoutManager(linearLayoutManagerSession);

        if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CURRENT_PROGRAM)) {

            mPresenter.onFinishUIComponentSetUpForCurrent();


        } else if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CATEGORY)) {
            String categoryId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_ID);
            String categoryProgramId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID);

            mPresenter.onFinishUIComponentsetUpForCategory(categoryId,categoryProgramId);

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void displayErrorMessage(String errorMessage) {

    }


    @Override
    public void displayCurrentDetailScreen(CurrentProgramVO currentProgramVO) {
        mSessionAdapter.setData(currentProgramVO.getSession());
        tvMeditationTitle.setText(currentProgramVO.getTitle());
        tvMeditationBrief.setText(currentProgramVO.getDescription());
    }

    @Override
    public void displayCategoryDetailScreen(ProgramVO currentProgramVO) {
        mSessionAdapter.setData(currentProgramVO.getSessions());
        tvMeditationTitle.setText(currentProgramVO.getTitle());
        tvMeditationBrief.setText(currentProgramVO.getDescription());
    }


}
