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
    rating_id long PRIMARY KEY UNIQUE,
    user_id integer NOT NULL REFERENCES Users (user_id),
    dish_id integer NOT NULL REFERENCES DIshes (dish_id),
    rating_value decimal NOT NULL,
    comments varchar,
    created_time TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_time TIMESTAMP WITH TIME ZONE NOT NULL
);

-- zzy Bookings


-- Steve Order


-- Simon Dishes


-- Robin Restaurants


-- Charles Users


-- shanshan Ingredients & Items

