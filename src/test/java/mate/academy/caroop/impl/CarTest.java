package mate.academy.caroop.impl;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import mate.academy.caroop.Car;
import mate.academy.caroop.CarDoor;
import mate.academy.caroop.CarWheel;
import mate.academy.caroop.Mode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private static final LocalDate NOW = LocalDate.now();
    public static final CarDoor CAR_DOOR = new CarDoor(Mode.CLOSED, Mode.OPEN);
    public static final CarWheel CAR_WHEEL = new CarWheel(0.2);
    private Car car;

    @BeforeEach
    void setUp() {
        List<CarWheel> wheels = DoubleStream.of(0.2, 0.4, 0.6, 1)
                .mapToObj(CarWheel::new)
                .collect(Collectors.toList());
        List<CarDoor> doors = Arrays.asList(new CarDoor(Mode.OPEN, Mode.CLOSED),
                new CarDoor(Mode.CLOSED, Mode.OPEN));
        car = new Car.CarBuilder()
                .withWheels(wheels)
                .withDoors(doors)
                .withEngineType("vee")
                .withMaxSpeed(250.)
                .withCurrentSpeed(200)
                .withPassengerCapacity(4)
                .withAccelerationTime(6)
                .withCurrentCountOfPassengers(2)
                .build();
    }

    @Test
    void dateOfManufactureEqualTest() {
        LocalDate actual = car.getDateOfManufacture();
        assertEquals(NOW, actual);
    }

    @Test
    void changeCurrentSpeedTrueFalseTest() {
        assertAll(
                () -> assertTrue(car.changeCurrentSpeed(230.)),
                () -> assertFalse(car.changeCurrentSpeed(260.))
        );
    }

    @Test
    void putPassengerEqualsTest() {
        car.putPassenger();
        assertEquals(3, car.getCurrentCountOfPassengers());
    }

    @Test
    void popPassengerEqualsTest() {
        car.popPassenger();
        assertEquals(1, car.getCurrentCountOfPassengers());
    }

    @Test
    void popAllPassengersEqualsTest() {
        car.popAllPassengers();
        assertEquals(0, car.getCurrentCountOfPassengers());
    }

    @Test
    void getDoorByIndexEqualsTest() {
        assertEquals(CAR_DOOR, car.getDoorByIndex(1));
    }

    @Test
    void getDoorByIndexThrowsExceptionTest() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> car.getDoorByIndex(2));
    }

    @Test
    void getWheelByIndexEqualsTest() {
        assertEquals(CAR_WHEEL, car.getWheelByIndex(0));
    }

    @Test
    void getWheelByIndexThrowsExceptionTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> car.getWheelByIndex(4));
    }

    @Test
    void popAllWheelsTrueEqualsTest() {
        assertAll(
                () -> assertTrue(car.popAllWheels()),
                () -> assertEquals(new ArrayList<CarWheel>(), car.getWheels())
        );
    }

    @Test
    void addWheelsEqualsTest() {
        assertEquals(7, car.addWheels(3));
    }

    @Test
    void getCurrentMaxSpeedEqualsTest() {
        assertEquals(50., car.getCurrentMaxSpeed());
    }

    @Test
    void getCurrentMaxSpeedEqualsZeroTest() {
        car.popAllPassengers();
        assertEquals(0., car.getCurrentMaxSpeed());
    }
}
