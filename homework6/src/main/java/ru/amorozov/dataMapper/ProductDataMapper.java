package ru.amorozov.dataMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProductDataMapper {
    List<ProductEntity> findAll() throws SQLException;

    Optional<ProductEntity> findById(Long id) throws SQLException;

    void insert(ProductEntity productEntity) throws SQLException;

    void update(ProductEntity productEntity) throws SQLException;

    void delete(Long id) throws SQLException;
}
