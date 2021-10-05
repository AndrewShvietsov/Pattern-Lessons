package FlowerGirl;

public class Tulip extends Flower {

    public Tulip(int price, int stalkLength, FreshLvl level) {
        super(price, stalkLength, level);
    }

    @Override
    public String toString() {
        return "Tulip{" +
                "price=" + price +
                ", stalkLength=" + stalkLength +
                ", level=" + level +
                '}';
    }
}
