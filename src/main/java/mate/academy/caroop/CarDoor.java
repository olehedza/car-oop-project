package mate.academy.caroop;

import java.util.Objects;

public class CarDoor {
    private Mode doorMode;
    private Mode windowMode;

    public CarDoor() {
        doorMode = Mode.CLOSED;
        windowMode = Mode.CLOSED;
    }

    public CarDoor(Mode doorMode, Mode windowMode) {
        this.doorMode = doorMode;
        this.windowMode = windowMode;
    }

    public boolean openDoor() {
        if (doorMode == Mode.OPEN) {
            return false;
        }
        doorMode = Mode.OPEN;
        return true;
    }

    public boolean closeDoor() {
        if (doorMode == Mode.CLOSED) {
            return false;
        }
        doorMode = Mode.CLOSED;
        return true;
    }

    public Mode switchDoor() {
        doorMode = doorMode == Mode.CLOSED
                ? Mode.OPEN
                : Mode.CLOSED;
        return doorMode;
    }

    public boolean openWindow() {
        if (windowMode == Mode.OPEN) {
            return false;
        }
        windowMode = Mode.OPEN;
        return true;
    }

    public boolean closeWindow() {
        if (windowMode == Mode.CLOSED) {
            return false;
        }
        windowMode = Mode.CLOSED;
        return true;
    }

    public Mode switchWindow() {
        windowMode = windowMode == Mode.CLOSED
                ? Mode.OPEN
                : Mode.CLOSED;
        return windowMode;
    }

    public String showInfo() {
        String info = "CarDoor{" + "doorMode=" + doorMode
                + ", windowMode=" + windowMode + '}';
        System.out.println(info);
        return info;
    }

    public Mode getDoorMode() {
        return doorMode;
    }

    public void setDoorMode(Mode doorMode) {
        this.doorMode = doorMode;
    }

    public Mode getWindowMode() {
        return windowMode;
    }

    public void setWindowMode(Mode windowMode) {
        this.windowMode = windowMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarDoor carDoor = (CarDoor) o;
        return getDoorMode() == carDoor.getDoorMode()
                && getWindowMode() == carDoor.getWindowMode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoorMode(), getWindowMode());
    }
}
