package ru.job4j.ood.lsp.parking;

public class ParkingService implements Parking {

    private final int passengerSpaces;
    private final int cargoSpaces;

    public ParkingService(int passengerSpaces, int cargoSpaces) {
        this.passengerSpaces = passengerSpaces;
        this.cargoSpaces = cargoSpaces;
    }

    @Override
    public boolean park(Car car) {
        return false;
    }
}
