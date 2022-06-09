package br.unicap.engsoftware.EstacionaAqui.Controller;

import br.unicap.engsoftware.EstacionaAqui.Entities.Parking;
import br.unicap.engsoftware.EstacionaAqui.Repository.ParkingRepository;
import br.unicap.engsoftware.EstacionaAqui.Service.ParkingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ParkingController.class)
public class ParkingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkingService parkingService;

    @MockBean
    private ParkingRepository parkingRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Parking parking0 = new Parking(1, "52061-200", "Parking Test0", 80, 100, "88888888", "test@email", "-8.55555", "+4.8888", "Street X");
    private Parking parking1 = new Parking(2, "52061-333", "Parking Test1", 80, 100, "88888888", "test@email", "-8.55555", "+4.8888", "Street X");
    private Parking parking2 = new Parking(3, "22221-200", "Parking Test2", 80, 100, "88888888", "test@email", "-8.55555", "+4.8888", "Street X");


    @Test
    public void getAllParkingTest() throws Exception {
        List<Parking> parkingList = new ArrayList<>(Arrays.asList(parking0, parking1, parking2));

        Mockito.when(parkingService.getAllParkingLots()).thenReturn(parkingList);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/parkingLots")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].name", is("Parking Test2")));
    }

    @Test
    public void getParkingByIdTest() throws Exception {
        Mockito.when(parkingService.getParkingById(parking0.getId())).thenReturn(parking0);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/parkingLots/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Parking Test0")));
    }

//    @Test
//    public void createParkingTest() throws Exception {
//        Parking newParking = new Parking(5, "52061-200", "New Parking", 80, 100, "88888888", "test@email", "-8.55555", "+4.8888", "Street X");
//
//        Mockito.when(parkingService.createParking(newParking)).thenReturn(newParking);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/parkingLots")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.objectMapper.writeValueAsString(newParking));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.name", is("New Parking")));
//    }

}
