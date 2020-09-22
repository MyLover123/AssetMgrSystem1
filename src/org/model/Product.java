package org.model;

public class Product {
    private Integer id;
    private String productId;
    private String name;
    private String model;
    private String unit;
    private Integer num;
    private Double price;
    private String datetime;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", unit='" + unit + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", datetime='" + datetime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Product(Integer id, String productId, String name, String model, String unit, Integer num, Double price, String datetime) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.model = model;
        this.unit = unit;
        this.num = num;
        this.price = price;
        this.datetime = datetime;
    }

    public Product() {
    }
}
