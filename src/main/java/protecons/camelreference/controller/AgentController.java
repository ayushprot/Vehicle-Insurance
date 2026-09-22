package protecons.camelreference.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import protecons.camelreference.dto.Agent;

import java.util.List;

@RestController
public class AgentController {

    @Autowired
    ProducerTemplate producerTemplate;

    @RequestMapping(value = "/agents", method = RequestMethod.GET)
    public List<Agent> getAllEmployees() {
        List<Agent> employees = producerTemplate.requestBody("direct:select", null, List.class);
        return employees;

    }

    @RequestMapping(value = "/agents", consumes = "application/json", method = RequestMethod.POST)
    public boolean insertEmployee(@RequestBody Agent emp) {
        producerTemplate.requestBody("direct:insert", emp, List.class);
        return true;
    }
}