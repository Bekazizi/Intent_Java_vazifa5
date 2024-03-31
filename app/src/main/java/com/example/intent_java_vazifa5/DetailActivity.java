package com.example.intent_java_vazifa5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intent_java_vazifa5.user.Member;
import com.example.intent_java_vazifa5.user.User;

public class DetailActivity extends AppCompatActivity {
    public final String TAG = DetailActivity.class.toString();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();
    }

    void initViews(){
        Button tv_exit = findViewById(R.id.tv_exit);
        tv_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member member = new Member("Davlat", 19);
                backToFinish(member);
            }
        });
        TextView tv_detail = findViewById(R.id.tv_detail);

        User user = (User) getIntent().getParcelableExtra("user");
        Log.d(TAG, user.toString());

        tv_detail.setText(user.toString());
    }

    void backToFinish(Member member){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("member", member);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

}
