create table users
(
    user_id         bigint   auto_increment,
    created_at     datetime     null,
    updated_at     datetime     null,
    active         bit          null,
    password       varchar(250) not null,
    user_name      varchar(50)  not null,
    personality_id bigint       not null,
    role_id        bigint        not null,
    primary key (user_id)
);
alter table users add    constraint UK_lqjrcobrh9jc8wpcar64q1bfh   unique (user_name);
alter table users add    constraint FKje4w4b99wu9ced9t3a8dl1pbl foreign key (personality_id) references personality (personality_id);
alter table users add    constraint FKn82ha3ccdebhokx3a8fgdqeyy foreign key (role_id) references role (role_id);


insert into users (user_id,active, user_name, personality_id,role_id,password)
values (1,1,'mld', 1,1,'$2a$10$ubuZKZrASaVxtmvinAydsexZwMM1dpQVlMTely3XeD6Spcrt9XfAi'),
       (2,1, 'ahmad', 2,2,'$2a$10$ubuZKZrASaVxtmvinAydsexZwMM1dpQVlMTely3XeD6Spcrt9XfAi');