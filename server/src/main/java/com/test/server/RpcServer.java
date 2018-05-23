package com.test.server;

import com.test.server.rpc.GreeterService;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class RpcServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(RpcServer.class);

    @Autowired
    private GreeterService greeterService;

    @PostConstruct
    public void start() throws IOException {
        int port = 12345;
        LOGGER.info("Rpc Server is starting...");
        ServerBuilder.forPort(port)
                .addService(greeterService)
                .build()
                .start();
        LOGGER.info("Rpc Server started, listening on " + port);
    }
}
