package org.iesfm.shop.emails;

import org.iesfm.Email;
import org.springframework.jms.annotation.JmsListener;

public class EmailListener {

    @JmsListener(destination = "shopEmail")
    public void onMessege(Email email) {
        System.out.println("Enviando email " + email.toString());
    }
}
