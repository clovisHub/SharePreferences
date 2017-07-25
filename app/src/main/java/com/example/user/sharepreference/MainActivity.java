package com.example.user.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String PREFER_NAME ="MyAppSettings";
    EditText name;
    EditText lastName;
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        lastName =(EditText)findViewById(R.id.lastName);

    }

    public void Save(View view) {

        String myNameValue = name.getText().toString();
        String myLastNameValue = lastName.getText().toString();

        EntryUI user = new EntryUI(myNameValue,myLastNameValue);

        settings = getSharedPreferences(PREFER_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("name",user.getName());
        editor.putString("lastName",user.getLastName());
        editor.commit();
        //clear
        name.setText("");
        lastName.setText("");
    }

    public void displayName(View view) {

        String name = settings.getString("name","");
        Toast.makeText(this,name, Toast.LENGTH_SHORT).show();
    }

    public void displayLastName(View view) {

        String name = settings.getString("lastName","");
        Toast.makeText(this,name, Toast.LENGTH_SHORT).show();
    }

    public void uploadInfo(View view) {

        String nameLo =  settings.getString("name","");
        String lastNameLo =  settings.getString("lastName","");

        name.setText(nameLo);
        lastName.setText(lastNameLo);
    }
}
