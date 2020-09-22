package org.model;

public class Asset {
    private Integer id;
    private Integer assetId;
    private String productId;
    private String typeId;
    private String name;
    private String model;
    private String unit;
    private Integer num;
    private Double price;
    private String datetime;
    private String state;
    private Integer fid;
    private String voucharNo;
    private String fdatetime;
    private String uname;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", assetId=" + assetId +
                ", productId='" + productId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", unit='" + unit + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", datetime='" + datetime + '\'' +
                ", state='" + state + '\'' +
                ", fid=" + fid +
                ", voucharNo='" + voucharNo + '\'' +
                ", fdatetime='" + fdatetime + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getVoucharNo() {
        return voucharNo;
    }

    public void setVoucharNo(String voucharNo) {
        this.voucharNo = voucharNo;
    }

    public String getFdatetime() {
        return fdatetime;
    }

    public void setFdatetime(String fdatetime) {
        this.fdatetime = fdatetime;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Asset(Integer id, Integer assetId, String productId, String typeId, String name, String model, String unit, Integer num, Double price, String datetime, String state, Integer fid, String voucharNo, String fdatetime, String uname) {
        this.id = id;
        this.assetId = assetId;
        this.productId = productId;
        this.typeId = typeId;
        this.name = name;
        this.model = model;
        this.unit = unit;
        this.num = num;
        this.price = price;
        this.datetime = datetime;
        this.state = state;
        this.fid = fid;
        this.voucharNo = voucharNo;
        this.fdatetime = fdatetime;
        this.uname = uname;
    }

    public Asset() {
    }
}
