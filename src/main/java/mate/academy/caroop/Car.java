package mate.academy.caroop;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Car {
    private final LocalDate dateOfManufacture;
    private String engineType;
    private double maxSpeed;
    private int accelerationTime;
    private int passengerCapacity;
    private int currentCountOfPassengers;
    private double currentSpeed;
    private List<CarWheel> wheels;
    private List<CarDoor> doors;

    private Car() {
        dateOfManufacture = LocalDate.now();
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public String getEngineType() {
        return engineType;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public int getAccelerationTime() {
        return accelerationTime;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getCurrentCountOfPassengers() {
        return currentCountOfPassengers;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public List<CarWheel> getWheels() {
        return wheels;
    }

    public List<CarDoor> getDoors() {
        return doors;
    }

    public boolean changeCurrentSpeed(double speed) {
        if (speed > maxSpeed) {
            return false;
        }
        currentSpeed = speed;
        return true;
    }

    public boolean putPassenger() {
        if (passengerCapacity < (currentCountOfPassengers + 1)) {
            return false;
        }
        currentCountOfPassengers++;
        return true;
    }

    public boolean popPassenger() {
        if (currentCountOfPassengers == 0) {
            return false;
        }
        currentCountOfPassengers--;
        return true;
    }

    public boolean popAllPassengers() {
        if (currentCountOfPassengers == 0) {
            return false;
        }
        currentCountOfPassengers = 0;
        return true;
    }

    public CarDoor getDoorByIndex(int index) {
        return doors.get(index);
    }

    public CarWheel getWheelByIndex(int index) {
        return wheels.get(index);
    }

    public boolean popAllWheels() {
        if (wheels.size() == 0) {
            return false;
        }
        wheels.clear();
        return true;
    }

    public int addWheels(int wheelsToAdd) {
        IntStream.range(0, wheelsToAdd)
                .forEach(i -> wheels.add(new CarWheel()));
        return wheels.size();
    }

    public double getCurrentMaxSpeed() {
        if (currentCountOfPassengers == 0) {
            return 0;
        }
        return wheels.stream()
                .mapToDouble(CarWheel::getState)
                .min()
                .getAsDouble() * maxSpeed;
    }

    public String showInfo() {
        String info = "Car{" + "dateOfManufacture=" + dateOfManufacture
                + ", engineType='" + engineType + '\'' + ", maxSpeed="
                + maxSpeed + ", accelerationTime=" + accelerationTime
                + ", passengerCapacity=" + passengerCapacity
                + ", currentCountOfPassengers=" + currentCountOfPassengers
                + ", currentSpeed=" + currentSpeed + ", wheels=" + wheels
                + ", doors=" + doors + ", maximal current speed: "
                + getCurrentMaxSpeed() + '}';
        System.out.println(info);
        return info;
    }

    public static class CarBuilder {
        private final Car newCar;

        public CarBuilder() {
            newCar = new Car();
        }

        public CarBuilder withEngineType(String engineType) {
            newCar.engineType = engineType;
            return this;
        }

        public CarBuilder withMaxSpeed(double maxSpeed) {
            newCar.maxSpeed = maxSpeed;
            return this;
        }

        public CarBuilder withAccelerationTime(int accelerationTime) {
            newCar.accelerationTime = accelerationTime;
            return this;
        }

        public CarBuilder withPassengerCapacity(int capacity) {
            newCar.passengerCapacity = capacity;
            return this;
        }

        public CarBuilder withCurrentCountOfPassengers(int count) {
            newCar.currentCountOfPassengers = count;
            return this;
        }

        public CarBuilder withWheels(List<CarWheel> wheels) {
            newCar.wheels = wheels;
            return this;
        }

        public CarBuilder withDoors(List<CarDoor> doors) {
            newCar.doors = doors;
            return this;
        }

        public CarBuilder withCurrentSpeed(double currentSpeed) {
            newCar.currentSpeed = currentSpeed;
            return this;
        }

        public Car build() {
            return newCar;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Double.compare(car.getMaxSpeed(), getMaxSpeed()) == 0
                && getAccelerationTime() == car.getAccelerationTime()
                && getPassengerCapacity() == car.getPassengerCapacity()
                && getCurrentCountOfPassengers() == car.getCurrentCountOfPassengers()
                && Double.compare(car.getCurrentSpeed(), getCurrentSpeed()) == 0
                && Objects.equals(getDateOfManufacture(), car.getDateOfManufacture())
                && Objects.equals(getEngineType(), car.getEngineType())
                && Objects.equals(getWheels(), car.getWheels())
                && Objects.equals(getDoors(), car.getDoors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateOfManufacture(), getEngineType(),
                getMaxSpeed(), getAccelerationTime(), getPassengerCapacity(),
                getCurrentCountOfPassengers(), getCurrentSpeed(), getWheels(), getDoors());
    }
}
