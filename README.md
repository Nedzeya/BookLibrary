# Book Libraru
#
## The Book Library web application allows you to register readers, issue books to them, and release books (after the reader returns the book back to the library). There is pagination for books, sorting books by year, book search page by title. There is also an automatic check to see if a person is overdue to return a book.
#
### There is a page with a list of all people, where you can add a new reader (people are clickable - clicking on them will take you to the person's page).
![File_of_people_list](documents/pictures/PeopleList.png)
#
### A page with a list of all books (books are clickable - when you click on them you go to the book page).
![File_of_book_list](documents/pictures/BookList.png)
#
### A person's page, showing the values of their fields and a list of the books they have borrowed.
![File_of_person_with_books](documents/pictures/PersonWithBook.png)
#
### *If a person hasn't picked up a single book:
![File_of_person_without_books](documents/pictures/PersonWithoutBook.png)
#
### A page of a book that shows the field values of that book and the name of the person, who picked up the book.
![File_of_taken_book](documents/pictures/TakenBook.png)
#
### *If this book hasn't been taken by anyone:
![File_of_free_book](documents/pictures/FreeBook.png)
#
### The person edit page
![File_of_person_edit](documents/pictures/EditPerson.png)
#
### Book edit page
![File_of_book_edit](documents/pictures/EditBook.png)
#
#
### The list of books can be paginated by specifying the number of pages and the number of books on one page
![File_of_book_edit](documents/pictures/BooksPageBooks_per_page.png)
#
#
### It is possible to sort books by year
![File_of_book_edit](documents/pictures/BooksSortByYear.png)
#
#
### Search for books by title or author (full or part)
![File_of_book_edit](documents/pictures/BooksSearch.png)
#
#
### An automatic check to see if a person is overdue for a book return. The book is highlighted in red
![File_of_book_edit](documents/pictures/BookOverdueRed.png)
#
***Re-additions of a person with already existing data (full name and year of birth) are not allowed. 
The book can be taken by a person over 6 years of age. 
One book can only belong to one person. 
Entering the name of the author of the book is not obligatory.
The deadline for returning a book is 10 days.***

____
*Java 11.0.0.1
____
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)  ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)  ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)  ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)  ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)  ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)  ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)  ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-8A2BE2?style=for-the-badge&logo=Spring-Data-JPA&logoColor=white)
