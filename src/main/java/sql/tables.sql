CREATE SCHEMA rolo;
CREATE TABLE rolo.users (
  id SERIAL PRIMARY KEY,
  name varchar(30) NOT NULL,
  pass varchar(20) NOT NULL,
  mail varchar(50)
);
CREATE TABLE rolo.roles (
  id SERIAL PRIMARY KEY,
  code varchar(30) NOT NULL
 );
 CREATE TABLE rolo.urro (
  id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL references rolo.users(id),
  role_id INTEGER NOT NULL references rolo.roles(id)
 );
 CREATE TABLE rolo.log (
  id SERIAL PRIMARY KEY,
  grp varchar(50) NOT NULL,
  item varchar(50) NOT NULL,
  mess varchar(100),
  dt date NOT NULL
  );
   CREATE TABLE rolo.state (
  id SERIAL PRIMARY KEY,
  name varchar(20) NOT NULL,
  value varchar(20)
  );
 CREATE UNIQUE INDEX urro_unq ON rolo.urro (user_id,role_id);
 CREATE UNIQUE INDEX roles_unq ON rolo.roles (code);
 CREATE UNIQUE INDEX users_unq ON rolo.users (name);
 CREATE UNIQUE INDEX state_unq ON rolo.state (name);
--------- 
drop index IF EXISTS urls_unq;
drop index IF EXISTS items_unq;
drop index IF EXISTS mails_unq;
drop TABLE IF EXISTS rss.items;
drop TABLE IF EXISTS  rss.urls;
drop TABLE IF EXISTS  rss.mails;

 CREATE SCHEMA rss;
CREATE TABLE rss.mails (
  id SERIAL PRIMARY KEY,
  url varchar(100) NOT NULL,
  name varchar(50),
  user_id INTEGER NOT NULL references rolo.users(id)
);

CREATE TABLE rss.urls (
  id SERIAL PRIMARY KEY,
  mails_id INTEGER NOT NULL references rss.mails(id),
  url varchar(100) NOT NULL,
  is_active char(1),
  laststart timestamp
);
CREATE TABLE rss.items (
  id SERIAL PRIMARY KEY,
  mails_id INTEGER NOT NULL references rss.mails(id),
  urls_id INTEGER NOT NULL references rss.urls(id),
  title varchar(50) NOT NULL,
  lastpub timestamp,
  is_active char(1)
);

CREATE UNIQUE INDEX urls_unq ON rss.urls (mails_id, url);
CREATE UNIQUE INDEX items_unq ON rss.items (urls_id, title);
CREATE UNIQUE INDEX mails_unq ON rss.mails (user_id, url);

insert into rolo.roles (code) values ('admin');
insert into rolo.roles (code) values ('any');
insert into rolo.users (name,pass) values ('admin','admin');
insert into rolo.urro ( role_id,user_id) values ( (select id from rolo.roles where code='admin'),(select id from rolo.users where name='admin'));