CREATE TABLE IF NOT EXISTS "category" (
	"id" serial NOT NULL UNIQUE,
	"name" varchar(50) NOT NULL,
	"color" varchar(10) NOT NULL,
	"icon" varchar(255) NOT NULL,
	PRIMARY KEY ("id")
);