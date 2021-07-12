package ru.amorozov.patterns.behavioral.visitor;

public interface ItemElements {
    public int accept(ShoppingCartVisitor visitor);
}
