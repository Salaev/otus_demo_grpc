package ru.otus.grpc;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.protobuf.services.ProtoReflectionService;
import io.grpc.Server;


import java.io.IOException;
import java.util.logging.Logger;

public class GrpcServer {

    int port;

    public GrpcServer(int port) {
        this.port = port;
    }

    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());

    public void start() throws IOException, InterruptedException {
        Server server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                .addService(new ExampleImpl())
                .addService(ProtoReflectionService.newInstance())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        server.awaitTermination();
    }

}
