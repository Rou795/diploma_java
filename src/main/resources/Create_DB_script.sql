create table if not exists Users(
	id bigserial PRIMARY KEY,
	login varchar(100) not null,
	password bytea not null,
	name varchar(50),
	last_name varchar(50),
	birthday date
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