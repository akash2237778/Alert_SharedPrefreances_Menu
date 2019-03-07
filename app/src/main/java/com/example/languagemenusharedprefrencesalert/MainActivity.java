package com.example.languagemenusharedprefrencesalert;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String languageSelected;
    TextView languageDisplay;
    SharedPreferences sharedPreferences;
    int a = 0;


    public void storeSharedPrefrences(String language) {
        sharedPreferences.edit().putString("Last language Selected", language).apply();
        languageDisplay.setText(language);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        sharedPreferences = this.getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        languageSelected = sharedPreferences.getString("Last language Selected", null);
        languageDisplay.setText(languageSelected);
       // a= Integer.parseInt(sharedPreferences.getString("val a", null));

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_file, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.spanish:
                languageSelected = "Spanish";
                storeSharedPrefrences(languageSelected);

                return true;
            case R.id.Hindi:
                languageSelected = "Hindi";

                storeSharedPrefrences(languageSelected);
                return true;
            default:
                languageSelected = "English";

                storeSharedPrefrences(languageSelected);
                return false;

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        languageDisplay = (TextView) findViewById(R.id.langDisplay);
        languageDisplay.setText(languageSelected);

        if (a == 0) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Select Default Language")
                    .setPositiveButton("Spanish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            languageSelected = "Spanish";
                            storeSharedPrefrences(languageSelected);
                            a = 1;
                            sharedPreferences.edit().putString("val a", String.valueOf(a)).apply();
                        }
                    })
                    .setNegativeButton("Hindi", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            languageSelected = "Hindi";
                            storeSharedPrefrences(languageSelected);
                            a = 1;
                            sharedPreferences.edit().putString("val a", String.valueOf(a)).apply();
                        }
                    })
                    .show();

        }
    }
}
