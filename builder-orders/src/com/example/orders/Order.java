package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public class Order {
    private String id;
    private String customerEmail;
    private final List<OrderLine> lines = new ArrayList<>();
    private Integer discountPercent; // 0..100 expected, but not enforced
    private boolean expedited;
    private String notes;

    private Order(OrderBuilder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
        // Defensive copy and unmodifiable
        this.lines = Collections.unmodifiableList(new ArrayList<>(builder.lines));
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return lines; } // leaks internal list
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    // OrderBuilder pattern
    public static class OrderBuilder {
        private final String id;
        private String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public OrderBuilder(String id, OrderLine firstLine) {
            if (id == null || id.isEmpty()) throw new IllegalArgumentException("Order id required");
            if (firstLine == null) throw new IllegalArgumentException("Order must have at least one line");
            this.id = id;
            this.lines.add(firstLine);
        }

        public OrderBuilder withCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public OrderBuilder withLine(OrderLine line) {
            if (line == null) throw new IllegalArgumentException("OrderLine cannot be null");
            this.lines.add(line);
            return this;
        }

        public OrderBuilder withDiscountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public OrderBuilder withExpedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public OrderBuilder withNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            // Validate email
            if (customerEmail == null || !Pattern.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$", customerEmail)) {
                throw new IllegalArgumentException("Invalid email format");
            }
            // Validate discount
            if (discountPercent != null && (discountPercent < 0 || discountPercent > 100)) {
                throw new IllegalArgumentException("Discount percent must be 0..100");
            }
            // Validate lines
            if (lines.isEmpty()) {
                throw new IllegalArgumentException("Order must have at least one line");
            }
            return new Order(this);
        }
    }

}
