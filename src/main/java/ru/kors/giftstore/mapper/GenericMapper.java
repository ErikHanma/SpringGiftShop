package ru.kors.giftstore.mapper;

import ru.kors.giftstore.dto.GenericDTO;
import ru.kors.giftstore.model.GenericModel;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;

/**
 * Абстрактный маппер для конвертации между сущностями и DTO.
 * Реализует основные операции преобразования данных.
 *
 * @param <E> - Сущность (например, Product, Category)
 * @param <D> - DTO (например, ProductDTO, CategoryDTO)
 */
@Component
public abstract class GenericMapper<E extends GenericModel, D extends GenericDTO>
        implements Mapper<E, D> {

    private final Class<E> entityClass;
    private final Class<D> dtoClass;
    protected final ModelMapper modelMapper;

    public GenericMapper(Class<E> entityClass,
                         Class<D> dtoClass,
                         ModelMapper modelMapper) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.modelMapper = modelMapper;
    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto)
                ? null
                : modelMapper.map(dto, entityClass);
    }

    @Override
    public D toDTO(E entity) {
        return Objects.isNull(entity)
                ? null
                : modelMapper.map(entity, dtoClass);
    }

    @Override
    public List<E> toEntities(List<D> dtos) {
        return dtos.stream().map(this::toEntity).toList();
    }

    @Override
    public List<D> toDTOs(List<E> entities) {
        return entities.stream().map(this::toDTO).toList();
    }

    /**
     * Конвертер для преобразования DTO в сущность с учетом специфичных полей.
     */
    protected Converter<D, E> toEntityConverter() {
        return context -> {
            D source = context.getSource();
            E destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    /**
     * Конвертер для преобразования сущности в DTO с учетом специфичных полей.
     */
    protected Converter<E, D> toDTOConverter() {
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    /**
     * Маппинг специфичных полей при преобразовании DTO в сущность.
     */
    protected abstract void mapSpecificFields(D source, E destination);

    /**
     * Маппинг специфичных полей при преобразовании сущности в DTO.
     */
    protected abstract void mapSpecificFields(E source, D destination);

    /**
     * Настройка маппера после инициализации.
     */
    @PostConstruct
    protected abstract void setupMapper();

    /**
     * Получение списка ID для связанных сущностей.
     */
    protected abstract List<Long> getIds(E entity);
}