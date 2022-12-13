BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, pets, user_pet, playDates, topics, messages, playdate_pet CASCADE;
DROP SEQUENCE IF EXISTS users_serial, pets_serial, playDates_serial, topics_serial, messages_serial;


--CREATE SEQUENCE users_serial;
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
    zip_code varchar(10) NOT NULL,
    CONSTRAINT PK_pet PRIMARY KEY (pet_id)
);

CREATE TABLE user_pet(
    user_id int NOT NULL,
    pet_id int NOT NULL,
    CONSTRAINT PK_user_pet PRIMARY KEY(user_id, pet_id),
    CONSTRAINT FK_user_pet_user FOREIGN KEY(user_id) REFERENCES users(user_id),
    CONSTRAINT FK_user_pet_pet FOREIGN KEY(pet_id) REFERENCES pets(pet_id)
);

--CREATE SEQUENCE playDates_serial;
CREATE TABLE playDates (
    playDate_id serial,
    dateandtime timestamp NOT NULL,
    location varchar(100) NOT NULL,
    requestMessage varchar(500) NOT NULL,
    CONSTRAINT PK_playDate PRIMARY KEY (playDate_id)
);

CREATE TABLE playdate_pet (
    playdate_id int NOT NULL,
    pet_id int NOT NULL,
    CONSTRAINT PK_playdate_pet PRIMARY KEY(playDate_id, pet_id),
    CONSTRAINT FK_playdate_pet_playdate FOREIGN KEY(playdate_id) REFERENCES playDates(playdate_id),
    CONSTRAINT FK_playdate_pet_pet FOREIGN KEY(pet_id) REFERENCES pets(pet_id)
);

--CREATE SEQUENCE topics_serial;
CREATE TABLE topics (
    topic_id serial,
    dateAndTime timestamp NOT NULL,
    topic_title varchar(200) NOT NULL,
    CONSTRAINT PK_topic PRIMARY KEY (topic_id)
);

--CREATE SEQUENCE messages_serial;
CREATE TABLE messages (
    message_id serial,
    dateAndTime timestamp NOT NULL,
    user_id int NOT NULL,
    topic_id int NOT NULL,
    message_title varchar(200) NOT NULL,
    message_text varchar(500) NOT NULL,
    CONSTRAINT PK_message PRIMARY KEY (message_id),
    CONSTRAINT FK_message_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT FK_message_topic_id FOREIGN KEY (topic_id) REFERENCES topics(topic_id)
);


COMMIT TRANSACTION;
