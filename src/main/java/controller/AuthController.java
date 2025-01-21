package controller;

import com.example.forohub.dto.UsernamePasswordDTO;
import com.example.forohub.service.TokenService;
import com.example.forohub.model.User;
import com.example.forohub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UsernamePasswordDTO loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(401).body("Usuario no encontrado o contraseña incorrecta");
        }
        String token = tokenService.generateToken(user.getUsername());
        return ResponseEntity.ok("Bearer " + token);
    }
}