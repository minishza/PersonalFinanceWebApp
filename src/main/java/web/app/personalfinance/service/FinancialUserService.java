package web.app.personalfinance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.app.personalfinance.dto.CreateFinancialUserDTO;
import web.app.personalfinance.dto.FinancialUserResponseDTO;
import web.app.personalfinance.entity.FinancialUser;
import web.app.personalfinance.enums.Role;
import web.app.personalfinance.exception.UsernameAlreadyExistsException;
import web.app.personalfinance.repository.ExpenseRepository;
import web.app.personalfinance.repository.FinancialUserRepository;

@Service
@RequiredArgsConstructor
public class FinancialUserService {
    private final ExpenseRepository expenseRepository;
    private final FinancialUserRepository financialUserRepository;
    private final PasswordEncoder passwordEncoder;

    public FinancialUserResponseDTO createFinancialUser(CreateFinancialUserDTO createFinancialUserDTO) {
        try {
            FinancialUser savedUser = financialUserRepository.save(
                    FinancialUser.builder()
                            .username(createFinancialUserDTO.getUsername())
                            .password(passwordEncoder.encode(createFinancialUserDTO.getPassword()))
                            .email(createFinancialUserDTO.getEmail())
                            .role(Role.USER)
                            .build());

            return FinancialUserResponseDTO.builder()
                    .username(savedUser.getUsername())
                    .email(savedUser.getEmail())
                    .build();

        } catch (Exception e) {
          throw new UsernameAlreadyExistsException("Username already exists");
        }
    }

    public FinancialUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Principal class: " + authentication.getPrincipal().getClass());
        System.out.println("Principal: " + authentication.getPrincipal());
        System.out.println("Authorities: " + authentication.getAuthorities());

        return (FinancialUser) authentication.getPrincipal();
    }
}
