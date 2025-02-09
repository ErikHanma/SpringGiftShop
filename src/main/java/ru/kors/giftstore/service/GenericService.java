package ru.kors.giftstore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.kors.giftstore.dto.GenericDTO;
import ru.kors.giftstore.exception.MyDeleteException;
import ru.kors.giftstore.mapper.GenericMapper;
import ru.kors.giftstore.model.GenericModel;
import ru.kors.giftstore.repository.GenericRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Абстрактный сервис который хранит в себе реализацию CRUD операций по умолчанию
 * Если реализация отличная от того что представлено в этом классе,
 * то она переопределяется в сервисе для конкретной сущности
 *
 * @param <E> - Сущность с которой мы работаем
 * @param <D> - DTO, которую мы будем отдавать/принимать дальше
 */
@Service
public abstract class GenericService<E extends GenericModel, D extends GenericDTO> {

    protected final GenericRepository<E> repository;
    protected final GenericMapper<E, D> mapper;

    public GenericService(GenericRepository<E> repository, GenericMapper<E, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<D> listAll() {
        return mapper.toDTOs(repository.findAll());
    }

    public Page<D> listAll(Pageable pageable) {
        Page<E> objects = repository.findAll(pageable);
        List<D> result = mapper.toDTOs(objects.getContent());
        return new PageImpl<>(result, pageable, objects.getTotalElements());
    }

    public Page<D> listAllNotDeleted(Pageable pageable) {
        Page<E> preResult = repository.findAllByIsDeletedFalse(pageable);
        List<D> result = mapper.toDTOs(preResult.getContent());
        return new PageImpl<>(result, pageable, preResult.getTotalElements());
    }

    public List<D> listAllNotDeleted() {
        return mapper.toDTOs(repository.findAllByIsDeletedFalse());
    }

    public D getOne(final Long id) {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Данные по заданному id:" + id + " не найдено!")));
    }

    public D create(D newObject) {
        newObject.setCreatedWhen(LocalDateTime.now());
        return mapper.toDTO(repository.save(mapper.toEntity(newObject)));
    }

    public D update(D updatedObject) {
        return mapper.toDTO(repository.save(mapper.toEntity(updatedObject)));
    }


    public void delete(final Long id) {
        repository.deleteById(id);
    }

    public void deleteSoft(final Long id) throws MyDeleteException {
        E obj = repository.findById(id).orElseThrow(() -> new NotFoundException("Данный объект не найден"));
        markAsDeleted(obj);
        repository.save(obj);
    }

    public void restore (final Long id) {
        E obj = repository.findById(id).orElseThrow(() -> new NotFoundException("Данный объект не найден"));
        unmarkAsDeleted(obj);
        repository.save(obj);
    }

    public void markAsDeleted(GenericModel genericModel) {
        genericModel.setDeleted(true);
        genericModel.setDeletedWhen(LocalDateTime.now());
        genericModel.setDeletedBy(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public void unmarkAsDeleted(GenericModel genericModel) {
        genericModel.setDeleted(false);
        genericModel.setDeletedWhen(null);
        genericModel.setDeletedBy(null);
    }
}
