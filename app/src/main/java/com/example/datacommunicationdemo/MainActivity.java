package com.example.datacommunicationdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        EditText editTex;
        TextView textView;
        Button btnok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();

    }

    private void initListener() {
        editTex.setOnClickListener(this);
        textView.setOnClickListener(this);
        btnok.setOnClickListener(this);
    }

    private void initView() {
        editTex=findViewById(R.id.edittext);
        textView=findViewById(R.id.textview);
        btnok=findViewById(R.id.Btnok);
    }

    @Override
    public void onClick(View view) {
        if (view==btnok){
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("edittext",editTex.getText().toString());
            startActivityForResult(intent,1);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle=data.getExtras();
        String result=bundle.getString("result");
        textView.setText(result);
    }
}