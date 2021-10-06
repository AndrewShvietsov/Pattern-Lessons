package NewYearPresent;

public class Cookie extends Goodies {

    public Cookie(int price, int sugarCount, int weight) {
        super(price, sugarCount, weight);
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "price=" + price +
                ", sugarCount=" + sugarCount +
                ", weight=" + weight +
                '}';
    }
}
