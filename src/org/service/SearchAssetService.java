package org.service;

import org.model.Asset;

import java.util.List;

public interface SearchAssetService {
    List<Asset> getAsset(Integer id);
}
