package com.adm.usermicroservice.producers;

import com.adm.usermicroservice.dtos.EmailDto;
import com.adm.usermicroservice.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {
        var emailDto = new EmailDto(userModel.getUserId(),
                                    userModel.getEmail(),
                            "Cadastro realizado com sucesso!",
                                userModel.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!"
        );

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
