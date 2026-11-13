package com.webdev2.runner;

import com.webdev2.model.*;
import com.webdev2.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Lab9Runner implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public Lab9Runner(DepartmentRepository departmentRepository,
                      StudentRepository studentRepository,
                      CourseRepository courseRepository,
                      EnrollmentRepository enrollmentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("=== STARTING LAB 9 SMOKE TEST ===");

        // Test Department and Employee Cascade
        Department dept = new Department("Information Technology");
        Employee emp = new Employee("Kaizer Palabay", "Developer");
        dept.addEmployee(emp);
        departmentRepository.save(dept);
        System.out.println("Saved department with cascaded employees successfully.");

        // Test Student, Course, and Enrollment Association
        Student student = new Student("Alice");
        Course course = new Course("Web Development 2");
        studentRepository.save(student);
        courseRepository.save(course);

        Enrollment enrollment = new Enrollment(student, course, "A");
        enrollmentRepository.save(enrollment);
        System.out.println("Saved student enrollment association successfully.");

        System.out.println("=== LAB 9 SMOKE TEST COMPLETED ===");
    }
}