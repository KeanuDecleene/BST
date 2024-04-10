public class Main {
    public static void main(String[] args) {
        StrBST BST = new StrBST();
        System.out.println("Testing BST");
        BST.insert("C");
        BST.insert("B");
        BST.insert("A");
        BST.insert("E");
        BST.insert("D");
        BST.print();
        System.out.println(BST.search("A"));
        System.out.println(BST.search("F"));
        System.out.println(BST.height());
        StrBST BST2 = new StrBST();
        System.out.println(BST2.height());
        BST2.insert("C");
        System.out.println(BST2.height());
        BST.remove("B");
        BST.remove("C");
        BST.remove("A");
        BST.print();
    }
}
