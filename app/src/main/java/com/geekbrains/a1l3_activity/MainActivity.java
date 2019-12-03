package com.geekbrains.a1l3_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IMainActivityView {
    private TextView textCounter;
    private Button increaseBtn;

    private MainActivityPresenter presenter;
    private final String counterValueKey = "counterValueKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainActivityPresenter(this);

        setContentView(R.layout.activity_main);
        initViews();
        setOnIncreaseBtnClick();

         //SingletonExample singletonExample = SingletonExample.getInstance();
        Toast.makeText(getApplicationContext(), "onCreate()", Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        textCounter = findViewById(R.id.textCounter);
        increaseBtn = findViewById(R.id.increaseButton);
    }

    private void setOnIncreaseBtnClick() {
        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String counterValue = presenter.getIncreasedValue(textCounter.getText().toString());
                textCounter.setText(counterValue);
            }
        });

        //recreate();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //Сейчас портрет. Как-нибудь реагируем на это
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        int counterValue = Integer.parseInt(textCounter.getText().toString());
        String text = String.valueOf(counterValue);
        saveInstanceState.putString(counterValueKey, text);
        super.onSaveInstanceState(saveInstanceState);

        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String counterValue = savedInstanceState.getString(counterValueKey, "0");
        textCounter.setText(counterValue);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
    }

}
