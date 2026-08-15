package web.app.personalfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.app.personalfinance.entity.FinancialUser;

public interface UserRepository extends JpaRepository<FinancialUser, Long> { }
