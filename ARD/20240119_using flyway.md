for migrate the newest version of the database
The name of version must follow syntax => "V<version>_<minor-version>__<brief>.sql
E.g.:
    - V1_001__Pokemon_Table.sql
    - V1_xxx__fix_bug.sql
    - V2_xxx__new_feature.sql


some commands in postgres:

1. \c pokemon_db admin
2. select current_user;
3. \du -> list existing roles
4. \dn -> list existing schemas
5. \c pokemon_db postgres
6. GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO admin;
7. \c pokemon_db admin
8. CREATE TABLE foo (id int); #test permission to create new table on public