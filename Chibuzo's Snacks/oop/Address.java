package oop;

public class Address {
    private String cityName;
    private String countryName;
    private String houseNumber;
    private String street;
    private String state;

    public Address(String cityName, String countryName, String houseNumber, String street, String state) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.houseNumber = houseNumber;
        this.street = street;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s%n%s%n%s", cityName, countryName, houseNumber, street, state);
    }

}
