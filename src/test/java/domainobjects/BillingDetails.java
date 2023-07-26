package domainobjects;

public class BillingDetails {
    private String firstName;
    private String lastName;
    private String addressOne;
    private String city;
    private String state;
    private String pinCode;

    public BillingDetails(String firstName, String lastName, String addressOne, String city, String state, String pinCode, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressOne = addressOne;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
}
