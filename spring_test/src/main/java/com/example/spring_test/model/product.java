package com.example.spring_test.model;
// import javax.persistence.*; // for Spring Boot 2
import jakarta.persistence.*; // for Spring Boot 3

@Entity
@Table(name = "product")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = false)
    private int id;
    @Column(name="pname")
    private String pname;
    @Column(name="price")
    private int price;
    @Column(name="stock")
    private int stock;

    public product(int id,String p_name, int price, int stock) {
        this.id= id;
        this.pname = p_name;
        this.price = price;
        this.stock = stock;
    }

    public product() {

    }

    public product(String id, String pName, int price, int stock) {
    }

    public int getId() {return id;}

    public String getP_name() {
        return pname;
    }

    public void setP_name(String p_name) {
        this.pname = p_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "product [id=" + id + ", pname=" + pname + ", price=" + price + ", stock=" + stock + "]";
    }
}
