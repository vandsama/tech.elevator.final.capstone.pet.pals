BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Rob','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Dave','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_USER');



INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
	VALUES ('Cat',	'Olive',	True,	True,	True,	'1-11 Months',	'Female',	'They take some warming up to',	'They take some warming up to',	'Napping',	'anything that can be knocked off a table',	'popcorn',	'https://imgur.com/kuVvJSV.jpg', '45219');

INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
	VALUES ('Dog',	'Hobbes',	True,	True,	True,	'4-7 years',	'Male',	'Yes',	'Yes',	'Swimming',	'Ball',	'Bagels',	'https://imgur.com/VHonkVy.jpg', '45201');

INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
	VALUES ('Cat',	'Muffin', 	False,	True,	True,	'1-3 years',	'Male',	'Sometimes','Yes',	'Napping',	'Anything that bounces',	'Chicken',	'https://imgur.com/UMCgC12.jpg', '45242');



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



INSERT INTO topics(
	topic_title)
	VALUES ('What''s the best way to socialize my puppy?');
INSERT INTO topics(
	topic_title)
	VALUES ('My sister''s cat loves to eat butter off the counter, does anyone else''s cat do this too or just him?');
INSERT INTO topics(
	topic_title)
	VALUES ('I think my bearded dragon is upset with me but I don''t know why. Help!');



INSERT INTO messages(
	message_id, user_id, topic_id, message_title, message_text)
	VALUES (1, 1, 1, 'play with other dogs', 'Get your puppy outside and make sure they play with lots of other dogs so they can get used to different attitudes and behaviors.');
INSERT INTO messages(
	message_id, user_id, topic_id, message_title, message_text)
	VALUES (2, 2, 3, 'are you sure it''s mad at you?', 'sometimes I feel like my bearded dragon Stacy is mad at me but she''s really just hungry for some flies.');
INSERT INTO messages(
	message_id, user_id, topic_id, message_title, message_text)
	VALUES (3, 3, 3, 'try getting it a friend', 'My bearded dragon buddy was always down in the dumps until I got him a friend to play with. Now he''s happy all the time');
INSERT INTO messages(
	message_id, user_id, topic_id, message_title, message_text)
	VALUES (4, 4, 2, 'ridiculous', 'I think you''re making that up no offense, you are, aren''t you?');
INSERT INTO messages(
	message_id, user_id, topic_id, message_title, message_text)
	VALUES (5, 1, 1, 'play with other animals, and take them out often', 'make sure you play with them and introduce them to strangers and other animals. that way they will be used to the world around them');
INSERT INTO messages(
	message_id, user_id, topic_id, message_title, message_text)
	VALUES (6, 2, 2, 'nah', 'nope you''re the only one');
INSERT INTO messages(
	message_id, user_id, topic_id, message_title, message_text)
	VALUES (7, 3, 3, 'what did you do', 'It must be mad at you for a reason. If you think really hard, you might be able to remember why it''s upset at you! Then you can mend the bridge between you two.');
INSERT INTO messages(
	message_id, user_id, topic_id, message_title, message_text)
	VALUES (8, 4, 1, 'why would you want to socialize them', 'I like my puppies not social');
INSERT INTO messages(
	message_id, user_id, topic_id, message_title, message_text)
	VALUES (9, 1, 2, 'yeah actually it''s so weird!', 'My cats do this too. They are such unique little fluff balls!');
INSERT INTO messages(
	message_id, user_id, topic_id, message_title, message_text)
	VALUES (10, 2, 1, 'Train them while they''re young!', 'You simply must train them while they are very very young to get the absolute best results possible.');



COMMIT TRANSACTION;

