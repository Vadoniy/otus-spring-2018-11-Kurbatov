package homework_10.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class WelcomePagesController {

    @GetMapping("/")
    public void startPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/welcomePage");
    }

    @GetMapping("/welcomePage")
    public String welcomePage() {
        return "welcomePage";
    }
}
