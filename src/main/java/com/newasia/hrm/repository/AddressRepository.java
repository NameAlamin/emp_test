package com.newasia.hrm.repository;

import com.newasia.hrm.model.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findAll();

    List<Address> findAddressesByAddressParentIdIsNull();

    @Query("select r from Address r where r.addressParentId.id = ?1")
    List<Address> findAddressesByParentId(Long id);


}
