package Observer;

public class Client {
    public static void main(String[] args) {
        WeatherAPI api = new WeatherAPI();
        api.registerObserver(new KoreanUser("김성우"));
        api.registerObserver(new KoreanUser("김영훈"));
        api.registerObserver(new KoreanUser("김영훈"));

        api.measurementsChanged();
        api.measurementsChanged();
    }
}
