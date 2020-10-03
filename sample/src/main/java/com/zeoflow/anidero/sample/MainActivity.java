package com.zeoflow.anidero.sample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zeoflow.password.strength.PasswordModel;
import com.zeoflow.password.strength.PasswordType;

import static com.zeoflow.password.strength.PasswordStrength.initializePassChecker;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PasswordModel zPasswordStrength = initializePassChecker()
            .requireDigits(true)
            .requireUpperCase(true)
            .calculateStrength("3454g36v5!?n4vt45j6");

    }
}
