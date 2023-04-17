package com.app.foodverse.config;

import com.app.foodverse.dao.UserRepository;
import com.app.foodverse.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository persistent = new UserRepository();

    public UserDetailsServiceImpl() {
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            User user = persistent.getUserByEmail(email);
            if (user != null) {
                return new CustomUserDetails(user);
            }
            throw new UsernameNotFoundException("User not found!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
