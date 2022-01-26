create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna (name, avg_age, discovery_date) values ('cat', 50000, '2022-09-01');
insert into fauna (name, avg_age, discovery_date) values ('tiger', 55000, '1800-11-12');
insert into fauna (name, avg_age, discovery_date) values ('fish', 2500, '1980-01-13');
insert into fauna (name, avg_age, discovery_date) values ('dog', 150, '1901-05-31');
insert into fauna (name, avg_age, discovery_date) values ('cow', 25000, '1917-12-21');
insert into fauna (name, avg_age, discovery_date) values ('bull', 19000, '2005-07-15');
insert into fauna (name, avg_age, discovery_date) values ('human', 2000000, '1937-02-03');

select * from fauna where name like '%fish%';
select * from fauna where avg_age between 10000 and 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950.01.01';
