package org.dao;

import org.model.MyAsset;

import java.util.List;

public interface MyAssetDao {
    List<MyAsset> getAsset(String account);
}
