create table if not exists sites (
    id serial primary key,
    site text,
    login text,
    password text,
    registration boolean,
    url_id int references sites(id)
);