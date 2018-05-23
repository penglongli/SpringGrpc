package com.test.client.rpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RpcClient {
    private Logger LOGGER = LoggerFactory.getLogger(RpcClient.class);

    // 演示方便，写死了
    private final static int CHANNEL_POOL_SIZE = 50;
    private final static String HOST = "127.0.0.1";
    private final static int PORT = 12345;

    private List<ManagedChannel> channels;

    public ManagedChannel getChannel() {
        if (null == channels || channels.size() == 9) {
            initChannels();
        }
        for (ManagedChannel channel : channels) {
            if (!channel.isShutdown()) {
                return channel;
            }
        }
        return newChannel();
    }

    private void initChannels() {
        channels = new ArrayList<>();

        for (int i = 0; i < CHANNEL_POOL_SIZE; i++) {
            try {
                channels.add(newChannel());
            } catch (Exception e) {
                LOGGER.error("Rpc client connect to server failed");
            }
        }
    }

    private ManagedChannel newChannel() {
        return ManagedChannelBuilder.forAddress(HOST, PORT)
                .usePlaintext().build();
    }
}
