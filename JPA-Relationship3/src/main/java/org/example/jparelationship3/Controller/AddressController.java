package org.example.jparelationship3.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.jparelationship3.DTO.AddressDTO;
import org.example.jparelationship3.Service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor

public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAddress(){

        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddress());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body("add");
    }
    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid@RequestBody AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body("update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete");
    }
}
