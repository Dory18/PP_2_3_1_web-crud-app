package org.web.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Фамилия должна быть заполнена")
    @Size(min = 2, max = 50, message = "Имя не может превышать 50 символов и быть меньше 2")
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty(message = "Имя должно быть заполнено")
    @Size(min = 2, max = 30, message = "Имя не может превышать 30 символов и быть меньше 2")
    @Column(name = "first_name")
    private String firstName;
    @Size(min = 2, max = 40, message = "Имя не может превышать 40 символов и быть меньше 2")
    @Column(name = "middle_name")
    private String middleName;
    @NotNull(message = "Укажите возраст")
    @Min(value = 14, message = "Пользователь должен быть старше 14 лет")
    @Column(name = "age")
    private int age;

    public User() {

    }

    public User(String lastName, String firstName, String middleName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", lastName='" + lastName + '\'' +
               ", firstName='" + firstName + '\'' +
               ", middleName='" + middleName + '\'' +
               ", age=" + age +
               '}';
    }
}
