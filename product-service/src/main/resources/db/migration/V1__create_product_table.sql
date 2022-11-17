-- Sequence required to generate primary keys when Generation Strategy AUTO is used
CREATE SEQUENCE HIBERNATE_SEQUENCE;

create table product (
    id bigint primary key,
    reference_id varchar(25),
    name varchar(255),
    price decimal(10,2),
    category varchar(255),
    description varchar(2048)
);