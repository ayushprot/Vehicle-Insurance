package protecons.camelreference.entity;

import jakarta.persistence.*;
import net.jcip.annotations.Immutable;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lender")
@Immutable
public class Lender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "lender_id")
    private String lenderId;
    @Column(name = "lender_name")
    private String lenderName;
    @Column(name = "lender_account_number")
    private String lenderAccountNumber;
    @Column(name = "loan_status")
    private String loanStatus;
    @Column(name = "original_loan_amount")
    private BigDecimal originalLoanAmount;
    @Column(name = "remaining_principal")
    private BigDecimal remainingPrincipal;
    @Column(name = "payoff_amount")
    private BigDecimal payOutAmount;
    @Column(name = "monthly_emi")
    private BigDecimal monthlyEmi;
    @Column(name = "emis_paid")
    private Integer emisPaid;
    @Column(name = "total_emis")
    private Integer totalEmis;
    @Column(name = "last_payment_id")
    private String lastPaymentId;
    @Column(name = "last_payment_date")
    private LocalDate lastPaymentDate;
    @Column(name = "currency")
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
}
