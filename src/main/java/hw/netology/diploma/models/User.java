package hw.netology.diploma.models;

//id bigserial PRIMARY KEY,
//login varchar(100) not null,
//password bytea not null,
//name varchar(50),
//last_name varchar(50),
//birthday date

import hw.netology.diploma.Authority;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Users", schema = "public")
public class User implements UserDetails {

    @Id
    @Column(nullable = false, columnDefinition = "bigserial")
    @JdbcTypeCode(SqlTypes.BIGINT)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "username", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.NVARCHAR)
    @Size(min = 5, message = "Не меньше пяти знаков")
    private String username;

    @Column(name = "password", nullable = false, unique = true)
    @Size(min = 5, message = "Не меньше пяти знаков")
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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Authority> authorities;

    @Column(name = "enabled")
    private boolean enabled;

    public User() {
    }

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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
