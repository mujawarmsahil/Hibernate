# Annotations & property names

## hibernate.cfg.xml
    - hibernate.hbm2ddl.auto : 
            1) create : Drop if table exists and create a new one every time then adds data
            2) update : Create table if not exist and update the values.
    - hibernate.dialect : 
        -   Dialect changes as the DB changes.
    
## Entities
    1. @Entity - used to define that this is an entity which helps hibernate to get name and use the fields while manipulating the DB
            - Additionally it takes name parameter which is used to define a different name than entity present
    2. @Id - if we define any field of entity as id then it considered as Primary key
    3. @Table - This is used to define that a particular class is a table in DB
    4. @Column - This is used to define that particular field is a column  of following table in DB
    5. @Transient - This is used to define a field as a non-required one which means it can be or cannot be defined while storing the data into the DB