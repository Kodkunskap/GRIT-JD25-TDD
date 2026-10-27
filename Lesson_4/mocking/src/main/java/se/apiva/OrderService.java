package se.apiva;

public class OrderService {

    private InventoryService inventoryService;
    private OrderRepository orderRepository;

    public OrderService(InventoryService inventoryService, OrderRepository orderRepository) {
        this.inventoryService = inventoryService;
        this.orderRepository = orderRepository;
    }

    public OrderService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Boolean placeOrder(long productId, int quantity) {
        return inventoryService.checkAvailability(productId, quantity);
    }

    public Boolean saveOrder(long orderId, long productId, int quantity) {
        return orderRepository.saveOrder(new Order(orderId, productId, quantity));
    }

}
