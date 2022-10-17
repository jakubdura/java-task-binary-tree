package main.node;

public class Leaf extends Node {

    public final char symbol;

    public Leaf(char symbol, int frequency) {
        super(frequency);
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Leaf other)) {
            return false;
        }
        return other.frequency == frequency && other.symbol == symbol;
    }

    @Override
    public String toString() {
        return "symbol: " + symbol + ", frequency: " + frequency;
    }
}
