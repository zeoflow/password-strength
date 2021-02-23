package com.zeoflow.password.strength.matching.match;

import com.zeoflow.password.strength.resources.Configuration;

public final class SeparatorMatch extends BaseMatch
{


    /**
     * Create a new {@link SeparatorMatch}
     *
     * @param match         the {@code String} we are creating the {@link SeparatorMatch} from.
     * @param configuration the {@link Configuration} object.
     * @param start_index   the start index in the password for this match.
     * @param end_index     the end index in the password for this match.
     */
    public SeparatorMatch(String match, Configuration configuration, int start_index, int end_index)
    {
        super(match, configuration, start_index, end_index);
        super.setEntropy(LOG_10);
    }
}
