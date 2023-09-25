package com.kata.marketplace.model;

public class Product {
    private String productId;
    private int quantity;
    private double unitaryPrice;
    private boolean isDiscounted;

    public Product() {

    }

    public Product(String productId, int quantity, double unitaryPrice, boolean isDiscounted) {
        this.productId=productId;
        this.quantity=quantity;
        this.unitaryPrice=unitaryPrice;
        this.isDiscounted=isDiscounted;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (quantity != product.quantity) return false;
        if (Double.compare(product.unitaryPrice, unitaryPrice) != 0) return false;
        if (isDiscounted != product.isDiscounted) return false;
        return productId != null ? productId.equals(product.productId) : product.productId == null;
    }
}
