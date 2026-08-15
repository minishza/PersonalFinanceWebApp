package web.app.personalfinance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.app.personalfinance.dto.CreateFinancialUserDTO;
import web.app.personalfinance.dto.FinancialUserResponseDTO;
import web.app.personalfinance.entity.FinancialUser;
import web.app.personalfinance.enums.Role;
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
          throw new UsernameNotFoundException("username already existed");// change to custom exception
        }
    }

    public FinancialUserResponseDTO getCurrentUser() {
        return FinancialUserResponseDTO.builder().build();//change to current user after security config
    }
}
