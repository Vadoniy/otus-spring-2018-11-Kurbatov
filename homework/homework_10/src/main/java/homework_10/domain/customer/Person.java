package homework_10.domain.customer;

import homework_10.utils.Utils;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PERSONS")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private int day;
    private int month;
    private int year;
    private LocalDate birthDate;
    private int age;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.birthDate = Utils.updateBirthday(day, month, year);
        this.age = Utils.getAge(birthDate);
    }

    public Person(long id, String name, int day, int month, int year, LocalDate birthDate, int age) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.birthDate = birthDate;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
