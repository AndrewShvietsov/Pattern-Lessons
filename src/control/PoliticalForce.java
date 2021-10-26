package control;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PoliticalForce {
    private String name;
    private Fractions fractions;
    enum Fractions {LEFT, RIGHT, CENTRAL}
    private LocalDate localDate;
    private Map<Integer, Citizen> partyMembers = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fractions getFractions() {
        return fractions;
    }

    public void setFractions(Fractions fractions) {
        this.fractions = fractions;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Map<Integer, Citizen> getPartyMembers() {
        return partyMembers;
    }

    public PoliticalForce(String name, Fractions fractions, LocalDate localDate) {
        this.setName(name);
        this.setFractions(fractions);
        this.setLocalDate(localDate);
    }

    @Override
    public String toString() {
        return "PoliticalForce{" +
                "name='" + getName() + '\'' +
                ", fractions=" + getFractions() +
                ", localDate=" + getLocalDate() +
                ", partyMembers=" + getPartyMembers() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoliticalForce that = (PoliticalForce) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }


}


