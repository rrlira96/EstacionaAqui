package br.unicap.engsoftware.EstacionaAqui.Repository;

import br.unicap.engsoftware.EstacionaAqui.Entities.Parking;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParkingRepositoryTest {

    @Autowired
    private ParkingRepository parkingRepository;

    private static int parkingId;

    private Parking parking = new Parking(50, "52061-200", "Parking Test", 80, 100, "88888888", "test@email",
            "-8.55555", "+4.8888", "Street X");

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveParkingTest() {

        Parking savedParking = parkingRepository.save(parking);

        Assert.assertNotNull(savedParking);
        Assert.assertEquals(parking.getAddress(), savedParking.getAddress());
        Assert.assertEquals(parking.getParkingSpotQuantity(), savedParking.getParkingSpotQuantity());
        Assert.assertEquals(parking.getTotalParkingSpot(), savedParking.getTotalParkingSpot());
        Assert.assertEquals(parking.getCep(), savedParking.getCep());
        Assert.assertEquals(parking.getLatitude(), savedParking.getLatitude());
        Assert.assertEquals(parking.getLongitude(), savedParking.getLongitude());
        Assert.assertEquals(parking.getName(), savedParking.getName());
        Assert.assertEquals(parking.getOwnerEmail(), savedParking.getOwnerEmail());
        Assert.assertEquals(parking.getPhone(), savedParking.getPhone());

        parkingId = savedParking.getId();
    }

    @Test
    @Order(2)
    public void getParkingTest() {
        Parking parkingReceived = parkingRepository.findById(parkingId).get();

        Assert.assertNotNull(parkingReceived);
        Assert.assertEquals(parking.getAddress(), parkingReceived.getAddress());
        Assert.assertEquals(parking.getParkingSpotQuantity(), parkingReceived.getParkingSpotQuantity());
        Assert.assertEquals(parking.getTotalParkingSpot(), parkingReceived.getTotalParkingSpot());
        Assert.assertEquals(parking.getCep(), parkingReceived.getCep());
        Assert.assertEquals(parking.getLatitude(), parkingReceived.getLatitude());
        Assert.assertEquals(parking.getLongitude(), parkingReceived.getLongitude());
        Assert.assertEquals(parking.getName(), parkingReceived.getName());
        Assert.assertEquals(parking.getOwnerEmail(), parkingReceived.getOwnerEmail());
        Assert.assertEquals(parking.getPhone(), parkingReceived.getPhone());

    }

    @Test
    @Order(3)
    public void getAllParkingTest() {

        List<Parking> parkingList = parkingRepository.findAll();
        Assertions.assertThat(parkingList.size()).isPositive();

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateParkingTest() {

        Parking parking = parkingRepository.findById(parkingId).get();
        parking.setName("Testing");
        Parking parkingUpdated = parkingRepository.save(parking);

        Assertions.assertThat(parkingUpdated.getName()).isEqualTo("Testing");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteParkingTest() {

        parkingRepository.deleteById(parkingId);
        Optional<Parking> parking = parkingRepository.findById(parkingId);
        Assert.assertFalse(parking.isPresent());

    }


}
