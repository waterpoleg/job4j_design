insert into role(name) values ('seller');
insert into users(name, role_id) values ('martin', 1);
insert into rules(name) values ('admin');
insert into role_rules(role_id, rules_id) values (1,1);
insert into state(name) values ('in progress');
insert into category(name) values ('goods');
insert into item(name, users_id, category_id, state_id) values ('thing',1,1,1);
insert into comments(name, item_id) values ('no comment',1);
insert into attaches(name,item_id) values ('empty',1);
