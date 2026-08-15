package web.app.personalfinance.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import web.app.personalfinance.enums.ExpenseCategory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal spent;
    private String description;
    private ExpenseCategory category;
    private LocalDate expenseDate;

    @CreationTimestamp
    private Timestamp creationDate;

    @ManyToOne
    @JoinColumn(name = "financial_user_id")
    private FinancialUser financialUser;
}
