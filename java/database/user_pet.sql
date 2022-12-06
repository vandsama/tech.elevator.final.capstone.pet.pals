BEGIN TRANSACTION;

DROP TABLE IF EXISTS user_pet;

CREATE TABLE user_pet(
user_id int NOT NULL,
pet_id int NOT NULL,
CONSTRAINT PK_user_pet PRIMARY KEY(user_id, pet_id),
CONSTRAINT FK_user_pet_user FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT FK_user_pet_pet FOREIGN KEY(pet_id) REFERENCES pets(pet_id)
);

COMMIT TRANSACTION;