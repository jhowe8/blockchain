package hk.blockchain.dev.models;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final int DIFFICULTY = 5;
    public static final int REWARD = 10;
    public static final String GENESIS_PREV_HASH = "0000000000000000000000000000000000000000000000000000000000000000";
}
