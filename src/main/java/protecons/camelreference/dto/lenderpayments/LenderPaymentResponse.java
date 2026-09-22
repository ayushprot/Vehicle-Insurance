package protecons.camelreference.dto.lenderpayments;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LenderPaymentResponse {
    private String paymentId;
    private String status;
    private BigDecimal paymentAmount;
    private String currency;
    private String customerId;
    private String vehicleId;
    private String vin;
    private String lenderId;
    private String lenderName;
    private LocalDate paymentDate;

    public String getPaymentId() {
        return paymentId;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVin() {
        return vin;
    }

    public String getLenderId() {
        return lenderId;
    }

    public String getLenderName() {
        return lenderName;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public LenderPaymentResponse(String paymentId, String status, BigDecimal paymentAmount, String currency, String customerId, String vehicleId, String vin, String lenderId, String lenderName, LocalDate paymentDate) {
        this.paymentId = paymentId;
        this.status = status;
        this.paymentAmount = paymentAmount;
        this.currency = currency;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.vin = vin;
        this.lenderId = lenderId;
        this.lenderName = lenderName;
        this.paymentDate = paymentDate;
    }
}
