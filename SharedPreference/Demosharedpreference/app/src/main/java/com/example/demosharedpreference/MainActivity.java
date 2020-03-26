package com.example.demosharedpreference;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {
Button mRedColor;
Button mGreenColor;
Button mYellowColor;
EditText user,pass;
Button login;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
    String usrname;
    String passwrd;
    Integer color1,color2,color3,color4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRedColor = (Button) findViewById(R.id.btnRed);
        mGreenColor = (Button) findViewById(R.id.btnGreen);
        mYellowColor = (Button) findViewById(R.id.btn_Yellow);
        user=(EditText)findViewById(R.id.editText);
        pass = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button);

        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        login.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = M)
            @Override
            public void onClick(View v) {
                colorchangebtn(1);
                login(1);

            }
        });
        mRedColor.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = M)
            @Override
            public void onClick(View v) {
                colorchangebtn(2);
                login(2);

            }
        });
        mGreenColor.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = M)
            @Override
            public void onClick(View v) {
                colorchangebtn(3);
                login(3);

            }
        });
        mYellowColor.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = M)
            @Override
            public void onClick(View v) {
                colorchangebtn(4);
                login(4);

            }
        });
   shared();
    }

    public void shared(){
        user.setText(sharedPreferences.getString("username", null));
        pass.setText(sharedPreferences.getString("password", null));
        login.setBackgroundColor(sharedPreferences.getInt("color1",0));
        mRedColor.setBackgroundColor(sharedPreferences.getInt("color2",0));
        mGreenColor.setBackgroundColor(sharedPreferences.getInt("color3",0));
        mYellowColor.setBackgroundColor(sharedPreferences.getInt("color4",0));
    }
    @RequiresApi(api = M)
    public void colorchangebtn(int i){
        if(i==1){
            user.setText("login");
            pass.setText("password");
            login.setBackgroundColor(getColor(R.color.colorPrimaryDark));
            mRedColor.setBackgroundColor(getColor(R.color.colorGreen));
            mGreenColor.setBackgroundColor(getColor(R.color.colorGreen));
            mYellowColor.setBackgroundColor(getColor(R.color.colorGreen));
        }else if(i==2){
            user.setText("Red");
            pass.setText("Red password");
            login.setBackgroundColor(getColor(R.color.colorGreen));
            mRedColor.setBackgroundColor(getColor(R.color.colorPrimaryDark));
            mGreenColor.setBackgroundColor(getColor(R.color.colorGreen));
            mYellowColor.setBackgroundColor(getColor(R.color.colorGreen));
        }else if(i==3){
            user.setText("green");
            pass.setText("green password");
            login.setBackgroundColor(getColor(R.color.colorGreen));
            mRedColor.setBackgroundColor(getColor(R.color.colorGreen));
            mGreenColor.setBackgroundColor(getColor(R.color.colorPrimaryDark));
            mYellowColor.setBackgroundColor(getColor(R.color.colorGreen));
        }else if(i==4){
            user.setText("yellow");
            pass.setText("yellow password");
            login.setBackgroundColor(getColor(R.color.colorGreen));
            mRedColor.setBackgroundColor(getColor(R.color.colorGreen));
            mGreenColor.setBackgroundColor(getColor(R.color.colorGreen));
            mYellowColor.setBackgroundColor(getColor(R.color.colorPrimaryDark));
        }
    }

    @RequiresApi(api = M)
    public void login(int i){

        if(i==1)
        {
            usrname = "login";
            passwrd = "password";
            color1 = getColor(R.color.colorPrimaryDark);
            color2 = getColor(R.color.colorGreen);;
            color3 = getColor(R.color.colorGreen);
            color4 = getColor(R.color.colorGreen);
        }
        else if(i==2) {
            usrname = "Red";
            passwrd = "Red password";
            color1 = getColor(R.color.colorGreen);
            color2 = getColor(R.color.colorPrimaryDark);;
            color3 = getColor(R.color.colorGreen);
            color4 = getColor(R.color.colorGreen);
        }
        else if(i==3){
            usrname = "green";
            passwrd = "green password";
            color1 = getColor(R.color.colorGreen);
            color2 = getColor(R.color.colorGreen);;
            color3 = getColor(R.color.colorPrimaryDark);
            color4 = getColor(R.color.colorGreen);
        }
        else if(i==4){
            usrname = "yellow";
            passwrd = "yellow password";
            color1 = getColor(R.color.colorGreen);
            color2 = getColor(R.color.colorGreen);;
            color3 = getColor(R.color.colorGreen);
            color4 = getColor(R.color.colorPrimaryDark);
        }

            editor.putString("username",usrname);
            editor.putString("password",passwrd);
            editor.putInt("color1",color1);
            editor.putInt("color2",color2);
            editor.putInt("color3",color3);
            editor.putInt("color4",color4);
            editor.commit();
    }
}
