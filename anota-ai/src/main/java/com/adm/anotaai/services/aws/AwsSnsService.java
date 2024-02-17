package com.adm.anotaai.services.aws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AwsSnsService {

    @Autowired
    AmazonSNS amazonSNS;

    @Qualifier("catalogEventsTopic")
    @Autowired
    Topic topic;

    public void publish(MessageDTO messageDTO) {
        this.amazonSNS.publish(topic.getTopicArn(), messageDTO.toString());
    }
}
