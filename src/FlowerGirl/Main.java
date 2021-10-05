package FlowerGirl;

public class Main {
    public static void main(String[] args) {
        Flower rose = new Rose(2, 3, Flower.FreshLvl.lowFresh);
        Flower chamomile = new Chamomile(1, 2, Flower.FreshLvl.fresh);
        Flower tulip = new Tulip(1, 1, Flower.FreshLvl.rotten);
        Bouquet flowerBouquet = new Bouquet();
        flowerBouquet.addToBouquet(rose,chamomile,tulip);
        flowerBouquet.addAccessory(Bouquet.Accessory.packing, Bouquet.Accessory.tape);
        flowerBouquet.view();
//        flowerBouquet.setFlowerComparator((x,y) -> x.price - y.price);
//        flowerBouquet.view();
        System.out.println(flowerBouquet.getBouquetPrice());
    }
}
