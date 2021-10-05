package FlowerGirl;

public class Chamomile extends Flower {

    public Chamomile(int price, int stalkLength, FreshLvl level) {
        super(price, stalkLength, level);
    }

    @Override
    public String toString() {
        return "Chamomile{" +
                "price=" + price +
                ", stalkLength=" + stalkLength +
                ", level=" + level +
                '}';
    }
}
