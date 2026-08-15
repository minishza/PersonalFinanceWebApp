package web.app.personalfinance.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import web.app.personalfinance.enums.ExpenseCategory;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
public class CreateExpenseResponseDTO {

    @NotNull
    @Positive(message = "pengarna måste vara mer än 0")
    private BigDecimal amount;

    private String description;

    @NotNull
    private ExpenseCategory category;

    @NotNull(message = "datum för handling måste finnas")
    private LocalDate expenseDate;
}
