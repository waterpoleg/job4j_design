create table departments(
	id serial primary key,
	name varchar(255)
);

create table employees(
	id serial primary key,
	name varchar(255),
	department_id int references departments(id)
);

insert into departments(name) values ('dep1'), ('dep2'), ('dep3'), ('dep4'), ('dep5');

insert into employees(name, department_id) values ('name1', 1), ('name2', 1), ('name3', 1);
insert into employees(name, department_id) values ('name4', 2), ('name5', null);
insert into employees(name, department_id) values ('name6', 3), ('name7', null), ('name8', 3);
insert into employees(name, department_id) values ('name9', 4);

select * from departments d
left join employees e
on d.id = e.department_id;

select * from departments d
right join employees e
on d.id = e.department_id;

select * from departments d
full join employees e
on d.id = e.department_id;

select * from departments cross join employees;

select * from departments d
left join employees e
on e.department_id = d.id
where e.department_id is null;

/*
* same result:
*/
select * from departments d
left join employees e
on d.id=e.department_id
where e.department_id is not null;

select * from departments d
right join employees e
on d.id=e.department_id
where e.department_id is not null;

/*
* ---------- teens -----------
*/

create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values ('name1', 'm'), ('name2', 'm'), ('name3', 'm'), ('name4', 'm');
insert into teens(name, gender) values ('name5', 'f'), ('name6', 'f'), ('name7', 'f'), ('name8', 'f'), ('name9', 'f');

select t1.name, t1.gender, t2.name, t2.gender
from teens t1 cross join teens t2
where t1.gender = 'm'
and t2.gender = 'f'

