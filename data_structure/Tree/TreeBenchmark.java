import java.util.*;

public class TreeBenchmark {
    private static final int ITERATIONS = 100;
    private static final int TREE_SIZE = 10;  // 더 작은 크기로 시작
    
    private static ArrayList<Integer> createTestData() {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(10);  // root
        data.add(11);  // left child of root
        data.add(9);   // right child of root
        data.add(7);
        data.add(null);
        data.add(15);
        data.add(8);
        return data;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> testData = createTestData();
        
        // 1. ArrayList Tree 벤치마크
        System.out.println("ArrayList Tree 테스트 시작...");
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            Tree<Integer> arrayListTree = new Tree<>();
            arrayListTree.makeTree(testData);
            arrayListTree.levelOrder();
        }
        long arrayListTime = System.nanoTime() - startTime;
        
        // 2. HashMap Tree 벤치마크
        System.out.println("HashMap Tree 테스트 시작...");
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            HashMapTree<Integer> hashMapTree = new HashMapTree<>();
            hashMapTree.makeTree(testData);
            hashMapTree.levelOrder();
        }
        long hashMapTime = System.nanoTime() - startTime;
        
        // 결과 출력
        System.out.println("\n=== 벤치마크 결과 ===");
        System.out.println("테스트 반복 횟수: " + ITERATIONS);
        System.out.println("트리 크기: " + testData.size());
        System.out.println("\nArrayList Tree 평균 실행 시간: " + arrayListTime/ITERATIONS + "ns");
        System.out.println("HashMap Tree 평균 실행 시간: " + hashMapTime/ITERATIONS + "ns");
        
        // 메모리 사용량 측정
        System.out.println("\n메모리 사용량 측정 시작...");
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        
        // ArrayList Tree 메모리 측정
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        ArrayList<Tree<Integer>> arrayListTrees = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            Tree<Integer> tree = new Tree<>();
            tree.makeTree(testData);
            arrayListTrees.add(tree);
        }
        long arrayListMemory = runtime.totalMemory() - runtime.freeMemory() - memoryBefore;
        
        // 메모리 정리
        arrayListTrees.clear();
        System.gc();
        try {
            Thread.sleep(1000);  // GC가 동작할 시간을 줍니다
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // HashMap Tree 메모리 측정
        memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        ArrayList<HashMapTree<Integer>> hashMapTrees = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            HashMapTree<Integer> tree = new HashMapTree<>();
            tree.makeTree(testData);
            hashMapTrees.add(tree);
        }
        long hashMapMemory = runtime.totalMemory() - runtime.freeMemory() - memoryBefore;
        
        System.out.println("\n=== 메모리 사용량 ===");
        System.out.println("ArrayList Tree: " + arrayListMemory/ITERATIONS + " bytes per tree");
        System.out.println("HashMap Tree: " + hashMapMemory/ITERATIONS + " bytes per tree");
        
        // 기능 테스트
        System.out.println("\n=== 기능 테스트 ===");
        Tree<Integer> arrayListTree = new Tree<>();
        arrayListTree.makeTree(testData);
        System.out.println("ArrayList Tree Level Order: " + arrayListTree.levelOrder());
        
        HashMapTree<Integer> hashMapTree = new HashMapTree<>();
        hashMapTree.makeTree(testData);
        System.out.println("HashMap Tree Level Order: " + hashMapTree.levelOrder());
    }
}
