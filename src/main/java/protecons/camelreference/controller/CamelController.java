package protecons.camelreference.controller;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelController {

    private static final Logger log = LoggerFactory.getLogger(CamelController.class);
    @Autowired
    private ProducerTemplate template;

    @GetMapping("/start")
    public String startProcess() {
        log.info("i am here, i have reached for the request");
        template.sendBody("direct:myProcess", "Triggered via REST");
        return "Process Started";
    }
}
