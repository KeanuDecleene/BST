/*
 * A class that represents a node in a binary search tree.
 * 
 * @author Keanu De Cleene
 */
public class DictionaryNode {
 public String _value; 
 public DictionaryNode _left;
 public DictionaryNode _right;
 public String _definition;

 /**
  * A constructor that initializes a node with a value.
  *  
  * @param value the value of the node to enter.
  */
 public DictionaryNode(String value, String definition) {
    _value = value; //ensures the value is all uppercase
    _definition = definition;
    _left = null;
    _right = null;
 }
}
