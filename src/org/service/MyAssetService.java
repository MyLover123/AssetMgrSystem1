package org.service;

import org.model.MyAsset;

import java.util.List;

public interface MyAssetService {
    List<MyAsset> getAsset(String account);
}
