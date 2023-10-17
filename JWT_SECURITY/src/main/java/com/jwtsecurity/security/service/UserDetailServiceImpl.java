package com.jwtsecurity.security.service;

import com.jwtsecurity.entity.Role;
import com.jwtsecurity.entity.User;
import com.jwtsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            Optional<User> user = userRepository.findByEmail(email);
            List<Role> roles = userRepository.findRolesByEmail(email);
            if (user == null) throw new UsernameNotFoundException("User name not found");
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            roles.stream().forEach(i -> authorities.add(new SimpleGrantedAuthority(i.getName())));
            return new org.springframework.security.core.userdetails
                    .User(user.get().getEmail(), user.get().getPassword(),authorities);
    }
}
