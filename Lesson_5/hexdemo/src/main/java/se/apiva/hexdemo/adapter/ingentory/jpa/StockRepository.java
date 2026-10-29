package se.apiva.hexdemo.adapter.ingentory.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity, String> {

}
