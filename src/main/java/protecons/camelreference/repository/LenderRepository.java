package protecons.camelreference.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import protecons.camelreference.entity.Lender;

import java.util.Optional;

public interface LenderRepository extends JpaRepository<Lender, Long> {

    public Optional<Lender> findByLenderId(String lenderId);
}
