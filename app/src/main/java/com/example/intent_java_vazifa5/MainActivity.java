package com.example.intent_java_vazifa5;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.intent_java_vazifa5.user.Member;
import com.example.intent_java_vazifa5.user.User;

public class MainActivity extends AppCompatActivity {
    public final String TAG = MainActivity.class.toString();

    TextView tv_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    ActivityResultLauncher <Intent> detailLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult member) {
                    if (member.getResultCode() == Activity.RESULT_OK){
                        Intent data = member.getData();
                        Member member1 = data.getParcelableExtra("member");
                        Log.d(TAG, member1.toString());

                        tv_home.setText(member1.toString());
                    }
                }
            }
    );

    void initViews(){
        tv_home = findViewById(R.id.tv_home);

        Button b_open_detail = findViewById(R.id.b_open_detail);
        b_open_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("Azizbek", 20);
                openDetailActivity(user);
            }
        });
    }
    void openDetailActivity(User user){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("user",user);

        detailLauncher.launch(intent);
    }
}