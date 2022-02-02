package org.iesfm.shop.api.controller;

import org.iesfm.Email;
import org.iesfm.User;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private JmsTemplate jmsTemplate;

    public UserController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users")
    public void insertUser(@RequestBody User user) {
        System.out.println("Registrando usuario" + user.getUsername());
        Email email = new Email(
                user.getEmailUser(),
                "Bienvenido " + user.getUsername(),
                " Gracias por registrate " + user.getUsername()

        );

        jmsTemplate.convertAndSend("shopEmail", email);
    }
}
