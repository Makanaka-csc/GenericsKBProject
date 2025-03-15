// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman


public class BinaryTreeNode<dataType>
{

   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   
   /**
    * Constructs a BinaryTreeNode with the specified data and child nodes.
    * 
    * @param d The data to be stored in the node.
    * @param l The left child node.
    * @param r The right child node.
    */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
   }
   
   /**
    * Returns the left child of the node.
    * 
    * @return The left child node, or {@code null} if there is no left child.
    */
   BinaryTreeNode<dataType> getLeft () { return left; }

   /**
    * Returns the right child of the node.
    * 
    * @return The right child node, or {@code null} if there is no right child.
    */
   BinaryTreeNode<dataType> getRight () { return right; }
}
