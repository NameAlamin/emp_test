package com.newasia.hrm.service.service_interface;

import com.newasia.hrm.model.Address;

import java.util.List;

public interface IAddressService {
    void saveAddress(Address address);
    List<Address> findAllAddress();

    List<Address> findAllAddressByParentId(Long parentId);

}