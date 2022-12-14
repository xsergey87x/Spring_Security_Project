package com.cursor.cursor.restController;


import com.cursor.cursor.security.AuthenticationRequest;
import com.cursor.cursor.security.JwtTokenUtil;
import com.cursor.cursor.security.JwtUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request)
    {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        UserDetails user = jwtUserDetailsService.loadUserByUsername(request.getEmail());
        if (user != null)
        {
            return ResponseEntity.ok(jwtTokenUtil.generateToken(user));
        }
        return ResponseEntity.status(400).body("Something bad happened");
    }

}
