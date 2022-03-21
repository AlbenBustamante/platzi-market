package com.alnicode.platzi.market.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final List<User> users = new ArrayList<>();

    public UserDetailsServiceImpl() {
        users.add(new User("guillermo", "{noop}xbytarifax", new ArrayList<>()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = users.stream().filter(user1 ->
                user1.getUsername().equals(username)).findAny();

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User by name: " + username + " not found!");
        }

        return user.get();
    }
}
