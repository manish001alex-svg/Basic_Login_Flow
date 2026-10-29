package in.xen.perfect_match.service;

import in.xen.perfect_match.dto.RegisterUserRequestDto;
import in.xen.perfect_match.entity.User;
import in.xen.perfect_match.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(RegisterUserRequestDto requestDto){

        // 1. Create new User
        User user = new User();
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());

        // 2. Encode password
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        user.setPassword(encodedPassword);

        // 3. Save password
        userRepository.save(user);

        return user;
    }
}
