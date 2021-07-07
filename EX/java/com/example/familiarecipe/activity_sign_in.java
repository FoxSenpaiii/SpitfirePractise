package com.example.familiarecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class activity_sign_in extends AppCompatActivity {
    String email, password;
    EditText ed1, ed2;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ed1 = findViewById(R.id.editTextTextEmailAddress);
        ed2 = findViewById(R.id.editTextTextPassword);
        dbHelper = new DBHelper(this);
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void signin_back(View view) {
        email = ed1.getText().toString();
        password = ed2.getText().toString();
        if (isEmailValid(email)) {
            if (password.length() >= 8) {
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                Cursor cursor = database.query(DBHelper.TABLE_USER_INFO, null, null, null, null, null, null);
                ContentValues contentValues = new ContentValues();

            }
            else {
                Toast.makeText(getApplicationContext(),"Password length < 8",Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
        }
    }

    public void signin_onclick(View view) {

    }
}