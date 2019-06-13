package homework_10.rest.dto;

import homework_10.domain.manufacture.Ingredient;

public class IngredientDto {

    private long id;
    private String name;
    private String description;
    private double quantity;
    private String measure;
    private String type;

    public IngredientDto() {}

    public IngredientDto(String name, double quantity, String measure, String type) {
        this.name = name;
        this.quantity = quantity;
        this.measure = measure;
        this.type = type;
    }

    public IngredientDto(long id, String name, String description, double quantity, String measure, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public static IngredientDto toDto(Ingredient ingredient) {
        return new IngredientDto(ingredient.getId()
                , ingredient.getName()
                , ingredient.getDescription()
                , ingredient.getQuantity()
                , ingredient.getMeasure()
                , ingredient.getType());
    }
}
