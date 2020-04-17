package com.sandun.test.Controller;

import com.sandun.test.DTO.CustomerDTO;
import com.sandun.test.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "save")
    public boolean saveCustomer(@RequestBody CustomerDTO customerDTO) throws Exception{
        return customerService.saveCustomer(customerDTO);
    }

    @DeleteMapping(value = "delete")
    public boolean deleteCustomer(@RequestParam("cid") int cid) throws Exception {
        return  customerService.deleteCustomer(cid);
    }

    @PutMapping(value = "update")
    public boolean updateCustomer(@RequestBody CustomerDTO customerDTO)throws  Exception {
        return customerService.updateCustomer(customerDTO);
    }

    @GetMapping(value = "search")
    public CustomerDTO searchCustomer(@RequestParam("cid") int cid) throws Exception {
        return customerService.searchCustomer(cid);
    }

    @GetMapping(value = "getAll")
    public List<CustomerDTO> getAllCustomer() throws Exception{
        return customerService.getAllCustomer();
    }
}
