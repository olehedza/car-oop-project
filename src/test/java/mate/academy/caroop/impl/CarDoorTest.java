package mate.academy.caroop.impl;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import mate.academy.caroop.CarDoor;
import mate.academy.caroop.Mode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarDoorTest {
    private CarDoor carDoor;

    @BeforeEach
    void setUp() {
        carDoor = new CarDoor(Mode.OPEN, Mode.CLOSED);
    }

    @Test
    void openDoorFalseTest() {
        assertFalse(carDoor.openDoor());
    }

    @Test
    void openDoorTrueTest() {
        carDoor.switchDoor();
        assertTrue(carDoor.openDoor());
    }

    @Test
    void closeDoorFalseTest() {
        carDoor.switchDoor();
        assertFalse(carDoor.closeDoor());
    }

    @Test
    void closeDoorTrueTest() {
        assertTrue(carDoor.closeDoor());
    }

    @Test
    void switchDoorEqualsTest() {
        assertAll(
                () -> assertEquals(Mode.CLOSED, carDoor.switchDoor()),
                () -> assertEquals(Mode.OPEN, carDoor.switchDoor())
        );
    }

    @Test
    void openWindowFalseTest() {
        carDoor.switchWindow();
        assertFalse(carDoor.openWindow());
    }

    @Test
    void openWindowTrueTest() {
        assertTrue(carDoor.openWindow());
    }

    @Test
    void closeWindowFalseTest() {
        assertFalse(carDoor.closeWindow());
    }

    @Test
    void closeWindowTrueTest() {
        carDoor.switchWindow();
        assertTrue(carDoor.closeWindow());
    }

    @Test
    void switchWindowEqualsTest() {
        assertAll(
                () -> assertEquals(Mode.OPEN, carDoor.switchWindow()),
                () -> assertEquals(Mode.CLOSED, carDoor.switchWindow())
        );
    }
}
