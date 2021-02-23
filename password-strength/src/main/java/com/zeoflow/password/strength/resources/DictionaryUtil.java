package com.zeoflow.password.strength.resources;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DictionaryUtil
{
    /**
     * Ranked dictionary of common passwords
     */
    public static final String passwords = "passwords.txt";

    /**
     * Ranked dictionary of common male names
     */
    public static final String male_names = "male-names.txt";

    /**
     * Ranked dictionary of common female names
     */
    public static final String female_names = "female-names.txt";

    /**
     * Ranked dictionary of common surnames
     */
    public static final String surnames = "surnames.txt";

    /**
     * Ranked dictionary of common English word
     */
    public static final String english = "english.txt";

    /**
     * Unranked dictionary from the EFF password wordlist
     */
    public static final String eff_large = "eff_large.txt";

    /**
     * Read a resource file with a list of entries (sorted by frequency) and use
     * it to create a ranked dictionary.
     * <p>
     * The dictionary must contain only lower case values for the matching to work properly.
     *
     * @param fileName the name of the file
     * @return the ranked dictionary (a {@code HashMap} which associated a
     * rank to each entry
     */
    public static Map<String, Integer> loadUnrankedDictionary(final String fileName, Context context)
    {
        Map<String, Integer> unranked = new HashMap<>();
        Set<String> unranked_set = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(context.getResources().getAssets().open("dictionaries/" + fileName), StandardCharsets.UTF_8)))
        {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null)
            {
                unranked_set.add(line);
                i++;
            }

            i = i / 2;

            for (String value : unranked_set)
            {
                unranked.put(value, i);
            }
        } catch (IOException e)
        {
            System.out.println("Error while reading " + fileName);
        }

        return unranked;
    }

    /**
     * Read a resource file with a list of entries (sorted by frequency) and use
     * it to create a ranked dictionary.
     * <p>
     * The dictionary must contain only lower case values for the matching to work properly.
     *
     * @param fileName the name of the file
     * @return the ranked dictionary (a {@code HashMap} which associated a
     * rank to each entry
     */
    public static Map<String, Integer> loadRankedDictionary(final String fileName, Context context)
    {
        Map<String, Integer> ranked = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(context.getResources().getAssets().open("dictionaries/" + fileName), StandardCharsets.UTF_8)))
        {
            String line;
            int i = 1;
            while ((line = reader.readLine()) != null)
            {
                ranked.put(line, i++);
            }
        } catch (IOException e)
        {
            System.out.println("Error while reading " + fileName);
        }

        return ranked;
    }

}
