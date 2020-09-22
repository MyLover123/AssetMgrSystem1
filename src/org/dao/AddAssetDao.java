package org.dao;

public interface AddAssetDao {
    boolean doAdd(String productId, String name, String model, String unit, Integer num, Double price, String datetime);
}
