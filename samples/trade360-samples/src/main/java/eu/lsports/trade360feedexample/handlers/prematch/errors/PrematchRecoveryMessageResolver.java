package eu.lsports.trade360feedexample.handlers.prematch.errors;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;

import java.text.MessageFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrematchRecoveryMessageResolver implements MessageRecoverer {
    protected static final Logger logger = LogManager.getLogger();

    @Override
    public void recover(Message message, Throwable cause) {

        // Printout error message after policy retry fulfilment
        logger.error(MessageFormat.format("Unable to process message due to {0} message: {1}", cause.getMessage(), message));

        // Further message handling can be added here, e.g. send to DLQ
    }
}
