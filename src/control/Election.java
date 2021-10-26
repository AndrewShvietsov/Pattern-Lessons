package control;

import java.util.*;
import java.util.stream.Collectors;

public class Election {
    private int year;
    private int month;
    private static final Map<Citizen, PoliticalForce> electionResult = new HashMap<>();
    private static final Set<PoliticalForce> politicalForceList = new HashSet<>();

    public Election(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public static Map<Citizen, PoliticalForce> getElectionResult() {
        return electionResult;
    }

    public static Set<PoliticalForce> getPoliticalForceList() {
        return politicalForceList;
    }


    @Override
    public String toString() {
        return "Elections{" +
                "year=" + year +
                ", month=" + month +
                ", electionResult=" + electionResult +
                ", politicalForceList=" + politicalForceList +
                '}';
    }

    public static PoliticalForce findByPoliticalForceName(String politicalForceName) {
        List<PoliticalForce> politicalForces = politicalForceList.stream().filter(i -> i.getName().equalsIgnoreCase(politicalForceName)).collect(Collectors.toList());
        return politicalForces.size() > 0 ? politicalForces.get(0) : null;
    }
}
