package Motorcyclist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReadyMotorcyclist {

    private final List<Equipment> equipmentList = new ArrayList<>();
    private Comparator<Equipment> equipmentComparator2 = Comparator.comparingInt(o -> o.weight);

    static Builder getBuilder() {
        ReadyMotorcyclist readyMotorcyclist = new ReadyMotorcyclist();
        Builder builder = new Builder(readyMotorcyclist);
        return builder;
    }

    @Override
    public String toString() {
        return "Ready Motorcyclist" +
                "equipment List=" + equipmentList + "Price - " +
                getPrice() + " " + "Weight - " + getWeight();
    }

    int getPrice() {
        return equipmentList.stream().map(x -> x.price).reduce(0, Integer::sum);
    }

    int getWeight() {
        return equipmentList.stream().map(x -> x.weight).reduce(0, Integer::sum);
    }

    void setCondition(Comparator<Equipment> equipmentComparator) {
        equipmentList.sort(equipmentComparator);
    }

    static class Builder {
        ReadyMotorcyclist readyMotorcyclist;

        public Builder(ReadyMotorcyclist readyMotorcyclist) {
            this.readyMotorcyclist = readyMotorcyclist;
        }

        public ReadyMotorcyclist build() {
            return readyMotorcyclist;
        }

        Builder addEquipment(Equipment equipment) {
                readyMotorcyclist.equipmentList.add(equipment);
            return this;
        }
    }
}
