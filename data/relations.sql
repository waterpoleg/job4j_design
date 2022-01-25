create table exam(
    id serial primary key,
    topic varchar(255)
);

create table students(
    id serial primary key,
    name varchar(255),
    topic_id int
);

insert into exam(topic) values ('math');
insert into students(name, topic_id) values ('martin', 1);

select * from students
select * from exam



create table doctor(id serial primary key, name varchar(255));
create table doctor(id serial primary key, name varchar(255));
create table cure(id serial primary key, doctor_id int references doctor(id), patiant_id int references patient(id));

insert into doctor(name) values('martin');
insert into doctor(name) values('bob');
insert into doctor(name) values('jerry');

insert into patient(name) values('ken');
insert into patient(name) values('chris');
insert into patient(name) values('jhon');

insert into cure(doctor_id, patiant_id) values(1,1);
insert into cure(doctor_id, patiant_id) values(1,2);
insert into cure(doctor_id, patiant_id) values(1,3);
insert into cure(doctor_id, patiant_id) values(2,1);
insert into cure(doctor_id, patiant_id) values(2,2);
insert into cure(doctor_id, patiant_id) values(2,3);
insert into cure(doctor_id, patiant_id) values(3,1);
insert into cure(doctor_id, patiant_id) values(3,2);
insert into cure(doctor_id, patiant_id) values(3,3);

select * from cure



create table car(
	id serial primary key,
	model varchar(255),
	number varchar(10)
);

create table owner(
	id serial primary key,
	name char(255),
	car_id int references car(id) unique
);

insert into car(model, number) values('bmw','e888kx777');
insert into owner(name, car_id) values('martin', 1);

select * from owner
select * from car