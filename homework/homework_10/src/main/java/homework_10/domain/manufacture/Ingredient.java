package homework_10.domain.manufacture;

import javax.persistence.*;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredient {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "QUANTITY")
    private double quantity;
    @Column(name = "MEASURE")
    private String measure;
    @Column(name = "TYPE")
    private String type;

    public Ingredient() {}

    public Ingredient(String name, double quantity, String measure, String type) {
        this.name = name;
        this.quantity = quantity;
        this.measure = measure;
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
