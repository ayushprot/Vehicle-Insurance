package protecons.camelreference.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import protecons.camelreference.dto.lender.LenderResponse;
import protecons.camelreference.entity.Lender;
import protecons.camelreference.repository.LenderRepository;
@RestController
@RequestMapping("/api")
public class LenderController {
    private final LenderRepository lenderRepository;

    public LenderController(LenderRepository lenderRepository) {
        this.lenderRepository = lenderRepository;
    }
    @GetMapping("/v1/lender/{lenderId}")
    private LenderResponse getLenderDetails(@PathVariable("lenderId") String lenderId){
        Lender lender = lenderRepository.findByLenderId(lenderId).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Lender Id is invalid or not registered"
                )
        );
        return new LenderResponse(lender.getLenderId(), lender.getLenderName(), lender.getLenderAccountNumber(), lender.getLoanStatus(),lender.getOriginalLoanAmount(), lender.getRemainingPrincipal(), lender.getPayOutAmount(), lender.getMonthlyEmi(), lender.getEmisPaid(), lender.getTotalEmis(), lender.getLastPaymentId(), lender.getLastPaymentDate(),lender.getCurrency());
    }
}
