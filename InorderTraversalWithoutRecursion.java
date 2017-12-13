/*
 * Inorder traversal of binary tree without recursion
 */
package inordertraversalwithoutrecursion;
import java.util.Stack;
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
public class InorderTraversalWithoutRecursion {
    Node root;
    
    void inorderTraversal(Node node){
        if(node==null)
            return;
        Stack<Node> stack=new Stack();
        
        while(node!=null){
            stack.push(node);
            node=node.left;
        }

        while(!stack.empty()){
            node=stack.pop();
            System.out.print(node.data+" ");
            
            if(node.right!=null){
                node=node.right;
                
                while(node!=null){
                    stack.push(node);
                    node=node.left;
                }
            }
        }    
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        InorderTraversalWithoutRecursion tree=new InorderTraversalWithoutRecursion();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);
        
        tree.root.right.right=new Node(6);
        
//        tree.root.left.left.left=new Node(7);
//        tree.root.left.left.right=new Node(8);
//        
//        tree.root.left.left.left.left=new Node(5);
//        
//        tree.root.left.left.left.left.left=new Node(2);
//        tree.root.left.left.left.left.left.left=new Node(4);
//        
//        tree.root.right.right.left=new Node(15);
//        tree.root.right.right.right=new Node(10);
//        
//        tree.root.right.right.right.left=new Node(12);
//        tree.root.right.right.right.right=new Node(5);
//        
//        tree.root.right.right.right.left.left=new Node(14);
//        tree.root.right.right.right.left.right=new Node(15);
//        
//        tree.root.right.right.right.right.left=new Node(16);
//        tree.root.right.right.right.right.right=new Node(17);
//        
//        tree.root.right.right.right.right.right.left=new Node(18);
//        tree.root.right.right.right.right.right.right=new Node(19);
//        
        tree.inorderTraversal(tree.root);
    }
    
}
