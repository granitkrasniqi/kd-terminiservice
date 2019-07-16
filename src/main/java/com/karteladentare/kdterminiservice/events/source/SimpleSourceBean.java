package com.karteladentare.kdterminiservice.events.source;

import com.karteladentare.kdterminiservice.domain.Termini;
import com.karteladentare.kdterminiservice.events.models.TerminiChangeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Granit Krasniqi
 * date: 7/16/2019
 * email: granitkrasniqi@outlook.com
 */
@Component
public class SimpleSourceBean {
    private Source source;

    private static final Logger logger =
            LoggerFactory.getLogger(SimpleSourceBean.class);

    @Autowired
    public SimpleSourceBean(Source source) {
        this.source = source;
    }

    public void publishTerminiChange(String action, String terminiId) {
        logger.debug("Sending Kafka message {} for Organization Id: {}",
                action, terminiId);
        TerminiChangeModel change = new TerminiChangeModel(
                TerminiChangeModel.class.getTypeName(),
                action,
                terminiId,
                "1"
//                UserContext.getCorrelationId()
        );

        source
                .output()
                .send(MessageBuilder
                        .withPayload(change)
                        .build());
    }
}
