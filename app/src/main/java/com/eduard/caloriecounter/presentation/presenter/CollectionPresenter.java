package com.eduard.caloriecounter.presentation.presenter;

import com.eduard.caloriecounter.presentation.base.BasePresenter;
import com.eduard.caloriecounter.presentation.utils.CalculatorUserModel;

public class CollectionPresenter extends BasePresenter<CollectionContract.View> implements CollectionContract.Presenter {

    private CollectionContract.Model model;

    public CollectionPresenter() {
    }

    @Override
    public void collectionInfoMale(double weight, double height, double age, int level) {
        model = new CalculatorUserModel();
        String data = String.valueOf(model.operationMale(weight, height, age, level));
        getView().showInformationDialog("Your result =" + data);
    }

    @Override
    public void collectionInfoFemale(double weight, double height, double age, int level) {
        model = new CalculatorUserModel();
        String data = String.valueOf(model.operationFemale(weight, height, age, level));
        getView().showInformationDialog("Your result =" + data);
    }
}

