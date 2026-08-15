package web.app.personalfinance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.app.personalfinance.dto.CreateFinancialUserDTO;
import web.app.personalfinance.dto.FinancialUserResponseDTO;
import web.app.personalfinance.service.FinancialUserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class FinancialUserController {

    private final FinancialUserService financialUserService;

    @PostMapping("/create")
    public ResponseEntity<FinancialUserResponseDTO> createFinancialUser(@RequestBody CreateFinancialUserDTO createFinancialUserDTO) {
        return new ResponseEntity<>(financialUserService.createFinancialUser(createFinancialUserDTO), HttpStatus.CREATED);
    }
}
