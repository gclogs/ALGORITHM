package proxy.cache;

public class Main {
    public static void main(String[] args) {
        IBrowser browser = new BrowserProxy("http://www.example.com");
        browser.show();
        browser.show();
    }
}
