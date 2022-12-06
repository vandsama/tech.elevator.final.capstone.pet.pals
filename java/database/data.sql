BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link)
	VALUES ('Cat',	'Little Jullian',	True,	True,	True,	'1-11 Months',	'Female',	'They take some warming up to',	'They take some warming up to',	'Napping',	'anything that can be knocked off a table',	'popcorn',	'https://drive.google.com/open?id=1qVW-5f29tE1t1oKwVjX8uMX31Ztt0ZTn'		);

INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link)
	VALUES ('Dog',	'Hobbes',	True,	True,	True,	'4-7 years',	'Male',	'Yes',	'Yes',	'Swimming',	'Ball',	'Bagels',	'https://drive.google.com/open?id=1ITkonmXvTNlp7utTFBOcnfpxI_L2YJy3'		);

INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link)
	VALUES ('Cat',	'Muffin', 	False,	True,	True,	'1-3 years',	'Male',	'Sometimes',	'Yes',	'Napping',	'Anything that bounces',	'Chicken',	'https://drive.google.com/open?id=1TeiqGFFklmsD89J5D_wRgPXdZ_DhtaKq'		);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (1, 1);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (1, 2);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (1, 3);


COMMIT TRANSACTION;

