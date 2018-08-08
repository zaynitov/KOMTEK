package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {

    @Id
    @Column(name = "SNILS")
    int SNILS;
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;
    @Column(name = "patronymic")
    String patronymic;
    @Column(name = "birth")
    Date birth;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient",
            cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Blood> blood = new HashSet<Blood>();


    public Patient() {
        super();
    }

    public Patient(String name, String surname, String patronymic, Date birth) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birth = birth;
    }


    public Set<Blood> getBlood() {
        return blood;
    }

    public void setBlood(Set<Blood> blood) {
        this.blood = blood;
    }

    public int getSNILS() {
        return SNILS;
    }

    public void setSNILS(int SNILS) {
        this.SNILS = SNILS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "SNILS=" + SNILS +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birth=" + birth +
                '}';
    }


}
