create database grizzly_storeDB;
use grizzly_storeDB;
create table user_details(user_name varchar(30) not null ,
							user_password varchar(30) not null,
							user_role varchar(30) not null,
                            user_status varchar(30) default 'active',
                            user_attempts int(3) default 0);


insert into user_details(user_name,user_password,user_role) values ('dipanjan','paradox','admin');


select * from user_details;


create table product_details(product_id int not null auto_increment primary key,
							product_name varchar(255) not null,
                            product_brand varchar(255) not null,
                            product_category varchar(255) not null,
                            product_rating double,
                            product_buffer int,
                            product_stock int not null,
							product_price double not null);

alter table product_details auto_increment=10001;
                           
                          
select * from product_details;

insert into product_details(product_name ,product_brand,product_category,product_rating,
							product_stock,
							product_price) values ('all stars',
                            'addidas','footware',5.0,40,7500);
insert into product_details(product_name ,product_brand,product_category,product_rating,
							product_stock,
							product_price) values ('Polo',
                            'levis','tshirt',4.7,200,1500);
