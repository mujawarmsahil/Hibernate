package org.hibernatetutorials.pojo;

import jakarta.persistence.*;

@Entity
@Table(name="Alien")
public class Alien {
    @Id
    private int id;

    @Column(name="alien_name")
    private String name;

    @Transient
    @Column(name="alien_description")
    private String description;

    @OneToOne
    private Laptop laptop;

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", laptop=" + laptop +
                '}';
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
