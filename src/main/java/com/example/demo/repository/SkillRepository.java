package com.example.demo.repository;

import com.example.demo.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository  extends JpaRepository<Skill,Long> {
    public List<Skill> findByLabel(String label);
}
