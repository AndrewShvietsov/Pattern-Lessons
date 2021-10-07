package Motorcyclist;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ReadyMotorcyclist readyMotorcyclist = ReadyMotorcyclist.getBuilder().addEquipment(new Helmet("Helmet", 200, 5))
                .addEquipment(new Jacket("Metallica", 700, 7))
                .addEquipment(new Trousers("Pants", 250, 3))
                .build();
        readyMotorcyclist.setCondition(Comparator.comparingInt(x -> x.price));
        System.out.println(readyMotorcyclist);
    }
}
