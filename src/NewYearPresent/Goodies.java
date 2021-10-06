package NewYearPresent;

public abstract class Goodies {
    int price;
    int sugarCount;
    int weight;

    public Goodies(int price, int sugarCount, int weight) {
        this.price = price;
        this.sugarCount = sugarCount;
        this.weight = weight;
    }
}
