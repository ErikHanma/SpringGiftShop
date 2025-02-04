package ru.kors.giftstore.service;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.kors.giftstore.dto.GenericDTO;
import ru.kors.giftstore.exception.MyDeleteException;
import ru.kors.giftstore.mapper.GenericMapper;
import ru.kors.giftstore.model.GenericModel;
import ru.kors.giftstore.repository.GenericRepository;
import ru.kors.giftstore.service.userdetails.CustomUserDetails;

public abstract class GenericTest<E extends GenericModel, D extends GenericDTO> {

    protected GenericService<E, D> service;
    protected GenericRepository<E> repository;
    protected GenericMapper<E, D> mapper;

    @BeforeEach
    void init() {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                CustomUserDetails.builder()
                        .username("MANAGER"), // Изменено на MANAGER
                null,
                null
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    protected abstract void getAll();

    protected abstract void getOne();

    protected abstract void create();

    protected abstract void update();

    protected abstract void delete() throws MyDeleteException;

    protected abstract void restore();

    protected abstract void getAllNotDeleted();
}