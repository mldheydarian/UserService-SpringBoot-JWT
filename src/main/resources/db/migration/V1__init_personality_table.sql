create table personality
(
    personality_id bigint auto_increment,
    created_at     datetime     null,
    updated_at     datetime     null,
    email          varchar(255) not null,
    first_name     varchar(255) not null,
    image_url      varchar(255) null,
    last_name      varchar(255) not null,
    phone          varchar(255) null,
    primary key (personality_id)

);
alter table personality ADD CONSTRAINT   UK_m442mg40nfqgsvr5bhwdynkby   unique (email);
insert into personality (personality_id,  email, first_name, image_url, last_name, phone)
values (1,'mld@yahoo.com','milad','https://bootdey.com/img/Content/avatar/avatar7.png','hdr','092166666'),
        (2,'reza@yahoo.com','reza','https://bootdey.com/img/Content/avatar/avatar8.png','rr','092166666');
