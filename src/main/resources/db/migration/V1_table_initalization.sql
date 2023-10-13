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


-- zzy Bookings


-- Steve Order


-- Simon Dishes


-- Robin Restaurants


-- Charles Users


-- shanshan Ingredients & Items

-- Ingredients Table
CREATE TABLE Ingredients
(
    ingredient_id     SERIAL PRIMARY KEY,
    ingredient_name   VARCHAR(255)       NOT NULL,
    unit              VARCHAR(50)        NOT NULL
);

-- IngredientItems Table
CREATE TABLE IngredientItems
(
    ingredientitems_id   SERIAL PRIMARY KEY,
    dish_id              INTEGER           NOT NULL REFERENCES Dishes (dish_id),
    ingredient_id        INTEGER           NOT NULL REFERENCES Ingredients (ingredient_id),
    quantity_value       DECIMAL(10, 2)    NOT NULL,
    quantity_unit        VARCHAR(50)       NOT NULL
);
