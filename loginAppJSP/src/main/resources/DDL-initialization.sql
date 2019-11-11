drop schema login_app if exists;
drop table if exists users ;
drop table if exists authenticate;
drop table if exists roles;
drop table if exists users_roles;
create schema login_app;
use login_app;
CREATE TABLE users (
  id int NOT NULL auto_increment,
  name varchar(255) NOT NULL default '',
  surname varchar(255) NOT NULL,
 email varchar(255) unique NOT NULL,
 age int NOT NULL,
  PRIMARY KEY  (id)
 );
 CREATE TABLE authenticate (
  id int NOT NULL,
 login varchar(45) unique NOT NULL  ,
  password varchar(45) NOT NULL,
  profile_enable boolean NOT NULL,
  PRIMARY KEY  (id)
 );
 CREATE TABLE roles (
  id int NOT NULL auto_increment,
 role varchar(45) NOT NULL default '',
  PRIMARY KEY  (id)
 );
 CREATE TABLE users_roles (
  id int NOT NULL auto_increment,
user_id int,
role_id int,
  PRIMARY KEY  (id)
 ) ;