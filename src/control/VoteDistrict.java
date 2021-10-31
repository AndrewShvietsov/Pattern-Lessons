package control;

import java.io.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class VoteDistrict implements Comparable<VoteDistrict>, Serializable {
    private static final long serialVersionUID = 1L;
    public static final String data = "vote_district.txt";
    private int id;
    private static int counter;
    private String address;
    private final Set<Citizen> citizenList = new TreeSet<>();
    private boolean isMilitary;
    private boolean isQuarantine;
    private static Set<VoteDistrict> voteDistrictSet = new TreeSet<>();


    static {
        try {
            File f = new File(VoteDistrict.data);
            if(f.exists() && !f.isDirectory()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(VoteDistrict.data));
                voteDistrictSet = (TreeSet<VoteDistrict>)in.readObject();
                System.out.println(voteDistrictSet);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public VoteDistrict(String address, boolean isMilitary, boolean isQuarantine) {
        this.id = counter++;
        this.address = address;
        this.isMilitary = isMilitary;
        this.isQuarantine = isQuarantine;
        voteDistrictSet.add(this);
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

    public static Set<VoteDistrict> getVoteDistrictSet() {
        return voteDistrictSet;
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

    @Override
    public int compareTo(VoteDistrict o) {
        return this.address.compareTo(o.address);
    }
}
