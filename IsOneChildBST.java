/*
 * Check if each internal node of a BST has exactly one child: geeksforgeeks
 * Given Preorder traversal of a BST, check if each non-leaf node has only one child. Assume that the BST contains unique entries.
 * Examples
 * Input: pre[] = {20, 10, 11, 13, 12}
 * Output: Yes
 */
package isonechildbst;

/**
 *
 * @author rumana aktar
 */
class Node{
        int data;
        Node left, right;
        
        Node(int data){
            this.data=data;
            left=right=null;
        }        
}

public class IsOneChildBST {
    Node root;
    
    Node insert(Node node, int val){
        if(root==null){
            root=new Node(val);
            return root;
        }           
        if(node==null){
            node=new Node(val);
            return node;
        }
        if(val<node.data)
            node.left=insert(node.left, val); 
        else
            node.right=insert(node.right, val);

        return node;
            
    }
    /**
     * @param args the command line arguments
     */
    
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
        System.out.print(node.data+"  ");
        printInorder(node.right);
    }
    
    boolean isOnechilded(Node node){
        if(node.left==null && node.right==null)
            return true;
        if(node.left==null & node.right!=null)
            return isOnechilded(node.right);
        if(node.left!=null & node.right==null)
            return isOnechilded(node.left);
        return false;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        IsOneChildBST tree=new IsOneChildBST();
        int nums[]={20, 10, 11, 13, 12};
        tree.insertArray(nums);
        System.out.println("Current tree is one childed: "+tree.isOnechilded(tree.root));
        tree.insert(tree.root, 16);
        System.out.println("Current tree is one childed: "+tree.isOnechilded(tree.root));
        
        
    }
    
}
