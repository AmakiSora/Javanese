package java_.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * HttpClientApi
 * java11新特性
 * HttpClient替换原有的仅适用于阻塞的HttpURLConnection,并提供WebSocket的支持
 * 该api支持同步和异步
 */
public class HttpClientApi {
    public void synchronous() throws IOException, InterruptedException {//同步
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response = httpClient.send(request, responseBodyHandler);
        String body = response.body();
        System.out.println(body);
    }

    public void asynchronous() throws ExecutionException, InterruptedException {//异步
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync = httpClient.sendAsync(request, responseBodyHandler);
        sendAsync.thenApply(HttpResponse::body).thenAccept(System.out::println);
        HttpResponse<String> response = sendAsync.get();
        String body = response.body();
        System.out.println(body);
    }

    //获取某个url的资源
    public void test() {
        try {
            synchronous();
            asynchronous();
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
