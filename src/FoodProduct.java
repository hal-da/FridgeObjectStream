import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class FoodProduct implements Serializable {
    private final String name;
    private final float weight;
    private final LocalDate expirationDate;
    private final double percentageFat;
    private final double percentageSugar;


    public FoodProduct(String name, float weight, LocalDate expirationDate, double percentageFat, double percentageSugar) {
        this.name = name;
        this.weight = weight;
        this.expirationDate = expirationDate;
        this.percentageFat = percentageFat;
        this.percentageSugar = percentageSugar;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public double getPercentageFat() {
        return percentageFat;
    }

    public double getPercentageSugar() {
        return percentageSugar;
    }

    @Override
    public String toString() {
        return name + " - weight: " + weight +
                ", expirationDate: " + expirationDate +
                ", percentageFat: " + percentageFat +
                ", percentageSugar: " + percentageSugar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodProduct that = (FoodProduct) o;
        return Float.compare(that.weight, weight) == 0 && Double.compare(that.percentageFat, percentageFat) == 0 && Double.compare(that.percentageSugar, percentageSugar) == 0 && Objects.equals(name, that.name) && Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, expirationDate, percentageFat, percentageSugar);
    }
}
