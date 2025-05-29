package com.jackwulanbatueurekaserver.inventoryservice.service;


import com.jackwulanbatueurekaserver.inventoryservice.exception.InsufficientStockException;
import com.jackwulanbatueurekaserver.inventoryservice.exception.InventoryNotFoundException;
import com.jackwulanbatueurekaserver.inventoryservice.model.Inventory;
import com.jackwulanbatueurekaserver.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;

@Service
public class InventoryServiceImp implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getInventoryByProductId(Long productId) {
        return inventoryRepository.findInventoriesById(productId).orElseThrow(()-> new InventoryNotFoundException("Product: " + productId + " is not exist"));
    }

    @Override
    public void increaseStock(Long productId, int quantity) {
        Inventory inventory = getInventoryByProductId(productId);
        inventory.setQuantity(inventory.getQuantity() + quantity);
        inventoryRepository.save(inventory);

    }

    @Override
    public void decreaseStock(Long productId, int quantity) {
        Inventory inventory = getInventoryByProductId(productId);
        if(inventory.getQuantity() < quantity){
            throw new InsufficientStockException("Insufficient inventory. Current inventory: " + inventory.getQuantity());
        }else {
            inventory.setQuantity(inventory.getQuantity() - quantity);
        }
        inventoryRepository.save(inventory);
    }

    @Override
    public boolean isStockAvailable(Long productId, int quantity) {

        Inventory inventory = getInventoryByProductId(productId);
        return inventory.getQuantity() >= quantity;
    }
}
