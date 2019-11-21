
drop table user_roles if exists;
drop table users if exists;

create table users (
  user_name         varchar(15) not null primary key,
  user_pass         varchar(15) not null
);

create table user_roles (
  user_name         varchar(15) not null,
  role_name         varchar(15) not null,
  primary key (user_name, role_name),
  foreign key (user_name) references users(user_name)
);

insert into users values ('kodecamp','kodecamp');
insert into users values ('kcamp','kcamp');

insert into user_roles values ('kodecamp','ADMIN');
insert into user_roles values ('kcamp','USER');
