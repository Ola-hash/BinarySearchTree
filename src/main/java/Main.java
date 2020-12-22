public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(5);
        Node<Integer> root = bst.getRoot();
         bst.insert(3);
         bst.insert(1);
          bst.insert(2);
          //bst.insert(2);
        //  bst.insert(6);
      //    bst.insert(9);
        bst.printTree(root);
        System.out.println("....");
        bst.findMax(root);


    }
}
