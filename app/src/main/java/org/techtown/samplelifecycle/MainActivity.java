package org.techtown.samplelifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;

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
        Toast.makeText(this, "onPause 호출됨", Toast.LENGTH_LONG).show();
        saveState(); //현재 입력상자에 입력된 데이터를 저장
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy 호출됨", Toast.LENGTH_LONG).show();
        restoreState(); //설정 정보에 저장된 데이터를 복원
    }

    public void println(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        Log.d("Main", data);
    }

    protected void restoreState() { //복원하는 메서드
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("name"))) {
            String name = pref.getString("name", "");
            nameInput.setText(name);
        }
    }

    protected void saveState() { //저장하는 메서드
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit(); // SharedPreferences.Editor 객체는 데이터를 저장 할 수 있는 edit() 메서드를 제공한다.
        editor.putString("name", nameInput.getText().toString()); //저장하려는 데이터를 설정할 수 있다.
        editor.commit(); //실질적으로 마지막에 커밋 메서드를 사용해야 완벽히 저장.
    }

    protected void clearState() { //위와 동일 // 예제를 보고 만들기는 했는데 이 메서드는 왜 만든지 모르겠음
        SharedPreferences pref = getSharedPreferences("name", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}