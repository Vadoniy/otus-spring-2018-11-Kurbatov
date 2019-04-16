package homework_10.rest.dto;

public class FullClientDto {
    private ClientDto clientDto;
    private PersonDto personDto;

    public FullClientDto() {
    }

    public ClientDto getClientDto() {
        return clientDto;
    }

    public void setClientDto(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }
}