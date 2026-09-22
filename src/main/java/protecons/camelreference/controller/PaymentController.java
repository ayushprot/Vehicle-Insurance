package protecons.camelreference.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import protecons.camelreference.dto.lender.LenderResponse;
import protecons.camelreference.dto.payments.PaymentResponse;
import protecons.camelreference.entity.Lender;
import protecons.camelreference.repository.LenderRepository;

@RestController
@RequestMapping("/api")
public class PaymentController {
    private final LenderRepository lenderRepository;

    public PaymentController(LenderRepository lenderRepository) {
        this.lenderRepository = lenderRepository;
    }

    @GetMapping("/v1/payments/{lenderId}")
    private PaymentResponse getLenderDetails(@PathVariable("lenderId") String lenderId){
        Lender lender = lenderRepository.findByLenderId(lenderId).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Lender Id is invalid or not registered"
                )
        );
        return new PaymentResponse(lender.getLenderId(), "PARTIALLY_PAID" ,lender.getLastPaymentId(),lender.getMonthlyEmi(), lender.getLastPaymentDate(),lender.getEmisPaid(), lender.getMonthlyEmi(), lender.getPayOutAmount());
    }
}
