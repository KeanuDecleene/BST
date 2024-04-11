import java.io.FileReader; //reads a file
import java.io.BufferedReader; //reader for file 
import java.util.Scanner; //scanner for user input
import java.io.IOException; //error handling

/*
 * A class that implements a binary search tree example, prompts the user for an input to interact with the made BST and 
 */
public class DictionaryLookup{
    public DictionaryBST _dictionary;

    /*
     * Dictionary lookup constructor initializes the BST
     */
    public DictionaryLookup(){
        _dictionary = new DictionaryBST();
    }

    /*
     * Starts the prompt for a choice and does the corresponding function to the number given by user.
     * 
     */
    public void startDictionaryLookup(){
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        while (running){
        int choice = getChoice(scan);
        switch (choice) {
            case 1:
                search(scan);
                continueLookup(scan);
                break;
            case 2:
                printGivenWord(scan);
                continueLookup(scan);
                break;
            case 3:
                additem(scan);
                continueLookup(scan);
                break;
            case 4:
                removeItem(scan);
                continueLookup(scan);
                break;
            case 5:
                printDictionary();
                continueLookup(scan);
                break;
            case 6:
                running = false;
                System.out.println("Exiting program");
                break;
            default:
                System.out.println("Please enter a number between 1 and 6");
        }
    }
    scan.close();
    }

    /*
     * prints the full dictionary in alphabetical order.
     */
    public void printDictionary(){
        System.out.println("\n" + "Printing full dictionary..." + "\n");
        _dictionary.printDictionary();
    }

    /*
     * removes the given user inputted word from the BST.
     * 
     * @param scan the scanner for user input
     */
    public void removeItem(Scanner scan){
        System.out.println("\n" + "Removing dictionary item..." + "\n");
        System.out.println("Please enter a word/phrase to remove from the dictionary");
        String word = scan.nextLine();
        _dictionary.remove(word);
        System.out.println("Thank you the item has been removed");
    }

    /*
     * Waits for the user to press any key to continue.
     * 
     * @param scan the scanner for user input
     */
    public void continueLookup(Scanner scan){
        System.out.println("\n" + "Press any key to continue...");
        scan.nextLine();
    }

    /*
     * prompts the user and stores the word and the definition the user gives to then insert into the BST.
     * 
     * @param scan the scanner for user input
     */
    public void additem(Scanner scan){
        System.out.println("\n" + "Adding dictionary item..." + "\n");
        System.out.println("Please enter a word/phrase to add to the dictionary");
        String word = scan.nextLine();
        System.out.println("Thank you, now please enter the definition");
        String definition = scan.nextLine();
        _dictionary.insert(word, definition);
        System.out.println("Thank you the item has been added to the dictionary");
    }

    /*
     * scans for user input to print out the specific words definition. 
     * 
     * @param scan the scanner for user input
     */
    public void printGivenWord(Scanner scan){
        System.out.println("\n" + "Printing dictionary item..." + "\n");
        System.out.println("Please enter a word/phrase to print");
        String word = scan.nextLine();
        System.out.println();
        _dictionary.printDictionaryItem(word);
    }
    /*
     * scans next line and searches for the word/phrase entered by the user displaying the result of the search.
     * 
     * @param scan the scanner for user input
     */
    public void search(Scanner scan){
        System.out.println("\n" + "Searching the dictionary..." + "\n");
        System.out.println("Please enter a word/phrase to search for in the dictionary");
        String word = scan.nextLine();
        System.out.println("The word/phrase '" + word + "' exists in the dictionary: " + _dictionary.search(word) + "\n");
    }

    /*
     * prints the prompt and recieves the choice from the user
     * 
     * @param scan the scanner for user input
     */
    public int getChoice(Scanner scan){
        System.out.println("Please enter a number to indicate what you would like to do");
        System.out.println("    1. Search for a word/phrase in the dictionary");
        System.out.println("    2. Print a given word/phrase and it’s definition");
        System.out.println("    3. Add a word/phrase and definition to the dictionary");
        System.out.println("    4. Remove a word/phrase and definition from the dictionary");
        System.out.println("    5. Print all of the words/phrases and their definitions, in alphabetical order");
        System.out.print("  6. Exit");
        System.out.println();
        int choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

    /*
     * Reads and loads the files values into the BST, and also handles errors.
     * 
     * @param filename the name of the file to be loaded
     */
    public void loadDictionary(String filename){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine())!= null) { //reads each line of the file
                if(!line.trim().isEmpty()){ //checks if the line is not empty
                String[] words = line.split(":"); //splits the line into two seperate parts
                String word = words[0].trim(); 
                String definition = words[1].trim();
                _dictionary.insert(word, definition);
                }
            }
            br.close();
        }catch (IOException e) {
            System.out.println("Error loading dictionary: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DictionaryLookup dicLookup = new DictionaryLookup();
        System.out.println("Loading dictionary...");
        dicLookup.loadDictionary("CS-Dictionary-small.txt");
        dicLookup.startDictionaryLookup();
    }
}