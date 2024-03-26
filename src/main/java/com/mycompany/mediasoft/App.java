package com.mycompany.mediasoft;
/**
 *
 * @author Евгений
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс приложения, запускающий Spring Boot приложение.
 */
@SpringBootApplication
public class App 
{
    /**
     * Точка входа в приложение.
     * @param args Аргументы командной строки.
     */
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
