package Facade;

import java.util.HashMap;
import java.util.Map;

/**
 * 데이터베이스 관리 시스템 클래스
 * 실제 데이터베이스 연산을 시뮬레이션합니다.
 */
public class DBMS {
    private final Map<String, Data> db;

    public DBMS() {
        this.db = new HashMap<>();
        System.out.println("DBMS가 초기화되었습니다.");
    }

    /**
     * 데이터베이스에 데이터를 삽입합니다.
     *
     * @param name 데이터 식별자
     * @param data 저장할 데이터 객체
     */
    public void insert(String name, Data data) {
        if (name == null || data == null) {
            System.out.println("DBMS: 유효하지 않은 데이터 삽입 시도");
            return;
        }
        
        db.put(name, data);
        System.out.println("DBMS: '" + name + "' 데이터가 저장되었습니다.");
    }

    /**
     * 데이터베이스에서 데이터를 조회합니다.
     *
     * @param name 조회할 데이터 식별자
     * @return 조회된 데이터, 없으면 null
     */
    public Data query(String name) {
        if (name == null) {
            System.out.println("DBMS: 유효하지 않은 쿼리 요청");
            return null;
        }
        
        // 실제 데이터베이스 조회를 시뮬레이션하기 위한 지연
        try {
            Thread.sleep(100); // 데이터베이스 조회는 캐시보다 느림을 시뮬레이션
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Data result = db.get(name);
        if (result != null) {
            System.out.println("DBMS: '" + name + "' 데이터를 찾았습니다.");
        } else {
            System.out.println("DBMS: '" + name + "' 데이터를 찾을 수 없습니다.");
        }
        
        return result;
    }
    
    /**
     * 데이터베이스에서 데이터를 삭제합니다.
     *
     * @param name 삭제할 데이터 식별자
     * @return 삭제된 데이터, 없으면 null
     */
    public Data delete(String name) {
        if (name == null) {
            System.out.println("DBMS: 유효하지 않은 삭제 요청");
            return null;
        }
        
        Data removed = db.remove(name);
        if (removed != null) {
            System.out.println("DBMS: '" + name + "' 데이터가 삭제되었습니다.");
        } else {
            System.out.println("DBMS: 삭제할 '" + name + "' 데이터가 없습니다.");
        }
        
        return removed;
    }
}
