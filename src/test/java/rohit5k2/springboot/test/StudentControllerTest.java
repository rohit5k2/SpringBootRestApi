package rohit5k2.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.validation.constraints.NotNull;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired @NotNull private MockMvc mockMvc;

    @Test
    public void getStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/get").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getStudentByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getbyname?name=rohit").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
