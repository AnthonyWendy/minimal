
CREATE TABLE IF NOT EXISTS "bank" (
	"id" serial NOT NULL UNIQUE,
	"name" varchar(25) NOT NULL,
	"icon" varchar(255) NOT NULL,
	PRIMARY KEY ("id")
);