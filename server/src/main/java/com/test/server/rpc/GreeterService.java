package com.test.server.rpc;

import com.test.proto.GreeterGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;

import static com.test.proto.HelloWorld.*;

@Component
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        responseObserver.onNext(HelloReply.newBuilder()
                .setMessage("Hello " + request.getName())
                .build()
        );
        responseObserver.onCompleted();

    }
}
