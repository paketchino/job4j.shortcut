create table if not exists urls(
    id serial primary key,
    url text,
    unique_code text,
    count int
);