import java.util.ArrayList;

class Tree<T> {
    private static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;

    public Tree() {
        this.root = null;
    }
    
    public ArrayList<T> levelOrder() {
        ArrayList<T> res = new ArrayList<>();
        if (this.root == null) {
            return res;
        }

        ArrayList<Node<T>> queue = new ArrayList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.remove(0);
            res.add(node.data);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            } 
        }

        return res;
    }

    public void makeTree(ArrayList<T> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException();
        }   
        
        this.root = new Node<>(data.get(0));
        ArrayList<Node<T>> queue = new ArrayList<>();
        queue.add(this.root);

        int index = 1;
        while (queue.size() > 0 && index < data.size()) {
            Node<T> node = queue.remove(0);

            if (data.get(index) != null) {
                node.left = new Node<>(data.get(index));
                queue.add(node.left);
            }
            index++;

            if (data.get(index) != null) {
                node.right = new Node<>(data.get(index));
                queue.add(node.right);
            }
            index++;
        }
    }

    public void insertKey(Tree<T> tree, T key) {
        Node<T> newNode = new Node<>(key);
        if (tree.root == null) {
            tree.root = newNode;
            return;
        } else {
            ArrayList<Node<T>> queue = new ArrayList<>();
            queue.add(tree.root);

            while (!queue.isEmpty()) {
                Node<T> current = queue.remove(0);

                if (current.left == null) {
                    current.left = new Node<>(key);
                    return;
                } else {
                    queue.add(current.left);
                }

                if (current.right == null) {
                    current.right = new Node<>(key);
                    return;
                } else {
                    queue.add(current.right);
                }
            }
        }
    }

    public void deleteKey(T key) {
        if (this.root == null) return;
        
        ArrayList<Node<T>> queue = new ArrayList<>();
        Node<T> deleteNode = null;
        T lastData = null;
        
        // 삭제할 노드 찾기
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove(0);
            lastData = node.data;
            
            if (node.data.equals(key)) {
                deleteNode = node;
            }
            
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        
        if (deleteNode == null) {
            System.out.println("Key " + key + " not found in the tree");
            return;
        }
        
        // 마지막 노드의 부모 찾아서 링크 제거
        queue.clear();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove(0);
            
            if (node.left != null) {
                if (node.left.data.equals(key)) {
                    node.left = null;
                    break;
                } else {
                    queue.add(node.left);
                }
            }
            if (node.right != null) {
                if (node.right.data.equals(key)) {
                    node.right = null;
                    break;
                } else {
                    queue.add(node.right);
                }
            }
        }
        
        // 삭제할 노드에 마지막 데이터 복사
        deleteNode.data = lastData;
    }
}

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(11);
        arr.add(9);
        arr.add(7);
        arr.add(null);
        arr.add(15);
        arr.add(8);
        
        tree.makeTree(arr);
        System.out.println("Initial tree: " + tree.levelOrder());
        
        tree.insertKey(tree, 12);
        System.out.println("After inserting 12: " + tree.levelOrder());
        
        tree.insertKey(tree, 13);
        System.out.println("After inserting 13: " + tree.levelOrder());
        
        tree.deleteKey(12);
        System.out.println("After deleting 12: " + tree.levelOrder());
        
        tree.deleteKey(13);
        System.out.println("After deleting 13: " + tree.levelOrder());
    }
}