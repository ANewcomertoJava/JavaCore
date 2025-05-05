package zhkh.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import zhkh.dto.ApartmentDTO;
import zhkh.service.ApartmentService;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApartmentService apartmentService;

    @Test
    void getAllApartments_ShouldReturnApartments() throws Exception {
        // Arrange
        ApartmentDTO dto = new ApartmentDTO();
        dto.setId(1L);
        when(apartmentService.findAll()).thenReturn(Collections.singletonList(dto));

        // Act & Assert
        mockMvc.perform(get("/api/apartments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }
}