package web.app.personalfinance.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import web.app.personalfinance.enums.Role;

import java.sql.Timestamp;
import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class FinancialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    private String email;

    private Role role;

    @CreationTimestamp
    private Timestamp creationDate;

    @OneToMany(mappedBy="financialUser")
    private List<Expense> userExpenses;
}
