package FlowerGirl;

public abstract class Flower {
    int price;
    int stalkLength;
    FreshLvl level;
    enum FreshLvl {
        rotten, lowFresh, fresh
    }

    public Flower(int price, int stalkLength, FreshLvl level) {
        this.price = price;
        this.stalkLength = stalkLength;
        this.level = level;
    }


}
