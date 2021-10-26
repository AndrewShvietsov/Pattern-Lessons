package control;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class VoteDistrict {
    private int id;
    private String address;
    private Set<Citizen> citizenList = new TreeSet<>();
    private boolean isMilitary;
    private boolean isQuarantine;

    public VoteDistrict(int id, String address, boolean isMilitary, boolean isQuarantine) {
        this.id = id;
        this.address = address;
        this.isMilitary = isMilitary;
        this.isQuarantine = isQuarantine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Citizen> getCitizenList() {
        return citizenList;
    }

    public boolean isMilitary() {
        return isMilitary;
    }

    public void setMilitary(boolean military) {
        isMilitary = military;
    }

    public boolean isQuarantine() {
        return isQuarantine;
    }

    public void setQuarantine(boolean quarantine) {
        isQuarantine = quarantine;
    }

    @Override
    public String toString() {
        return "VoteDistrict{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", citizenList=" + citizenList +
                ", isMilitary=" + isMilitary +
                ", isQuarantine=" + isQuarantine +
                '}';
    }

    public long getVoterRate() {
        return citizenList.stream().filter(i -> (LocalDate.now().getYear() - i.getBirthday().getYear()) >= 18).count() / citizenList.size();
    }
}
