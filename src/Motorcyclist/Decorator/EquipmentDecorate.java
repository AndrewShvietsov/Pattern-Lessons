package Motorcyclist.Decorator;

public abstract class EquipmentDecorate {
    String description;
    int price;
    int weight;

    public EquipmentDecorate(String description, int price, int weight) {
        this.description = description;
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "EquipmentDecorate{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
