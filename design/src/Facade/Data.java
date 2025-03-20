package Facade;

/**
 * 데이터 클래스
 * 시스템에서 관리하는 사용자 데이터를 표현합니다.
 */
public class Data {
    private final String name;
    private final String password;
    private final String email;
    private final long createdAt;

    public Data(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.createdAt = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getCreatedAt() {
        return createdAt;
    }
    
    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
