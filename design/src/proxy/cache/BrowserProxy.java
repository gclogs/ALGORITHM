package proxy.cache;

public class BrowserProxy implements IBrowser {
    private String url;
    private Html html;
    
    public BrowserProxy(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        if (html == null) {
            html = new Html(url);
            System.out.println("loading browser: "+url);
        } else {
            System.out.println("use cache: " + url);
        }
        return html;
    }
}
