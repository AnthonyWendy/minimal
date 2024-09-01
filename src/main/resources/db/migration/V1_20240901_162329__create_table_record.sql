CREATE TABLE IF NOT EXISTS "record" (
	"id" serial NOT NULL UNIQUE,
	"type" varchar(7) NOT NULL,
	"value" numeric(15,2) NOT NULL,
	"paid" boolean NOT NULL,
	"category_id" bigint NOT NULL,
	"bank_id" bigint NOT NULL,
	"payment_date" timestamp with time zone NOT NULL,
	"registretion_date" timestamp with time zone NOT NULL,
	PRIMARY KEY ("id")
);