package homework_9.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public void startPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/welcomePage");
    }

    @GetMapping("/welcomePage")
    public String welcomePage() {
        return "welcomePage";
    }

    @GetMapping("/exit")
    public void exit() {
        System.exit(100500);
    }
}
