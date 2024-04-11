/*
 * A Binary Search Tree that is unbalanced, assumes 
 * duplicates are not allowed, uses self referential nodes,
 * and the operations are implemented using recursion.
 * 
 * @author Keanu De Cleene
 */
public class DictionaryBST{
    public DictionaryNode _root;

    /* 
     * adds the value to the BST using recursion and, maintains ordering by using the compareTo method.
     * 
     * @param s the value to be added to the BST.
     */
    public void insert(String s, String definition){
        _root = insert(_root, s, definition);
    }

    /*
     * inserts the value into the BST using recursion and assumes duplicates are not allowed.
     * 
     * @param node the node to be inserting the value into at the top of the subtree 
     * @param value the value to be inserted 
     * @return the new node
     */
    private DictionaryNode insert(DictionaryNode node, String value, String definition){
        if(node == null){
            node = new DictionaryNode(value, definition);
        }
        else if(value.compareTo(node._value) < 0){
            node._left = insert(node._left, value, definition);
        }
        else if(value.compareTo(node._value) > 0){
            node._right = insert(node._right, value, definition);
        }
        return node;
    }

    /*
     * prints the value and definition of a specific given word/phrase using recursion.
     * 
     * @param s the word/phrase to be printed
     */
    public void printDictionaryItem(String s){
        printDictionaryItem(_root, s);
    }

    /*
     * prints the value and definition of a specific given word/phrase using recursion.
     * 
     * @param s the word/phrase to be printed
     * @param the specific node holding the word or phrase
     */
    private void printDictionaryItem(DictionaryNode node, String s){
        if (node == null){
            System.out.println("Word/Phrase not found.");
        }
        else if(s.compareTo(node._value) == 0){
            System.out.println(node._value + "\n" + node._definition);
        }
        else if(s.compareTo(node._value) < 0){
            printDictionaryItem(node._left, s);
        }
        else {
            printDictionaryItem(node._right, s);
        }
        }

    /*
     * prints the value and definition of each node in alphabetical order printing only the current node using recursion.
     * 
     */
    public void printDictionary(){
        printDictionary(_root);
    }

    /*
     * prints the value and current node.
     * 
     * @return the node to print next
     */
    private void printDictionary(DictionaryNode node){
        if (node != null){
            printDictionary(node._left);
            System.out.println(node._value + "\n" + node._definition + "\n");
            printDictionary(node._right);
        }
    }

    /*
     * Finds the height of the tree using recursion.
     * 
     * @return the height of the tree
     */
    public int height(){
        int height = height(_root);
        return height;
    }

    /*
    * Calculates the height of the tree or subtree rooted at the given node.
    * This method uses recursion to calculate the height.
    *
    * @param node The root node of the tree or subtree whose height is to be calculated.
    * @return The height of the tree or subtree
    */
    private int height(DictionaryNode node){
        if (node == null) {return 0;}
        else {
            int lHeight = height(node._left);
            int rHeight = height(node._right);
            return (lHeight > rHeight) ? lHeight + 1 : rHeight + 1; // returns the larger height of the subtrees
        }

    }

    /*
     * removes the value from the BST using recursion.
     * 
     * @param s the value to be removed from the BST
     */
    public void remove(String s){
        _root = remove(_root, s); // removes the value 
    }
    
    /*
     * Searches for the node to remove then deals with the case where the node is a leaf node,
     * or a parent node with one or more children. 
     * 
     * @param node the node to search
     * @param value the value to be removed from the BST
     * @return the node to remove &
     */
    private DictionaryNode remove(DictionaryNode node, String value){
        //search for the node to remove 
        if (node == null) {return node;}
        if (value.compareTo(node._value) < 0){
            node._left = remove(node._left, value);
        }
        else if (value.compareTo(node._value) > 0){
            node._right = remove(node._right, value);
        }
        else {
            //Node is a leaf node 
            if (node._left == null && node._right == null){
                return null;
            }
            //Node has only one child
            else if(node._left == null){ 
                return node._right;
            }
            else if(node._right == null){
                return node._left;
            }
            //node has two children finds the minimum value in the right subtree
            else{
                DictionaryNode minRight = findMin(node._right);
                //replace value with the minimum right value
                node._value = minRight._value;
                //remove the node with the miminum value 
                node._right = remove(node._right, minRight._value);
            }
        }
        return node;
    }

    /*
     * helps find the node with the minimum value using recursion
     * 
     * @param node the node to find the minimum value in
     */
    private DictionaryNode findMin(DictionaryNode node){
        if(node._left == null){
            return node;
        }
        return findMin(node._left);
    }
    

    /*  
     * searches the tree to find the specified value using recursion and returns the boolean true,
     * if the value is found, false otherwise.
     * 
     * @param s the value to be searched for in the BST.
     * @return true if the value is found in the tree, false otherwise.
     */
    public boolean search(String s){
        return search(_root, s);
    }

    /*
     * Searches for a specific value within the binary search tree starting from a given node.
     * This method uses recursion to traverse the tree. It compares the target value with the current node's value
     * to decide whether to search in the left or right subtree or if the value is found.
     *
     * @param node The starting node for the search.
     * @param value The value to search for in the tree.
     * @return true if the value is found in the tree, false otherwise.
     */
    private boolean search(DictionaryNode node, String value){
        if(node == null){
            return false;
        }
        else if(node._value.equals(value)){
            return true;
        }
        else if(value.compareTo(node._value) < 0){
            return search(node._left, value);
        }
        else if (value.compareTo(node._value) > 0){
            return search(node._right, value);
        }
        else{
            return false;
        }
    }

    /*
     * A method that prints out the tree following an in-order traversal with each value on a seperate line using recursion.
     */
    public void print(){
        print(_root);
    }

    /*
     * A method that prints out the tree following an in-order traversal with each value on a seperate line using recursion
     * 
     * @param node the node to be printing
     */
    private void print(DictionaryNode node){
        if (node!= null){
            String leftValue = (node._left != null) ? node._left._value : "null"; //checking if the nodes to left or right are null
            String rightValue = (node._right!= null) ? node._right._value : "null";
            print(node._left);
            System.out.println("Root: " + node._value + " | Left: " + leftValue + " | Right: " + rightValue);
            print(node._right);
        }
    }
    

}
