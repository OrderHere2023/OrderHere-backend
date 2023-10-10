CREATE
EXTENSION IF NOT EXISTS pgcrypto;
-- example
-- CREATE TABLE img
-- (
--     id  uuid PRIMARY KEY DEFAULT gen_random_uuid(),
--     url text NOT NULL UNIQUE,
--     md5 text NOT NULL
-- );

-- Photos Rating
CREATE TABLE rating
(
    rating_id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id integer NOT NULL,
    dish_id integer NOT NULL,
    rating_value decimal NOT NULL,
    comments varchar,
    create_at timestamp NOT NULL
);

-- zzy Bookings


-- Steve Order


-- Simon Dishes


-- Robin Restaurants


-- Charles Users


-- shanshan Ingredients & Items

