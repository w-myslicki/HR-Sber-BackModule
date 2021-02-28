create schema if not exists public;

create table if not exists public.users
(
    id serial not null
        constraint users_pk
            primary key,
    username varchar not null,
    password varchar not null,
    created_at timestamp default current_timestamp not null
);

create unique index if not exists users_username_uindex
    on users (username);

create table if not exists posts
(
    id serial not null
        constraint posts_pk
            primary key,
    content json not null,
    author_id int not null
        constraint posts_users_id_fk
            references users,
    created_at timestamp default current_timestamp not null
);

create table if not exists tags
(
    id serial not null
        constraint tags_pk
            primary key,
    name varchar not null
);

create unique index if not exists tags_name_uindex
    on tags (name);


create table if not exists posts_likes
(
    post_id int not null
        constraint posts_likes_posts_id_fk
            references posts,
    user_id int not null
        constraint posts_likes_users_id_fk
            references users
);

create table if not exists posts_tags
(
    post_id int not null
        constraint posts_tags_posts_id_fk
            references posts,
    tag_id int not null
        constraint posts_tags_tags_id_fk
            references tags
);

create table if not exists roles
(
    id serial not null
        constraint roles_pk
            primary key,
    name varchar not null
);

alter table roles owner to root;

create unique index if not exists roles_name_uindex
	on roles (name);

INSERT INTO roles (name)
    SELECT ('ROLE_USER')
    WHERE NOT EXISTS ( SELECT name FROM roles WHERE name = 'ROLE_USER' );

INSERT INTO roles (name)
SELECT ('ROLE_ADMIN')
    WHERE NOT EXISTS ( SELECT name FROM roles WHERE name = 'ROLE_ADMIN' );

