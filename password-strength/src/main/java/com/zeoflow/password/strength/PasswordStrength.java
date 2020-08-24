package com.zeoflow.password.strength;

import static com.zeoflow.password.strength.PasswordType.MEDIUM;
import static com.zeoflow.password.strength.PasswordType.STRONG;
import static com.zeoflow.password.strength.PasswordType.VERY_STRONG;
import static com.zeoflow.password.strength.PasswordType.WEAK;

public class PasswordStrength
{

    //--------REQUIREMENTS--------
    static int REQUIRED_LENGTH = 8;
    static int MAXIMUM_LENGTH = 15;
    static boolean REQUIRE_SPECIAL_CHARACTERS = true;
    static boolean REQUIRE_DIGITS = true;
    static boolean REQUIRE_LOWER_CASE = true;
    static boolean REQUIRE_UPPER_CASE = false;

    PasswordStrength()
    {

    }

    public static PasswordStrength initializePassChecker()
    {
        return new PasswordStrength();
    }

    public PasswordType calculateStrength(String password)
    {
        int currentScore = 0;
        boolean sawUpper = false;
        boolean sawLower = false;
        boolean sawDigit = false;
        boolean sawSpecial = false;

        for (int i = 0; i < password.length(); i++)
        {
            char c = password.charAt(i);

            if (!sawSpecial && !Character.isLetterOrDigit(c))
            {
                currentScore += 1;
                sawSpecial = true;
            } else
            {
                if (!sawDigit && Character.isDigit(c))
                {
                    currentScore += 1;
                    sawDigit = true;
                } else
                {
                    if (!sawUpper || !sawLower)
                    {
                        if (Character.isUpperCase(c))
                            sawUpper = true;
                        else
                            sawLower = true;
                        if (sawUpper && sawLower)
                            currentScore += 1;
                    }
                }
            }

        }

        if (password.length() > REQUIRED_LENGTH)
        {
            if ((REQUIRE_SPECIAL_CHARACTERS && !sawSpecial)
                    || (REQUIRE_UPPER_CASE && !sawUpper)
                    || (REQUIRE_LOWER_CASE && !sawLower)
                    || (REQUIRE_DIGITS && !sawDigit))
            {
                currentScore = 1;
            } else
            {
                currentScore = 2;
                if (password.length() > MAXIMUM_LENGTH)
                {
                    currentScore = 3;
                }
            }
        } else
        {
            currentScore = 0;
        }

        switch (currentScore)
        {
            case 0:
                return WEAK;
            case 1:
                return MEDIUM;
            case 2:
                return STRONG;
            case 3:
                return VERY_STRONG;
            default:
        }

        return VERY_STRONG;
    }

}
