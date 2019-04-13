package homework_10.rest.dto;

import homework_10.domain.manufacture.Pizza;

public class PizzaDto {

    private long id = -1;
    private String name;

    public PizzaDto() {
    }

    public PizzaDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PizzaDto toDto(Pizza pizza) {
        return new PizzaDto(pizza.getId(), pizza.getName());
    }
}
