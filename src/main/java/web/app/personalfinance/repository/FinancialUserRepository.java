package web.app.personalfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.app.personalfinance.entity.FinancialUser;

public interface FinancialUserRepository extends JpaRepository<FinancialUser, Long> {
}
