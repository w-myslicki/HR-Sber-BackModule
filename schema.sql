create table users
(
    id serial not null
        constraint users_pk
            primary key,
    username varchar not null,
    password varchar not null,
    created_at timestamp default current_timestamp not null
);

create unique index users_username_uindex
    on users (username);

create table posts
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

create table tags
(
    id serial not null
        constraint tags_pk
            primary key,
    name varchar not null
);

create unique index tags_name_uindex
    on tags (name);


create table posts_likes
(
    post_id int not null
        constraint posts_likes_posts_id_fk
            references posts,
    user_id int not null
        constraint posts_likes_users_id_fk
            references users
);

create table posts_tags
(
    post_id int not null
        constraint posts_tags_posts_id_fk
            references posts,
    tag_id int not null
        constraint posts_tags_tags_id_fk
            references tags
);




