create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('phone', 80000), ('notebook', 150000), ('watch', 18000), ('ebook', 15000),
('ipad', 60000), ('pc', 100000), ('mouse', 6000);

insert into people(name) values ('martin'), ('kent'), ('john'), ('molly'), ('july'), ('lily');

insert into devices_people(people_id, device_id) values (1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (3, 1), (3, 5), (4, 1),
(4, 2), (5, 3), (5, 6), (6, 1), (6, 7);

select avg(price) from devices;

select p.name, avg(d.price)
from devices_people as dp
join people p
on dp.people_id = p.id
join devices d
on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price)
from devices_people as dp
join people p
on dp.people_id = p.id
join devices d
on dp.device_id = d.id
group by p.name
having avg(d.price) > 50000;
