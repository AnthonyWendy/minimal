ALTER TABLE "record" ADD CONSTRAINT "record_fk_category" FOREIGN KEY ("category_id") REFERENCES "category" ("id");

ALTER TABLE "record" ADD CONSTRAINT "record_fk_bank" FOREIGN KEY ("bank_id") REFERENCES "bank"("id");