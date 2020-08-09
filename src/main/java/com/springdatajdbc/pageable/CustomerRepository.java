package com.springdatajdbc.pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Page<Customer> findByName(String name, Pageable page);

    List<Customer> findListByName(String name, Pageable page);

    @Query("select * from customer where name = :name ")
    List<Customer> findListByNameParamQuery(String name, Pageable page);

    Long countByName(String name);

}