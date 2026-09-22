package protecons.camelreference.dto.vehicles;

public class VehicleResponse {
    private String vin;
    private String vehicleId;
    private Integer year;
    private String make;
    private String model;
    private String trim;
    private String color;
    private String vehicleType;
    private Boolean totalLoss;
    private String lenderId;
    private String titleStatus;
    private String registrationState;

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

    public VehicleResponse(String vin, String vehicleId, Integer year, String make, String model, String trim, String color, String vehicleType, Boolean totalLoss, String lenderId, String titleStatus, String registrationState) {
        this.vin = vin;
        this.vehicleId = vehicleId;
        this.year = year;
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.color = color;
        this.vehicleType = vehicleType;
        this.totalLoss = totalLoss;
        this.lenderId = lenderId;
        this.titleStatus = titleStatus;
        this.registrationState = registrationState;
    }
}
