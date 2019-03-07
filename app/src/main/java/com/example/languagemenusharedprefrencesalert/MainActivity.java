package com.example.languagemenusharedprefrencesalert;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String languageSelected = "English";
    TextView languageDisplay;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_file,menu);
        return super.onCreateOptionsMenu(menu);

        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.spanish:
                languageSelected = "Spanish";
                languageDisplay.setText(languageSelected);
                return true;
            case R.id.Hindi:
                languageSelected = "Hindi";
                languageDisplay.setText(languageSelected);
                return true;
                default:
                    languageSelected = "English";
                    languageDisplay.setText(languageSelected);
                    return false;

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        languageDisplay = (TextView)findViewById(R.id.langDisplay);
        languageDisplay.setText(languageSelected);

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Select Default Language")
                .setPositiveButton("Spanish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        languageSelected = "Spanish";
                        languageDisplay.setText(languageSelected);
                    }
                })
                .setNegativeButton("Hindi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        languageSelected = "Hindi";
                        languageDisplay.setText(languageSelected);
                    }
                })
                .show();

    }
}
