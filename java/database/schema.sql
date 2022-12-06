BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, pets, user_pet CASCADE;
DROP SEQUENCE IF EXISTS users_serial, pets_serial;


CREATE SEQUENCE users_serial;
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE pets_serial;
CREATE TABLE pets (
pet_id serial,
animal_type varchar(50) NOT NULL,
pet_name varchar(50) NOT NULL,
pet_experience boolean NOT NULL,
vaccinated boolean NOT NULL,
spayed boolean NOT NULL,
age_years varchar(25) NOT NULL,
sex varchar(25) NOT NULL,
pet_friendliness varchar(50) NOT NULL,
human_friendliness varchar(50) NOT NULL,
favorite_activities varchar(200) NOT NULL,
favorite_toy varchar(50) NOT NULL,
favorite_treat varchar(50) NOT NULL,
img_link varchar(100) NOT NULL,
CONSTRAINT PK_pet PRIMARY KEY (pet_id),
CONSTRAINT FK_user FOREIGN KEY (pet_id) REFERENCES pets (pet_id)
);

CREATE TABLE user_pet(
user_id int NOT NULL,
pet_id int NOT NULL,
CONSTRAINT PK_user_pet PRIMARY KEY(user_id, pet_id),
CONSTRAINT FK_user_pet_user FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT FK_user_pet_pet FOREIGN KEY(pet_id) REFERENCES pets(pet_id)
);


COMMIT TRANSACTION;
