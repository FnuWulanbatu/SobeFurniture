package com.jackwulanbatueurekaserver.inventoryservice.exception;


public class InventoryNotFoundException extends RuntimeException{
    public InventoryNotFoundException(String message){
        super(message);
    }
}
