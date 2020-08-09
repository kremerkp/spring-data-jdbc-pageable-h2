package com.springdatajdbc.pageable;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private Float salary;

    public Customer() {
    }

    public Customer(Long id, String name, Integer age, String address, Float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getSalary() {
        return this.salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Customer id(Long id) {
        this.id = id;
        return this;
    }

    public Customer name(String name) {
        this.name = name;
        return this;
    }

    public Customer age(Integer age) {
        this.age = age;
        return this;
    }

    public Customer address(String address) {
        this.address = address;
        return this;
    }

    public Customer salary(Float salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", age='" + getAge() + "'" + ", address='"
                + getAddress() + "'" + ", salary='" + getSalary() + "'" + "}";
    }

}