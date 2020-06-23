package mate.academy.caroop.impl;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import mate.academy.caroop.CarWheel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarWheelTest {
    private CarWheel carWheel;

    @BeforeEach
    void setUp() {
        carWheel = new CarWheel();
    }

    @Test
    void changeToNewEqualsTest() {
        assertEquals(1., carWheel.changeToNew());
    }

    @Test
    void eraseEqualsTest() {
        assertAll(
                () -> assertEquals(0.88, carWheel.erase(12)),
                () -> assertEquals(0., carWheel.erase(89))
        );
    }

    @Test
    void getStateEqualsTest() {
        assertEquals(1., carWheel.getState());
    }
}
