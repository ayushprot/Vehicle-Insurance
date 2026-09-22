package protecons.camelreference.entity;

import jakarta.persistence.*;
import net.jcip.annotations.Immutable;
import protecons.camelreference.constants.Role;
@Entity
@Immutable
@Table(name = "vehicles")
public class Vehicles {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "vin")
    private String vin;

    @Column(name = "vehicle_id")
    private String vehicleId;

    @Column(name = "year")
    private Integer year;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "trim")
    private String trim;

    @Column(name = "color")
    private String color;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "total_loss")
    private Boolean totalLoss;

    @Column(name = "lender_id")
    private String lenderId;

    @Column(name = "title_status")
    private String titleStatus;

    @Column(name = "registration_state")
    private String registrationState;

    public Vehicles() {
    }

    public Long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public Integer getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getTrim() {
        return trim;
    }

    public String getColor() {
        return color;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Boolean getTotalLoss() {
        return totalLoss;
    }

    public String getLenderId() {
        return lenderId;
    }

    public String getTitleStatus() {
        return titleStatus;
    }

    public String getRegistrationState() {
        return registrationState;
    }
}
