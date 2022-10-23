package com.newasia.hrm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "address_tb")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address_name")
    private String addressName;

    @JsonIgnore
    @ManyToOne(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "addressParentId", referencedColumnName = "id")
    private Address addressParentId;

}