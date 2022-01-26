create table book(
    id serial primary key,
    name text,
    isbn int
);

create table author(
    id serial primary key,
    name text,
    book_id int references book(id)
);

insert into book (name, isbn) values ('the one','19511334');
insert into book (name, isbn) values ('clean code','123456');
insert into book (name, isbn) values ('agile','1235621');

insert into author (name, book_id) values ('martin',1);
insert into author (name, book_id) values ('jhon',2);
insert into author (name, book_id) values ('july',3);
insert into author (name) values ('kent');

select *
from author as a
inner join book b
on a.book_id = b.id;

select a.name, b.name, b.isbn
from author as a
join book as b
on a.book_id = b.id;

select a.name as Имя, b.name as Название, b.isbn as Серия
from author as a
join book as b
on a.book_id = b.id;
