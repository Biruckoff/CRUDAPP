/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediasoft;
/**
 *
 * @author Евгений
 */
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс репозитория для работы с сущностями Product в базе данных.
 */
public interface ProductRepository extends JpaRepository<Product, UUID> {

    /**
     * Проверяет наличие продукта в базе данных по его идентификатору.
     * @param id Идентификатор продукта.
     * @return true, если продукт существует, иначе false.
     */
    boolean existsById(UUID id);

    /**
     * Удаляет продукт из базы данных по его идентификатору.
     * @param id Идентификатор продукта.
     */
    void deleteById(UUID id);
    Optional<Product> findByArticle(String article);
    boolean existsByArticle(String article);
}