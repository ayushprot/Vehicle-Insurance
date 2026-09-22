package protecons.camelreference.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import protecons.camelreference.constants.Role;
import protecons.camelreference.dto.AddressDTO;
import protecons.camelreference.dto.customer.CustomerRequest;
import protecons.camelreference.dto.customer.CustomerResponse;
import protecons.camelreference.entity.Addresses;
import protecons.camelreference.entity.Customer;
import protecons.camelreference.repository.CustomerRepository;

import java.util.Date;
@PreAuthorize("hasAnyRole('ADMIN', 'INSURANCE_AGENT')")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public CustomerResponse customerAdd(@RequestBody CustomerRequest customerRequest){
        if (customerRepository.existsByEmail(customerRequest.getEmail())) {
            throw new RuntimeException("Customer already exists with email: "
                    + customerRequest.getEmail());
        }

        Customer customer = new Customer();
        Addresses addresses = new Addresses();
        AddressDTO addressDTO = customerRequest.getAddress();
        addresses.setStreet(addressDTO.getStreet());
        addresses.setCity(addressDTO.getCity());
        addresses.setZipCode(addressDTO.getZipcode());
        addresses.setState(addressDTO.getState());
        customer.setCustomerId(generateCustomerId());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhone(customerRequest.getPhone());
        customer.setAddress(addresses);
        customer.setRole(Role.CUSTOMER);
        customerRepository.save(customer);

        Date createdAt = new Date();
        return new CustomerResponse(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(),customer.getPhone(), "Created", createdAt);
    }

    private String generateCustomerId() {

        long count = customerRepository.count();

        return "CUS" + (1001 + count);
    }
}
