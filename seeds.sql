DROP DATABASE If EXISTS think_food_db;

CREATE DATABASE IF NOT EXISTS think_food_db;

USE think_food_db;


INSERT INTO  recipes(id, title, prep_time, description, rating)
VALUES (1, 'Sweet potato casserole', 90, 'some words that make it sound delicious', 8);

INSERT INTO  recipes(id, title, prep_time, description, rating)
VALUES (2, 'Grilled chicken', 60, 'some words that make it sound scrump-dida-lumptious', 7);

# INSERT INTO  recipes(title, prep_time, description, chef, rating)
# VALUES (2, 'Grilled chicken', 60, 'some words that make it sound scrump-dida-lumptious', 7);
