package web.app.personalfinance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.app.personalfinance.dto.CreateExpenseRequestDTO;
import web.app.personalfinance.dto.ExpenseResponseDTO;
import web.app.personalfinance.dto.UpdateExpenseRequestDTO;
import web.app.personalfinance.service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<ExpenseResponseDTO>> findAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{expenseId}")
    public ResponseEntity<ExpenseResponseDTO> findExpensesById(@PathVariable Long expenseId) {
        return ResponseEntity.ok(expenseService.getExpenseById(expenseId));
    }

    @PostMapping
    public ResponseEntity<ExpenseResponseDTO> createExpense(@RequestBody CreateExpenseRequestDTO createExpenseRequestDTO) {
        return new ResponseEntity<>(expenseService.createExpense(createExpenseRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{expenseId}")
    public ResponseEntity<ExpenseResponseDTO> updateExpense(@PathVariable Long expenseId, @RequestBody UpdateExpenseRequestDTO updateExpenseRequestDTO) {
        return ResponseEntity.ok(expenseService.updateExpense(expenseId, updateExpenseRequestDTO));
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long expenseId) {
        expenseService.deleteExpenseById(expenseId);
        return ResponseEntity.noContent().build();
    }
}
