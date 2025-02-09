package ru.kors.giftstore.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kors.giftstore.dto.UserDTO;
import ru.kors.giftstore.mapper.GenericMapper;
import ru.kors.giftstore.model.Role;
import ru.kors.giftstore.model.User;
import ru.kors.giftstore.repository.GenericRepository;
import ru.kors.giftstore.repository.RoleRepository;
import ru.kors.giftstore.repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class UserService extends GenericService<User, UserDTO> {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(GenericRepository<User> repository, GenericMapper<User, UserDTO> mapper, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        super(repository, mapper);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDTO create(UserDTO newObject) {
        User user = mapper.toEntity(newObject);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCreatedBy("REGISTRATION FORM");
        user.setCreatedWhen(LocalDateTime.now());

        // Set default role (e.g., "USER")
        Role defaultRole = roleRepository.findByTitle("USER").orElseGet(() -> {
            Role newRole = new Role();
            newRole.setTitle("USER");
            return roleRepository.save(newRole);
        });
        user.setRole(defaultRole);

        return mapper.toDTO(repository.save(user));
    }

    public UserDTO getUserByLogin(final String login) {
        return mapper.toDTO(userRepository.findUserByLogin(login));
    }

    public UserDTO getUserByEmail(final String email) {
        return mapper.toDTO(userRepository.findByEmail(email).orElse(null));
    }
}
