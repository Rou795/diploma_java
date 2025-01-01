package hw.netology.diploma.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "storage", schema = "public")
public class Storage {

//    id bigserial PRIMARY KEY,
//    user_id int,
//    file_name VARCHAR(255) NOT NULL,
//    date timestamp NOT NULL,
//    is_removed boolean NOT null default false,
//    file_data bytea,
//
//    foreign key (user_id) references Users (id)

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "date")
    private Date date;

    @Column(name = "is_removed")
    private boolean isRemoved;

    @Column(name = "file_data", nullable = true)
    private byte[] fileData;
}
