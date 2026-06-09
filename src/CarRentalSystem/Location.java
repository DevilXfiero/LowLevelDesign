package CarRentalSystem;

public class Location {
    String Address;
    int pinCode;
    String City;

    public Location(String address, int pinCode, String city) {
        Address = address;
        this.pinCode = pinCode;
        City = city;
    }
}
