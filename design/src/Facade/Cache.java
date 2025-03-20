package Facade;

import java.util.HashMap;
import java.util.Map;

/**
 * 캐시 시스템 클래스
 * 빠른 데이터 접근을 위한 캐싱 기능을 제공합니다.
 */
public class Cache {
    private final Map<String, Data> cache;
    private final int maxSize;

    public Cache() {
        this(100); // 기본 캐시 크기
    }
    
    public Cache(int maxSize) {
        this.cache = new HashMap<>();
        this.maxSize = maxSize;
        System.out.println("캐시 시스템이 초기화되었습니다. (최대 크기: " + maxSize + ")");
    }

    /**
     * 캐시에 데이터를 저장합니다.
     * 캐시가 가득 찬 경우 간단한 정책으로 처리합니다.
     *
     * @param name 데이터 식별자
     * @param data 저장할 데이터 객체
     */
    public void insert(String name, Data data) {
        if (name == null || data == null) {
            System.out.println("캐시: 유효하지 않은 데이터 삽입 시도");
            return;
        }
        
        // 캐시가 가득 찼는지 확인
        if (cache.size() >= maxSize && !cache.containsKey(name)) {
            System.out.println("캐시: 캐시가 가득 찼습니다. 가장 오래된 항목을 제거합니다.");
            // 실제로는 LRU 등의 정책을 구현해야 하지만, 예제에서는 간단히 처리
            if (!cache.isEmpty()) {
                String firstKey = cache.keySet().iterator().next();
                cache.remove(firstKey);
                System.out.println("캐시: '" + firstKey + "' 항목이 제거되었습니다.");
            }
        }
        
        cache.put(name, data);
        System.out.println("캐시: '" + name + "' 데이터가 캐시에 저장되었습니다.");
    }

    /**
     * 캐시에서 데이터를 조회합니다.
     *
     * @param name 조회할 데이터 식별자
     * @return 조회된 데이터, 없으면 null
     */
    public Data get(String name) {
        if (name == null) {
            System.out.println("캐시: 유효하지 않은 조회 요청");
            return null;
        }
        
        Data result = cache.get(name);
        if (result != null) {
            System.out.println("캐시: '" + name + "' 데이터를 캐시에서 찾았습니다.");
        } else {
            System.out.println("캐시: '" + name + "' 데이터가 캐시에 없습니다.");
        }
        
        return result;
    }
    
    /**
     * 캐시에서 데이터를 제거합니다.
     *
     * @param name 제거할 데이터 식별자
     * @return 제거된 데이터, 없으면 null
     */
    public Data remove(String name) {
        if (name == null) {
            System.out.println("캐시: 유효하지 않은 제거 요청");
            return null;
        }
        
        Data removed = cache.remove(name);
        if (removed != null) {
            System.out.println("캐시: '" + name + "' 데이터가 캐시에서 제거되었습니다.");
        } else {
            System.out.println("캐시: 제거할 '" + name + "' 데이터가 캐시에 없습니다.");
        }
        
        return removed;
    }
    
    /**
     * 캐시를 비웁니다.
     */
    public void clear() {
        int size = cache.size();
        cache.clear();
        System.out.println("캐시: 모든 데이터가 제거되었습니다. (제거된 항목 수: " + size + ")");
    }
    
    /**
     * 현재 캐시 크기를 반환합니다.
     *
     * @return 캐시에 저장된 항목 수
     */
    public int size() {
        return cache.size();
    }
}
