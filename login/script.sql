
-- USER TABLE
drop table users if exists;
create table users (
  user_name         varchar(15) not null primary key,
  user_pass         varchar(15) not null
);

insert into users values ('kodecamp','kodecamp');
insert into users values ('kcamp','kcamp');
---------------------------------------------------------

-- USER_ROLES TABLE
drop table user_roles if exists;
create table user_roles (
  user_name         varchar(15) not null,
  role_name         varchar(15) not null,
  primary key (user_name, role_name),
  foreign key (user_name) references users(user_name)
);

insert into user_roles values ('kodecamp','ADMIN');
insert into user_roles values ('kcamp','USER');

---------------------------------------------------------

-- USER_TOKEN TABLE
drop table user_tokens if exists;
create table user_tokens(
  user_name         varchar(15) not null,
  token varchar(1024) not null,
  primary key (user_name),
  foreign key (user_name) references users(user_name)
);

---------------------------------------------------------




