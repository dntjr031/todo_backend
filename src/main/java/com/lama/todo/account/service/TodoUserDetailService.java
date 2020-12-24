package com.lama.todo.account.service;

import com.lama.todo.account.entity.TodoUser;
import com.lama.todo.account.repository.TodoUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoUserDetailService implements UserDetailsService {

    private final TodoUserRepo todoUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        TodoUser user = todoUserRepo.findByUserId(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with userId: " + username);
        }
        return user;
    }

}
