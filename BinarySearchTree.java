
public class BinarySearchTree<E extends Comparable<E>>
    // extends AbstractStructure<E> implements OrderedStructure<E>
	// no las usuaremos por el momento
{
    /**
     * A reference to the root of the tree
     */
    protected BinaryTree<E> root;

    /**
     * The node used as all leaves, in this implementation.
     */
    protected final BinaryTree<E> EMPTY = new BinaryTree<E>();

    /**
     * The number of nodes in the tree
     */ 
    protected int count;
    
    /**
     * Constructs a binary search tree with no data
     *
     * @post Constructs an empty binary search tree
     */
    public BinarySearchTree()
    {
        root = EMPTY;
        count = 0;
    }

    /**
     * Checks for an empty binary search tree
     *
     * @post Returns true iff the binary search tree is empty
     * 
     * @return True iff the tree contains no data
     */
    public boolean isEmpty()
    {
        return root.equals(EMPTY);
    }

    /**
     * Removes all data from the binary search tree
     *
     * @post Removes all elements from binary search tree
     */
    public void clear()
    {
        root = new BinaryTree<E>();
        count = 0;
    }

    /**
     * Determines the number of data values within the tree
     *
     * @post Returns the number of elements in binary search tree
     * 
     * @return The number of nodes in the binary search tree
     */
    public int size()
    {
        return count;
    }
    
    /**
     * @pre root and value are non-null
     * @post returned: 1 - existing tree node with the desired value, or
     *                 2 - the node to which value should be added
     */
    protected BinaryTree<E> locate(BinaryTree<E> root, E value)
    {
        E rootValue = root.value();
        BinaryTree<E> child;

        // found at root: done
        if (rootValue.equals(value)) return root;
        // look left if less-than, right if greater-than
        if (rootValue.compareTo(value) < 0)
        {
            child = root.right();
        } else {
            child = root.left();
        }
        // no child there: not in tree, return this node,
        // else keep searching
        if (child.isEmpty()) {
            return root;
        } else {
            return locate(child, value);
        }
    }

    protected BinaryTree<E> predecessor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.left();
        while (!result.right().isEmpty()) {
            result = result.right();
        }
        return result;
    }
    
    protected BinaryTree<E> successor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.right();
        while (!result.left().isEmpty()) {
            result = result.left();
        }
        return result;
    }

    /**
     * Add a (possibly duplicate) value to binary search tree
     *
     * @post Adds a value to binary search tree
     * 
     * @param val A reference to non-null object
     */
    public void add(E value)
    {
        BinaryTree<E> newNode = new BinaryTree<E>(value,EMPTY,EMPTY);

        // add value to binary search tree 
        // if there's no root, create value at root
        if (root.isEmpty())
        {
            root = newNode;
        } else {
            BinaryTree<E> insertLocation = locate(root,value);
            E nodeValue = insertLocation.value();
            // The location returned is the successor or predecessor
            // of the to-be-inserted value
            if (nodeValue.compareTo(value) < 0) {
                insertLocation.setRight(newNode);
            } else {
                if (!insertLocation.left().isEmpty()) {
                    // if value is in tree, we insert just before
                    predecessor(insertLocation).setRight(newNode);
                } else {
                    insertLocation.setLeft(newNode);
                }
            }
        }
        count++;
    }

    /**
     * Determines if the binary search tree contains a value
     *
     * @post Returns true iff val is a value found within the tree
     * 
     * @param val The value sought.  Should be non-null
     * @return True iff the tree contains a value "equals to" sought value
     */
    public boolean contains(E value)
    {
        if (root.isEmpty()) return false;

        BinaryTree<E> possibleLocation = locate(root,value);
        return value.equals(possibleLocation.value());
    }

    /**
     * Returns reference to value found within three.  This method can
     * be potentially dangerous if returned value is modified: if 
     * modification would change the relation of value to others within
     * the tree, the consistency of the structure is lost
     * <b>Don't modify returned value</b>
     *
     * @post Returns object found in tree, or null
     * 
     * @param val Value sought from within tree
     * @return A value "equals to" value sought; otherwise null
     */
    public E get(E value)
    {
        if (root.isEmpty()) return null;

        BinaryTree<E> possibleLocation = locate(root,value);
        boolean found = possibleLocation.value().compareTo(value)==0;
        if (found){
          return possibleLocation.value();}
        else{
          return null;}
    }

    /**
     * Remove an value "equals to" the indicated value.  Only one value
     * is removed, and no guarantee is made concerning which of duplicate
     * values are removed.  Value returned is no longer part of the
     * structure
     *
     * @post Removes one instance of val, if found
     * 
     * @param val Value sought to be removed from tree
     * @return Actual value removed from tree
     */
    public E remove(E value) 
    {
        if (isEmpty()) return null;
      
        if (value.equals(root.value())) // delete root value
        {
            BinaryTree<E> newroot = removeTop(root);
            count--;
            E result = root.value();
            root = newroot;
            return result;
        }
        else
        {
            BinaryTree<E> location = locate(root,value);

            if (value.equals(location.value())) {
                count--;
                BinaryTree<E> parent = location.parent();
                if (parent.right() == location) {
                    parent.setRight(removeTop(location));
                } else {
                    parent.setLeft(removeTop(location));
                }
                return location.value();
            }
        }
        return null;
    }

    /**
     * Removes the top node of the tree rooted, performs the necissary
     * rotations to reconnect the tree.
     *
     * @pre topNode contains the value we want to remove
     * @post We return an binary tree rooted with the predecessor of topnode.
     * @param topNode Contains the value we want to remove
     * @return The root of a new binary tree containing all of topNodes 
     * descendents and rooted at topNode's predecessor
     */
    protected BinaryTree<E> removeTop(BinaryTree<E> topNode)
    {
        // remove topmost BinaryTree from a binary search tree
        BinaryTree<E> left  = topNode.left();
        BinaryTree<E> right = topNode.right();
        // disconnect top node
        topNode.setLeft(EMPTY);
        topNode.setRight(EMPTY);
        // Case a, no left BinaryTree
        //   easy: right subtree is new tree
        if (left.isEmpty()) { return right; }
        // Case b, no right BinaryTree
        //   easy: left subtree is new tree
        if (right.isEmpty()) { return left; }
        // Case c, left node has no right subtree
        //   easy: make right subtree of left
        BinaryTree<E> predecessor = left.right();
        if (predecessor.isEmpty())
        {
            left.setRight(right);
            return left;
        }
        // General case, slide down left tree
        //   harder: successor of root becomes new root
        //           parent always points to parent of predecessor
        BinaryTree<E> parent = left;
        while (!predecessor.right().isEmpty())
        {
            parent = predecessor;
            predecessor = predecessor.right();
        }
        // Assert: predecessor is predecessor of root
        parent.setRight(predecessor.left());
        predecessor.setLeft(left);
        predecessor.setRight(right);
        return predecessor;
    }

    public void printInorder(){
        root.printInorder(root);
    }


    

    /**
     * Returns a string representing tree
     *
     * @post Generates a string representation of the BST
     * 
     * @return String representation of tree
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<BinarySearchTree:");
        if (!root.isEmpty()) {
            s.append(root);
        }
        s.append(">");
        return s.toString();
    }
}