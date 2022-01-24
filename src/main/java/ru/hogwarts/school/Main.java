package ru.hogwarts.school;

import ru.hogwarts.school.domain.Faculty;
import ru.hogwarts.school.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> students = List.of(new Student(1L, "Harry Potter", 11),
                new Student(2L, "Ronald Weasley", 11),
                new Student(3L, "Hermione Granger", 11)
        );
        List<Faculty> faculties = List.of(new Faculty(1L, "Gryffindor", "red"),
                new Faculty(2L, "Ravenclaw", "blue"),
                new Faculty(3L, "Hufflepuff", "yellow"));

        System.out.println(students);
        System.out.println(faculties);
    }
}
