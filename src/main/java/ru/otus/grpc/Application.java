package ru.otus.grpc;

import java.io.IOException;

public class Application {
    static int port = 8091;

    public static void main(String[] args) throws IOException, InterruptedException {
        final GrpcServer server = new GrpcServer(port);
        server.start();
    }

}
