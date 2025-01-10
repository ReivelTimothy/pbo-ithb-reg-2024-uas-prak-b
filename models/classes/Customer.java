package models.classes;

public class Customer {
    private int id;
    private String name, password, addresss, phone;
    public Customer(int id, String name, String password, String addresss, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.addresss = addresss;
        this.phone = phone;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddresss() {
        return addresss;
    }
    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
