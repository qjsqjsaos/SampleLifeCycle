package org.techtown.samplelifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate 호출됨.", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        println("onStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        println("onStop 호출됨");
    }

    @Override
    protected void onResume() {
        super.onResume();
        println("onResume 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        println("onPause 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        println("onDestroy 호출됨");
    }

    public void println(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        Log.d("Main", data);
    }
}