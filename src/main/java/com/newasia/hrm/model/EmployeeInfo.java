package com.newasia.hrm.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employeeInfo_tb")
public class EmployeeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_age")
    private Integer age;

    @Column(name = "emp_phone")
    private String phone;

    @Column(name = "basic_salary")
    private Double basic;

    @Column(name = "house_allownce")
    private Double ha;

    @Column(name = "mobile_allownce")
    private Double ma;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private Department department;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employee_address",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id", referencedColumnName = "id")})
    private List<Address> addresses;

}