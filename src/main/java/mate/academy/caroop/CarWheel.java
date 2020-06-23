package mate.academy.caroop;

import java.util.Objects;

public class CarWheel {
    private double tireIntegrity;

    public CarWheel() {
        this.tireIntegrity = 1.;
    }

    public CarWheel(double tireIntegrity) {
        this.tireIntegrity = tireIntegrity;
    }

    public double changeToNew() {
        tireIntegrity = 1.;
        return tireIntegrity;
    }

    public double erase(double wearDegree) {
        tireIntegrity -= (wearDegree / 100);
        return Math.max(tireIntegrity, 0.);
    }

    public double getState() {
        return tireIntegrity;
    }

    public String showInfo() {
        String info = "CarWheel{" + "tireIntegrity=" + tireIntegrity + '}';
        System.out.println(info);
        return info;
    }

    public void setTireIntegrity(double tireIntegrity) {
        this.tireIntegrity = tireIntegrity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarWheel carWheel = (CarWheel) o;
        return Double.compare(carWheel.tireIntegrity, tireIntegrity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tireIntegrity);
    }
}
