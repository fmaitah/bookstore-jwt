
-- Insert data into the bookstore table
INSERT INTO "bookstore" ("name", "phone_number", "email", "location", "type")
VALUES ('Book Haven', '0790267193', 'bookhaven@example.com', 'Abu Nseir, Amman', 1),
       ('The Movies Store', '0795215678', 'themoviesstore@example.com', 'Dabouq, Amman', 0),
       ('Tech Bookstore', '0795179012', 'techbookstore@example.com', 'Nasser, Amman', 2),
       ('Children Bookstore', '0795123445', 'childrenbookstore@example.com', 'Jubeiha, Amman', 3);

-- Insert data into the book table
INSERT INTO "book" ("title", "author", "price")
VALUES ('The Alchemist', 'Paulo Coelho', 20.5),
       ('The Da Vinci Code', 'Dan Brown', 18.0),
       ('Harry Potter and the Philosopher''s Stone', 'J.K. Rowling', 25.0),
       ('The Lord of the Rings', 'J.R.R. Tolkien', 30.0),
       ('J.K. Rowling', 'Harry Potter and the Sorcerer Stone', 15.99),
       ('J.R.R. Tolkien', 'The Hobbit', 12.99),
       ('George Orwell', '1984', 9.99),
       ('J.D. Salinger', 'The Catcher in the Rye', 8.99),
       ('Leo Tolstoy', 'War and Peace', 11.99),
       ('F. Scott Fitzgerald', 'The Great Gatsby', 10.99),
       ('Mark Twain', 'The Adventures of Tom Sawyer', 7.99),
       ('Jane Austen', 'Pride and Prejudice', 8.99),
       ('Ernest Hemingway', 'The Old Man and the Sea', 9.99),
       ('Gabriel Garcia Marquez', 'One Hundred Years of Solitude', 12.99);


-- Insert data into the bookstore_book table
INSERT INTO "bookstore_book" ("store_id", "book_id")
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (3, 3),
       (3, 4),
       (4, 1),
       (4, 4),
       (1, 5),
       (1, 6),
       (2, 7),
       (2, 8),
       (3, 9),
       (3, 10),
       (4, 1),
       (4, 2),
       (4, 3),
       (4, 4);
