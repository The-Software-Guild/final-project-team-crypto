package com.mthree.cryptoinvesting.data;

import com.mthree.cryptoinvesting.model.Orders;

import java.util.List;

public interface OrderDao {

    /**
     * Adds an order to the databse.
     * @param order The order to be added to the table.
     * @return The order that was added.
     */
    Orders addOrder(Orders order);

    /**
     * Returns an order by its specidied id.
     * @param orderId The id of the unique order.
     * @return The order that was returned.
     */
    Orders getOrderById(int orderId);

    /**
     * Returns all orders associated with a specific portfolio.
     * @param portfolioId The portfolio to return the orders of.
     * @return The list of all orders by a specific id.
     */
    List<Orders> getAllOrdersByPortfolioId(int portfolioId);

    /**
     * Returns a list of all orders that exist in the table.
     * @return A list of all orders in the orders table.
     */
    List<Orders> getAllOrders();

}
