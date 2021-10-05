package FlowerGirl;

import org.w3c.dom.ranges.Range;

import java.util.*;

public class Bouquet {
    private final Set<Flower> flowerSet = new HashSet<>();
    private final Set<Accessory> accessoriesSet = new HashSet<>();
    private Comparator<Flower> flowerComparator = (x, y) -> x.level.compareTo(y.level);

    public void setFlowerComparator(Comparator<Flower> flowerComparator) {
        this.flowerComparator = flowerComparator;
    }

    enum Accessory {
        tape(3), packing(5);
        int price;
        Accessory(int price) {
            this.price = price;
        }
    }

    public void addToBouquet(Flower... flowers) {
        for (Flower temp : flowers) {
            flowerSet.add(temp);
        }
    }

    public void addAccessory(Accessory... accessories) {
        for (Accessory temp : accessories) {
            accessoriesSet.add(temp);
        }
    }

    public int getBouquetPrice() {
        int result = 0;
        for (Flower tempFlowers : flowerSet) {
            result += tempFlowers.price;
            }
        for (Accessory tempAccessory : accessoriesSet) {
            result += tempAccessory.price;
        }
        return result;
    }

    public Set<Flower> findByStalkLength(int beginRange, int endRange) {
        Set<Flower> result = new HashSet<>();
        int currentStart = beginRange > endRange ? endRange : beginRange;
        int currentEnd = beginRange > endRange ? beginRange : endRange;
        for (Flower tempFlowers : flowerSet) {
            if (tempFlowers.stalkLength > currentStart && tempFlowers.stalkLength < currentEnd) {
                result.add(tempFlowers);
            }
        }
        return result;
    }

    public void view() {
        flowerSet.stream().sorted(flowerComparator).forEach(System.out::println);
    }

}
