package com.dxballtest.dipanjal.dxball_test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new Game(this));

        this.button=(Button)findViewById(R.id.button2);
    }

    public void switchContext()
    {
        //setContentView(new Game(this));
        //Intent i=new Intent(getApplicationContext(),MenuActivity.class);
        //startActivity(i);
        //Log.d("Intent","Call Menu");
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
