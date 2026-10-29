package se.apiva.hexdemo.adapter.ingentory.jpa;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.apiva.hexdemo.domain.model.ProductId;
import se.apiva.hexdemo.domain.port.Inventory;

@Component
public class JpaInventory implements Inventory {
    private final StockRepository repo;
    public JpaInventory(StockRepository repo) { this.repo = repo; }

    @Override
    @Transactional
    public boolean reserve(ProductId productId, int qty) {
        return repo.findById(productId.value()).map(entity -> {
            if (entity.getQuantity() < qty) return false;
            entity.setQuantity(entity.getQuantity() - qty);
            // dirty checking flushes at tx end
            return true;
        }).orElse(false);
    }
}
