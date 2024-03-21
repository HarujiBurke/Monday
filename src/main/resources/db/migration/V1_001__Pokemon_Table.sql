-- V1_001__Pokemon_Table.sql

-- Create Pokemon table
CREATE TABLE IF NOT EXISTS pokemon (
    id SERIAL PRIMARY KEY,
    uid VARCHAR(255),
    name VARCHAR(255),
    type VARCHAR(255),
    height INT,
    weight INT,
    abilities TEXT
);

CREATE SEQUENCE IF NOT EXISTS pokemon_seq START 1;