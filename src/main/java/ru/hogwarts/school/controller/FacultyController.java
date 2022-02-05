package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @GetMapping("{facultyId}")
    public Faculty getFaculty(@PathVariable Long facultyId) {
        return facultyService.getFacultyById(facultyId);
    }

    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty.getId(), faculty);
    }

    @DeleteMapping("{facultyId}")
    public Faculty deleteFaculty(@PathVariable Long facultyId) {
        return facultyService.deleteFaculty(facultyId);
    }

    @GetMapping("{color}")
    public Collection<Faculty> getFacultyByColor(@PathVariable String color) {
        return facultyService.getAll().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }

}
