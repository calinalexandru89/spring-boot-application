package com.amigoscode.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marcheaza clasa ca un controller REST
// Permite expunerea metodelor care returneaza direct raspunsuri HTTP (Json / text), fara sa fie nevoie de templeaturi (HTML)
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //Cele 2 variante sunt asemanatoare doar ca GetMapping este mai rapid/destept si stie tot post, put, delete si get automat
    //@RequestMapping(value = "api/v1/customers", method = RequestMethod.GET)
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("{customerid}")
    public Customer getCustomerById(@PathVariable("customerid") Integer customerid) {
        return customerService.getCustomer(customerid);
    }

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request){
        customerService.addCustomer(request);
    }

    @DeleteMapping("{customerid}")
    public void deleteCustomer(@PathVariable("customerid") Integer customerid){
        customerService.deleteCustomerById(customerid);
    }

    @PutMapping("{customerid}")
    public void updateCustomer(@PathVariable("customerid") Integer customerId, @RequestBody CustomerUpdateRequest updateRequest){
        customerService.updateCustomer(customerId, updateRequest);
    }
}
