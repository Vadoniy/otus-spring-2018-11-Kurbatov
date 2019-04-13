package homework_9.domain.manufacture;

import javax.persistence.*;

@Entity
@Table(name = "INGREDIENTSRATE")
public class IngRate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Pizza pizza;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Ingredient ingredient;
    @Column
    private double rate;

    public IngRate() {
    }

    public IngRate(Pizza pizza, Ingredient ingredient, double rate) {
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
