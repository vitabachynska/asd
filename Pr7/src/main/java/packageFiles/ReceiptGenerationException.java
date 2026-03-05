package packageFiles;
import java.io.IOException;

class ReceiptGenerationException extends RuntimeException {
    public ReceiptGenerationException(String message, Throwable cause) { super(message, cause); }
}

class ReceiptWriter implements AutoCloseable {
    public void writeReceipt(Order order) throws IOException {
        System.out.println("Writing receipt for order #" + order.id());
    }

    @Override
    public void close() {
        System.out.println("ReceiptWriter closed");
    }
}


