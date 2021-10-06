package NewYearPresent;

public class Cake extends Goodies {

    public Cake(int price, int sugarCount, int weight) {
        super(price, sugarCount, weight);
    }

    @Override
    public String toString() {
        return "Cake{" +
                "price=" + price +
                ", sugarCount=" + sugarCount +
                ", weight=" + weight +
                '}';
    }
}
