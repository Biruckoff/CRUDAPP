/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediasoft;
/**
 *
 * @author Евгений
 */
import javax.persistence.*;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;
/**
 * Класс представляет сущность "Продукт" для хранения информации о продуктах в базе данных.
 */
@Entity
@Data
@Table(name = "product")
public class Product {

    /**
     * Уникальный идентификатор продукта.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * Артикул продукта (уникальное значение).
     */
    @Column(unique = true)
    @NotNull(message = "Article cannot be null")
    private String article;

    /**
     * Наименование продукта.
     */
    @NotNull(message = "Name cannot be null")
    private String name;

    /**
     * Описание продукта.
     */
    private String description;

    /**
     * Категория продукта.
     */
    @NotNull(message = "Category cannot be null")
    private String category;

    /**
     * Цена продукта.
     */
    @NotNull(message = "Price cannot be null")
    private double price;

    /**
     * Количество продукта.
     */
    @NotNull(message = "Quantity cannot be null")
    private int quantity;
    
    /**
     * Дата и время последнего изменения количества товара.
     */
    @Column(name = "last_quantity_change_timestamp")
    private LocalDateTime lastQuantityChangeTimestamp;

    /**
     * Дата и время создания товара.
     */
    @Column(name = "creation_timestamp")
    private LocalDateTime creationTimestamp;

}