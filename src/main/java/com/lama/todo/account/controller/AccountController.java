package com.lama.todo.account.controller;

import com.lama.todo.account.model.LoginParam;
import com.lama.todo.account.model.LoginResponse;
import com.lama.todo.account.service.TodoUserDetailService;
import com.lama.todo.config.jwt.JwtTokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final TodoUserDetailService userService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginParam param) throws Exception {
        authenticate(param.getUserId(), param.getPassword());

        final UserDetails userDetails = userService.loadUserByUsername(param.getUserId());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
