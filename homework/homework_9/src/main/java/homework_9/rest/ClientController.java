package homework_9.rest;

import homework_9.domain.customer.Client;
import homework_9.domain.customer.Person;
import homework_9.repository.ClientRepository;
import homework_9.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

@Controller
public class ClientController {

    private ClientRepository clientRepository;
    private PersonRepository personRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository, PersonRepository personRepository) {
        this.clientRepository = clientRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public void startPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("/clients");
    }

    @GetMapping("/clients")
    public String pageClients(Model model){
        model.addAttribute("clients", clientRepository.findAll());
        return "clients";
    }

    @GetMapping("/createClient")
    public String pageCreateClients(){
        return "createClient";
    }

    @PostMapping("/client/create")
    public void createClient(HttpServletResponse response,
                               @ModelAttribute(value = "client") Client client,
                               @ModelAttribute(value = "person") Person person) throws IOException {
        Person cachePerson = new Person(person.getName(), person.getDay(), person.getMonth(), person.getYear());
        personRepository.save(cachePerson);
//        How to inject person from above to client???
        client.setPerson(cachePerson);
        client.setRegistryDate(LocalDate.now());
        clientRepository.save(client);
        response.sendRedirect("/clients");
    }
}
