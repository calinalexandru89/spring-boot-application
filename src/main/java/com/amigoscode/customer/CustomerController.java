package com.amigoscode.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// Marcheaza clasa ca un controller REST
// Permite expunerea metodelor care returneaza direct raspunsuri HTTP (Json / text), fara sa fie nevoie de templeaturi (HTML)
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //Cele 2 variante sunt asemanatoare doar ca GetMapping este mai rapid/destept si stie tot post, put, delete si get automat
    //@RequestMapping(value = "api/v1/customers", method = RequestMethod.GET)
    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("api/v1/customers/{customerid}")
    public Customer getCustomerById(@PathVariable("customerid") Integer customerid) {
        return customerService.getCustomers(customerid);
    }
}
