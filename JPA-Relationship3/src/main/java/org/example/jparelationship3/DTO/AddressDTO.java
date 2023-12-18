package org.example.jparelationship3.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    @NotEmpty(message = "area Must be not be empty")
    private String area;
    @NotEmpty(message = "street Must be  not be empty")
    private String street;
    @NotEmpty(message = "building number Must be  not be empty")
    private String Building_number;
}
