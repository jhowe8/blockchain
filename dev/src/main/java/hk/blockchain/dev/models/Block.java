package hk.blockchain.dev.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Block {
    private final Integer id;
    private Integer nonce = 0;
    private final Long timestamp;
    @Getter @Setter private String hash;
    @Getter @Setter private String prevHash;
    private final String transaction;

    public Block(Integer id, String transaction, String prevHash) {
        this.id = id;
        this.transaction = transaction;
        this.prevHash = prevHash;
        this.timestamp = new Date().getTime();
        generateHash();
    }

    public void generateHash() {
        String dataToHash = id + prevHash + timestamp + nonce + transaction;
        this.hash = SHA256Helper.generateHash(dataToHash);
    }

    public void incrementNonce() {
        this.nonce++;
    }

    @Override
    public String toString() {
        return "\t\t{" +
                "\t\t\t\n\t\t\t\"id\": " + id +
                ", \n\t\t\t\"nonce\": " + nonce +
                ", \n\t\t\t\"timestamp\": " + timestamp +
                ", \n\t\t\t\"hash\": \"" + hash + '\"' +
                ", \n\t\t\t\"prevHash\": \"" + prevHash + '\"' +
                ", \n\t\t\t\"transaction\": \"" + transaction + '\"' +
                "\n\t\t}";
    }
}
