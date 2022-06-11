package com.fastfood.fastfood;


import com.fastfood.fastfood.properties.OpenApiProperties;
import com.fastfood.fastfood.repositories.order.CartRepository;
import com.fastfood.fastfood.repositories.user.RedisUserRepository;
import com.fastfood.fastfood.repositories.user.VerificationCodeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Optional;

@SpringBootApplication
@EnableConfigurationProperties({
        OpenApiProperties.class,
        ServerProperties.class
})
public class FastFoodApplication {



    public static void main(String[] args) {
        SpringApplication.run(FastFoodApplication.class, args);
    }

    @Resource
    VerificationCodeRepository verificationCodeRepository;
    @Resource
    CartRepository cartRepository;
    @Resource
    RedisUserRepository redisUserRepository;

    @Bean
    CommandLineRunner runner(){
        return (args -> {
//            System.out.println("saving...");
//            VerificationCode verificationCode = VerificationCode.builder()
//                    .code("5555")
//                    .id("id")
//                    .createdAt(LocalDateTime.now())
//                    .expiredAt(LocalDateTime.now().plus(1, ChronoUnit.MINUTES))
//                    .phoneNumber("+998976990897")
//                    .build();
//
//            verificationCodeRepository.save(verificationCode);
//
//            Optional<VerificationCode> byId = verificationCodeRepository.findById(verificationCode.getId());
//            System.out.println(byId.isPresent());
//            System.out.println(byId.get());

//            Cart cart = Cart.builder()
//                    .userId("id")
//                    .orderItems(Collections.singleton(new OrderItem("14523kdjaksdja", 5)))
//                    .build();
//            cartRepository.save(cart);
//            Optional<Cart> byId = cartRepository.findById(cart.getId());
//            System.out.println(byId.isPresent());
//            System.out.println(byId.get());
//            RedisUser user = RedisUser.builder()
//                    .permissions(Collections.emptyList())
//                    .phoneNumber("+998976990897")
//                    .role(Role.CUSTOMER)
//                    .chosenLanguage("ru")
//                    .build();
//            redisUserRepository.save(user);
//
//            redisUserRepository.findById("user.getId()");


        });

    }


}
