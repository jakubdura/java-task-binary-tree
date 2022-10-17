package main.node;

public class InnerNode extends Node {

    public final Node left;
    public final Node right;

    public InnerNode(Node left, Node right) {
        //  super(left.frequency + right.frequency);
        super(left, right);
        this.left = left;
        this.right = right;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InnerNode other)) {
            return false;
        }
        return other.left.equals(left) && other.right.equals(right);
    }

    @Override
    public String toString() {
        return "frequency: " + frequency + "\nleft: (" + left + ")\nright: (" + right + ")";
    }

}
