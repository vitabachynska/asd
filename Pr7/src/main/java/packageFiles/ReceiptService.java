package packageFiles;
import java.io.IOException;

class ReceiptService {
    public void generate(Order order) {
        try (ReceiptWriter writer = new ReceiptWriter()) {
            writer.writeReceipt(order);
        } catch (IOException e) {
            throw new ReceiptGenerationException("Failed to generate receipt", e);
        }
    }
}
