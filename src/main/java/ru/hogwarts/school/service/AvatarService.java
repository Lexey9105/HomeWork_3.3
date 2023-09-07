package ru.hogwarts.school.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface AvatarService {

    Avatar getById(Long id);
    List<Avatar> getAll (Integer pageNumber, Integer pageSize);
    Long save(Long studentId, MultipartFile multipartFile) throws IOException;
    String saveToDisk(Long studentId, MultipartFile multipartFile) throws IOException;
    Avatar saveToDataBase(Long studentId, MultipartFile multipartFile, String absolutePath) throws IOException;


}
