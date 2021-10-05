package FlowerGirl;

public class Rose extends Flower {

    public Rose(int price, int stalkLength, FreshLvl level) {
        super(price, stalkLength, level);
    }

    @Override
    public String toString() {
        return "Rose{" +
                "price=" + price +
                ", stalkLength=" + stalkLength +
                ", level=" + level +
                '}';
    }
}
