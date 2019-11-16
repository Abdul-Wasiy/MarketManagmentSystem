package hu.cs.se.model;
import javax.persistence.*;
import java.util.Set;

@Entity
public class MyCategory {
    @Column(name = "cat_id")
    private long id;
    private String type;

    private Set<Good> goods;

    @OneToMany(mappedBy = "myCategory")

    public Set<Good> getGoods() {
        return goods;
    }

    public void setGoods(Set<Good> goods) {
        this.goods = goods;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
