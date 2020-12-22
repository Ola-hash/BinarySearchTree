public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;
    private int size;


    public Node<T> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public void insert(T key) {
        size++;
        if (root == null) {
            root = new Node<T>(key);
            return;
        }
        Node<T> node = root;
        Node<T> parent = node.getParent();
        while (node != null) {
            parent = node;
            if (node.getKey().compareTo(key) >= 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        Node<T> newNode = new Node<>(key);
        newNode.setParent(parent);
        if (parent.getKey().compareTo(newNode.getKey()) >= 0) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }

    public Node<T> find(T key) {
        Node<T> node = root;
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node;
            } else if (node.getKey().compareTo(key) > 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return null;
    }

    private Node<T> successor(Node<T> node) {
        Node<T> successor = node.getRight();
        while (successor.getLeft() != null) {
            successor = successor.getLeft();
        }
        return successor;
    }

    public boolean delete(T key) {
        Node<T> nodeToDelete = find(key);
        if (nodeToDelete == null) {
            return false;
        }
        if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null) {
            Node<T> parent = nodeToDelete.getParent();
            if (nodeToDelete == root) {
                root = null;
            } else if (nodeToDelete.getKey().compareTo(parent.getKey()) >= 0) {
                parent.setRight(null);
            } else {
                parent.setLeft(null);
            }
        } else if (nodeToDelete.getLeft() == null && nodeToDelete.getRight() != null) {
            Node<T> parent = nodeToDelete.getParent();
            Node<T> child = nodeToDelete.getRight();
            child.setParent(parent);
            if (nodeToDelete == root) {
                root = child;
            } else if (isRightChild(nodeToDelete)) {
                parent.setRight(child);
            } else {
                parent.setLeft(child);
            }
        } else if (nodeToDelete.getLeft() != null && nodeToDelete.getRight() == null) {
            Node<T> parent = nodeToDelete.getParent();
            Node<T> child = nodeToDelete.getLeft();
            child.setParent(parent);
            if (nodeToDelete == root) {
                root = child;
            } else if (isRightChild(nodeToDelete)) {
                parent.setRight(child);
            } else {
                parent.setLeft(child);
            }
        } else if (nodeToDelete.getLeft() != null && nodeToDelete.getRight() != null) {
            Node<T> successor = successor(nodeToDelete);
            Node<T> parent = successor.getParent();
            Node<T> child = successor.getRight();
            nodeToDelete.setKey(successor.getKey());
            if (isRightChild(successor)) {
                parent.setRight(child);
            } else {
                parent.setLeft(child);
            }
            if (child != null) {
                child.setParent(parent);
            }
        }
        return true;
    }

    private boolean isRightChild(Node<T> node) {
        Node<T> parent = node.getParent();
        return parent.getRight() == node;
    }

    private void printTree(Node<T> node) {
        if (node == null) {
            return;
        }
        printTree(node.getLeft());
        System.out.print(node.getKey() + " ");
        printTree(node.getRight());
    }

    public void printTree() {
        printTree(root);
    }

    private T findMax(Node<T> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getKey();
    }

    public T findMax() {
        if (root == null) {
            return null;
        }
        return findMax(root);
    }

    private T findMaxRekurencja(Node<T> node) {
        if (node.getRight() == null) {
            return node.getKey();
        }
        return findMaxRekurencja(node.getRight());
    }

    public T findMaxRekurencja() {
        return findMaxRekurencja(root);
    }

    private T findMin(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getKey();
    }

    public T findMin() {
        if (root == null) {
            return null;
        }
        return findMin(root);
    }

    private T findMinRekurencja(Node<T> node) {
        if (node.getLeft() == null) {
            return node.getKey();
        }
        return findMinRekurencja(node.getLeft());
    }

    public T findMinRekurencja() {
        return findMinRekurencja(root);
    }

}
