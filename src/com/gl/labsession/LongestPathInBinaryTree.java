package com.gl.labsession;

import java.util.ArrayList;

public class LongestPathInBinaryTree {

    static class Node{
        int data;
        Node left, right;
    }

    static Node newNode(int nodeData){
        Node temp =  new Node();
        temp.data = nodeData;
        temp.left =  null;
        temp.right = null;
        return temp;
    }

    private static ArrayList<Integer> findLongestPath(Node root) {

        
        // base case
        if(root==null){
            ArrayList<Integer> output = new ArrayList<Integer>(); 
            return output ;
        }

        // path left subtree - L
        ArrayList<Integer> leftNode = findLongestPath(root.left);

        // path right subtree - R
        ArrayList<Integer> rightNode = findLongestPath(root.right);

        // compare the sizes of the two Arraylists and pick the longest 
        // list and then add root to that list
        if(rightNode.size()<leftNode.size()){
            leftNode.add(root.data);
        }else{
            rightNode.add(root.data);
        }


        // return the longest list
        return (leftNode.size() > rightNode.size() ? leftNode:rightNode);
    }

    public static void main(String[] args) {
        // Create the Binary Tree
        Node root = newNode(100);
        root.left = newNode(20);
        root.right = newNode(130);
        root.left.left = newNode(10);
        root.left.right = newNode(50);
        root.right.left = newNode(10);
        root.right.right = newNode(140);
        root.left.left.left = newNode(5);

        //find the longest path
        ArrayList<Integer> output = findLongestPath(root);

        for (int i = output.size()-1;i>=0;i--) {
            System.out.print("->"+output.get(i));
        }// for-each

    }



    
}
