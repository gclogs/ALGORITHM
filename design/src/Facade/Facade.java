package Facade;

/**
 * 퍼사드 패턴의 핵심 클래스
 * 복잡한 서브시스템(DBMS, Cache)에 대한 단순한 인터페이스를 제공합니다.
 */
public class Facade implements IFacade {
    private final DBMS dbms;
    private final Cache cache;

    public Facade() {
        this.dbms = new DBMS();
        this.cache = new Cache();
    }

    /**
     * 시스템 초기화 - 테스트 데이터 삽입
     */
    @Override
    public void init() {
        dbms.insert("test", new Data("test", "password123", "test@example.com"));
        System.out.println("시스템이 초기화되었습니다.");
    }

    /**
     * 데이터 조회 작업을 수행합니다.
     * 1. 먼저 캐시에서 데이터를 찾습니다.
     * 2. 캐시에 없으면 DBMS에서 조회합니다.
     * 3. DBMS에서 찾은 데이터는 캐시에 저장합니다.
     *
     * @param name 조회할 데이터의 이름
     * @return 조회된 데이터, 없으면 null
     */
    @Override
    public Data getData(String name) {
        System.out.println(name + " 데이터 조회를 시작합니다.");
        
        // 1. 캐시에서 먼저 조회
        Data data = cache.get(name);
        if(data != null) {
            System.out.println("캐시에서 데이터를 찾았습니다: " + data.getName());
            return data;
        }
        
        // 2. DBMS에서 조회
        System.out.println("캐시에 데이터가 없어 DBMS에서 조회합니다.");
        data = dbms.query(name);
        
        // 3. 데이터가 있으면 캐시에 저장
        if(data != null) {
            System.out.println("DBMS에서 데이터를 찾았습니다: " + data.getName());
            cache.insert(name, data);
            System.out.println("찾은 데이터를 캐시에 저장했습니다.");
        } else {
            System.out.println("데이터를 찾을 수 없습니다: " + name);
        }
        
        return data;
    }
    
    /**
     * 새로운 데이터를 시스템에 추가합니다.
     * DBMS와 캐시에 동시에 저장합니다.
     *
     * @param data 저장할 데이터 객체
     */
    @Override
    public void addData(Data data) {
        if (data == null) {
            System.out.println("유효하지 않은 데이터입니다.");
            return;
        }
        
        String name = data.getName();
        System.out.println("새 데이터를 추가합니다: " + name);
        
        // DBMS와 캐시에 동시에 저장
        dbms.insert(name, data);
        cache.insert(name, data);
        
        System.out.println("데이터가 성공적으로 추가되었습니다.");
    }
}
