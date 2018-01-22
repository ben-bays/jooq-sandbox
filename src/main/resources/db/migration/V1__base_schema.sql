

--
-- Create our base schemas and our application user "jsx".  Grant permission to the new schemas to "jsx".
--


-- create schema for users
create schema if not exists iam;

-- create an application user
DO
$body$
BEGIN
  IF NOT EXISTS(SELECT * FROM pg_catalog.pg_user WHERE usename='jsx') THEN
    CREATE USER jsx WITH NOCREATEDB NOCREATEROLE NOSUPERUSER PASSWORD 'testpwd!123';
  END IF;
END
$body$;

-- create a group for the application user to belong to
DO
$body$
BEGIN
  IF NOT EXISTS(SELECT * FROM pg_catalog.pg_roles WHERE rolname='jsxgroup') THEN
    CREATE ROLE jsxgroup NOSUPERUSER NOCREATEROLE NOCREATEDB;
  END IF;
END
$body$;

-- grant group to our application user
grant jsxgroup to jsx;

-- grant group permission to our root user
grant jsxgroup to sa;

-- application user owns the group
alter schema iam owner to jsxgroup;

-- grant permissions to all relevant database objects to our application group.  This alters the
-- default privileges, which allows these settings to be applied to objects that don't exist yet
alter default privileges in schema iam grant all privileges on tables to jsxgroup;
alter default privileges in schema iam grant all privileges on sequences to jsxgroup;
alter default privileges in schema iam grant all privileges on functions to jsxgroup;

-- create a core schema
create schema if not exists core;
alter schema core owner to jsxgroup;

alter default privileges in schema core grant all privileges on tables to jsxgroup;
alter default privileges in schema core grant all privileges on sequences to jsxgroup;
alter default privileges in schema core grant all privileges on functions to jsxgroup;




create table iam.user (
  id bigserial not null,
  email varchar(128) not null,
  first_name varchar(64) default '' not null,
  last_name varchar(64) default '' not null,
  constraint user_id_pkey primary key (id)
);

create unique index  user_email_key on iam.user (lower(email));


create table core.photo (
  id bigserial not null,
  owner_id bigint not null,
  created_date timestamp default current_timestamp not null,
  description text,
  constraint photos_id_pkey primary key (id),
  constraint photos_owner_id_fkey foreign key (owner_id) references iam.user(id)
);

create table core.photo_tag (
  user_id bigint not null,
  photo_id bigint not null,
  constraint photo_tag_pkey primary key (user_id, photo_id),
  constraint photo_user_id_fkey foreign key (user_id) references iam.user (id),
  constraint photo_photo_id_fkey foreign key (photo_id) references core.photo (id)
);
