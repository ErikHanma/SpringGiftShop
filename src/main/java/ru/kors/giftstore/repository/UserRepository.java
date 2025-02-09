package ru.kors.giftstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kors.giftstore.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    Optional<User> findUserByLogin(String login);

    User findUserByChangePasswordToken(String uuid);

    List<String> getDelayedEmails();

    Optional<User> findByEmail(String email);
}
