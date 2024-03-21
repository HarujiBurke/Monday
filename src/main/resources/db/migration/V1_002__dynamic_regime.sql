-- V1_002_dynamic_regime.sql

-- Create table for dynamic regime
CREATE TABLE IF NOT EXISTS entity(
    id SERIAL PRIMARY KEY,
    uid VARCHAR(255),
    type VARCHAR(50),
    data TEXT
);

CREATE TABLE IF NOT EXISTS record (
    id SERIAL PRIMARY KEY,
    entityUID VARCHAR(150),
    data TEXT
);

CREATE TABLE IF NOT EXISTS acl(
    id SERIAL PRIMARY KEY,
    sourceUID VARCHAR(255),
    targetUID VARCHAR(255),
    data TEXT
);

CREATE TABLE IF NOT EXISTS relation(
   id SERIAL PRIMARY KEY,
   sourceUID VARCHAR(255),
   targetUID VARCHAR(255),
   data TEXT
);