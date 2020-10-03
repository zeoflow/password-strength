package com.zeoflow.password.strength;

import static com.zeoflow.password.strength.PasswordType.MEDIUM;
import static com.zeoflow.password.strength.PasswordType.STRONG;
import static com.zeoflow.password.strength.PasswordType.VERY_STRONG;
import static com.zeoflow.password.strength.PasswordType.WEAK;

public class PasswordStrength
{

    int REQUIRED_LENGTH = 8;
    int MAXIMUM_LENGTH = 50;
    boolean REQUIRE_SPECIAL_CHARACTERS = true;
    boolean REQUIRE_DIGITS = true;
    boolean REQUIRE_LOWER_CASE = true;
    boolean REQUIRE_UPPER_CASE = false;

    PasswordStrength()
    {

    }

    public static PasswordStrength initializePassChecker()
    {
        return new PasswordStrength();
    }

    public PasswordStrength withRequiredLength(int requiredLength) {
        this.REQUIRED_LENGTH = requiredLength;
        return this;
    }

    public PasswordStrength withMaximumLength(int maximumLength) {
        this.MAXIMUM_LENGTH = maximumLength;
        return this;
    }

    public PasswordStrength requireSpecialCharacters(boolean requireSpecialCharacters) {
        this.REQUIRE_SPECIAL_CHARACTERS = requireSpecialCharacters;
        return this;
    }

    public PasswordStrength requireDigits(boolean requireDigits) {
        this.REQUIRE_DIGITS = requireDigits;
        return this;
    }

    public PasswordStrength requireLowerCase(boolean requireLowerCase) {
        this.REQUIRE_LOWER_CASE = requireLowerCase;
        return this;
    }

    public PasswordStrength requireUpperCase(boolean requireUpperCase) {
        this.REQUIRE_UPPER_CASE = requireUpperCase;
        return this;
    }

    public PasswordModel calculateStrength(String password)
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
                return new PasswordModel(WEAK, currentScore);
            case 1:
                return new PasswordModel(MEDIUM, currentScore);
            case 2:
                return new PasswordModel(STRONG, currentScore);
            case 3:
                return new PasswordModel(VERY_STRONG, currentScore);
            default:
        }

        return new PasswordModel(VERY_STRONG, currentScore);
    }

}
