package test;

import main.code.Code;
import main.code.CodeImplementation;
import main.node.InnerNode;
import main.node.Leaf;
import main.node.Node;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleTests {

    CodeImplementation code = new CodeImplementation();

    @Test
    public void createTree_inputString_resultBinaryTreeOfNodes() {
        //given
        Node tree = code.createCode("abacaca");

        //when
        Node result = new InnerNode(
                new InnerNode(
                        new Leaf('b', 1),
                        new Leaf('c', 2)
                ), new Leaf('a', 4));

        //then
        assertEquals(tree,result);
    }

    @Test
    public void createTree_inputOneTypeOfChar_oneLeafTree() {
        //given
        Node tree = code.createCode("ffffffffff");

        //when
        Node result = new Leaf('f',10);

        //then
        assertEquals(tree,result);
    }

    @Test void createTree_inputZeroChars_throwsIllegalArgumentException(){
        //given
        String empty="";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> code.createCode(empty));
    }
}