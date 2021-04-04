CREATE TABLE athletes(
aid serial primary key,
aname text unique not null
);

CREATE TABLE workouts(
wid serial primary key,
athlete_id integer not null references athletes (aid), 
wout_day text not null,
distance integer not null,
gain integer not null,
wout_time numeric not null
);