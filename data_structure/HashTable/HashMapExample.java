import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Java의 HashMap 생성 (내부적으로 체이닝 사용)
        HashMap<String, Integer> studentScores = new HashMap<>();

        // 의도적으로 해시 충돌이 발생할 수 있는 데이터 삽입
        // "Aa"와 "BB"는 같은 해시코드를 가짐
        studentScores.put("Aa", 95);  // hashCode = 2112
        studentScores.put("BB", 87);  // hashCode = 2112

        // 해시 충돌이 발생해도 각각의 값을 정확히 가져올 수 있음
        System.out.println("Aa's score: " + studentScores.get("Aa"));  // 95
        System.out.println("BB's score: " + studentScores.get("BB"));  // 87
        
        // 해시코드 확인
        System.out.println("Hash code of 'Aa': " + "Aa".hashCode());
        System.out.println("Hash code of 'BB': " + "BB".hashCode());
    }
}
