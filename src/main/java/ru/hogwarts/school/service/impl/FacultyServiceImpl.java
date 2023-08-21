package ru.hogwarts.school.service.impl;


import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;


import java.util.Collection;
import java.util.HashMap;

import java.util.Map;
import java.util.stream.Collectors;


@Service
public class FacultyServiceImpl implements FacultyService {
    private final Map<Long, Faculty> storageFac;
    private Long size = 0L;

    public FacultyServiceImpl() {
        this.storageFac = new HashMap<>();
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        size++;
        Faculty faculty1=faculty;
        faculty1.setId(size);
        storageFac.put(faculty1.getId(), faculty1);
        return faculty1;
    }

    @Override
    public Faculty updateFaculty(Long idUp, Faculty faculty) {
        if (!storageFac.containsKey(idUp)) {
            return null;
        }Faculty faculty1=faculty;
        storageFac.put(idUp, faculty1);
        return faculty1;
    }

    @Override
    public Faculty getFaculty(Long id) {
        long id1=id;
        return storageFac.get(id1);
    }

    @Override
    public Faculty deleteFaculty(Long id) {
        if (id == null || id == 0) {
            throw new RuntimeException("введен пустой запрос");
        }
        if (!storageFac.containsKey(id)) {
            throw new RuntimeException("Сотрудник не найден");
        }
        storageFac.get(id);
        Faculty faculty = storageFac.get(id);
        storageFac.remove(id);
        size--;
        return faculty;
    }

    @Override
    public Collection<Faculty> facFilter(String color) {
        return storageFac.values().stream()
                .filter(e -> e.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
