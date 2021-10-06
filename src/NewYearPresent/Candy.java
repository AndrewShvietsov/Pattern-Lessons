package NewYearPresent;

public class Candy extends Goodies {

    public Candy(int price, int sugarCount, int weight) {
        super(price, sugarCount, weight);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "price=" + price +
                ", sugarCount=" + sugarCount +
                ", weight=" + weight +
                '}';
    }
}
