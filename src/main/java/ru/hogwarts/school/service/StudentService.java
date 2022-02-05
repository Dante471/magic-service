package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.ObjectNotFoundException;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentService {

    private final Map<Long, Student> students = new HashMap<>();
    private long generatedStudentId;

    public Student addStudent(Student student) {
        students.put(generatedStudentId, student);
        generatedStudentId++;
        return student;
    }

    public Student getStudentById(Long studentId) {
        if(!students.containsKey(studentId)) {
            throw new ObjectNotFoundException();
        }
        return students.get(studentId);
    }

    public Student updateStudent(Long studentId, Student student) {
        if(!students.containsKey(studentId)) {
            throw new ObjectNotFoundException();
        }
        students.put(studentId, student);
        return student;
    }

    public Student deleteStudent(Long studentId) {
        if(!students.containsKey(studentId)) {
            throw new ObjectNotFoundException();
        }
        return students.remove(studentId);
    }

    public Collection<Student> getAll() {
        return students.values();
    }
}
