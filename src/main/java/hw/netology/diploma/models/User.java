package hw.netology.diploma.models;

//id bigserial PRIMARY KEY,
//login varchar(100) not null,
//password bytea not null,
//name varchar(50),
//last_name varchar(50),
//birthday date

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Users", schema = "public")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "login", nullable = true, unique = true)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String login;

    @Column(name = "password", nullable = true, unique = true)
    //@JdbcTypeCode(SqlTypes.BLOB)
    private String password;

    @Column(name = "name")
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String name;

    @Column(name = "last_name")
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    private String lastName;

    @Column(name = "birthday")
    @JdbcTypeCode(SqlTypes.DATE)
    private Date birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
