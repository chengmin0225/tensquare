package com.tensquare.comment;

import com.tensquare.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author 程民
 * @date 2018/10/17
 */
@SpringBootApplication
public class CommentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }
}
