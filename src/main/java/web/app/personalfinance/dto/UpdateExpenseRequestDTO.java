package web.app.personalfinance.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import web.app.personalfinance.enums.ExpenseCategory;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
public class UpdateExpenseRequestDTO {
    private String description;
    @Positive(message = "pengarna måste vara mer än 0")
    private BigDecimal spent;
    private ExpenseCategory category;
    private LocalDate expenseDate;
}
