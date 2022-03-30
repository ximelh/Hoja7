/**
 * Binary Tree
 */
public class BinaryTree<E>
{

    protected E val; // value associated with node
	protected BinaryTree<E> parent; // parent of node
	protected BinaryTree<E> left, right; // children of node
	
	public BinaryTree()
	// post: constructor that generates an empty node
	{
		val = null;
		parent = null; left = right = null;
	}
	
	public BinaryTree(E value)
	// post: returns a tree referencing value and two empty subtrees
	{
		val = value;
		right = left = new BinaryTree<E>();
		setLeft(left);
		setRight(right);
	}
	
	public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
	// post: returns a tree referencing value and two subtrees
	{
		val = value;
		if (left == null) { left = new BinaryTree<E>(); }
		setLeft(left);
		if (right == null) { right = new BinaryTree<E>(); }
		setRight(right);
	}
	
	public void setRight(BinaryTree<E> newRight) {
		if (isEmpty()) return;
		if (right != null && right.parent() == this) right.setParent(null);
		right = newRight;
		right.setParent(this);
	
	}

	public BinaryTree<E> left()
	{
		return left;
	}

	public BinaryTree<E> right()
	{
		return right;
	}
	
	/**
	 * returns reference to parent node
	 * @return
	 */
	public BinaryTree<E> parent()
	{
		return parent;
	}
	// post: , or null
	
	public void setLeft(BinaryTree<E> newLeft)
	// post: sets left subtree to newLeft
	// re-parents newLeft if not null
	{
		if (isEmpty()) return;
		if (left != null && left.parent() == this) left.setParent(null);
		left = newLeft;
		left.setParent(this);
	}
	
	boolean isEmpty() {
		return val==null;
	}

	protected void setParent(BinaryTree<E> newParent)
	// post: re-parents this node to parent reference, or null
	{
		if (!isEmpty()) {
		parent = newParent;
		}
	}
	
	
	public E value()
	// post: returns value associated with this node
	{
		return val;
	}
	
	public void setValue(E value)
	// post: sets the value associated with this node
	{
		val = value;
	}

	public void printInorder(BinaryTree<E> node)
    {
        if (node.value() == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left());
 
        /* then print the data of node */
        System.out.print(node.value().toString() + "\n");
 
        /* now recur on right child */
        printInorder(node.right());
    }
}


 