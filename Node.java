/*
 * A class that represents a node in a binary search tree.
 * 
 * @author Keanu De Cleene
 */
public class Node {

 public String _value; 
 public Node _left;
 public Node _right;

 /**
  * A constructor that initializes a node with a value.
  *  
  * @param value the value of the node to enter.
  */
 public Node(String value){
    _value = value;
    _left = null;
    _right = null;
 }

}
