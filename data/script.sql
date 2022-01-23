create table books(
	id serial primary key,
	author varchar(255),
	name varchar(255),
	description text,
	price money
);

insert into books(author, name, description, price) values('Bob', 'Clean code', 'description', 100);

select * from books;

update books set price=150;

select * from books;

delete from books;

select * from books;
