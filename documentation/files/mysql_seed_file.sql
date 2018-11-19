CREATE SCHEMA `tinybeans` ;

drop table if exists products;
create table if not exists products (
	id int primary key auto_increment,
    image_file varchar(50) not null unique key,
    product_name varchar(100) not null,
    product_description text not null,
    sku int not null unique key,
    price decimal(10,2) not null
);

drop table if exists payments;
create table if not exists payments (
	id int primary key auto_increment,
    amount decimal(10,2) not null,
    sku int not null,
    stripe_token varchar(200) not null,
    stripe_token_type varchar(100) not null,
    stripe_email varchar(100) not null,
    charge_id varchar(100) not null,
    creation_time timestamp default current_timestamp,
    updated_time timestamp default current_timestamp on update current_timestamp
);
ALTER TABLE payments AUTO_INCREMENT=1001;

insert into products 
(image_file, product_name, product_description, sku, price)
values
('toothpaste.png','Toothpaste','Spearmint flavor, clinicaly proven to prevent cavities',12234,2.99),
('toothbrush.png','Toothbrush','Cleans teeth in hard to reach places',34083,1.99),
('mouthwash.png','Mouthwash','Use twice daily to help fight bad breath',34579,5.99),
('floss.png','Floss','4 out of 5 dentists recommend flossing daily',18862,3.99),
('combopack.png','Dental Combo Pack','Includes one each of - Toothpaste, Toothbrush & Floss',99864,7.99),
('whiteningstrips.png','Whitening Strips','Use one a day nightly to brigten teeth in as little as 2 weeks',26827,29.99)
;

#select * from products;
#select * from payments;

