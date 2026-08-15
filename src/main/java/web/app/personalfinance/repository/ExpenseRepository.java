package web.app.personalfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.app.personalfinance.entity.Expense;
import web.app.personalfinance.entity.FinancialUser;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findAllByFinancialUser(FinancialUser financialUser);
    Optional<Expense> findByIdAndFinancialUserId(Long id, Long financialUserId);
}
