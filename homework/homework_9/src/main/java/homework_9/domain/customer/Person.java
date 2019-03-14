package homework_9.domain.customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "PERSONS")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private LocalDate birthDate;
    private int age;

//    public Person() {}

    public Person(String name, int day, int month, int year) {
        this.name = name;
        this.birthDate = LocalDate.of(year, month, day);
        this.age = getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int day, int month, int year) {
        this.birthDate = LocalDate.of(year, month, day);
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + getAge() +
                '}';
    }
}
