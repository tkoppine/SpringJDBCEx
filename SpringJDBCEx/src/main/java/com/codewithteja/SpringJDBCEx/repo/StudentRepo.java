package com.codewithteja.SpringJDBCEx.repo;

import com.codewithteja.SpringJDBCEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbcTemplate() {
        return jdbc;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student student)
    {
        String sql = "insert into student (rollno, name, marks) values (?,?,?)";

        int rows = jdbc.update(sql, student.getRollNo(), student.getName(), student.getMarks());

        System.out.println(rows + " rows inserted");
    }
    public List<Student> findAll()
    {
        String sql = "select * from student";
        return jdbc.query(sql, ( rs,  rowNum) -> {
            Student student = new Student();
            student.setRollNo(rs.getInt("rollno"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;
        });
    }
}
