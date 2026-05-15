package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import Domain.Department;
import Factory.DepartmentFactory;
import Repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.departmentmanagementsystem.DepartmentManagementSystemApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = DepartmentManagementSystemApplication.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DepartmentRepository departmentRepository;   // needed to create real data

    private Department testDepartment;

    @BeforeEach
    void setUp() {
        // Create and save a fresh department before each test that needs it
        testDepartment = DepartmentFactory.createDepartment("Computer Science", 500000);
        testDepartment = departmentRepository.save(testDepartment);
    }

    @Test
    @Order(1)
    void createDepartment() throws Exception {
        Department newDept = DepartmentFactory.createDepartment("Mathematics", 300000);
        mockMvc.perform(post("/department/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newDept)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name.name").value("Mathematics"));
    }

    @Test
    @Order(2)
    void readDepartment() throws Exception {
        // Use the saved department from setUp
        mockMvc.perform(get("/department/read/{id}", testDepartment.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name.name").value("Computer Science"));
    }

    @Test
    @Order(3)
    void updateDepartment() throws Exception {
        Department updated = Department.Builder.copy(testDepartment).setBudget(600000).build();
        mockMvc.perform(put("/department/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.budget").value(600000));
    }

    @Test
    @Order(4)
    void deleteDepartment() throws Exception {
        mockMvc.perform(delete("/department/delete/{id}", testDepartment.getId()))
                .andExpect(status().isOk());
        // Optionally verify deletion
    }

    @Test
    @Order(5)
    void getAllDepartments() throws Exception {
        mockMvc.perform(get("/department/getAll"))
                .andExpect(status().isOk());
    }
}