package web.app.personalfinance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import web.app.personalfinance.enums.ExpenseCategory;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
public class CreateExpenseDTO {
    private BigDecimal amount;

    private String description;


    private ExpenseCategory category;


    private LocalDate expenseDate;
}
