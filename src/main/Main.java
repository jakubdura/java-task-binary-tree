package main;

import main.code.CodeImplementation;
import main.node.Node;


public class Main {
    public static void main(String[] args) {
        CodeImplementation code = new CodeImplementation();

        Node result = code.createCode("aaaaabbbbccF");

        code.displayBinaryTree(result, 0);

    }
}