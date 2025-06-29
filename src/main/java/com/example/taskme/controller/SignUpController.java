package com.example.taskme.controller;

import com.example.taskme.dto.request.usuario.UsuarioRequest;
import com.example.taskme.dto.response.GeneralResponse;
import com.example.taskme.dto.response.usuario.UsuarioResponse;
import com.example.taskme.service.UsuarioService;
import com.example.taskme.utils.ResponseBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taskme/api/registro")
public class SignUpController {

    private final UsuarioService usuarioService;

    @Autowired
    public SignUpController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //REGISTRO
    @PostMapping()
    public ResponseEntity<GeneralResponse> createUsuario(
            @Valid @RequestBody UsuarioRequest req
    ) {
        UsuarioResponse response = usuarioService.createUsuario(req);

        return ResponseBuilder.buildResponse(
                "Usuario registrado exitosamente.",
                HttpStatus.CREATED,
                response
        );
    }
}
