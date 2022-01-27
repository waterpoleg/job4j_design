create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255),
	type_id int references type(id),
	expired_date date,
	price float
);

insert into type(name) values ('сыр'), ('молоко'), ('мороженое'), ('фрукты');

insert into product(name, type_id, expired_date, price) values ('сыр российский', 1, '2022-10-12', 100);
insert into product(name, type_id, expired_date, price) values ('сыр пармезан', 1, '2022-09-01', 250);
insert into product(name, type_id, expired_date, price) values ('сыр колбасный', 1, '2022-06-01', 120);
insert into product(name, type_id, expired_date, price) values ('молоко Домик в деревне', 2, '2022-07-02', 70);
insert into product(name, type_id, expired_date, price) values ('молоко Valio', 2, '2022-11-10', 90);
insert into product(name, type_id, expired_date, price) values ('молоко фермерское', 2, '2022-02-10', 150);
insert into product(name, type_id, expired_date, price) values ('молоко чебурашкино', 2, '2021-02-10', 80);
insert into product(name, type_id, expired_date, price) values ('мороженое пломбир', 3, '2022-05-20', 50);
insert into product(name, type_id, expired_date, price) values ('мороженое лакомка', 3, '2022-04-25', 40);
insert into product(name, type_id, expired_date, price) values ('мороженое эскимо', 3, '2022-06-08', 35);
insert into product(name, type_id, expired_date, price) values ('яблоко антоновка', 4, '2022-08-12', 100);
insert into product(name, type_id, expired_date, price) values ('яблоко голден', 4, '2022-09-15', 75);
insert into product(name, type_id, expired_date, price) values ('апельсин', 4, '2022-04-20', 90);

select * from product as p
join type as t
on p.type_id = t.id
where t.name = 'сыр'

select * from product
where product.name like '%мороженое%'

select * from product
where product.expired_date < now();

select * from product
where price = (select max(price) from product);

select t.name, count(p.name) from product as p
join type as t
on p.type_id = t.id
group by t.name;

select p.name from product as p
join type as t
on p.type_id = t.id
group by p.name, t.name
having t.name = 'сыр'
or t.name = 'молоко';

select t.name, count(p.name) from product as p
join type as t
on p.type_id = t.id
group by t.name
having count(p.name) < 10;

select p.name, t.name
from product as p
join type as t
on p.type_id = t.id;