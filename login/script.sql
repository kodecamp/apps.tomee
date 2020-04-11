-- USER TABLE
drop table user_tokens if exists;
drop table user_roles if exists;
drop table users if exists;

create table users (
  id varchar(128) not null primary key,
  login_id         varchar(15) not null unique,
  password         varchar(15) not null
);

insert into users values ('100','kodecamp','kodecamp');
insert into users values ('101','kcamp','kcamp');
---------------------------------------------------------

-- USER_ROLES TABLE
create table user_roles (
  id varchar(128) not null,
  login_id         varchar(15) not null,
  role_name         varchar(15) not null,
  primary key (login_id, role_name),
  foreign key (login_id) references users(login_id)
);

insert into user_roles values ('100','kodecamp','ADMIN');
insert into user_roles values ('101','kcamp','USER');

---------------------------------------------------------

-- USER_TOKEN TABLE
create table login_tokens(
  id varchar(128) not null,
  login_id varchar(15) not null,
  token_id varchar(1024) not null,
  primary key (login_id,token_id),
  foreign key (login_id) references users(login_id)
);

---------------------------------------------------------




