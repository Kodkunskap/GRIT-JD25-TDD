package se.apiva;

public interface InventoryService {
    public Boolean checkAvailability(long productId, int quantity);
}
