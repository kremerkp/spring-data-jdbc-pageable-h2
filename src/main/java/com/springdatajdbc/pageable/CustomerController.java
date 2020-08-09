package com.springdatajdbc.pageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/findByName")
    public ResponseEntity<?> findByName(@RequestParam String name, Pageable pagable) {
        return ResponseEntity.ok().body(customerRepository.findByName(name, pagable));
    }

    @GetMapping(value = "/findListByName")
    public ResponseEntity<?> findByNameList(@RequestParam String name, Pageable pagable) {
        // Paging and sorting are working.
        List<Customer> custList = customerRepository.findListByName(name, pagable);
        Long count = customerRepository.countByName(name);
        Page<Customer> customerPage = PageableExecutionUtils.getPage(custList, pagable, () -> count);
        return ResponseEntity.ok().body(customerPage);
    }

    @GetMapping(value = "/findListByNameParamQuery")
    public ResponseEntity<?> findListByNameParamQuery(@RequestParam String name, Pageable pagable) {
        // Pageing works, sort did not
        List<Customer> custList = customerRepository.findListByNameParamQuery(name, pagable);
        Long count = customerRepository.countByName(name);
        Page<Customer> customerPage = PageableExecutionUtils.getPage(custList, pagable, () -> count);
        return ResponseEntity.ok().body(customerPage);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllRoles(Pageable pageable) {
        return ResponseEntity.ok().body(customerRepository.findAll(pageable));
    }

}