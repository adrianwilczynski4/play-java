# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cabinet (
  id                            serial not null,
  category                      varchar(255) not null,
  nr                            varchar(255),
  constraint pk_cabinet primary key (id)
);

create table possible_visits (
  id                            serial not null,
  doctorsname                   integer not null,
  hour                          time,
  date                          date,
  fullname                      varchar(255),
  booking_id                    integer,
  login                         varchar(255),
  isbooked                      boolean,
  constraint pk_possible_visits primary key (id)
);

create table room (
  id                            serial not null,
  doctors_id                    integer,
  roomnr_id                     integer,
  length                        time,
  date                          date,
  starttime                     time,
  endtime                       time,
  constraint pk_room primary key (id)
);

create table specialization (
  id                            serial not null,
  specializationname            varchar(255) not null,
  constraint pk_specialization primary key (id)
);

create table user_role (
  id                            serial not null,
  role                          varchar(255),
  constraint pk_user_role primary key (id)
);

create table users (
  id                            serial not null,
  firstname                     varchar(255) not null,
  lastname                      varchar(255),
  email                         varchar(255),
  login                         varchar(255),
  password                      varchar(255),
  address                       varchar(255),
  postcode                      varchar(255),
  phone                         varchar(255),
  pesel                         varchar(255),
  enabled                       boolean,
  constraint pk_users primary key (id)
);

create table users_specialization (
  users_id                      integer not null,
  specialization_id             integer not null,
  constraint pk_users_specialization primary key (users_id,specialization_id)
);

create table users_user_role (
  users_id                      integer not null,
  user_role_id                  integer not null,
  constraint pk_users_user_role primary key (users_id,user_role_id)
);

alter table room add constraint fk_room_roomnr_id foreign key (roomnr_id) references cabinet (id) on delete restrict on update restrict;
create index ix_room_roomnr_id on room (roomnr_id);

alter table users_specialization add constraint fk_users_specialization_users foreign key (users_id) references users (id) on delete restrict on update restrict;
create index ix_users_specialization_users on users_specialization (users_id);

alter table users_specialization add constraint fk_users_specialization_specialization foreign key (specialization_id) references specialization (id) on delete restrict on update restrict;
create index ix_users_specialization_specialization on users_specialization (specialization_id);

alter table users_user_role add constraint fk_users_user_role_users foreign key (users_id) references users (id) on delete restrict on update restrict;
create index ix_users_user_role_users on users_user_role (users_id);

alter table users_user_role add constraint fk_users_user_role_user_role foreign key (user_role_id) references user_role (id) on delete restrict on update restrict;
create index ix_users_user_role_user_role on users_user_role (user_role_id);


# --- !Downs

alter table if exists room drop constraint if exists fk_room_roomnr_id;
drop index if exists ix_room_roomnr_id;

alter table if exists users_specialization drop constraint if exists fk_users_specialization_users;
drop index if exists ix_users_specialization_users;

alter table if exists users_specialization drop constraint if exists fk_users_specialization_specialization;
drop index if exists ix_users_specialization_specialization;

alter table if exists users_user_role drop constraint if exists fk_users_user_role_users;
drop index if exists ix_users_user_role_users;

alter table if exists users_user_role drop constraint if exists fk_users_user_role_user_role;
drop index if exists ix_users_user_role_user_role;

drop table if exists cabinet cascade;

drop table if exists possible_visits cascade;

drop table if exists room cascade;

drop table if exists specialization cascade;

drop table if exists user_role cascade;

drop table if exists users cascade;

drop table if exists users_specialization cascade;

drop table if exists users_user_role cascade;

