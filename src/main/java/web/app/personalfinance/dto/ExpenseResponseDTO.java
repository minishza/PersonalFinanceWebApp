package web.app.personalfinance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.app.personalfinance.enums.ExpenseCategory;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ExpenseResponseDTO {
    private Long id;
    private String description;
    private BigDecimal spent;
    private ExpenseCategory category;
    private LocalDate expenseDate;
}
