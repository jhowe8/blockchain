package hk.blockchain.dev.controllers;

import hk.blockchain.dev.models.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HashController {
    private static final String TRANSACTION = "transaction";

    @GetMapping(value = "/hash")
    @ResponseBody
    String getHashData(@RequestParam String data) {
        return SHA256Helper.generateHash(data);
    }

    @GetMapping(value = "/checkSHA")
    String checkSHAHelper() {
        StringBuilder sha = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            sha.append(SHA256Helper.generateHash(Integer.toString(i)));
            sha.append('\n');
        }

        return sha.toString();
    }

    @GetMapping(value = "/blockchain")
    String getBlockChain() {
        BlockChain blockChain = new BlockChain();
        Miner miner = new Miner();

        Block genesisBlock = new Block(0, TRANSACTION + blockChain.getSize(), Constants.GENESIS_PREV_HASH);
        miner.mine(genesisBlock, blockChain);

        Block erBlock = new Block(1, TRANSACTION + blockChain.getSize(), blockChain.getBlockChain().get(blockChain.getSize() - 1).getHash());
        miner.mine(erBlock, blockChain);

        Block sanBlock = new Block(2, TRANSACTION + blockChain.getSize(), blockChain.getBlockChain().get(blockChain.getSize() - 1).getHash());
        miner.mine(sanBlock, blockChain);

        return "{\n\t\"blockchain\": [\n" + blockChain + "\n\t],\n" + "\t\"minerReward\": " + miner.getReward() + "\n}";
    }

    @GetMapping(value = "/merkle")
    String checkMerkleTree() {
        List<String> transactions = new ArrayList<>();
        transactions.add("aa");
        transactions.add("bb");
        transactions.add("cc");
        transactions.add("dd");
        transactions.add("ee");
        transactions.add("11");
        transactions.add("22");
        transactions.add("33");
        transactions.add("44");
        transactions.add("55");

        MerkleTree merkleTree = new MerkleTree(transactions);
        return merkleTree.getMerkleRoot().get(0);
    }
}
