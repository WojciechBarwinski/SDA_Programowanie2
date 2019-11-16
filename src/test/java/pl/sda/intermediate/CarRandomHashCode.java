package pl.sda.intermediate;

import java.util.Objects;
import java.util.Random;

public class CarRandomHashCode {

    private String model;

    public CarRandomHashCode(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRandomHashCode that = (CarRandomHashCode) o;
        return Objects.equals(this.model, that.model);
    }

    @Override
    public int hashCode() {
        return new Random().nextInt(20);
    }
}
