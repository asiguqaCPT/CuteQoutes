package api;

import io.javalin.Javalin;

public class CuteQuotesServer {
    private final Javalin server;

    public CuteQuotesServer() {
        server = Javalin.create(config -> {
            config.defaultContentType = "application/json";
        });

        this.server.get("/quotes", context -> QuoteApiHandler.getAll(context));
        this.server.get("/quote/{id}", context -> QuoteApiHandler.getOne(context));
        this.server.post("/quotes", context -> QuoteApiHandler.create(context));
    }

    public static void main(String[] args) {
        CuteQuotesServer server = new CuteQuotesServer();
        server.start(5000);
    }

    public void start(int port) {
        this.server.start(port);
    }

    public void stop() {
        this.server.stop();
    }
}