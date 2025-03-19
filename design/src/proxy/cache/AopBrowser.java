package proxy.cache;

import java.util.concurrent.atomic.AtomicLong;

public class AopBrowser implements IBrowser {
    private String url;
    private Html html;

    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {
        before.run();

        if (html == null) {
            html = new Html(url);
            System.out.println("loading browser: "+url);
        }

        after.run();
        System.out.println("use cache: " + url);
        return html;
    }
}

class AopClient {
    private static AtomicLong start = new AtomicLong();
    private static AtomicLong end = new AtomicLong();

    public static void main(String[] args) {
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("loading aop browser");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });

        aopBrowser.show();
        System.out.println("loading time: " + end.get());

        aopBrowser.show();
        System.out.println("loading time: " + end.get());
    }
}