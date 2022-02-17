CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company (id, name) values (1, 'c1');
insert into company (id, name) values (2, 'c2');
insert into company (id, name) values (3, 'c3');
insert into company (id, name) values (4, 'c4');
insert into company (id, name) values (5, 'c5');

insert into person(id, name, company_id) values (1, 'n1', 1);
insert into person(id, name, company_id) values (2, 'n2', 5);
insert into person(id, name, company_id) values (3, 'n3', 3);
insert into person(id, name, company_id) values (4, 'n4', 2);
insert into person(id, name, company_id) values (5, 'n5', 5);

select p.name, c.name
from person as p
join company c on p.company_id = c.id
where p.company_id != 5;

select c.name, count(p.name)
from company c
join person p
on c.id = p.company_id
group by c.name
having count(p.id) =
(select count(p.id)
from person p
group by p.company_id
order by count(p.name) desc limit 1)