package packageFiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private final List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(Objects.requireNonNull(item, "item"));
    }

    public Money total() {
        Money sum = Money.zero();
        for (OrderItem item : items) {
            sum = sum.add(item.total());
        }
        return sum;
    }
}

class OrderItem {
    private final String sku;
    private final Money price;
    private final int quantity;

    public OrderItem(String sku, Money price, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        this.sku = Objects.requireNonNull(sku, "sku");
        this.price = Objects.requireNonNull(price, "price");
        this.quantity = quantity;
    }

    public Money total() {
        return price.multiply(quantity);
    }
}
