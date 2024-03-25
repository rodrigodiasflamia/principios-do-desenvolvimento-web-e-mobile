package br.com.estoque;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.estoque.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository userRepository;

	public UserDetailsServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		return this.userRepository.findByUsername(username)
				.map(user -> new UserAuthenticated(user))
				.orElseThrow(() -> 
					new UsernameNotFoundException("Usuário inválido: " + username)
				);
	}
}