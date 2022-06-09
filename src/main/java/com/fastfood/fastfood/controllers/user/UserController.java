package com.fastfood.fastfood.controllers.user;


import com.fastfood.fastfood.controllers.AbstractController;
import com.fastfood.fastfood.services.user.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends AbstractController<UserService> {
    public UserController(UserService service) {
        super(service);
    }
}
