package com.roderly.microbiomelabufu.login.controller;


import com.roderly.microbiomelabufu.infra.security.TokenService;
import com.roderly.microbiomelabufu.login.dto.AuthenticationDTO;
import com.roderly.microbiomelabufu.login.dto.LoginResponseDTO;
import com.roderly.microbiomelabufu.usuario.dto.request.UsuarioCompletoRequest;
import com.roderly.microbiomelabufu.usuario.model.Usuario;
import com.roderly.microbiomelabufu.usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.usuario(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));

    }



}
