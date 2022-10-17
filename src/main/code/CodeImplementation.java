package main.code;

import main.node.InnerNode;
import main.node.Leaf;
import main.node.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CodeImplementation implements Code {
    @Override
    public Node createCode(String inputText) {

        // check the frequency of repeating the letters
        HashMap<Character, Integer> frequencyMap = characterCount(inputText);

        // write results from Map to ArrayList
        ArrayList<Node> nodes;
        nodes = createArrayOfNodes(frequencyMap);

        // create binary tree
        Node result = createTree(nodes);

        return result;
    }

    private Node createTree(ArrayList<Node> nodes) {

        // if array contains only 1 type of char, return one Leaf
        // if array contains more than 2, create Node from the 2 smallest elements in the array
        // repeat until there are 2 nodes left, then create root of them and return tree

        int nodeSize = nodes.size();

        if (nodeSize < 1){
            throw new IllegalArgumentException("0 elements in array.");
        }

        Node T1 = nodes.get(0);
        Node T2 = null;
        Node T12;

        if (nodeSize == 1) {
            return T1;
        }

        while (nodeSize >= 2) {
            if (nodeSize == 2) {
                T1 = findMin(nodes);
                nodes.remove(T1);
                T2 = findMin(nodes);
                break;
            } else {
                T1 = findMin(nodes);
                nodes.remove(T1);

                T2 = findMin(nodes);
                nodes.remove(T2);

                T12 = new InnerNode(T1, T2);

                nodes.add(T12);

                nodeSize--;
            }
        }
        return new InnerNode(T1, T2);
    }

    private Node findMin(ArrayList<Node> nodes) {
        return Collections.min(nodes);
    }

    private HashMap<Character, Integer> characterCount(String inputText) {

        // apply filter to text,
        // check the frequency of repeating the letters,
        // save the results to the Map

        inputText = inputText.toLowerCase().replaceAll("\\s", "");

        char[] textArray = inputText.toCharArray();

        // HashMap K -> char, V -> frequency
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (char c : textArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        return charCountMap;
    }

    private ArrayList<Node> createArrayOfNodes(HashMap<Character, Integer> map) {
        ArrayList<Node> nodesArray = new ArrayList<>();
        System.out.println("Frequency of occurrence of characters:");
        for (Character i : map.keySet()) {
            System.out.println("char: " + i + " freq: " + map.get(i));
            nodesArray.add(new Leaf(i, map.get(i)));
        }
        return nodesArray;
    }

    public void printBinaryTree(Node root, int level) {
        if (root == null)
            return;
        printBinaryTree(root.getRight(), level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + root.frequency);
        } else
            System.out.println(root.frequency);
        printBinaryTree(root.getLeft(), level + 1);
    }

    public void displayBinaryTree(Node node, int level) {
        System.out.println("\nBinary tree:");
        printBinaryTree(node, level);
    }


}
