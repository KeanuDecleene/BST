/*
 * A Binary Search Tree that is unbalanced, assumes 
 * duplicates are not allowed, uses self referential nodes,
 * and the operations are implemented using recursion.
 * 
 * @author Keanu De Cleene
 */
public class StrBST{
    public Node _root;

    /* 
     * adds the value to the BST using recursion and, maintains ordering by using the compareTo method.
     * 
     * @param s the value to be added to the BST.
     */
    public void insert(String s){
        _root = insert(_root, s);
    }

    /*
     * traverses the tree using recursion and prints the values in order.
     * 
     */
    public void traversal(){

    }

    /*
     * Finds the height of the tree using recursion.
     * 
     * @return the height of the tree
     */
    public int height(){
        return 0;
    }
    /*
     * inserts the value into the BST using recursion and assumes duplicates are not allowed.
     * 
     * @param node the node to be inserting the value into at the top of the subtree 
     * @param value the value to be inserted 
     * @return the new node
     */
    private Node insert(Node node, String value){
        if(node == null){
            node = new Node(value);
        }
        else if(value.compareTo(node._value) < 0){
            node._left = insert(node._left, value);
        }
        else if(value.compareTo(node._value) > 0){
            node._right = insert(node._right, value);
        }
        return node;
    }

    /*
     * removes the value from the BST using recursion.
     * 
     * @param s the value to be removed from the BST
     */
    public void remove(String s){

    }

    /*  
     * searches the tree to find the specified value using recursion and returns the boolean true,
     * if the value is found, false otherwise.
     * 
     * @param s the value to be searched for in the BST.
     */
    public boolean search(String s){
        return false;
    }



    /*
     * A method that prints out the tree following an in-order traversal with each value on a seperate line using recursion.
     */
    public void print(){
        print(_root);
    }

    //- a method which prints out the tree following an in-order traversal with
    //each value on a separate line. For example:
    private void print(Node node){
        if (node!= null){
            String leftValue = (node._left != null) ? node._left._value : "null"; //checking if the nodes to left or right are null
            String rightValue = (node._right!= null) ? node._right._value : "null";
            print(node._left);
            System.out.println("Root: " + node._value + " | Left: " + leftValue + " | Right: " + rightValue);
            print(node._right);
        }
    }
    

}
