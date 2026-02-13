package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.web.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.application.AuthService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.web.dto.LoginRequest;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.web.dto.LoginResponse;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        String tocken=authService.login(request.email(), request.password());
        return new LoginResponse(tocken);
    }
}
