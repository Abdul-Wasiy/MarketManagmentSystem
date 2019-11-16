package hu.cs.se.model;
import org.hibernate.dialect.MyISAMStorageEngine;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Good {
    @Column(name = "goods_id")
    private Long id;
    private String name;
    private String category;
    private Integer quantity;
    private Float price;
    private String regDate;
    private String expireDate;
    private MyCategory myCategory;
    private Set<Customer> customers;

    @ManyToMany
    @JoinTable(name = "sales")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    public MyCategory getMyCategory() {
        return myCategory;
    }

    public void setMyCategory(MyCategory myCategory) {
        this.myCategory = myCategory;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
}
