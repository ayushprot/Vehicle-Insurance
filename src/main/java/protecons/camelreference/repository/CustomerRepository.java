package protecons.camelreference.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import protecons.camelreference.entity.Customer;
import protecons.camelreference.entity.User;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Optional<Customer> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByCustomerId(String customerID);
}
