package org.hibernatetutorials.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class School {

    @Id
    @Column(unique = true)
    private int id;

    @Column(name="address")
    private String address;

    @OneToMany(mappedBy = "school")
    private List<Student> students;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", address=" + address +
                ", students=" + students +
                '}';
    }
}
