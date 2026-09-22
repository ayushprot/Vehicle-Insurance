package protecons.camelreference.dto.lender;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LenderResponse {
    private String lenderId;
    private String lenderName;
    private String lenderAccountNumber;
    private String loanStatus;
    private BigDecimal originalLoanAmount;
    private BigDecimal remainingPrincipal;
    private BigDecimal payOutAmount;
    private BigDecimal monthlyEmi;
    private Integer emisPaid;
    private Integer totalEmis;
    private String lastPaymentId;
    private LocalDate lastPaymentDate;
    private String currency;

    public String getLenderId() {
        return lenderId;
    }

    public String getLenderName() {
        return lenderName;
    }

    public String getLenderAccountNumber() {
        return lenderAccountNumber;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public BigDecimal getOriginalLoanAmount() {
        return originalLoanAmount;
    }

    public BigDecimal getRemainingPrincipal() {
        return remainingPrincipal;
    }

    public BigDecimal getPayOutAmount() {
        return payOutAmount;
    }

    public BigDecimal getMonthlyEmi() {
        return monthlyEmi;
    }

    public Integer getEmisPaid() {
        return emisPaid;
    }

    public Integer getTotalEmis() {
        return totalEmis;
    }

    public String getLastPaymentId() {
        return lastPaymentId;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public String getCurrency() {
        return currency;
    }

    public LenderResponse(String lenderId, String lenderName, String lenderAccountNumber, String loanStatus, BigDecimal originalLoanAmount, BigDecimal remainingPrincipal, BigDecimal payOutAmount, BigDecimal monthlyEmi, Integer emisPaid, Integer totalEmis, String lastPaymentId, LocalDate lastPaymentDate, String currency) {
        this.lenderId = lenderId;
        this.lenderName = lenderName;
        this.lenderAccountNumber = lenderAccountNumber;
        this.loanStatus = loanStatus;
        this.originalLoanAmount = originalLoanAmount;
        this.remainingPrincipal = remainingPrincipal;
        this.payOutAmount = payOutAmount;
        this.monthlyEmi = monthlyEmi;
        this.emisPaid = emisPaid;
        this.totalEmis = totalEmis;
        this.lastPaymentId = lastPaymentId;
        this.lastPaymentDate = lastPaymentDate;
        this.currency = currency;
    }
}
