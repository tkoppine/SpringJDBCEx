package com.codewithteja.SpringJDBCEx.service;

import com.codewithteja.SpringJDBCEx.model.Student;
import com.codewithteja.SpringJDBCEx.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class StudentService {
    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student student)
    {
        repo.save(student);
    }
    public void getAll()
    {
        System.out.println(repo.findAll());
    }
}
