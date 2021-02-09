package com.drinok.webservice.address;

import com.drinok.webservice.abstracts.AbstractEntity;

import java.util.Objects;


public class Address extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String companyName;
    private String streetAddress1;
    private String city;
    private String cityArea;
    private String postalCode;
    private String country;
    private String countryArea;
    private String phone;

    public Address() {
    }

    public Address(String firstName, String lastName, String city, String postalCode, String country, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
    }

    public Address(String firstName, String lastName, String companyName, String streetAddress1, String city, String cityArea, String postalCode, String country, String countryArea, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.streetAddress1 = streetAddress1;
        this.city = city;
        this.cityArea = cityArea;
        this.postalCode = postalCode;
        this.country = country;
        this.countryArea = countryArea;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return this.getId().equals(address.getId()) &&
                Objects.equals(companyName, address.companyName) &&
                Objects.equals(streetAddress1, address.streetAddress1) &&
                Objects.equals(city, address.city) &&
                postalCode.equals(address.postalCode) &&
                country.equals(address.country) &&
                Objects.equals(phone, address.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), companyName, streetAddress1, city, postalCode, country, phone);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + this.getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", streetAddress1='" + streetAddress1 + '\'' +
                ", city='" + city + '\'' +
                ", cityArea='" + cityArea + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", countryArea='" + countryArea + '\'' +
                ", phone='" + phone + '\'' +
                '}';
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityArea() {
        return cityArea;
    }

    public void setCityArea(String cityArea) {
        this.cityArea = cityArea;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(String countryArea) {
        this.countryArea = countryArea;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
