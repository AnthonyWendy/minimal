CREATE OR REPLACE FUNCTION set_registration_date()
RETURNS TRIGGER AS $$
BEGIN
    NEW.registration_date := NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER before_insert_record
BEFORE INSERT ON record
FOR EACH ROW
EXECUTE FUNCTION set_registration_date();