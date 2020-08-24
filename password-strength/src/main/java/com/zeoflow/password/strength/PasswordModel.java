package com.zeoflow.password.strength;

public class PasswordModel
{
    PasswordType mPasswordType;
    String mContent;
    int mColor;

    PasswordModel(PasswordType mPasswordType, String mContent, int mColor)
    {
        this.mColor = mColor;
        this.mContent = mContent;
        this.mPasswordType = mPasswordType;
    }

    public int getColor()
    {
        return mColor;
    }

    public PasswordType getPasswordType()
    {
        return mPasswordType;
    }

    public String getContent()
    {
        return mContent;
    }
}
