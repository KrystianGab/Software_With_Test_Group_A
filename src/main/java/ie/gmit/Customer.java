package ie.gmit;

public class Customer {

    private String Name;
    private  String PPS;
    private String Address;
    private String Email;
    private String Phone;

    public Customer(String name, String pps, String address, String email, String phone){
        setName(name);
        setPPS(pps);
        this.Address = address;
        this.Email = email;
        this.Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if((name.length() >= 6)){
            this.Name = name;
        }
        else{
            throw new IllegalArgumentException("invalid Name");
        }
    }

    public String getPPS() {
        return PPS;
    }

    public void setPPS(String PPS) {
        if((PPS.length() == 8)){
            this.PPS = PPS;
        }
        else{
            throw new IllegalArgumentException("invalid PPS must be 7 digits followed by a letter");
        }
    }
}
