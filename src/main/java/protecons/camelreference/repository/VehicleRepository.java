package protecons.camelreference.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import protecons.camelreference.entity.Vehicles;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicles, Long> {
    public Optional<Vehicles> findByVin(String vin);


}
