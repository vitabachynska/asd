package packageFiles;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CheckoutRequest {
    private int id;
    private String productName;
    private int quantity;
}
