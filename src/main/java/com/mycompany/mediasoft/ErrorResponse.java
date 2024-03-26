/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediasoft;
/**
 *
 * @author Евгений
 */
import lombok.Data;



/**
 *
 * @author Евгений
 */
/**
 * Класс для представления объекта ошибки.
 */
@Data
public class ErrorResponse {
    
    /**
     * Сообщение об ошибке.
     */
    private String message;
    
    /**
     * HTTP статус ошибки.
     */
    private int status;
    
    /**
     * Конструктор класса ErrorResponse.
     * @param message Сообщение об ошибке.
     * @param status HTTP статус ошибки.
     */
    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
