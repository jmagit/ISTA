package com.ista.demo.dtos;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.ista.demo.model.City;
import com.ista.demo.model.Country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CityDTO implements Serializable {
	@NonNull
	private long cityId;
	@NonNull
	@Size(min=1, max=50)
	private String city;
	//private List<Address> addresses;
	@Min(value=1, message="Es obligatorio")
	private long countryId = -1;
	
	public static CityDTO form(City source) {
		return new CityDTO(
				source.getCityId(), 
				source.getCity(), 
				source.getCountry() == null ? -1 : 
					source.getCountry().getCountryId());
	}
	public static City form(CityDTO source) {
		return new City(
				source.getCityId(), 
				source.getCity(), 
				source.getCountryId() == -1 ? null : new Country(source.getCountryId()));
	}

}
