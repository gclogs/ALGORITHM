public class HashFunctionExamples {
    private static final int TABLE_SIZE = 13; // 소수를 테이블 크기로 사용

    // 1. Division Hash Function
    // 실제 사례: 학생 ID를 해시 테이블 인덱스로 변환
    public static int divisionHash(int studentId) {
        return studentId % TABLE_SIZE;
    }

    // 2. Additive Hash Function
    // 실제 사례: 문자열(이름)을 해시값으로 변환
    public static int additiveHash(String name) {
        int hash = 0;
        for (char c : name.toCharArray()) {
            hash += c;
        }
        return hash % TABLE_SIZE;
    }

    // 3. Rotating Hash Function
    // 실제 사례: URL을 해시값으로 변환
    public static int rotatingHash(String url) {
        int hash = 0;
        for (char c : url.toCharArray()) {
            hash = (hash << 4) ^ (hash >> 28) ^ c;
        }
        return Math.abs(hash % TABLE_SIZE);
    }

    // 4. Universal Hash Function
    // 실제 사례: 전화번호를 해시값으로 변환
    public static int universalHash(long phoneNumber) {
        int a = 1717; // 임의의 소수
        int b = 31;   // 임의의 상수
        int p = 524287; // 메르센 소수
        return (int)(((a * phoneNumber + b) % p) % TABLE_SIZE);
    }

    // 5. Perfect Hash Function
    // 실제 사례: Java 예약어를 해시값으로 변환
    public static int perfectHash(String keyword) {
        String[] keywords = {"if", "else", "for", "while", "break", "continue", "return"};
        for (int i = 0; i < keywords.length; i++) {
            if (keywords[i].equals(keyword)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 1. Division Hash - 학생 ID
        int[] studentIds = {1234, 5678, 9012, 3456};
        System.out.println("\n1. Division Hash (학생 ID):");
        for (int id : studentIds) {
            System.out.printf("학생 ID %d의 해시값: %d%n", id, divisionHash(id));
        }

        // 2. Additive Hash - 이름
        String[] names = {"John", "Jane", "Bob", "Alice"};
        System.out.println("\n2. Additive Hash (이름):");
        for (String name : names) {
            System.out.printf("이름 '%s'의 해시값: %d%n", name, additiveHash(name));
        }

        // 3. Rotating Hash - URL
        String[] urls = {
            "https://example.com",
            "https://google.com",
            "https://github.com"
        };
        System.out.println("\n3. Rotating Hash (URL):");
        for (String url : urls) {
            System.out.printf("URL '%s'의 해시값: %d%n", url, rotatingHash(url));
        }

        // 4. Universal Hash - 전화번호
        long[] phoneNumbers = {1234567890L, 9876543210L, 5555555555L};
        System.out.println("\n4. Universal Hash (전화번호):");
        for (long phone : phoneNumbers) {
            System.out.printf("전화번호 %d의 해시값: %d%n", phone, universalHash(phone));
        }

        // 5. Perfect Hash - Java 예약어
        String[] keywords = {"if", "else", "for", "while"};
        System.out.println("\n5. Perfect Hash (Java 예약어):");
        for (String keyword : keywords) {
            System.out.printf("예약어 '%s'의 해시값: %d%n", keyword, perfectHash(keyword));
        }
    }
}
