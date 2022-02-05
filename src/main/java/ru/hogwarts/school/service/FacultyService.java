package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.ObjectNotFoundException;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {

    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long generatedFacultyId;

    public Faculty addFaculty(Faculty faculty) {
        faculties.put(generatedFacultyId, faculty);
        generatedFacultyId++;
        return faculty;
    }

    public Faculty getFacultyById(Long facultyId) {
        if (!faculties.containsKey(facultyId)) {
            throw new ObjectNotFoundException();
        }
        return faculties.get(facultyId);
    }

    public Faculty updateFaculty(Long facultyId, Faculty faculty) {
        if (!faculties.containsKey(facultyId)) {
            throw new ObjectNotFoundException();
        }
        faculties.put(facultyId, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long facultyId) {
        if (!faculties.containsKey(facultyId)) {
            throw new ObjectNotFoundException();
        }
        return faculties.remove(facultyId);
    }

    public Collection<Faculty> getAll() {
        return faculties.values();
    }

}
