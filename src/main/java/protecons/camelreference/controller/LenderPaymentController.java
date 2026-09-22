package protecons.camelreference.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import protecons.camelreference.dto.lenderpayments.LenderPaymentRequest;
import protecons.camelreference.dto.lenderpayments.LenderPaymentResponse;
import protecons.camelreference.entity.Customer;
import protecons.camelreference.entity.Lender;
import protecons.camelreference.entity.Vehicles;
import protecons.camelreference.repository.CustomerRepository;
import protecons.camelreference.repository.LenderRepository;
import protecons.camelreference.repository.VehicleRepository;


@RestController
@RequestMapping("/api")
public class LenderPaymentController {
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;
    private final LenderRepository lenderRepository;

    public LenderPaymentController(CustomerRepository customerRepository, VehicleRepository vehicleRepository, LenderRepository lenderRepository) {
        this.customerRepository = customerRepository;
        this.vehicleRepository = vehicleRepository;
        this.lenderRepository = lenderRepository;
    }

    @PostMapping("/v1/payments")
    public LenderPaymentResponse lenderPayment(@RequestBody LenderPaymentRequest request)  {

        Customer customer = customerRepository.findByEmail(request.getEmail()).orElseThrow(() ->
                new RuntimeException("Customer not found with email: " + request.getEmail()));
        Lender lender = lenderRepository.findByLenderId(request.getLenderId()) .orElseThrow(() ->
                new RuntimeException("Lender not found with lenderId: " + request.getLenderId()));

        Vehicles vehicles = vehicleRepository.findByVin(request.getVin()).orElseThrow(() ->
                new RuntimeException("Vehicle not found with VIN: " + request.getVin()));

        String currentPaymentId = lender.getLastPaymentId();

        // Extract number and increment by 1
        long paymentNumber = Long.parseLong(
                currentPaymentId.substring(currentPaymentId.indexOf("-") + 1)
        );

        String nextPaymentId = "PAY-" + (paymentNumber + 1);

        return new LenderPaymentResponse(nextPaymentId, "SUCCESS", lender.getPayOutAmount(), lender.getCurrency(), customer.getCustomerId(), vehicles.getVehicleId(), vehicles.getVin(), lender.getLenderId(), lender.getLenderName(), lender.getLastPaymentDate());
    }
}