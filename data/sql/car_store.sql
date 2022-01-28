create table carbody(
	id serial primary key,
	body varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table transmission(
	id serial primary key,
	type varchar(255)
);

create table car(
	id serial primary key,
	name varchar(255),
	body_id int references carbody(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into carbody(body) values ('sedan'), ('uni'), ('hatchback'), ('cabrio'), ('limousine');
insert into engine(name) values ('steam'), ('disel'), ('benzin'), ('jet'), ('turbo');
insert into transmission(type) values ('auto'), ('mech'), ('mix'), ('robo');

insert into car(name, body_id, engine_id, transmission_id) values('bmw', 1, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values('lada', 3, 1, 2);
insert into car(name, body_id, engine_id, transmission_id) values('mercedes', 4, 3, 1);
insert into car(name, body_id, engine_id, transmission_id) values('maz', 2, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values('toyota', 3, 3, 4);

select c.name car, b.body body, e.name engine, t.type transmission
from car c
left join carbody b on c.body_id = b.id
left join engine e on c.engine_id = e.id
left join transmission t on c.body_id = t.id;

select e.name
from engine e
full join car c on e.id = c.engine_id
where c.id is null;
