package web.app.personalfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.app.personalfinance.entity.Expense;

public interface FinancialExpenseRepository extends JpaRepository<Expense,Long> { }
