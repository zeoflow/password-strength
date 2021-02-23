package com.zeoflow.password.strength.enums;

public enum PasswordType
{
    /*
     * VERY_WEAK: risky password: "too guessable"
     */
    VERY_WEAK,

    /*
     * WEAK: modest protection from throttled online attacks: "very guessable"
     */
    WEAK,

    /*
     * MEDIUM: modest protection from unthrottled online attacks: "somewhat guessable"
     */
    MEDIUM,

    /*
     * STRONG: modest protection from offline attacks: "safely unguessable" (assuming a salted, slow hash function)
     */
    STRONG,

    /*
     * VERY_STRONG: strong protection from offline attacks: "very unguessable" (assuming a salted, slow hash function)
     */
    VERY_STRONG
}