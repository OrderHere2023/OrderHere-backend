alter table orders
    alter column order_status type varchar(255);

alter table orders
    alter column order_type type varchar(255);

alter table booking
    alter column status type varchar(255);

alter table users
    alter column user_role type varchar(255);

alter table opening_hours
    alter column day_of_week type varchar(255);

