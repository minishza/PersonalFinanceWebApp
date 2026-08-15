package web.app.personalfinance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.app.personalfinance.dto.CreateExpenseRequestDTO;
import web.app.personalfinance.dto.ExpenseResponseDTO;
import web.app.personalfinance.dto.UpdateExpenseRequestDTO;
import web.app.personalfinance.entity.Expense;
import web.app.personalfinance.entity.FinancialUser;
import web.app.personalfinance.repository.ExpenseRepository;
import web.app.personalfinance.repository.FinancialUserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final FinancialUserRepository financialUserRepository;

    public List<ExpenseResponseDTO> getAllExpenses() {
        FinancialUser financialUser = FinancialUser.builder().build(); // mock user

        return expenseRepository.findAllByFinancialUser(financialUser)
                .stream()
                .map(expense -> ExpenseResponseDTO.builder()
                        .id(expense.getId())
                        .description(expense.getDescription())
                        .spent(expense.getSpent())
                        .category(expense.getCategory())
                        .expenseDate(expense.getExpenseDate())
                        .build())
                .toList();
    }

    public ExpenseResponseDTO getExpenseById(Long id) {
        FinancialUser financialUser = FinancialUser.builder().build(); // mock user

        Expense expense = expenseRepository.findByIdAndFinancialUserId(id, financialUser.getId())
                .orElseThrow(); // add exception

        return ExpenseResponseDTO.builder()
                .id(expense.getId())
                .description(expense.getDescription())
                .spent(expense.getSpent())
                .category(expense.getCategory())
                .expenseDate(expense.getExpenseDate())
                .build();
    }

    public ExpenseResponseDTO createExpense(CreateExpenseRequestDTO createExpenseRequestDTO) {
        Expense expense = Expense.builder()
                .spent(createExpenseRequestDTO.getSpent())
                .description(createExpenseRequestDTO.getDescription())
                .category(createExpenseRequestDTO.getCategory())
                .expenseDate(createExpenseRequestDTO.getExpenseDate())
                .build();

        FinancialUser financialUser = FinancialUser.builder().build(); //mock user

        expense.setFinancialUser(financialUser);
        expenseRepository.save(expense);

        return ExpenseResponseDTO.builder()
                .id(expense.getId())
                .description(expense.getDescription())
                .spent(expense.getSpent())
                .category(expense.getCategory())
                .expenseDate(expense.getExpenseDate())
                .build();
    }

    public ExpenseResponseDTO updateExpense(Long id, UpdateExpenseRequestDTO updateExpenseRequestDTO) {
        FinancialUser financialUser = FinancialUser.builder().build(); //mock user

        Expense expense = expenseRepository.findByIdAndFinancialUserId(id, financialUser.getId())
                .orElseThrow(); // add exception

        if (updateExpenseRequestDTO.getDescription() != null) {
            expense.setDescription(updateExpenseRequestDTO.getDescription());
        }
        if (updateExpenseRequestDTO.getSpent() != null) {
            expense.setSpent(updateExpenseRequestDTO.getSpent());
        }
        if (updateExpenseRequestDTO.getCategory() != null) {
            expense.setCategory(updateExpenseRequestDTO.getCategory());
        }
        if (updateExpenseRequestDTO.getExpenseDate() != null) {
            expense.setExpenseDate(updateExpenseRequestDTO.getExpenseDate());
        }

        Expense savedExpense = expenseRepository.save(expense);

        return ExpenseResponseDTO.builder()
                .id(savedExpense.getId())
                .description(savedExpense.getDescription())
                .spent(savedExpense.getSpent())
                .category(savedExpense.getCategory())
                .expenseDate(expense.getExpenseDate())
                .build();
    }

    public void deleteExpenseById(Long id) {
        if (!expenseRepository.existsById(id)) {
            throw new UsernameNotFoundException("ExpenseNotFoundException");//change to custom exception
        }
        expenseRepository.deleteById(id);
    }
}
