package org.dao;

import org.model.Asset;

import java.util.List;

public interface SearchAssetDao {
    List<Asset> getAsset(Integer id);
}
