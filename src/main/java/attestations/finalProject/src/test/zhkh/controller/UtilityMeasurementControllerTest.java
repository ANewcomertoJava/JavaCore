package zhkh.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import zhkh.dto.UtilityMeasurementDTO;
import zhkh.service.UtilityMeasurementService;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UtilityMeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UtilityMeasurementService measurementService;

    @Test
    void createMeasurement_ShouldReturnCreated() throws Exception {
        // Arrange
        UtilityMeasurementDTO dto = new UtilityMeasurementDTO();
        dto.setColdWater(10.5);
        when(measurementService.save(any())).thenReturn(dto);

        // Act & Assert
        mockMvc.perform(post("/api/measurements")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"coldWater\":10.5}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.coldWater").value(10.5));
    }

    @Test
    void getMeasurementsByApartment_ShouldReturnList() throws Exception {
        // Arrange
        UtilityMeasurementDTO dto = new UtilityMeasurementDTO();
        dto.setId(1L);
        when(measurementService.findByApartmentId(1L))
                .thenReturn(Collections.singletonList(dto));

        // Act & Assert
        mockMvc.perform(get("/api/measurements/apartment/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }

}
