package main.node;

public abstract class Node implements Comparable<Node> {
    public final int frequency;

    Node right;
    Node left;

    protected Node(int frequency) {
        this.frequency = frequency;
    }

    protected Node(Node left, Node right) {
        this.left = left;
        this.right = right;
        this.frequency = left.frequency + right.frequency;
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }


}
