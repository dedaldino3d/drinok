package com.drinok.webservice.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("addresses")
public class AddressController {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    private void verifyIfAddressExist(Long id){
        Address address = addressRepository.getOne(id);
        if(address == null){
//            TODO: create an appropriate exception to handle this
            throw new RuntimeException();
        }
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(addressRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable("id") Long id) {
        verifyIfAddressExist(id);
        Address address = addressRepository.getOne(id);
        return new ResponseEntity<>(address, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> createAddress(@Validated @RequestBody Address address) {
        return new ResponseEntity<>(addressRepository.save(address), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @Validated @RequestBody Address address) {
        verifyIfAddressExist(id);
        return new ResponseEntity<>(addressRepository.save(address), HttpStatus.OK);
    }
}
