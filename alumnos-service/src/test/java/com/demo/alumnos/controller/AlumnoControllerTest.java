package com.demo.alumnos.controller;

import com.demo.alumnos.model.Alumno;
import com.demo.alumnos.repository.AlumnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
class AlumnoControllerTest {

    @MockBean
    AlumnoService alumnoService;

    @MockBean
    AlumnoRepository alumnoRepository;

    @Autowired
    private MockMvc mockMvc;

    List<Alumno> listAlumnos;
    Alumno alumno;
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        alumno = new Alumno(1L, "Guille", "Jilguero", 90888777);
        listAlumnos = new ArrayList<>();
        listAlumnos.add( new Alumno(1L, "Keanu", "Reeves", 23423234));
        listAlumnos.add(new Alumno(2L, "Bellucci", "Monica", 23333444));
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

    }

    @Test
    void getAlumnos() throws Exception {
        List<Alumno> alumnoList = new ArrayList<>();
        alumnoList.add(new Alumno(1L,"Reeves","Keanu", 12323423));
        alumnoList.add(new Alumno(2L,"Doe","Joe", 12222333));
        when(alumnoService.findAll()).thenReturn(alumnoList);
        mockMvc.perform(MockMvcRequestBuilders.get("/alumnos/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(jsonPath("$[0].apellido").value("Reeves"))
                .andExpect(jsonPath("$[1].apellido").value("Doe"))

        ;

    }

    @Test
    void getAlumnoById() throws Exception {
        when(alumnoService.findById(1L)).thenReturn(alumno);

        mockMvc.perform(MockMvcRequestBuilders.get("/alumnos/1").contentType(MediaType.APPLICATION_JSON))

                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(jsonPath("$.apellido").value("Guille"))
        ;
    }

    @Test
    void createAlumno() throws Exception {
        Alumno newAlumno = new Alumno(1L, "Keanu", "Reeves", 44000111);
        Alumno createdAlumno = new Alumno(1L, "Keanu", "Reeves", 44000111);

        when(alumnoService.createAlumno(any())).thenReturn(createdAlumno);

        mockMvc.perform(MockMvcRequestBuilders.post("/alumnos/create").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newAlumno)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.apellido").value("Keanu"));
    }

}
