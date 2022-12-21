create table if not exists urls(
    id serial primary key,
    url text,
    key_code text,
    count int
);