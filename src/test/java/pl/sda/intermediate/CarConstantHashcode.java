package pl.sda.intermediate;

import java.util.Objects;

public class CarConstantHashcode {

    private String model;

    public CarConstantHashcode(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarConstantHashcode that = (CarConstantHashcode) o;
        return Objects.equals(this.model, that.model);
    }

    @Override
    public int hashCode() {
        return 7;
    }
}
