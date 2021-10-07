package Motorcyclist;

public abstract class Equipment {
    String description;
    int price;
    int weight;

    public Equipment(String description, int price, int weight) {
        this.description = description;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        String temp = getClass().getCanonicalName();
        String name = temp.substring(temp.lastIndexOf('.') + 1);
        return name +
                "description='" + description + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}' + "\n";
    }
}
