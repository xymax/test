package com.xy.hx;

public class TestDemo {
    public static void main(String[] args) {
        TestBinaryTree testBinaryTree = new TestBinaryTree();
        String str = "ABC##DE#G##F### ";
        TestBinaryTree.TreeNode root = testBinaryTree.createTestTree(str);
        testBinaryTree.binaryTreePrevOrder(root);
        System.out.println();

        testBinaryTree.binaryTreePostOrder(root);
        System.out.println();

        testBinaryTree.binaryTreeInOrder(root);
        System.out.println();
//        System.out.println(testBinaryTree.getSize(root));
//        System.out.println(testBinaryTree.getLeafSize(root));
//        System.out.println(testBinaryTree.getKLevelSize(root,3));
      //  System.out.println(testBinaryTree.find(root,'E'));
      //  System.out.println(testBinaryTree.height(root));

        testBinaryTree.binaryTreeInOrderNonR(root);
        System.out.println();
        testBinaryTree.binaryTreePostOrderNonR(root);

    }
}
