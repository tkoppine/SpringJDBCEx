package com.codewithteja.SpringJDBCEx;

import com.codewithteja.SpringJDBCEx.model.Student;
import com.codewithteja.SpringJDBCEx.repo.StudentRepo;
import com.codewithteja.SpringJDBCEx.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);

		Student student = context.getBean(Student.class);
		StudentService studentService = context.getBean(StudentService.class);
		StudentRepo studentRepo = context.getBean(StudentRepo.class);

		student.setRollNo(104);
		student.setName("Noel");
		student.setMarks(80);

		studentService.addStudent(student);
		studentService.getAll();
	}

}
