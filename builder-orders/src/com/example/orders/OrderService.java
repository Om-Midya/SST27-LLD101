package com.example.orders;

import java.util.List;

public class OrderService {

    public Order createOrder(String id, String email, List<OrderLine> lines, Integer discount, boolean expedited, String notes) {
        if (lines == null || lines.isEmpty()) throw new IllegalArgumentException("Order must have at least one line");
        Order.OrderBuilder builder = new Order.OrderBuilder(id, lines.get(0))
                .withCustomerEmail(email);
        for (int i = 1; i < lines.size(); i++) builder.withLine(lines.get(i));
        if (discount != null) builder.withDiscountPercent(discount);
        builder.withExpedited(expedited);
        if (notes != null) builder.withNotes(notes);
        return builder.build();
    }
}
