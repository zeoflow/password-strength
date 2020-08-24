package com.zeoflow.app;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zeoflow.password.strength.PasswordType;

import static com.zeoflow.password.strength.PasswordStrength.initializePassChecker;

public class MainActivity extends AppCompatActivity implements TextWatcher
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText password = (EditText) findViewById(R.id.login_password);
        password.addTextChangedListener(this);

        PasswordType res = initializePassChecker()
                .calculateStrength("(TeEl!Be_Ro@01+25)");
        Log.d("tag", String.valueOf(res));
        Log.d("tag", String.valueOf(res));

    }

    @Override
    public void afterTextChanged(Editable s)
    {
    }

    @Override
    public void beforeTextChanged(
            CharSequence s, int start, int count, int after)
    {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {
        updatePasswordStrengthView(s.toString());
    }

    private void updatePasswordStrengthView(String password)
    {

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        TextView strengthView = (TextView) findViewById(R.id.password_strength);
        if (TextView.VISIBLE != strengthView.getVisibility())
            return;

        if (password.isEmpty())
        {
            strengthView.setText("");
            progressBar.setProgress(0);
        }
    }
}


