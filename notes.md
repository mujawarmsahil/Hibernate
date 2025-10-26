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
    6. @Embeddable - This is used with a subclass which is used as field in another class.
        This annotation is basically fetch all the details present in the sub class and store it in the DB in which the parent class is being stored.

        For ex :-
        ```java
            @Embeddable
            Class Laptop{
                String model;
                int ram;
            }
            
            @Entity
            Class Alien{
                @ID
                int id;
                String name;
                String tech;
            }

            public class SomethingWhichStoresInDB{
                // All the configuration part and object instantiation of Alien and Laptop
                session.persist(alien); // alien is a instance which laptop is present
            }
        ```

        ```
           --------------Alien-----------------
            Id Name Tech model ram
        ```

# Mapping
    -   Mapping refers to maintaining relationships between tables using primary keys and foreign keys.
    -   There are four types of mappings in database relationships:
        -   One-to-One Mapping
        -   One-to-Many Mapping
        -   Many-to-One Mapping
        -   Many-to-Many Mapping

    1. One-to-One Mapping
        In a one-to-one relationship, a record in one table is linked to exactly one record in another table.
        This is achieved when a table contains a foreign key that is also a primary key in the referenced table, and no duplicate foreign keys exist.
        Example:    A person uses a laptop for personal use. Each person has exactly one laptop, and each laptop belongs to only one person.

                Person ID   ---------- has ----------   Laptop ID
                101         --------------------------   201
                102         --------------------------   202
                103         --------------------------   203

    2. One-to-Many Mapping
        In this relationship, a single record in one table is associated with multiple records in another table.
        The foreign key column contains duplicate values to represent multiple links.
        Example:    A single user owns multiple laptops.

                Person ID   ---------- has ----------   Laptop ID
                101         --------------------------   201
                101         --------------------------   202
                101         --------------------------   203

    3. Many-to-One Mapping
        This is the reverse of one-to-many.
        Multiple records in one table are linked to a single record in another table.
        Example:    Multiple users use the same laptop.

                Person ID   ---------- has ----------   Laptop ID
                101         --------------------------   201
                102         --------------------------   201
                103         --------------------------   201

    4. Many-to-Many Mapping
        In a many-to-many relationship, multiple records in one table can relate to multiple records in another table.
        A third table (junction table) is usually used to establish this relationship.
        Example:    Students using PCs in a computer lab — each student can use multiple PCs, and each PC can be used by multiple students.
            
            Student ID   ---------- uses ----------   PC ID
            101          --------------------------   201
            101          --------------------------   202
            102          --------------------------   201
            103          --------------------------   202