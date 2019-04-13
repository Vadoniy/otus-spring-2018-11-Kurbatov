package homework_9.rest;

import homework_9.domain.customer.Client;
import homework_9.domain.customer.Person;
import homework_9.repository.ClientRepository;
import homework_9.repository.IngredientRepository;
import homework_9.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@Controller
public class ClientController {

    private ClientRepository clientRepository;
    private PersonRepository personRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository
            , PersonRepository personRepository
            , IngredientRepository ingredientRepository) {
        this.clientRepository = clientRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("/clients")
    public String pageClients(Model model){
        model.addAttribute("clients", clientRepository.findAll());
        return "clients";
    }

    @GetMapping("/client/update")
    public String updateClientPage(@RequestParam long id, Model model){
        Client cacheClient = clientRepository.findById(id).get();
        model.addAttribute("client", cacheClient);
        model.addAttribute("person", cacheClient.getPerson());
        model.addAttribute("id", id);
        return "editClient";
    }

    @PutMapping("/client/update")
    public void updateClient(HttpServletResponse response,
                                 @ModelAttribute(value = "client") Client client,
                                 @ModelAttribute(value = "person") Person person) throws IOException {
        Client cacheClient = clientRepository.findById(client.getId()).get();
        Person cachePerson = personRepository.findById(cacheClient.getPerson().getId()).get();
        cacheClient.getPerson().setDay(person.getDay());
        cacheClient.getPerson().setMonth(person.getMonth());
        cacheClient.getPerson().setYear(person.getYear());
        cacheClient.getPerson().setName(person.getName());
        cacheClient.setPerson(cachePerson);
        cacheClient.setAddress(client.getAddress());
        cacheClient.setAddress(client.getEmail());
        cacheClient.setAddress(client.getPhone());
        cacheClient.setAddress(client.getComment());
        clientRepository.save(cacheClient);
        response.sendRedirect("/clients");
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
        client.setPerson(cachePerson);
        client.setRegistryDate(LocalDate.now());
        clientRepository.save(client);
        response.sendRedirect("/clients");
    }

    @GetMapping("/client/delete")
    public void deleteClient(HttpServletResponse response, @RequestParam long id) throws IOException {
        clientRepository.delete(clientRepository.findById(id).get());
        response.sendRedirect("/clients");
    }
}
