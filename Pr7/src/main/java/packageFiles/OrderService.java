package packageFiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    public void checkout(Order order) {
        try {
            throw new PaymentGatewayException("timeout підключення");
        } catch (PaymentGatewayException e) {
            log.error("Log: id {}, email {}", order.id(), order.userEmail(), e);
            throw new OrderProcessingException("Не вдалося зробити замовлення ", e);
        }
    }
}
