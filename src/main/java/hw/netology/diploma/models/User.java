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
}
