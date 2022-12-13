BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Rob','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Dave','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Mary','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Phil','$2a$10$9dUaeaRfBlPNfc8oOlH9yOhaNHlNLD06O.8Uzz3ZUOLhkAEvoLfxa','ROLE_USER');



INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
	VALUES ('Cat',	'Olive',	True,	True,	True,	'1-11 Months',	'Female',	'They take some warming up to',	'They take some warming up to',	'Napping',	'anything that can be knocked off a table',	'popcorn',	'https://imgur.com/jJtjRpR.jpg', '45219');

INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
	VALUES ('Dog',	'Hobbes',	True,	True,	True,	'4-7 years',	'Male',	'Yes',	'Yes',	'Swimming',	'Ball',	'Bagels',	'https://imgur.com/VHonkVy.jpg', '45201');

INSERT INTO pets(
	animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
	VALUES ('Cat',	'Muffin', 	False,	True,	True,	'1-3 years',	'Male',	'Sometimes','Yes',	'Napping',	'Anything that bounces',	'Chicken',	'https://imgur.com/UMCgC12.jpg', '45242');

INSERT INTO pets(
    animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
    VALUES('Cat', 'Slayton', False, True, True, '1-3 years', 'Male', 'They take some warming up to', 'Yes', 'Fetch', 'Plastic springs', 'Tuna patte', 'https://imgur.com/cfgHvyM.jpg', '45208');

INSERT INTO pets(
    animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
    VALUES('Cat', 'Mishka', True, True, True, '1-11 months', 'Female', 'They take some warming up to', 'Yes', 'Walks', 'Laser pointer', 'Sheba Pate', 'https://imgur.com/shU7viw.jpg', '45216');

INSERT INTO pets(
    animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
    VALUES('Dog', 'Daisy', True, True, True, '4-7 years', 'Female', 'Sometimes', 'Yes', 'Napping', 'Squeaky ball', 'PB bananas', 'https://imgur.com/xsXN5dO.jpg', '45241');

INSERT INTO pets(
    animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
    VALUES('Fish', 'The Don Vito Corleone', 'No', 'No', 'No', '1-11 months', 'Male', 'They take some warming up to', 'They take some warming up to', 'Swimming', 'The blood of his enemies', 'The blood of his enemies','https://imgur.com/qY1qfwi.jpg', '45247');

INSERT INTO pets(
    animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
    VALUES('Dog','Willow', True, True, True, '7-10 years','Female','Sometimes', 'They take some warming up to','Play hunting/wrestling', 'Squeaky lobster', 'PB bananas', 'https://imgur.com/llyXKTN.jpg', '45240');

INSERT INTO pets(
    animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
    VALUES('Dog', 'Baxter', True, True, True, '11+ Years', 'Male', 'Sometimes', 'Yes', 'Walks', 'Bones', 'Cheese', 'https://imgur.com/k6B8xvF.jpg', '45216');

INSERT INTO pets(
    animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
    VALUES('Dog', 'Charlotte', True, True, True, '4-7 years', 'Female','Yes','Yes', 'Walks', 'Plushies', 'Apples/Bananas','https://imgur.com/cAoRNqu.jpg' ,'45241');

INSERT INTO pets(
    animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
    VALUES('Dog', 'Penny', True, True, True, '4-7 years', 'Female', 'Yes', 'Yes', 'Play hunting/wrestling', 'Fake Snake','Liver', 'https://imgur.com/fS0GGe4.jpg', '45211');

INSERT INTO pets(
    animal_type, pet_name, pet_experience, vaccinated, spayed, age_years, sex, pet_friendliness, human_friendliness, favorite_activities, favorite_toy, favorite_treat, img_link, zip_code)
    VALUES('Bearded Dragon', 'Max', False, False, False, '1-3 years', 'Male', 'Yes', 'Yes', 'laying on rocks', 'fake trees', 'crickets','https://imgur.com/V2pry45.jpg' , '45248');

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (1, 1);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (3, 2);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (4, 3);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (4, 4);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (4, 5);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (5, 6);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (5, 7);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (6, 8);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (3, 9);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (1, 10);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (5, 11);

INSERT INTO user_pet(
	user_id, pet_id)
	VALUES (6, 12);



INSERT INTO playDates(
	dateandtime, location, requestmessage)
	VALUES ('2023-06-22 19:10:00-00', 'Pet Play Park', 'Want to go on a pet date?');

INSERT INTO playDates(
	dateandtime, location, requestmessage)
	VALUES ('2023-02-14 15:00:00-00', 'Pet Friendly Dogfe', 'Want to go on a pet date?');

INSERT INTO playDates(
	dateandtime, location, requestmessage)
	VALUES ('2023-1-29 09:30:00-00', 'Washington Park', 'Want to go on a pet date?');



INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (1, 1);

INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (1, 4);

INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (1, 2);

INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (2, 2);

INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (2, 3);

INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (2, 7);

INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (3, 8);

INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (3, 5);

INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (3, 2);

INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (3, 3);

INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (3, 6);

INSERT INTO playdate_pet(
	playdate_id, pet_id)
	VALUES (3, 9);




INSERT INTO topics(dateandtime, topic_title)
	VALUES ('2022-12-02 07:15:00-00', 'What''s the best way to socialize my puppy?');
INSERT INTO topics(dateandtime, topic_title)
	VALUES ('2022-12-04 12:30:05-00', 'My sister''s cat loves to eat butter off the counter, does anyone else''s cat do this too or just him?');
INSERT INTO topics(dateandtime, topic_title)
	VALUES ('2022-12-10 19:10:00-00', 'I think my bearded dragon is upset with me but I don''t know why. Help!');



INSERT INTO messages(
	dateandtime, user_id, topic_id, message_title, message_text)
	VALUES ('2022-12-02 22:22:00-00', 4, 1, 'play with other dogs', 'Get your puppy outside and make sure they play with lots of other dogs so they can get used to different attitudes and behaviors.');
INSERT INTO messages(
	dateandtime, user_id, topic_id, message_title, message_text)
	VALUES ('2022-12-11 20:08:00-00', 5, 3, 'are you sure it''s mad at you?', 'sometimes I feel like my bearded dragon Stacy is mad at me but she''s really just hungry for some flies.');
INSERT INTO messages(
	dateandtime, user_id, topic_id, message_title, message_text)
	VALUES ('2022-12-12 16:29:00-00', 3, 3, 'try getting it a friend', 'My bearded dragon buddy was always down in the dumps until I got him a friend to play with. Now he''s happy all the time');
INSERT INTO messages(
	dateandtime, user_id, topic_id, message_title, message_text)
	VALUES ('2022-12-04 16:44:00-00', 4, 2, 'woah I''d never heard of that', 'I think you''re making that up no offense, you are, aren''t you?');
INSERT INTO messages(
	dateandtime, user_id, topic_id, message_title, message_text)
	VALUES ('2022-12-03 12:43:00-00', 4, 1, 'play with other animals, and take them out often', 'make sure you play with them and introduce them to strangers and other animals. that way they will be used to the world around them');
INSERT INTO messages(
	dateandtime, user_id, topic_id, message_title, message_text)
	VALUES ('2022-12-05 10:15:00-00', 5, 2, 'nah', 'nope you''re the only one');
INSERT INTO messages(
	dateandtime, user_id, topic_id, message_title, message_text)
	VALUES ('2022-12-12 18:10:00-00', 3, 3, 'what did you do', 'It must be mad at you for a reason. If you think really hard, you might be able to remember why it''s upset at you! Then you can mend the bridge between you two.');
INSERT INTO messages(
	dateandtime, user_id, topic_id, message_title, message_text)
	VALUES ('2022-12-04 09:55:00-00', 6, 1, 'why would you want to socialize them', 'I like my puppies not social');
INSERT INTO messages(
	dateandtime, user_id, topic_id, message_title, message_text)
	VALUES ('2022-12-08 02:08:00-00', 4, 2, 'yeah actually it''s so weird!', 'My cats do this too. They are such unique little fluff balls!');
INSERT INTO messages(
	dateandtime, user_id, topic_id, message_title, message_text)
	VALUES ('2022-12-04 15:03:00-00', 5, 1, 'Train them while they''re young!', 'You simply must train them while they are very very young to get the absolute best results possible.');



COMMIT TRANSACTION;

