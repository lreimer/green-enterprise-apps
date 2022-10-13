package green.enterprise.app;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Optional;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Microservice implements HttpHandler {
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(port());
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/api/green", new Microservice());
        server.setExecutor(null); // creates a default executor
        server.start();        
    }

    static String port() {
        String port = System.getenv("PORT");
        return Optional.ofNullable(port).orElse("8080");
    }
    
    @Override
    public void handle(HttpExchange t) throws IOException {
        String response = "Green Enterprise Apps with Java.";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
