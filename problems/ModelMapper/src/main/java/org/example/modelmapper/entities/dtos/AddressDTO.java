package org.example.modelmapper.entities.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;

public class AddressDTO {
    @Expose
    private String country;

    @Expose
    private String city;

    public AddressDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
