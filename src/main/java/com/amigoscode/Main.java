package com.amigoscode;

import com.amigoscode.customer.Customer;
import com.amigoscode.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

// Anotare principala care marcheaza clasa ca aplicatie Spring Boot
// Activeaza auto-configurarea si scanarea componentelor in pachetul curent
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Metoda care porneste aplicatia Spring Boot
        // Creeaza contextul Spring si initializeaza toate componentele (bean-urile)
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {

        return (args) -> {
            Customer alex = new Customer( "Alex", "alex@gmail.com", 36);
            Customer jamila = new Customer("Jamila", "jamila@gmail.com", 26);
            List<Customer> customers = List.of(alex, jamila);
            customerRepository.saveAll(customers);
        };
    }
}
