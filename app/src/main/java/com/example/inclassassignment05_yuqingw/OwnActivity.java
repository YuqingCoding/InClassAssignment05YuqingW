package com.example.inclassassignment05_yuqingw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OwnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own);

        Intent ownActivity = getIntent();
        String str = ownActivity.getStringExtra("KEY_STRING");

        TextView textView = findViewById(R.id.show_text_view);
        textView.setText(str);
    }
}
