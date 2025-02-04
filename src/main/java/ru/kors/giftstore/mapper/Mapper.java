package ru.kors.giftstore.mapper;

import ru.kors.giftstore.dto.GenericDTO;
import ru.kors.giftstore.model.GenericModel;

import java.util.List;

public interface Mapper<E extends GenericModel, D extends GenericDTO> {

    E toEntity(D dto); // метод, преобразующий из DTO в сущность

    D toDTO(E entity); // метод, преобразующий из сущности в DTO

    List<E> toEntities(List<D> dtos);

    List<D> toDTOs(List<E> entities);
}
