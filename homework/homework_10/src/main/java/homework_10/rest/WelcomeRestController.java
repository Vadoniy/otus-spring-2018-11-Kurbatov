package homework_10.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

    @GetMapping("/exit")
    public void stopProgram() {
        System.exit(100500);
    }
}
