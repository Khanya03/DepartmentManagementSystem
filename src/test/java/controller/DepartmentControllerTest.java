package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import Domain.Department;
import Factory.DepartmentFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static Department department;

    @BeforeAll
    static void setUp() {
        department = DepartmentFactory.createDepartment("Computer Science", 500000);
    }

    @Test
    @Order(1)
    void createDepartment() throws Exception {
        mockMvc.perform(post("/department/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(department)))
                .andExpect(status().isOk())
                // name is a CourseName object: {"name": "Computer Science"}, so path is $.name.name
                .andExpect(jsonPath("$.name.name").value("Computer Science"));
    }

    @Test
    @Order(2)
    void readDepartment() throws Exception {
        mockMvc.perform(get("/department/read/1"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void updateDepartment() throws Exception {
        Department updated = Department.Builder.copy(department).setBudget(600000).build();
        mockMvc.perform(put("/department/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.budget").value(600000));
    }

    @Test
    @Order(4)
    void deleteDepartment() throws Exception {
        mockMvc.perform(delete("/department/delete/1"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(5)
    void getAllDepartments() throws Exception {
        mockMvc.perform(get("/department/getAll"))
                .andExpect(status().isOk());
    }
}