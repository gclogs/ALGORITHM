package proxy.cache;

public class Browser implements IBrowser {

    private String url;

    public Browser(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("Loading " + url);
        return new Html(url);
    }
}

class Client {
    public static void main(String[] args) {
        IBrowser browser = new BrowserProxy("http://www.google.com");
        browser.show();
        browser.show();
        browser.show();
    }
}