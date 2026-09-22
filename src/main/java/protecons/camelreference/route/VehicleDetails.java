package protecons.camelreference.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class VehicleDetails extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/vehicle")
                .get()
                .routeId("101")
                .produces("application/json")
                .consumes("application/json")
                .to("direct:details");
        from("direct:details")
                .log("Start vehicle details route");
    }
}
