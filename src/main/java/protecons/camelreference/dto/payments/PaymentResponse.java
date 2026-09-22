package protecons.camelreference.dto.payments;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class PaymentResponse {
    private String lenderId;
    private String paymentStatus;
    private String lastPaymentId;
    private BigDecimal lastPaymentAmount;
    private LocalDate lastPaymentDate;
    private Integer totalPaymentsMade;
    private BigDecimal totalAmountMade;
    private BigDecimal remainingPayoffAmount;

    public String getLenderId() {
        return lenderId;
    }

    public String getPaymentStatus() {
        return "PARTIALLY_PAID";
    }

    public String getLastPaymentId() {
        return lastPaymentId;
    }

    public BigDecimal getLastPaymentAmount() {
        return lastPaymentAmount;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public Integer getTotalPaymentsMade() {
        return totalPaymentsMade;
    }

    public BigDecimal getTotalAmountMade() {
        return lastPaymentAmount.multiply(BigDecimal.valueOf(totalPaymentsMade));
    }

    public BigDecimal getRemainingPayoffAmount() {
        return remainingPayoffAmount;
    }

    public PaymentResponse(String lenderId, String paymentStatus, String lastPaymentId, BigDecimal lastPaymentAmount, LocalDate lastPaymentDate, Integer totalPaymentsMade, BigDecimal totalAmountMade, BigDecimal remainingPayoffAmount) {
        this.lenderId = lenderId;
        this.paymentStatus = paymentStatus;
        this.lastPaymentId = lastPaymentId;
        this.lastPaymentAmount = lastPaymentAmount;
        this.lastPaymentDate = lastPaymentDate;
        this.totalPaymentsMade = totalPaymentsMade;
        this.totalAmountMade = totalAmountMade;
        this.remainingPayoffAmount = remainingPayoffAmount;
    }
}
