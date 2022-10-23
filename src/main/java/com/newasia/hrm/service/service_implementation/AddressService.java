package com.newasia.hrm.service.service_implementation;

import com.newasia.hrm.model.Address;
import com.newasia.hrm.repository.AddressRepository;
import com.newasia.hrm.service.service_interface.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public List<Address> findAllAddress() {
        return addressRepository.findAddressesByAddressParentIdIsNull();
    }

    @Override
    public List<Address> findAllAddressByParentId(Long parentId) {
        return addressRepository.findAddressesByParentId(parentId);
    }
}


// optional, stream, lambda, collection