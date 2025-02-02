import java.util.ArrayList;
import java.util.List;

class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

public class HashTable<K, V> {
    private final int maxLen;
    private List<List<Entry<K, V>>> table;

    public HashTable(int length) {
        this.maxLen = length;
        this.table = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            this.table.add(new ArrayList<>());
        }
    }

    public HashTable() {
        this(5);  // 기본 크기 5
    }

    private int hash(K key) {
        if (key == null) return 0;
        
        String keyStr = key.toString();
        int sum = 0;
        for (char c : keyStr.toCharArray()) {
            sum += c;
        }
        return Math.abs(sum % maxLen);
    }

    public void set(K key, V value) {
        int h = hash(key);
        List<Entry<K, V>> bucket = table.get(h);
        
        // 이미 존재하는 키인지 확인
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getKey().equals(key)) {
                bucket.set(i, new Entry<>(key, value));  // 값 업데이트
                return;
            }
        }
        
        bucket.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int h = hash(key);
        List<Entry<K, V>> bucket = table.get(h);

        if (bucket.isEmpty()) {
            return null;
        }

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public void printTable() {
        System.out.println("해시 테이블의 상태");
        System.out.println("===============");
        for (int i = 0; i < table.size(); i++) {
            System.out.println(i + " " + formatBucket(table.get(i)));
        }
        System.out.println();
    }

    private String formatBucket(List<Entry<K, V>> bucket) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < bucket.size(); i++) {
            Entry<K, V> entry = bucket.get(i);
            sb.append("(").append(entry.getKey()).append(", ").append(entry.getValue()).append(")");
            if (i < bucket.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        HashTable<String, String> capital = new HashTable<>();
        
        String[] countries = {"Korea", "America", "China", "England", "Türkiye"};
        String[] cities = {"Seoul", "Washington", "Beijing", "London", "Ankara"};

        for (int i = 0; i < countries.length; i++) {
            capital.set(countries[i], cities[i]);
        }

        capital.printTable();

        System.out.println("해시 테이블의 검색 결과");
        System.out.println("====================");
        System.out.println("Capital of America = " + capital.get("America"));
        System.out.println("Capital of Korea = " + capital.get("Korea"));
        System.out.println("Capital of England = " + capital.get("England"));
        System.out.println("Capital of China = " + capital.get("China"));
        System.out.println("Capital of Japan = " + capital.get("Japan"));
        System.out.println("Capital of Türkiye = " + capital.get("Türkiye"));
    }
}