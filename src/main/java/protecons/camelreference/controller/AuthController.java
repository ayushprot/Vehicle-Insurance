package protecons.camelreference.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import protecons.camelreference.constants.Role;
import protecons.camelreference.dto.RegisterRequest;
import protecons.camelreference.dto.auth.LoginRequest;
import protecons.camelreference.dto.auth.LoginResponse;
import protecons.camelreference.entity.User;
import protecons.camelreference.repository.UserRepository;
import protecons.camelreference.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthController(
            PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
            UserRepository userRepository,
            JwtService jwtService) {
        this.passwordEncoder = passwordEncoder;

        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow();

        String token = jwtService.generateToken(user);

        return new LoginResponse(token,"Bearer", 3600, user.getUserId(), user.getRole());
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        User user = new User();

        user.setUserId(request.getUserId());
        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole(Role.CUSTOMER);

        userRepository.save(user);

        return "User registered successfully";
    }

    @GetMapping("/loginDetails/{email}")
    public String getUserDetails(@PathVariable("email") String email){
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return "User not exists";
        }
        return Base64.getDecoder().decode(user.get().getPassword()).toString();
    }
}
