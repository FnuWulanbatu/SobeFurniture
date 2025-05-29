package com.jackwulanbatueurekaserver.inventoryservice.service;

import com.jackwulanbatueurekaserver.inventoryservice.model.Inventory;

public interface InventoryService {
    Inventory createInventory(Inventory inventory);
    Inventory getInventoryByProductId(Long productId);
    void increaseStock(Long productId, int quantity);
    void decreaseStock(Long productId, int quantity);
    boolean isStockAvailable(Long productId, int quantity);
}
