create database grizzly_store;
use grizzly_store;
create table grizzly_user(id int(10) not null auto_increment primary key,
							user_admin varchar(30) not null,
                            user_password varchar(30) not null,
                            user_status varchar(30) default 'active');
alter table grizzly_user auto_increment=101;