package web.app.personalfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.app.personalfinance.entity.FinancialUser;

import java.util.Optional;

@Repository
public interface FinancialUserRepository extends JpaRepository<FinancialUser, Long> {
    Optional<FinancialUser> findByUsername(String username);
}
