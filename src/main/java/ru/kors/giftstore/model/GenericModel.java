package ru.kors.giftstore.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass // Не даст создать таблицу GenericModel
public abstract class GenericModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
    private Long id;  // ID генерируется в виде последовательных чисел

    @Column(name = "created_when")
    private LocalDateTime createdWhen;  // Дата и время создания записи

    @Column(name = "created_by")
    private String createdBy;  // Пользователь, создавший запись

    @Column(name = "updated_when")
    private LocalDateTime updatedWhen;  // Дата и время последнего обновления

    @Column(name = "updated_by")
    private String updatedBy;  // Пользователь, обновивший запись

    @Column(name = "deleted_when")
    private LocalDateTime deletedWhen;  // Дата и время удаления

    @Column(name = "deleted_by")
    private String deletedBy;  // Пользователь, удаливший запись

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;  // Флаг мягкого удаления
}
