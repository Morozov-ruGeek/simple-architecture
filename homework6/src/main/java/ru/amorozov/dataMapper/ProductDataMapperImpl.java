package ru.amorozov.dataMapper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductDataMapperImpl implements ProductDataMapper {
    private final Connection connection;
    private List<ProductEntity> products;

    public ProductDataMapperImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ProductEntity> findAll() throws SQLException {
        products = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement("SELECT id, title, price  FROM products");
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                ProductEntity product = new ProductEntity(resultSet.getLong(1), resultSet.getString(2), resultSet.getBigDecimal(3));
                products.add(product);
            }
        }
        return Collections.unmodifiableList(products);
    }

    @Override
    public Optional<ProductEntity> findById(Long id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT id, title, price  FROM products WHERE id = ?");
        statement.setLong(1, id);
        ProductEntity product;
        try (ResultSet resultSet = statement.executeQuery()) {
            resultSet.next();
            if (resultSet != null) {
                product = new ProductEntity(resultSet.getLong(1), resultSet.getString(2), resultSet.getBigDecimal(3));
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public void insert(ProductEntity productEntity) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("INSERT INTO products (title, price) VALUES (?, ?)");
        statement.setString(1, "bread");
        statement.setBigDecimal(2, BigDecimal.valueOf(47.6));
    }

    @Override
    public void update(ProductEntity productEntity) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("UPDATE products SET title=?, price=? WHERE id=?");
        statement.setLong(3, 1);
        statement.setString(1, "bread");
        statement.setBigDecimal(2, BigDecimal.valueOf(47.6));
    }

    @Override
    public void delete(Long id) throws SQLException {
        this.connection.prepareStatement("DELETE FROM products WHERE id = ?");
    }
}
