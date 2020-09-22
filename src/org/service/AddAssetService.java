package org.service;

public interface AddAssetService {
    boolean doAdd(String productId, String name, String model, String unit, Integer num, Double price, String datetime);
}
