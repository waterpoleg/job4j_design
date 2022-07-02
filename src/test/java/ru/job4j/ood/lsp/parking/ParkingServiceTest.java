package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingServiceTest {

    @Ignore
    @Test
    public void whenParkPassengerCarAndTruck() {
        ParkingService parkingService = new ParkingService(1, 1);
        assertTrue(parkingService.park(new Vehicle(1)));
        assertTrue(parkingService.park(new Vehicle(2)));
    }

    @Ignore
    @Test
    public void whenParkPassengerCarAndTruckThenNotEnoughCargoPlaces() {
        ParkingService parkingService = new ParkingService(2, 1);
        assertTrue(parkingService.park(new Vehicle(1)));
        assertTrue(parkingService.park(new Vehicle(2)));
        assertFalse(parkingService.park(new Vehicle(4)));
    }

    @Ignore
    @Test
    public void whenParkToManyPassengerCar() {
        ParkingService parkingService = new ParkingService(1, 2);
        assertTrue(parkingService.park(new Vehicle(1)));
        assertFalse(parkingService.park(new Vehicle(1)));
    }
}
