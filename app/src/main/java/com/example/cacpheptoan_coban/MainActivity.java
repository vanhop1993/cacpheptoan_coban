package com.example.cacpheptoan_coban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText number1, number2;
    Button cong, tru, nhan, chia;
    TextView ketqua;

    int tong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        number1= (EditText)findViewById(R.id.edtSo1);
        number2 = (EditText)findViewById(R.id.edtSo2);
        cong = (Button)findViewById(R.id.btnCong);
        tru = (Button)findViewById(R.id.btnTru);
        nhan = (Button)findViewById(R.id.btnNhan);
        chia = (Button)findViewById(R.id.btnChia);
        ketqua =(TextView)findViewById(R.id.tvKetqua);
        cong.setOnClickListener(this);
        tru.setOnClickListener(this);
        nhan.setOnClickListener(this);
        chia.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (number1.getText().toString().length() <= 0 || number2.getText().toString().length() <= 0) {
            Toast.makeText(this, "vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        } else {
            int s1 = Integer.parseInt(number1.getText().toString());
            int s2 = Integer.parseInt(number2.getText().toString());
            switch (view.getId()) {
                case R.id.btnCong:// nghĩ là trên cái view có cái id nào bằng vs case thì nó sẽ chạy
                    int tong = s1 + s2;
                    ketqua.setText(String.valueOf(tong));
                    break;
                case R.id.btnTru:
                    int tru = s1 -s2;
                    ketqua.setText(String.valueOf(tru));
                    break;
                case R.id.btnNhan:
                    int nhan= s1*s2;
                    ketqua.setText(String.valueOf(nhan));
                    break;
                case R.id.btnChia:
                    if(s2==0){
                        Toast.makeText(this, "số 2 phải khác không", Toast.LENGTH_SHORT).show();
                    }else {
                        float chia = (float)s1/s2;
                        ketqua.setText(String.valueOf(chia));
                    }
                    break;
            }
        }
    }
}