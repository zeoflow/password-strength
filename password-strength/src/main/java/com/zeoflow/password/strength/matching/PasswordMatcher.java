package com.zeoflow.password.strength.matching;

import com.zeoflow.password.strength.matching.match.Match;
import com.zeoflow.password.strength.resources.Configuration;

import java.util.List;

/**
 * Interface for different matching methods to implement..
 */
public interface PasswordMatcher
{
    /**
     * Creates a {@code List} of {@code Match} from the password.
     *
     * @param configuration configuration for the matcher.
     * @param password      password to match.
     * @return a {@code List} of {@code Match}es that this matcher found for the given password and configuration.
     */
    List<Match> match(final Configuration configuration, final String password);
}
