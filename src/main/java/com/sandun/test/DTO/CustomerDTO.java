package com.sandun.test.DTO;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private int cid;
    private String name;
    private String address;
    private String tele;

    public CustomerDTO() {
    }

    public CustomerDTO(int cid, String name, String address, String tele) {
        this.setCid(cid);
        this.setName(name);
        this.setAddress(address);
        this.setTele(tele);
    }


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }
}
