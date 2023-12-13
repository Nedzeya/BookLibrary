CREATE TABLE person (
person_id serial primary key ,
"name" varchar (50) not null unique,
year int check  ("year">=1923 or "year"<=2017) not null
);

create table Book (
id serial primary key ,
person_id int references person (person_id) on delete set null ,
assign_time date,
name_of_book varchar (100) not null,
author varchar (50) not null default 'Unknown',
year int check ("year">=1000 or "year"<=9999)
);