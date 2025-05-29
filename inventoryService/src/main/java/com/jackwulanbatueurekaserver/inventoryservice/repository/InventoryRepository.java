package com.jackwulanbatueurekaserver.inventoryservice.repository;

import com.jackwulanbatueurekaserver.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findInventoriesById(Long productId);
    boolean existsInventoryById(Long productId);
}
