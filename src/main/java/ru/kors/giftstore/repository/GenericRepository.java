package ru.kors.giftstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.kors.giftstore.model.GenericModel;

import java.util.List;

/**
 * Абстрактный репозиторий
 * Необходим для работы абстрактного сервиса
 * т.к. в абстрактном сервисе мы не можем использовать конкретный репозиторий,
 * а должны указывать параметризованный (GenericRepository)
 * @param <T> - Сущность, с которой работает репозиторий
 */

@NoRepositoryBean // не даст создать репозиторий, т.к. он абстрактный. Аналог @MappedSuperclass у GenericModel
public interface GenericRepository <T extends GenericModel> extends JpaRepository<T, Long> { // Ограничиваем работу
    // только с моделями, которые наследуются от GenericModel

    Page<T> findAllByIsDeletedFalse(Pageable pageable);
    List<T> findAllByIsDeletedFalse();



}
