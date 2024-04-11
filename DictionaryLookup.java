import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class DictionaryLookup{
    public DictionaryBST _dictionary;

    public DictionaryLookup(){
        _dictionary = new DictionaryBST();

    }
    public void loadDictionary(String filename){

        }

    public static void main(String[] args) {
        DictionaryLookup dicLookup = new DictionaryLookup();
        dicLookup.loadDictionary("CS-Dictionary-small.txt");
        
    }

}