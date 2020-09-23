package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class order_service
{
    public static void main( String[] args )
    {
        SpringApplication.run(order_service.class, args);
        System.out.println( "This is Orders microservice!" );
    }
}
