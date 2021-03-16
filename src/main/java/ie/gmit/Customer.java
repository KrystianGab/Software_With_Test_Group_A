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
        setAddress(address);
        setEmail(email);
        setPhone(phone);
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        if((Address.length() >= 8)){
            this.Address = Address;
        }
        else{
            throw new IllegalArgumentException("invalid Adress must be 8 digits or greater");
        }
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        if((Email.length() >= 8)){
            this.Email = Email;
        }
        else{
            throw new IllegalArgumentException("invalid Email must be at least 8 Charaters");
        }
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        if((Phone.length() >= 7)){
            this.Phone = Phone;
        }
        else{
            throw new IllegalArgumentException("invalid Phone must be at least 7 digits");
        }
    }
}
