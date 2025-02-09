package ru.kors.giftstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kors.giftstore.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByTitle(String title);
}
