package homework_10.page;

import homework_10.domain.customer.Client;
import homework_10.repository.ClientRepository;
import homework_10.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;

@Controller
public class ClientPagesController {

    private ClientRepository clientRepository;
    private PersonRepository personRepository;

    @Autowired
    public ClientPagesController(ClientRepository clientRepository, PersonRepository personRepository) {
        this.clientRepository = clientRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("/clients")
    public String pageClients(Model model){
        model.addAttribute("keywords", "Clients");
        return "clients";
    }

    @GetMapping("/updateClient")
    public String updatePage(@RequestParam long id, Model model){

        Client cacheClient = null;

        try {
            cacheClient = clientRepository.findById(id).get();
        } catch (EntityNotFoundException e){
            e.printStackTrace();
        }
        model.addAttribute("client", cacheClient);
        model.addAttribute("person", cacheClient.getPerson());
        model.addAttribute("id", id);
        return "editClient";
    }

    @GetMapping("/createClient")
    public String getCreateClientPage(Model model) {
        return "createClient";
    }
}
