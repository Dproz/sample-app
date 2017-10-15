package com.ceitechs.dproz.shared.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Implementation of AuditorAware based on Spring Security.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

	public static final String SYSTEM_ACCOUNT = "system";

	@Override
	public Optional<String> getCurrentAuditor() {
		String userName = SecurityUtils.getCurrentUserLogin();
		return Optional.of(userName != null ? userName : SYSTEM_ACCOUNT);
	}
}
