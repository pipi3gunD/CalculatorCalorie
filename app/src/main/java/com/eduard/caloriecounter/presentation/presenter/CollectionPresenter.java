package com.eduard.caloriecounter.presentation.presenter;

import com.eduard.caloriecounter.presentation.base.BasePresenter;
import com.eduard.caloriecounter.presentation.utils.CalculatorUserModel;

public class CollectionPresenter extends BasePresenter<CollectionContract.View> implements CollectionContract.Presenter {

    private CollectionContract.Model model;

    public CollectionPresenter() {
    }

    @Override
    public void collectionInfoMale(double weight, double height, double age) {
        model = new CalculatorUserModel();
        String data = String.valueOf(model.operationMale(weight,height,age));
        getView().setViewData(data);
    }

    @Override
    public void collectionInfoFemale(double weight, double height, double age) {
        model = new CalculatorUserModel();
        String data = String.valueOf(model.operationFemale(weight,height,age));
        getView().setViewData(data);
    }
}

//Формула Харриса-Бенедикта
//        для мужчин: BMR = 88.36 + (13.4 x вес, кг) + (4.8 х рост, см) – (5.7 х возраст, лет)
//        для женщин: BMR = 447.6 + (9.2 x вес, кг) + (3.1 х рост, cм) – (4.3 х возраст, лет)

//+суточная активность
//        Норма калорий = BMR x Уровень активности = 1765 х 1.55 = 2735 ккал