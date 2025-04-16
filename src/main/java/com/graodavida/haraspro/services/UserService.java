package com.graodavida.haraspro.services;

import com.graodavida.haraspro.entities.User;
import com.graodavida.haraspro.repositories.UserRepository;
import com.graodavida.haraspro.request.UserCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    public UserCreateRequest createUser(UserCreateRequest user) {
        User userCreate = User.builder().email(user.getEmail()).password(user.getPassword()).name(user.getName()).phoneNumber(user.getPhoneNumber()).build();
        userCreate.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userCreate);
        return user;
    }
}
