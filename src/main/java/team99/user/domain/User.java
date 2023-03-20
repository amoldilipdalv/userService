package team99.user.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name= "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_at")
    private Integer createdAt;

    @Column(name = "updated_at")
    private Integer updatedAt;

    public User() {

    }
    public User(String name) {
        this.name = name;
        /*this.createdAt = Instant.now().truncatedTo(ChronoUnit.MICROS);*/
        this.createdAt = ((Long)(System.currentTimeMillis()*1000)).intValue();
        this.updatedAt = ((Long)(System.currentTimeMillis()*1000)).intValue();
    }
    public User(Integer id, String name, Integer createdAt, Integer updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getupdatedAt() {
        return updatedAt;
    }

    public void setupdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
