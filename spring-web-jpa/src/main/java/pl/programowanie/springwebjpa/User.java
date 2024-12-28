package pl.programowanie.springwebjpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String displayName;
    private Integer yearofbirth;

    @OneToMany(mappedBy = "user")
    List<Post> posts;



    public User() {
    }

    public Integer getYearofbirth() {
        return yearofbirth;
    }

    public void setYearofbirth(Integer yearofbirth) {
        this.yearofbirth = yearofbirth;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
