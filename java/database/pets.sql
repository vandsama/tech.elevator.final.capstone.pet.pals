BEGIN TRANSACTION;

DROP TABLE IF EXISTS pets;

CREATE TABLE pets (
pet_id serial,
pet_name varchar(50) NOT NULL,
animal_type varchar(50) NOT NULL,
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
CONSTRAINT FK_user FOREIGN KEY (pet_id) REFERENCES user_pet (pet_id)
);

COMMIT TRANSACTION;