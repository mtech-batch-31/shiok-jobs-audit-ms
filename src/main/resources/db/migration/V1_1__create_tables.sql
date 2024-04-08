CREATE TABLE IF NOT EXISTS sjmsaudit.audit_trail
(
    id serial PRIMARY KEY,
    account_uuid VARCHAR(255) NOT NULL,
    access_time timestamp(6) NOT NULL,
    event character varying(255) NOT NULL,
    status character varying(255) NOT NULL,
    message character varying(255)  NULL,
    data character varying  NULL
);