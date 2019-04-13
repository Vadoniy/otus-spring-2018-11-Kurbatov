package homework_10.rest.dto;

import homework_10.domain.manufacture.Ingredient;
import homework_10.domain.manufacture.Pizza;

public class IngRateDto {

    private long id;
    private Pizza pizza;
    private Ingredient ingredient;
    private double rate;

    public IngRateDto() {
    }

    public IngRateDto(Pizza pizza, Ingredient ingredient, double rate) {
        this.pizza = pizza;
        this.ingredient = ingredient;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
