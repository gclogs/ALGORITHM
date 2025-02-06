import java.util.*;

class HashMapTree<T> {
    private HashMap<Integer, T> tree;
    
    public HashMapTree() {
        tree = new HashMap<>();
    }
    
    public void insert(int index, T value) {
        tree.put(index, value);
    }
    
    public T get(int index) {
        return tree.get(index);
    }
    
    public void delete(int index) {
        tree.remove(index);
    }
    
    public ArrayList<T> levelOrder() {
        ArrayList<T> result = new ArrayList<>();
        int index = 1;
        while (tree.containsKey(index)) {
            result.add(tree.get(index));
            index++;
        }
        return result;
    }
    
    public ArrayList<T> preOrder() {
        ArrayList<T> result = new ArrayList<>();
        preOrderTraversal(1, result);
        return result;
    }
    
    private void preOrderTraversal(int index, ArrayList<T> result) {
        if (!tree.containsKey(index)) return;
        
        result.add(tree.get(index));
        preOrderTraversal(2 * index, result);     // left child
        preOrderTraversal(2 * index + 1, result); // right child
    }
    
    public void makeTree(ArrayList<T> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != null) {
                tree.put(i + 1, arr.get(i));
            }
        }
    }
}
