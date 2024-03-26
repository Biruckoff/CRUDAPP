/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediasoft;
/**
 *
 * @author Евгений
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;



/**
 * Глобальный обработчик исключений для перехвата и обработки исключений во всем приложении.
 */

public class GlobalExceptionHandler {
    
    /**
     * Обрабатывает исключения типа Exception.
     * @param ex Исключение, которое произошло.
     * @return Ответ с сообщением об ошибке и HTTP статусом 500 (Internal Server Error).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse error = new ErrorResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}