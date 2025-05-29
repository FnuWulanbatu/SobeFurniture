package com.jackwulanbatueurekaserver.inventoryservice.Controller;


import com.jackwulanbatueurekaserver.inventoryservice.model.Inventory;
import com.jackwulanbatueurekaserver.inventoryservice.repository.InventoryRepository;
import com.jackwulanbatueurekaserver.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryService inventoryService;


    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> getInventory(@PathVariable Long productId){
        return ResponseEntity.ok(inventoryService.getInventoryByProductId(productId));
    }

    @GetMapping("/{productId}/available")
    public ResponseEntity<Boolean> isAvailable(@PathVariable Long productId, @RequestParam("quantity")int quantity){
        return ResponseEntity.ok(inventoryService.isStockAvailable(productId,quantity));
    }

    @PostMapping
    public ResponseEntity<Inventory> create(@RequestBody Inventory inventory){
        return ResponseEntity.ok(inventoryService.createInventory(inventory));
    }

    @PutMapping("/{productId}/increase")
    public ResponseEntity<Void> increase(@PathVariable Long productId, @RequestParam("quantity")int quantity){
        inventoryService.increaseStock(productId, quantity);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{productId}/decrease")
    public ResponseEntity<Void> decrease(@PathVariable Long productId, @RequestParam("quantity") int quantity) {
        inventoryService.decreaseStock(productId, quantity);
        return ResponseEntity.ok().build();
    }


}
