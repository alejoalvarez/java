# HTTP Client API

Java 11 added a new module java.net.http and a package java.net.http to define the HTTP Client and WebSocket APIs.

This package contains several classes and interfaces to provide high-level client interfaces to HTTP and low-level client interfaces to WebSocket.

We can use these classes and interface to sent synchronous or asynchronous requests.

## List of Interfaces

The following are the interfaces of the java.net.http package and can be used to handle client requests and responses.

| Interface | Description |
|---|---|
| HttpClient.Builder| A builder of HTTP Clients.|
| HttpRequest.BodyPublisher| A BodyPublisher converts high-level Java objects into a flow of byte buffers suitable for sending as a request body.|
| HttpRequest.Builder| A builder of HTTP requests.|
| HttpResponse<T>| An HTTP response.|
| HttpResponse.BodyHandler<T> | A handler for response bodies.|
| HttpResponse.BodySubscriber<T> | A BodySubscriber consumes response body bytes and converts them into a higher-level Java type.|
| HttpResponse.PushPromiseHandler<T>| A handler for push promises.|
| HttpResponse.ResponseInfo | Initial response information supplied to a BodyHandler when a response is initially received and before the body is processed.|
| WebSocket | A WebSocket Client.|
| WebSocket.Builder | A builder of WebSocket Clients.|
| WebSocket.Listener | The receiving interface of WebSocket.|

## List of Classes

The following are the classes under the java.net.http package and used to create HttpClient and connect to the host.

| Class | Description |
|---|---|
| HttpClient | An HTTP Client.|
| HttpHeaders | A read-only view of a set of HTTP headers.|
| HttpRequest | An HTTP request.|
| HttpRequest.BodyPublishers | Implementations of BodyPublisher that implement various useful publishers, such as publishing the request body from a String, or from a file.|
| HttpResponse.BodyHandlers | Implementations of BodyHandler that implement various useful handlers, such as handling the response body as a String, or streaming the response body to a file.|
| HttpResponse.BodySubscribers|Implementations of BodySubscriber that implement various useful subscribers, such as converting the response body bytes into a String, or streaming the bytes to a file.|

## Time for an Example:

In this example, we are sending a get request to "studytonight.com" by using HttpClient.

```java
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://www.example.com"))
				.build();
		HttpClient httpClient = HttpClient.newBuilder()
				.version(Version.HTTP_2)
				.followRedirects(Redirect.NORMAL)
				.connectTimeout(Duration.ofSeconds(20))
				.build();
		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		System.out.println(response.statusCode());

	}
}
RESULT:
200
```

