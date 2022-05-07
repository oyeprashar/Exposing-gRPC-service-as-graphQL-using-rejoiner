package server;

import com.google.inject.AbstractModule;
import io.github.oyeprashar.server.proto.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCAppClientModule extends AbstractModule {
    private static final String HOST = "localhost";
    private static final int PORT = 8089;

    @Override
    protected void configure() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(HOST,PORT).usePlaintext().build();
        bind(GreetingServiceGrpc.GreetingServiceBlockingStub.class).toInstance(GreetingServiceGrpc.newBlockingStub(channel));
        bind(GreetingServiceGrpc.GreetingServiceFutureStub.class).toInstance(GreetingServiceGrpc.newFutureStub(channel));

    }
}
