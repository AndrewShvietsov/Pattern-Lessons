package Motorcyclist.Decorator;

public class DecoratorCreate extends EquipmentDecorate {
        EquipmentDecorate equipmentDecorate;


    public DecoratorCreate(String description, int price, int weight, EquipmentDecorate equipmentDecorate) {
        super(description, price, weight);
        this.equipmentDecorate = equipmentDecorate;
    }

    public DecoratorCreate(EquipmentDecorate equipmentDecorate) {
        super(equipmentDecorate.description, equipmentDecorate.price, equipmentDecorate.weight);
        this.equipmentDecorate = equipmentDecorate;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + equipmentDecorate.getPrice();
    }

    @Override
    public int getWeight() {
        return super.getWeight() + equipmentDecorate.getWeight();
    }

    private DecoratorCreate(String description, int price, int weight) {
        super(description, price, weight);
    }

    @Override
    public String toString() {
        return super.toString() + equipmentDecorate.toString();
    }
}
