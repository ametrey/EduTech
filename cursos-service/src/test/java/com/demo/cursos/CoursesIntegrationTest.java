package com.demo.cursos;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class CoursesIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllCourses() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/courses")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].nombre").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].nombre").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].cursoId").isNotEmpty());
    }

    @Test
    public void getCoursesById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/courses/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.cursoId").value(1));
    }

}
