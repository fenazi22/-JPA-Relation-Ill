package org.example.jparelationship3.Service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.jparelationship3.Api.ApiEXception;
import org.example.jparelationship3.DTO.AddressDTO;
import org.example.jparelationship3.Model.Address;
import org.example.jparelationship3.Model.Teacher;
import org.example.jparelationship3.Repository.AddressRepository;
import org.example.jparelationship3.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<Address> getAddress(){

        return addressRepository.findAll();
    }

    public void addAddress(@Valid AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher==null){
            throw new ApiEXception("Sorry not found teacher id !!");
        }
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuilding_number(),teacher);

        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(address==null){
            throw new ApiEXception("Sorry not found address id !!");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuilding_number(addressDTO.getBuilding_number());

        addressRepository.save(address);
    }


    public void deleteAddress(Integer id){

        Address address = addressRepository.findAddressById(id);
        Teacher teacher = teacherRepository.findTeacherById(id);

        if(address==null){
            throw new ApiEXception("Sorry not found id !!");
        }

        teacher.setAddress(null);
        addressRepository.delete(address);
    }

}
