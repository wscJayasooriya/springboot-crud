package com.sandun.test.Service.Impl;

import com.sandun.test.DTO.CustomerDTO;
import com.sandun.test.Entity.Customer;
import com.sandun.test.Repository.CustomerRepository;
import com.sandun.test.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {

        Customer customer = new Customer(
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getTele()
        );
        customerRepository.save(customer);

        return true;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {

        Optional<Customer> byId = customerRepository.findById(customerDTO.getCid());

        if(byId.isPresent()){
            Customer customer = byId.get();
            customer.setName(customerDTO.getName());
            customer.setAddress(customerDTO.getAddress());
            customer.setTele(customerDTO.getTele());
            customerRepository.save(customer);
        }
        return true;
    }



    @Override
    public List<CustomerDTO> getAllCustomer() throws Exception {

        List<Customer> all = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : all ) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCid(customer.getCid());
            customerDTO.setName(customer.getName());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setTele(customer.getTele());

            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO searchCustomer(int id) throws Exception {

        Optional<Customer> byId = customerRepository.findById(id);
        if (byId.isPresent()){
            Customer customer = byId.get();
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCid(customer.getCid());
            customerDTO.setName(customer.getName());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setTele(customer.getTele());

            return customerDTO;
        }else {
            return null;
        }
    }

    @Override
    public boolean deleteCustomer(int id) throws Exception {

        Optional<Customer> byId = customerRepository.findById(id);
        if(byId.isPresent()){
                customerRepository.deleteById(id);
        }
        return true;
    }
}
