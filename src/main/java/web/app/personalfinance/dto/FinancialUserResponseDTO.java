package web.app.personalfinance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class FinancialUserResponseDTO {
    private String username;
    private String email;
}
