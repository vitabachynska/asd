package packageFiles;

class PaymentGatewayException extends Exception {
    public PaymentGatewayException(String message) {
        super(message);
    }
}

class AppException extends RuntimeException {
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}

class OrderProcessingException extends AppException {
    public OrderProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}


