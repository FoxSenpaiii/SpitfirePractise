package com.example.familiarecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class launch_screen extends AppCompatActivity {
    /*@Override
    protected void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        Intent i;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //Toast.makeText(getApplicationContext(),"Internet", Toast.LENGTH_SHORT).show();
            i = new Intent(this, main_screens.class);
            startActivity(i);
            finish();
        }
        else {
            //Toast.makeText(getApplicationContext(),"No internet",Toast.LENGTH_SHORT).show();
            i = new Intent(this, network_error.class);
            startActivity(i);
            finish();

        }

        /*ImageView iv1 = findViewById(R.id.launch_a_logotype);
        iv1.setAnimation(AnimationUtils.loadAnimation(this, R.anim.animation_main_button_bottom));

        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.animation_main_edittext2);
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.animation_main_text1);
        Animation anim3 = AnimationUtils.loadAnimation(this, R.anim.animation_main_text3);
        Animation anim4 = AnimationUtils.loadAnimation(this, R.anim.animation_main_edittext4);
        Animation anim5 = AnimationUtils.loadAnimation(this, R.anim.animation_main_logo);
        Animation anim6 = AnimationUtils.loadAnimation(this, R.anim.fromthehigh);
        Animation anim7 = AnimationUtils.loadAnimation(this, R.anim.righthigh);
        Animation anim8 = AnimationUtils.loadAnimation(this, R.anim.lefthigh);
         */
    }
}