/*
 * Find k-th smallest element in BST (Order Statistics in BST): geeksforgeeks
 * Given root of binary search tree and K as input, find K-th smallest element in BST.
 */
package kthsmallestinbst;

import java.util.Vector;

/**
 *
 * @author rumana aktar, idea: geeksforgeeks
 */
class Node{
        int data, rank;
        Node left, right;
        
        Node(int data){
            this.data=data;
            left=right=null;
            this.rank=0;
        }        
}

public class KthSmallestInBST {
    Node root;
    /**
     * @param args the command line arguments
     */
    Node insert(Node node, int val){
        if(root==null){
            root=new Node(val);
            return root;
        }           
        if(node==null){
            node=new Node(val);
            return node;
        }
        if(val<node.data){
            node.rank+=1;
            node.left=insert(node.left, val); 
        }
        else
            node.right=insert(node.right, val);

        return node;
            
    }
    
    int getKthSmallest(Node node, int k){
        if(node==null){
            System.out.print("\nNo such node......");
            return -1;
        }
        if(node.rank==k-1)
            return node.data;
        
        if(k-1 < node.rank)
            return getKthSmallest(node.left, k);
        else
            return getKthSmallest(node.right, k-node.rank-1);
    }
    
    void insertArray(int nums[]){
        root=insert(root, nums[0]);
        for(int i=1; i<nums.length; i++)
            insert(root, nums[i]);
        
        printInorder(root);System.out.println();
    }
    void printInorder(Node node){
        if(node==null)
            return;
        printInorder(node.left);
        System.out.print(node.data+","+node.rank+"   ");
        printInorder(node.right);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        KthSmallestInBST tree=new KthSmallestInBST();
        int nums[]={300,40,400, 20,350,34,56,23,12,46,67};
        tree.insertArray(nums);
        System.out.println("The kth smallest: "+tree.getKthSmallest(tree.root, 8));
    }
    
}
