create table role
(
    role_id    bigint auto_increment,
    created_at datetime     null,
    updated_at datetime     null,
    role_name  varchar(255) null,
    primary key (role_id)
);

insert into role (role_id,role_name)
VALUES
     ( 1,'ROLE_ADMIN' ),
       (2,'ROLE_USER');