package org.model;

public class Finance {
    private Integer id;
    private String voucherNo;
    private String datetime;
    private String name;

    @Override
    public String toString() {
        return "Finance{" +
                "id=" + id +
                ", voucherNo='" + voucherNo + '\'' +
                ", datetime='" + datetime + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Finance(Integer id, String voucherNo, String datetime, String name) {
        this.id = id;
        this.voucherNo = voucherNo;
        this.datetime = datetime;
        this.name = name;
    }

    public Finance() {
    }
}
