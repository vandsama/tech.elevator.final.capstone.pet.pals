BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Rob','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Dave','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_USER');

INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link)
	VALUES ('Cat',	'Olive',	True,	True,	True,	'1-11 Months',	'Female',	'They take some warming up to',	'They take some warming up to',	'Napping',	'anything that can be knocked off a table',	'popcorn',	'https://imgur.com/kuVvJSV.jpg'		);

INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link)
	VALUES ('Dog',	'Hobbes',	True,	True,	True,	'4-7 years',	'Male',	'Yes',	'Yes',	'Swimming',	'Ball',	'Bagels',	'https://imgur.com/VHonkVy.jpg'		);

INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link)
	VALUES ('Cat',	'Muffin', 	False,	True,	True,	'1-3 years',	'Male',	'Sometimes',	'Yes',	'Napping',	'Anything that bounces',	'Chicken',	'https://imgur.com/UMCgC12.jpg'		);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (1, 1);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (1, 2);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (1, 3);

INSERT INTO playDates(
	dateandtime, location, requestmessage, inviter_user_id, inviter_pet_id, invitee_user_id, invitee_pet_id)
	VALUES ('2023-06-22 19:10:00-00', 'Pet Play Park', 'Want to go on a pet date?', 1, 1, 2, 3);

INSERT INTO playDates(
	dateandtime, location, requestmessage, inviter_user_id, inviter_pet_id, invitee_user_id, invitee_pet_id)
	VALUES ('2023-02-14 15:00:00-00', 'Pet Friendly Dogfe', 'Want to go on a pet date?', 3, 1, 4, 2);

INSERT INTO playDates(
	dateandtime, location, requestmessage, inviter_user_id, inviter_pet_id, invitee_user_id, invitee_pet_id)
	VALUES ('2023-1-29 09:30:00-00', 'Washington Park', 'Want to go on a pet date?', 4, 2, 2, 3);

COMMIT TRANSACTION;

