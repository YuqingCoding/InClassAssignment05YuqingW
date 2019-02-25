package com.example.inclassassignment05_yuqingw;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendEmail (View view){

        EditText titleField = findViewById(R.id.title_field);
        String title = titleField.getText().toString();

        EditText messageField = findViewById(R.id.message_field);
        String message = messageField.getText().toString();

        CheckBox onlySendTitleCheckBox = findViewById(R.id.sendTitle_checkbox);
        boolean onlySendTitle = onlySendTitleCheckBox.isChecked();

        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto: "));
        email.putExtra(Intent.EXTRA_SUBJECT,title);
        if(onlySendTitle){
        email.putExtra(Intent.EXTRA_TEXT,"");
        }else{email.putExtra(Intent.EXTRA_TEXT,message);}

        if(email.resolveActivity(getPackageManager())!=null){
            startActivity(email);
        }
    }

    public void launchActivity(View view) {
        EditText messageField = findViewById(R.id.message_field);
        String message = messageField.getText().toString();

        Intent ownActivity = new Intent(this, OwnActivity.class);
        ownActivity.putExtra("KEY_STRING", message);
        if (ownActivity.resolveActivity(getPackageManager()) != null) {
            startActivity(ownActivity);
        }
    }

    public void launchCamera (View view){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }



}


