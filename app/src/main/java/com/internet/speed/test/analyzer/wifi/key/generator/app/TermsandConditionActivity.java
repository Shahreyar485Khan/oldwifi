package com.internet.speed.test.analyzer.wifi.key.generator.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TermsandConditionActivity extends AppCompatActivity {
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("PREFSs", 0);
        String chk = preferences.getString("firsttime", "0");

        if (chk.equals("yes")) {
            try {
                startActivity(new Intent(getApplicationContext(), SelectCountry.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {


            setContentView(R.layout.activity_termsand_condition);

        }


    }

    public void acceptbtn(View view) {
        try {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("firsttime", "yes");
            editor.apply();
            startActivity(new Intent(getApplicationContext(), SelectCountry.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void denybtn(View view) {
        finishAffinity();
    }
}
