
create table public.action (

  id bigserial primary key,
  name text unique not null,
  rating integer not null,
  image text
);


create table public.performed_action (

  id bigserial primary key,
  action_id bigint references public.action,
  user_id text,
  cts TIMESTAMP NOT NULL DEFAULT NOW()

);

insert into public.action(name, rating) values ('Smoke', -20);
insert into public.action(name, rating) values ('Run', 10);
insert into public.action(name, rating) values ('Swim', 20);
insert into public.action(name, rating) values ('Read', 10);
insert into public.action(name, rating) values ('Drive Car', -10);
insert into public.action(name, rating) values ('Walk', 10);
insert into public.action(name, rating) values ('Drink Alcohol', -10);
