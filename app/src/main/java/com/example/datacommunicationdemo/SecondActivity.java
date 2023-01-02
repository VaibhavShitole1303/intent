package com.example.datacommunicationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity implements View.OnClickListener {
    TextView secTextview;
    EditText secEdittext;
    Button btnBack;
    String text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        initview();
        initlistener();
        extaData();
    }

    private void extaData() {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        text=bundle.getString("edittext");
        secTextview.setText(text);

    }

    private void initlistener() {
        btnBack.setOnClickListener(this);
    }

    private void initview() {
        secTextview=findViewById(R.id.sectextview);
        secEdittext=findViewById(R.id.seceditview);
        btnBack=findViewById(R.id.btnback);

    }

    @Override
    public void onClick(View view) {
    Intent revintent=new Intent();
    revintent.putExtra("result",secEdittext.getText().toString());
    setResult(1,revintent);
    finish();
    }
}
