package server;

import com.google.api.graphql.rejoiner.Query;
import com.google.api.graphql.rejoiner.SchemaModule;
import com.google.inject.Inject;

import io.github.oyeprashar.server.proto.Greeting.GreetingResponse;
import io.github.oyeprashar.server.proto.Greeting.GreetingService;
import io.github.oyeprashar.server.proto.Greeting.UserData;
import io.github.oyeprashar.server.proto.GreetingServiceGrpc;


public class GreetingSchemaModule extends SchemaModule {
    @Inject
    GreetingServiceGrpc.GreetingServiceBlockingStub client;


    @Query("getGreeting")
    GreetingResponse getGreeting(UserData request) throws InterruptedException {
        return client.getGreeting(request);
    }
}
