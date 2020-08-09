package com.springdatajdbc.pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

        Page<Customer> findByName(String name, Pageable page);

        List<Customer> findListByName(String name, Pageable page);

        @Query("select * from customer where name = :name limit :limit offset :offset  ")
        List<Customer> findListByNameParamQuery(String name, Pageable page, @Param("limit") Integer size,
                        @Param("offset") Long offset);

        @Query("select * from customer where name = :name order by :sort limit :limit offset :offset  ")
        List<Customer> findListByNameParamQuerySort(@Param("name") String name, Pageable page,
                        @Param("limit") Integer size, @Param("offset") Long offset, @Param("sort") String sort);

        Long countByName(String name);

}