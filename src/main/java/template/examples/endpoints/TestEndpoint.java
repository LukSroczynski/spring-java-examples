package template.examples.endpoints;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TestEndpoint {

    @RequestMapping(method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void jacksonTest() {

    }
}
