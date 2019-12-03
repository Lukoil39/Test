package com.geekbrains.a1l3_activity;

public class MainActivityPresenter {
    IMainActivityView view;

    MainActivityPresenter(IMainActivityView view) {
        this.view = view;
    }

    String getIncreasedValue(String value) {
        try {
            int valueInt = Integer.parseInt(value);
            return String.valueOf(++valueInt);
        } catch (Exception exception) {
            return "0";
        }
    }
}
