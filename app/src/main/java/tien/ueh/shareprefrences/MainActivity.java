package tien.ueh.shareprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView number;
    Button btnBlack,btnRed,btnBlue,btnGreen,btnCount,btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("number", Context.MODE_PRIVATE);
        number = findViewById(R.id.idNumber);
        btnBlack = findViewById(R.id.btnBlack);
        btnBlue =  findViewById(R.id.btnBlue);
        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);
        btnCount= findViewById(R.id.btnCount);
        btnReset = findViewById(R.id.btnReset);
        int num = sharedPreferences.getInt("count",0);
        number.setText(""+num);
        int color = sharedPreferences.getInt("color", 0);
        number.setBackgroundColor(color);
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(number.getText().toString());
                if(count >= 0){
                    count  = count +1;
                    number.setText(""+count);
                }
            }
        });
        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.setBackgroundColor(getResources().getColor(R.color.green));

            }
        });
        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.setBackgroundColor(getResources().getColor(R.color.red));

            }
        });
        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.setBackgroundColor(getResources().getColor(R.color.blue));

            }
        });
        btnBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number.setBackgroundColor(getResources().getColor(R.color.black));
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                number.setText(""+0);
                number.setBackgroundColor(getResources().getColor(R.color.gray));
                editor.apply();
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("number",Context.MODE_PRIVATE);
        int count=Integer.parseInt(number.getText().toString());
        int color=((ColorDrawable)number.getBackground()).getColor();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("count",count);
        editor.putInt("color",color);
        editor.apply();
    }
}