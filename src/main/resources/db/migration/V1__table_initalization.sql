CREATE
EXTENSION IF NOT EXISTS pgcrypto;
-- example
CREATE TABLE "order_items"
(
    order_item_id BIGSERIAL PRIMARY KEY NOT NULL UNIQUE,
    order_id      BIGSERIAL             NOT NULL REFERENCES "orders" ("order_id"),
    dish_id       BIGINT                NOT NULL REFERENCES "dishes" ("dish_id"),
    dish_quantity INT                   NOT NULL
);

-- Photos Rating


-- zzy Bookings
CREATE TYPE booking_status AS ENUM ('PENDING', 'CONFIRMED', 'CANCELLED');

CREATE TABLE Bookings
(
    booking_id       SERIAL PRIMARY KEY,
    user_id          INTEGER                  NOT NULL REFERENCES Users (user_id),
    table_number     INTEGER                  NOT NULL,
    reservation_time TIMESTAMP WITH TIME ZONE NOT NULL,
    status           booking_status           NOT NULL,
    restaurant_id    INTEGER                  NOT NULL REFERENCES Restaurants (restaurant_id)
);

-- Steve Order

CREATE TYPE order_status AS ENUM ('PENDING', 'PREPARING', 'FINISHED', 'CANCELLED');
CREATE TYPE order_type AS ENUM ('DINE_IN', 'DELIVERY', 'PICKUP');

CREATE TABLE "orders"
(
    order_id     BIGSERIAL PRIMARY KEY    NOT NULL UNIQUE,
    user_id      BIGINT REFERENCES "users" ("user_id"),
    created_time TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_time TIMESTAMP WITH TIME ZONE NOT NULL,
    order_status order_status             NOT NULL,
    order_type   order_type               NOT NULL,
    table_number INT,
    pickup_time  TIMESTAMP,
    address      VARCHAR(255),
    total_price  DECIMAL(10, 2)           NOT NULL,
    discount     DECIMAL(10, 2)           NOT NULL,
    note         VARCHAR(255)
);

-- Simon Dishes


-- Robin Restaurants


-- Charles Users


-- shanshan Ingredients & Items

-- Ingredients Table
CREATE TABLE Ingredients
(
    ingredient_id     SERIAL PRIMARY KEY,
    ingredient_name   VARCHAR(255)       NOT NULL,
    unit              VARCHAR(50)        NOT NULL,
    created_time     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_time     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);

-- IngredientItems Table
CREATE TABLE IngredientItems
(
    ingredientitems_id   SERIAL PRIMARY KEY,
    dish_id              INTEGER           NOT NULL REFERENCES Dishes (dish_id),
    ingredient_id        INTEGER           NOT NULL REFERENCES Ingredients (ingredient_id),
    quantity_value       DECIMAL(10, 2)    NOT NULL,
    quantity_unit        VARCHAR(50)       NOT NULL,
    created_time     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_time     TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);
