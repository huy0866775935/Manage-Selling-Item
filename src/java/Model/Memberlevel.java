package Model;


public class Memberlevel{
    private int membership_id;
    private String membership_name;

    public Memberlevel(int membership_id, String membership_name) {
        this.membership_id = membership_id;
        this.membership_name = membership_name;
    }

    public Memberlevel() {
    }

    public int getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(int membership_id) {
        this.membership_id = membership_id;
    }

    public String getMembership_name() {
        return membership_name;
    }

    public void setMembership_name(String membership_name) {
        this.membership_name = membership_name;
    }

    @Override
    public String toString() {
        return "Memberlevel{" + "membership_id=" + membership_id + ", membership_name=" + membership_name + '}';
    }
    
    
}
