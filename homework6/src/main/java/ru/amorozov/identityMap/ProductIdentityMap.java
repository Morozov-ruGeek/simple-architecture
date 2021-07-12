package ru.amorozov.identityMap;

import ru.amorozov.dataMapper.ProductDataMapperImpl;
import ru.amorozov.dataMapper.ProductEntity;

import java.sql.SQLException;
import java.util.*;

public class ProductIdentityMap {
    private final ProductDataMapperImpl productIdentityMap;
    private ProductEntity productEntity;
    private Map<Long, Optional<ProductEntity>> productsMap;

    public ProductIdentityMap(ProductDataMapperImpl productIdentityMap) {
        this.productIdentityMap = productIdentityMap;
    }

    public Optional<ProductEntity> findById(Long id) throws SQLException {
        if (productsMap.get(id) == null) {
            return Optional.empty();
        }
        return productsMap.get(id);
    }

    public void addProductsInMap(ProductEntity productEntity) {
        productsMap = new HashMap<>();
        try {
            productsMap.put(productEntity.getId(), productIdentityMap.findById(productEntity.getId()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
