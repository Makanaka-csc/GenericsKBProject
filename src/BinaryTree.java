// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTree<dataType>
{
   // The root node of the binary tree
   BinaryTreeNode<dataType> root;
   
  
   public BinaryTree ()
   {
      root = null;
   }
   
   /**
    * Returns the height of the tree.
    * The height of a tree is the length of the longest path from the root to a leaf node.
    * 
    * @return the height of the tree.
    */
   public int getHeight ()
   {
      return getHeight (root);
   }   
   
   /**
    * Helper method to calculate the height of a subtree rooted at the given node.
    * 
    * @param node The root node of the subtree.
    * @return the height of the subtree.
    */
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1; 
         else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   /**
    * Returns the size (number of nodes) in the tree.
    * 
    * @return the size of the tree.
    */
   public int getSize ()
   {
      return getSize (root);
   }   
   
   /**
    * method to calculate the size of a subtree rooted at the given node.
    * 
    * @param node The root node of the subtree.
    * @return the size of the subtree (number of nodes).
    */
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   /**
    * A method to visit and print the data of a node.
    * 
    * @param node The node to visit.
    */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   
 
 
    public void preOrder ()
   {
      preOrder (root);
   }
   
   /**
    * Helper method to perform a pre-order traversal of the subtree rooted at the given node.
    * 
    * @param node The root node of the subtree.
    */
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);  
         preOrder (node.getLeft ());  
         preOrder (node.getRight ());      
         }   
   }

   
      public void postOrder ()
   {
      postOrder (root);
   }
   
   /**
    * method to perform a post-order traversal of the subtree rooted at the given node.
    * 
    * @param node The root node of the subtree.
    */
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());  
         postOrder (node.getRight ()); 
         visit (node);  // Visit the current node
      }   
   }



   /**
    * Performs an in-order traversal of the tree.
    * In in-order, the left subtree is visited first, then the root, and then the right subtree.
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   
   /**
    * Helper method to perform an in-order traversal of the subtree rooted at the given node.
    * 
    * @param node The root node of the subtree.
    */
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ()); 
         visit (node);  
         inOrder (node.getRight ());  
          }   
   }
}
