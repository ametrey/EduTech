package com.demo.cursos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.demo.cursos.dto.CourseCreationDto;
import com.demo.cursos.dto.CourseDto;
import com.demo.cursos.dto.Mapper;
import com.demo.cursos.entities.Course;
import com.demo.cursos.exceptions.NotFound;
import com.demo.cursos.repositories.CourseRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository cRepository;

    @Autowired
    Mapper mapper;

    public List<CourseDto> getAll() {
        return cRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CourseDto getCourseDtoById(Integer id) {
        return cRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFound(id));
    }

    public void createCourse(CourseCreationDto dto) {
        cRepository.save(mapper.toCourse(dto));
    }

    public CourseDto updateCourse(Integer id, CourseDto cDto) {
        Course c = cRepository.findById(id).orElseThrow(() -> new NotFound(id));
        c.setNombre(cDto.getNombre());
        c.setDescripcion(cDto.getDescripcion());
        cRepository.save(c);
        return mapper.toDto(c);
    }

}
