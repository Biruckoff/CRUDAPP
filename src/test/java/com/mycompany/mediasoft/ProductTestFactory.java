/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediasoft;

import java.util.UUID;

/**
 *
 * @author Евгений
 */

public class ProductTestFactory {

    public static Product createProduct(String Article) {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setArticle(Article);
        product.setName("Example Product"+product.getId());
        product.setDescription("This is an example product" +product.getId());
        product.setCategory("Electronics");
        product.setPrice(99.99);
        product.setQuantity(10);
        return product;
    }
}