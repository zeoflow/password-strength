package com.zeoflow.app;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zeoflow.password.strength.PasswordType;

import static com.zeoflow.password.strength.PasswordStrength.initializePassChecker;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PasswordType res = initializePassChecker()
                .calculateStrength("3454g36v5n4vt45j6");
        Toast.makeText(this, String.valueOf(res), Toast.LENGTH_SHORT).show();

    }
}


