package server;

import com.google.api.graphql.rejoiner.Query;
import com.google.api.graphql.rejoiner.SchemaModule;
import com.google.inject.Inject;
import io.github.oyeprashar.server.proto.Greeting.GreetingService;
import io.github.oyeprashar.server.proto.GreetingServiceGrpc;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GRPCAppSchemaModule extends SchemaModule {

    @Inject
    GreetingServiceGrpc.GreetingServiceBlockingStub client;

    @Query("weather")
    String getWeather() throws InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("================= At weather service start============"+dtf.format(now));
       // Thread.sleep(8000);
        now = LocalDateTime.now();
        System.out.println("================= At weather service stop============"+dtf.format(now));
        return "temperature is 32 degree celcius";
    }

}
