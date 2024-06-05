package ru.otus.grpc;

import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import ru.otus.grpc.demo.ExampleApiGrpc;
import ru.otus.grpc.demo.ExampleMessageRequest;
import ru.otus.grpc.demo.ExampleMessageResponse;
import java.time.LocalDateTime;


public class ExampleImpl extends ExampleApiGrpc.ExampleApiImplBase {

        @Override
    public void currentTime(ExampleMessageRequest request,
                            StreamObserver<ExampleMessageResponse> responseObserver) {
        var currentTime = LocalDateTime.now();
        ExampleMessageResponse response = ExampleMessageResponse.newBuilder()
                .setTime(Timestamp.newBuilder()
                        .setNanos(currentTime.getNano())
                        .setSeconds(currentTime.getSecond())
                        .build())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}