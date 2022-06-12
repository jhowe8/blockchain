package hk.blockchain.dev.models;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class BlockChain {
    @Getter
    private List<Block> blockChain;

    public BlockChain() {
        this.blockChain = new LinkedList<>();
    }

    public void addBlock(Block block) {
        this.blockChain.add(block);
    }

    public int getSize() {
        return this.blockChain.size();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < this.blockChain.size(); i++){
            s.append(blockChain.get(i).toString());
            if (i < blockChain.size() - 1) {
                s.append(",\n");
            }
        }

        return s.toString();
    }
}
