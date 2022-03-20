package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;
    private String name;
    private LocalDate DOB;
    private Integer age;
    private String email;
    @ManyToMany
    private List<Skill> skills;
    public Student(Long id, String name, LocalDate DOB, Integer age, String email, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.age = age;
        this.email = email;
        this.skills = skills;
    }

    public Student(String name, LocalDate DOB, Integer age, String email,List<Skill> skills) {
        this.name = name;
        this.DOB = DOB;
        this.age = age;
        this.email = email;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public boolean hasSkill(Skill skill){
        for(Skill currentSkill: getSkills()){
            if(currentSkill.getId() == skill.getId()) {
              return true;
            }

        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DOB=" + DOB +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
