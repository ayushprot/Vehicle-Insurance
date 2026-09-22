package protecons.camelreference.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import protecons.camelreference.dto.Agent;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AgentServiceImpl extends RouteBuilder {

    @Autowired
    DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void configure() throws Exception {

        //Insert Route
        from("direct:insert")
                .process(new Processor() {
            public void process(Exchange xchg) throws Exception {
                //Take the Employee object from the exchange and create the insert query
                Agent agent = xchg.getIn().getBody(Agent.class);
                String query = "INSERT INTO agent(username,password)values('" + agent.getUsername() +  "','"+ agent.getPassword() + "')";
                // Set the insert query in body and call camel jdbc
                xchg.getIn().setBody(query);
            }
        }).to("jdbc:dataSource");

        // Select Route
        from("direct:select")
                .setBody(constant("select * from Employee"))
                .to("jdbc:dataSource")
                .process(new Processor() {
                    public void process(Exchange xchg) throws Exception {
                        //the camel jdbc select query has been executed. We get the list of employees.
                        ArrayList<Map<String, String>> dataList = (ArrayList<Map<String, String>>) xchg.getIn()
                                .getBody();
                        List<Agent> agents = new ArrayList<Agent>();
                        System.out.println(dataList);
                        for (Map<String, String> data : dataList) {
                            Agent agent = new Agent();
                            agent.setUsername(data.get("username"));
                            agent.setPassword(data.get("password"));
                            agents.add(agent);
                        }
                        xchg.getIn().setBody(agents);
                    }
                });
    }
}

