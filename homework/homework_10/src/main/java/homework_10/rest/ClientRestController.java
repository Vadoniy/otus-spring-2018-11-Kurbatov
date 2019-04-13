package homework_10.rest;

import homework_10.domain.customer.Client;
import homework_10.domain.customer.Person;
import homework_10.repository.ClientRepository;
import homework_10.repository.IngredientRepository;
import homework_10.repository.PersonRepository;
import homework_10.rest.dto.ClientDto;
import homework_10.rest.dto.PersonDto;
import homework_10.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClientRestController {

    private ClientRepository clientRepository;
    private PersonRepository personRepository;

    @Autowired
    public ClientRestController(ClientRepository clientRepository
            , PersonRepository personRepository
            , IngredientRepository ingredientRepository) {
        this.clientRepository = clientRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("/client")
    public ClientDto getClient(@RequestParam long id, Model model){
        return clientRepository.findById(id).map(ClientDto::toDto).get();
    }

    @GetMapping("/clients/list")
    public List<ClientDto> getClients(Model model){
        return clientRepository.findAll().stream().map(ClientDto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/client/delete")
    public List<ClientDto> deleteClient(@RequestParam long client_id, Model model) throws IOException {
        clientRepository.delete(clientRepository.findById(client_id).get());
        return clientRepository.findAll().stream().map(ClientDto::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/client/update", consumes = "application/json")
    public void updateClient(@RequestBody ClientDto client,
                             @RequestBody PersonDto person, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            throw new IOException();
        }
        Client cacheClient = clientRepository.findById(client.getId()).get();
        Person cachePerson = personRepository.findById(cacheClient.getPerson().getId()).get();
        cachePerson.setName(person.getName());
        cachePerson.setDay(person.getDay());
        cachePerson.setMonth(person.getMonth());
        cachePerson.setYear(person.getYear());
        cachePerson.setBirthDate(Utils.updateBirthday(person.getDay(), person.getMonth(), person.getYear()));
        personRepository.save(cachePerson);
        cacheClient.setAddress(client.getAddress());
        cacheClient.setAddress(client.getEmail());
        cacheClient.setAddress(client.getPhone());
        cacheClient.setAddress(client.getComment());
        clientRepository.save(cacheClient);
    }
}
