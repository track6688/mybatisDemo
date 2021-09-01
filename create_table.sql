create table t_address
(
    id bigint auto_increment
        primary key,
    street varchar(255) null,
    city varchar(255) null,
    country varchar(255) null,
    customer_id bigint null
);

create table t_customer
(
    id bigint auto_increment
        primary key,
    name varchar(255) not null,
    phone varchar(255) null
);

create table t_dept
(
    id int auto_increment
        primary key,
    dept_name varchar(50) null
)
    comment '组织表';

create table t_emp
(
    id int auto_increment
        primary key,
    user_name varchar(128) null,
    age int null,
    dept_id int null
)
    comment 'emp';

create table t_order
(
    id bigint auto_increment
        primary key,
    address_id bigint null,
    customer_id bigint null,
    create_time bigint null
);

create table t_order_item
(
    id bigint auto_increment
        primary key,
    amount int null,
    order_id bigint null,
    product_id bigint null
);

create table t_product
(
    id bigint auto_increment
        primary key,
    name varchar(255) null,
    description varchar(255) null,
    price bigint null
);

create table t_user
(
    id bigint auto_increment
        primary key,
    year int null,
    user_name varchar(100) null,
    age int null,
    create_time datetime null
);

create table t_user2021
(
    id bigint auto_increment
        primary key,
    year int null,
    user_name varchar(100) null,
    age int null,
    create_time datetime null
);

create table t_user_2021
(
    id bigint auto_increment
        primary key,
    year int null,
    user_name varchar(100) null,
    age int null,
    create_time datetime null
);