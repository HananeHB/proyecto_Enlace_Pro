package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.application;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.db.jpa.entity.UserEntity;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.db.jpa.repository.UserEntityRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final MessageSource messageSource;

    //login: valida la contraseña y devuelve JWT si la contraseña es correcta
    public String login(String email, String rawPassword){
        UserEntity user=userEntityRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException(messageSource.getMessage("auth.user.notfound", null,Locale.getDefault()));
        }

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException(messageSource.getMessage("auth.password.incorrecta", null,Locale.getDefault()));
        }

        //generar JWT email y rol
        return JwtUtil.generarToken(user.getEmail(), user.getRole().name());
    }

}
