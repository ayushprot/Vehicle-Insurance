package protecons.camelreference.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import protecons.camelreference.dto.vehicles.VehicleResponse;
import protecons.camelreference.entity.Vehicles;
import protecons.camelreference.repository.VehicleRepository;


@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "Bearer Authentication")
public class VehicleController {
    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/v1/vehicles/{vin}")
    public VehicleResponse getVehicleDetails(@PathVariable("vin") String vin){

        Vehicles vehicles = vehicleRepository.findByVin(vin).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Vehicle Number is invalid or not registered"
                )
        );
        return new VehicleResponse(vehicles.getVin(),vehicles.getVehicleId(),vehicles.getYear(),vehicles.getMake(), vehicles.getModel(), vehicles.getTrim(),vehicles.getColor(), vehicles.getVehicleType(), vehicles.getTotalLoss(),vehicles.getLenderId(), vehicles.getTitleStatus(),vehicles.getRegistrationState());
    }
}
