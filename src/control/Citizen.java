package control;

import java.time.LocalDate;

public class Citizen  implements Comparable<Citizen> {
    private String fullName;
    private String passport;
    private String iNN;
    private LocalDate birthday;
    private boolean isMilitary;
    private boolean isQuarantine;
    private VoteDistrict voteDistrict;


    public Citizen(String fullName, String passport, String iNN, LocalDate birthday, boolean isMilitary, boolean isQuarantine) throws InnException {
        this.fullName = fullName;
        this.passport = passport;
        this.birthday = birthday;
        this.isMilitary = isMilitary;
        this.isQuarantine = isQuarantine;

        setiNN(iNN);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getiNN() {
        return iNN;
    }

    public void setiNN(String iNN) throws InnException {
            String mask = "[0-9]{10}";
            if (iNN.matches(mask)) {
                this.iNN = iNN;
            } else {
                throw new InnException("Problem with user INN-number");
            }
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    public VoteDistrict getVoteDistrict() {
        return voteDistrict;
    }

    public void setVoteDistrict(VoteDistrict voteDistrict) {
        this.voteDistrict = voteDistrict;
    }



    @Override
    public String toString() {
        return "Citizen{" +
                "fullName='" + fullName + '\'' +
                ", passport='" + passport + '\'' +
                ", iNN='" + iNN + '\'' +
                ", birthday=" + birthday +
                ", isMilitary=" + isMilitary +
                ", isQuarantine=" + isQuarantine +
                ", voteDistrict=" + voteDistrict +
                '}';
    }


    @Override
    public int compareTo(Citizen o) {
        return iNN.compareTo(o.iNN);
    }

    public boolean isVote(String politicalForceName) {
        PoliticalForce politicalForce = Election.findByPoliticalForceName(politicalForceName);
        if (politicalForce != null) {
            Election.getElectionResult().put(this, politicalForce);
        }
        return false;
    }
}
