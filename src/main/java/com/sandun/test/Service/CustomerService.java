package com.sandun.test.Service;

import com.sandun.test.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {

    boolean saveCustomer(CustomerDTO customerDTO) throws  Exception;

    boolean updateCustomer(CustomerDTO customerDTO) throws  Exception;

    boolean deleteCustomer(int id) throws  Exception;

    List<CustomerDTO> getAllCustomer() throws  Exception;

    CustomerDTO searchCustomer (int id) throws  Exception;

}
