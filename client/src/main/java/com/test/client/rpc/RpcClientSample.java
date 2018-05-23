package com.test.client.rpc;

import com.test.proto.GreeterGrpc;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;

import static com.test.proto.HelloWorld.*;
import static com.test.proto.GreeterGrpc.*;

@Service
public class RpcClientSample extends RpcClient {

    public String sayHello(String name) {
        ManagedChannel channel = getChannel();
        GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        HelloReply reply = stub.sayHello(
                HelloRequest.newBuilder()
                        .setName(name)
                        .build()
        );
        return reply.getMessage();
    }
}
