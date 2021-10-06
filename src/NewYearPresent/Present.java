package NewYearPresent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Present {
    private final List<Goodies> goodiesList = new ArrayList<>();
    private Comparator<Goodies> goodiesComparator = (x, y) -> x.weight - y.weight;
    private Predicate<Goodies> condition = x -> x.sugarCount < 10;

    public void setGoodiesComparator(Comparator<Goodies> goodiesComparator) {
        this.goodiesComparator = goodiesComparator;
    }

    public void setCondition(Predicate<Goodies> condition) {
        this.condition = condition;
    }

    public void viewPresent() {
        goodiesList.stream().filter(condition).sorted(goodiesComparator).forEach(System.out::println);
    }
}
