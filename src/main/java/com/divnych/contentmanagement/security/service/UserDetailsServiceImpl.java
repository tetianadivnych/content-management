package com.divnych.contentmanagement.security.service;

import com.divnych.contentmanagement.entity.User;
import com.divnych.contentmanagement.repository.UserRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username)
            .orElseThrow(() -> new UsernameNotFoundException(username + "user name not found"));
        return UserDetailsImpl.build(user);
    }
}
