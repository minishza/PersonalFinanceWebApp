package web.app.personalfinance.service;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.app.personalfinance.repository.FinancialUserRepository;

@Service
@RequiredArgsConstructor
public class cUserDetailsService implements UserDetailsService {

    private final FinancialUserRepository financialUserRepository;

    @Override
    public @Nonnull UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return financialUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
