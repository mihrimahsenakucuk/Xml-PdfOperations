package com.example.xml.Controller;

import com.example.xml.Service.JwtService;
import com.example.xml.dto.AuthRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;

    private JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/generateToken")
    @ResponseBody
    public String generateToken(@RequestBody AuthRequest request){
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.userName(), request.password()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(request.userName());
        }
        throw new UsernameNotFoundException("invalid username {} " + request.userName());
    }

}
