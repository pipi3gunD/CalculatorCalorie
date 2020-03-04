package com.eduard.caloriecounter.presentation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.eduard.caloriecounter.R;
import com.eduard.caloriecounter.presentation.base.BaseFragment;
import com.eduard.caloriecounter.presentation.presenter.CollectionContract;
import com.eduard.caloriecounter.presentation.presenter.CollectionPresenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CollectionFragment extends BaseFragment implements CollectionContract.View, View.OnClickListener {

//    @Inject
//    CollectionPresenter collectionPresenter;

    private CollectionContract.Presenter presenter;
    private DialogFragment loadingFragment = DialogLoadingFragment.getInstance();

    @Override
    public void onPreparePresenter() {
        attachPresenter((CollectionPresenter) presenter, this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = new CollectionPresenter();
        return inflater.inflate(R.layout.collection_of_info_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().findViewById(R.id.btn_generate).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText etWeight=getView().findViewById(R.id.et_Weight);
        EditText etHeight=getView().findViewById(R.id.et_Height);
        EditText etAge=getView().findViewById(R.id.et_Age);
        RadioButton rb_Male = getView().findViewById(R.id.rb_Male);
        RadioButton rb_Female = getView().findViewById(R.id.rb_Female);


        if (rb_Male.isChecked() == true) {
            presenter.collectionInfoMale(Double.valueOf(etWeight.getText().toString()),
                    Double.valueOf(etHeight.getText().toString()),
                    Double.valueOf(etAge.getText().toString()));
        }else if(rb_Female.isChecked() == true) {
            presenter.collectionInfoFemale(Double.valueOf(etWeight.getText().toString()),
                    Double.valueOf(etHeight.getText().toString()),
                    Double.valueOf(etAge.getText().toString()));
        }
    }

    @Override
    public void setViewData(String data) {
        TextView tvInfo=getView().findViewById(R.id.tv_info_test);
        tvInfo.setText(data);
    }

    @Override
    public void showProgressBar() {
        if (!loadingFragment.isVisible()) {
            loadingFragment.show(getActivity().getSupportFragmentManager(), "LOADING");
        }
    }

    @Override
    public void hideProgressBar() {
            if (loadingFragment.isVisible()) {
                loadingFragment.dismiss();
            }
    }

    @Override
    public void showError() {
    }

//    protected void onInjection() {
//        DaggerCalculatorComponents.builder()
//                .appComponent(CalculatorApp.getComponent())
//                .presentationModule(new PresentationModule())
//                .build()
//                .inject(this);
//    }

}
