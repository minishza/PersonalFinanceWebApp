package web.app.personalfinance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import web.app.personalfinance.enums.ExpenseCategory;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
public class ExpenseResponseDTO {

    private Long id;

    private String description;

    private ExpenseCategory category;

    private LocalDate expenseDate;
}
