package Facade;

/**
 * 퍼사드 인터페이스
 * 퍼사드 패턴의 인터페이스를 정의합니다.
 * 이를 통해 다양한 퍼사드 구현체를 사용할 수 있습니다.
 */
public interface IFacade {
    void init();
    
    /**
     * 이름으로 데이터를 조회합니다.
     *
     * @param name 조회할 데이터 이름
     * @return 조회된 데이터, 없으면 null
     */
    Data getData(String name);
    
    /**
     * 새로운 데이터를 추가합니다.
     *
     * @param data 추가할 데이터
     */
    void addData(Data data);
}
