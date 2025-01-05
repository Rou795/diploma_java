drop table users;
drop table authorities;
drop table storage;

create table if not exists Users(
	id bigserial PRIMARY KEY,
	username varchar(100) not null unique,
	password varchar(50) not null,
	confirm_password varchar(50) not null,
	name varchar(50),
	last_name varchar(50),
	birthday date not null default '1900-01-01',
	authority varchar(20) not null default 'ROLE_USER',
	enabled boolean not null default true,

	foreign key (authority) references Authorities (authority)
);

create table if not exists Authorities(
    username varchar(100) not null,
	authority varchar(20) not null,

	foreign key (username) references Users (username)
);

create table if not exists Storage(
	id bigserial PRIMARY KEY,
	user_id int,
	file_name VARCHAR(255) NOT NULL,
	date timestamp NOT NULL,
	is_removed boolean NOT null default false,
	file_data bytea,

	foreign key (user_id) references Users (id)
);

--тестовые данные

insert into authorities (authority, description)
values ('admin', 'ROLE_ADMIN');

insert into users (username, password, confirm_password, name, last_name, birthday, authority)
values ('admin', '{noop}admin', '{noop}admin', 'Admin', 'Admin', '2024-10-24', 'ROLE_ADMIN');