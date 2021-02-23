package com.zeoflow.anidero.sample;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.zeoflow.compat.ActivityCore;
import com.zeoflow.password.strength.PasswordChecker;
import com.zeoflow.password.strength.resources.Configuration;
import com.zeoflow.password.strength.resources.ConfigurationBuilder;
import com.zeoflow.password.strength.resources.Dictionary;
import com.zeoflow.password.strength.resources.DictionaryBuilder;

import java.util.List;

public class MainActivity extends ActivityCore
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a map of excluded words on a per-user basis using a hypothetical "User" object that contains this info
        List<Dictionary> dictionaryList = ConfigurationBuilder.getDefaultDictionaries(this);
        dictionaryList.add(new DictionaryBuilder(this)
            .setDictionaryName("exclude")
            .setExclusion(true)
            .addWord("Teodor", 0)
            .addWord("Grigor", 0)
            .addWord("grigor.teodor@gmail.com", 0)
            .createDictionary());

        // Create our configuration object and set our custom minimum
        // entropy, and custom dictionary list
        Configuration configuration = new ConfigurationBuilder()
            .setMinimumEntropy(40d)
            .setDictionaries(dictionaryList)
            .createConfiguration(this);

        // Create our PasswordChecker object with the configuration we built
        PasswordChecker passwordChecker = new PasswordChecker(configuration);

        logger(String.valueOf(passwordChecker.estimate("asdasdssd").getStrength()));

    }
}
