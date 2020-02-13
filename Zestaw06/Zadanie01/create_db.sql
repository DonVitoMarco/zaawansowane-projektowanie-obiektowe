create table if not exists dish
(
    id         varchar(50) not null,
    name       varchar(50) not null,
    price      double      not null,
    max_orders int         not null,
    vegan      tinyint(1)  not null,
    constraint dish_id_uindex
        unique (id)
);

alter table dish
    add primary key (id);

create table if not exists user
(
    id            varchar(50)                         not null,
    login         varchar(50)                         not null,
    first_name    varchar(50)                         not null,
    second_name   varchar(50)                         not null,
    password      varchar(50)                         not null,
    email         varchar(50)                         not null,
    register_date timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    phone         varchar(50)                         not null,
    constraint user_id_uindex
        unique (id),
    constraint user_login_uindex
        unique (login)
);

alter table user
    add primary key (id);

create table if not exists address
(
    id           varchar(50) not null,
    city         varchar(50) not null,
    street       varchar(50) not null,
    house_number varchar(50) not null,
    post_code    varchar(50) not null,
    user_id      varchar(50) not null,
    constraint address_id_uindex
        unique (id),
    constraint address_user_id_fk
        foreign key (user_id) references user (id)
);

alter table address
    add primary key (id);

create table if not exists `order`
(
    id         varchar(50)                         not null,
    order_date timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    user_id    varchar(50)                         not null,
    constraint order_id_uindex
        unique (id),
    constraint order_user_id_fk
        foreign key (user_id) references user (id)
);

alter table `order`
    add primary key (id);

create table if not exists order_entry
(
    id        varchar(50) not null,
    dish_name varchar(50) not null,
    order_id  varchar(50) not null,
    price     double      not null,
    amount    int         not null,
    constraint order_entry_id_uindex
        unique (id),
    constraint order_entry_order_id_fk
        foreign key (order_id) references `order` (id)
);

alter table order_entry
    add primary key (id);

