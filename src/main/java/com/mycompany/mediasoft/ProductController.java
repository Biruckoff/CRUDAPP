/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediasoft;
/**
 *
 * @author Евгений
 */
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Контроллер, обрабатывающий запросы, связанные с продуктами.
 */
@Controller
@RequestMapping("/products")
@Api(tags = "Product Controller")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Получить все продукты и отобразить на странице "products".
     * @param model Модель для передачи атрибутов на страницу.
     * @return Название представления для отображения.
     */
    @ApiOperation(value = "Get all products")
    @GetMapping("/")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    /**
     * Получить продукт по его идентификатору и отобразить на странице "product".
     * @param id Идентификатор продукта.
     * @param model Модель для передачи атрибутов на страницу.
     * @return Название представления для отображения.
     */
    @ApiOperation(value = "Get product by ID")
    @GetMapping("/id")
    public String getProductById(@RequestParam UUID id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    /**
     * Сохранить или обновить информацию о продукте.
     * @param product Объект продукта.
     * @param result Результаты валидации.
     * @return Перенаправление на страницу со всеми продуктами или страницу с сообщением об ошибке.
     */
    @ApiOperation(value = "Save or update product")
    @PostMapping("/")
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "errorPage";
        }
        
        if(productService.existsByArticle(product.getArticle())){
        if(product.getQuantity()!=productService.findProductByArticle(product.getArticle()).getQuantity()){
        product.setLastQuantityChangeTimestamp(LocalDateTime.now());
        product.setCreationTimestamp(productService.findProductByArticle(product.getArticle()).getCreationTimestamp());
        }else{
        product.setCreationTimestamp(productService.findProductByArticle(product.getArticle()).getCreationTimestamp());
        product.setLastQuantityChangeTimestamp(productService.findProductByArticle(product.getArticle()).getLastQuantityChangeTimestamp());
        }
        }else{
        product.setCreationTimestamp(LocalDateTime.now());
        product.setLastQuantityChangeTimestamp(LocalDateTime.now());
        }
        productService.saveOrUpdateProduct(product);
        return "redirect:/products/";
    }

    /**
     * Показать форму для создания нового продукта.
     * @param model Модель для передачи атрибутов на страницу.
     * @return Название представления для отображения.
     */
    @ApiOperation(value = "Show form for new product")
    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    /**
     * Показать форму для редактирования продукта по его идентификатору.
     * @param id Идентификатор продукта.
     * @param model Модель для передачи атрибутов на страницу.
     * @return Название представления для отображения.
     */
    @ApiOperation(value = "Show form for editing product")
    @GetMapping("/edit")
    public String editProduct(@RequestParam UUID id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-form";
    }

    /**
     * Удалить продукт по его идентификатору.
     * @param id Идентификатор продукта.
     * @return Перенаправление на страницу со всеми продуктами или сообщение об ошибке.
     */
    @ApiOperation(value = "Delete product by ID")
    @DeleteMapping("/delete")
    public String deleteProduct(@RequestParam UUID id) {
        if (productService.existsById(id)) {
            productService.deleteProduct(id);
            return "redirect:/products/";
        } else {
            return "Product with ID " + id + " does not exist";
        }
    }
}
