/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preordertraversalwithoutrecursion;

/*
 * Preorder traversal of binary tree without recursion
 */
import java.util.*;
/**
 *
 * @author rumanaaktar
 */


class Node{
        int data;
        Node left, right;
        
        Node(int data){
            this.data=data;
            left=right=null;
        }
}
public class PreorderTraversalWithoutRecursion {
    Node root;
    
    void inorderTraversal(Node node){
        if(node==null)
            return;
        
        Stack<Node> stack=new Stack();
        
        while(node!=null){ //keep printing and adding nodes (for accessing right child later) to stack
            System.out.print(node.data + " ");
            stack.add(node);
            node=node.left;            
        }
        node=stack.pop(); //get the parent of Left most node
        
        while(!stack.isEmpty() || node.right!=null){ //keep doing until all nodes are processed
            if(node.right==null){ //if no right child, just pop it.
                node=stack.pop();
            }else{
                node=node.right; //if right child, keep doing everything again
                while(node!=null){
                    System.out.print(node.data + " ");
                    stack.add(node);
                    node=node.left;            
                }
                node=stack.pop();
        
            }
            
        }
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        PreorderTraversalWithoutRecursion tree=new PreorderTraversalWithoutRecursion();
        tree.root=new Node(2);
        tree.root.left=new Node(4);
        tree.root.right=new Node(6);
        
        tree.root.right.right=new Node(16);
        
        tree.root.left.left=new Node(8);
        tree.root.left.right=new Node(12);
        
        tree.root.left.right.left=new Node(3);
        tree.root.left.right.right=new Node(14);
        
        tree.inorderTraversal(tree.root);
    }
    
}
