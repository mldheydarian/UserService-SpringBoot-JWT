create table address
(
    address_id     bigint auto_increment,
    tittle         VARCHAR(255) null,
    full_address   VARCHAR(255) null ,
    postal_code    VARCHAR(255) null ,
    city           VARCHAR(255) null ,
    created_at     datetime     null,
    updated_at     datetime     null,
    personality_id bigint       not null,
    primary key (address_id)
);

ALTER TABLE address
    ADD constraint fk_personality_id_in_address_tbl foreign key (personality_id) references personality (personality_id);