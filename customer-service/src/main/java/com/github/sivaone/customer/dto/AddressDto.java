package com.github.sivaone.customer.dto;

import com.github.sivaone.customer.model.Address;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String type;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    public Address toAddressDomain() {
        return Address.builder()
                .id(this.id)
                .type(this.type)
                .line1(this.line1)
                .line2(this.line2)
                .city(this.city)
                .state(this.state)
                .country(this.country)
                .zipcode(this.zipcode)
                .build();
    }

    public static AddressDto fromAddressDomain(final Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .type(address.getType())
                .line1(address.getLine1())
                .line2(address.getLine2())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zipcode(address.getZipcode())
                .build();
    }
}
