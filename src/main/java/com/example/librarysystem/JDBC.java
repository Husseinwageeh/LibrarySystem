package com.example.librarysystem;
import java.sql.*;
import java.util.ArrayList;

public class JDBC {

    private static Connection conn;
    private static JDBC jdbc;

    private JDBC() {

    }

    public static JDBC getInstance() {

        if (jdbc == null)
            jdbc = new JDBC();
        return jdbc;
    }

    private void connect() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "toor");
    }

    private void disconnect() throws SQLException {
        conn.close();
    }

    public boolean memberExists(int memberid) throws SQLException {
        jdbc.connect();

        String query = "SELECT * FROM member WHERE memberid = " + memberid;

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if(resultSet.next()) {
            jdbc.disconnect();
            return true;
        }

        jdbc.disconnect();
        return false;
    }

    // TODO: 6/2/2022
    public void addMember(Member member) throws SQLException {
        if(memberExists(member.getMemberID())) {
            //throw new UserExistsException();
        }
        jdbc.connect();
        //Generating member ID:
        //1.Getting last member ID
        String query = "SELECT max(memberid) FROM member";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        int last = -1;
        try {
            while(resultSet.next()) {
                last = resultSet.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //2.Incrementing it by one
        last++;

        query = "INSERT INTO `root`.`member`" +
                "(`name`,`phone_number`,`address`,`national_id`,`age`,`gender`,`memberid`,`date`,`borrowed_book`)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.setString(1, member.getFullName());
            preparedStmt.setString(2, member.getContactNumber());
            preparedStmt.setString(3, member.getAddress());
            preparedStmt.setString(4, member.getNationalID());
            preparedStmt.setInt(5, member.getAge());
            preparedStmt.setString(6, member.getGender());
            preparedStmt.setInt(7, last);
            preparedStmt.setString(9, member.getBorrowedbook());
            preparedStmt.setString(8, member.getDate());

            preparedStmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            jdbc.disconnect();
        }
    }
    public void addBook(Book book) throws SQLException {

        jdbc.connect();

        //Generating Book ID(code):
        //1.Getting last Book ID
        String query = "SELECT max(code) FROM book";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        int last =-1;
        try {
            while(resultSet.next()) {
                last = resultSet.getInt(1);
                System.out.println("hi");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //2.Incrementing it by one
        last++;
        System.out.println(last);
        query = "INSERT INTO `root`.`book`" + " (code, Name, Author, Quantity, Publisher, Number_Availble, Number_Borrowed, Language)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.setInt(1, last);
            preparedStmt.setString(2, book.getTitle());
            preparedStmt.setString(3, book.getAuthor());
            preparedStmt.setInt(4, book.getQuantity());
            preparedStmt.setString(5, book.getPublisher());
            preparedStmt.setInt(6, book.getNumAvailable());
            preparedStmt.setInt(7, book.getNumBorrowed());
            preparedStmt.setString(8, book.getLanguage());

            preparedStmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            jdbc.disconnect();
        }
    }

    public ArrayList<Member> getAllMembers() throws SQLException {

        jdbc.connect();
        ArrayList<Member> members = new ArrayList<>();
        String query = "SELECT * FROM member ";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        try{

            while(resultSet.next()){

                String fullname = resultSet.getString("name");
                String contactNumber = resultSet.getString("phone_number");
                String address = resultSet.getString("address");
                String nationalID = resultSet.getString("national_id");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                int memberid = resultSet.getInt("memberid");
                String borrowedbook = resultSet.getString("borrowed_book");
                String date = resultSet.getString("date");

                members.add(new Member(fullname, contactNumber, address, nationalID, age, gender, memberid, borrowedbook, date ));
            }

        } catch(Exception e){
            System.out.println(e.getMessage());

        } finally {
            jdbc.disconnect();
        }
        return members;
    }

    public ArrayList<Book> getAllBooks() throws SQLException {

        jdbc.connect();
        ArrayList<Book> books = new ArrayList<>();
        String query = "SELECT * FROM book ";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        try{

            while(resultSet.next()){

                int book_ID = resultSet.getInt("code");
                String title = resultSet.getString("Name");
                String author = resultSet.getString("Author");
                String language = resultSet.getString("Language");
                String publisher = resultSet.getString("Publisher");
                int quantity = resultSet.getInt("Quantity");
                int numAvailable = resultSet.getInt("Number_Availble");
                int numBorrowed = resultSet.getInt("Number_Borrowed");

                books.add(new Book(book_ID, title, author, language, publisher, quantity, numAvailable, numBorrowed) );
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
            jdbc.disconnect();
        }
        return books;
    }

    public ArrayList<Book> getAllBorrowedBooks() throws SQLException {

        jdbc.connect();
        ArrayList<Book> borrowedBooks = new ArrayList<>();
        String query = "SELECT * FROM book WHERE Number_Borrowed > 0";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        try{

            while(resultSet.next()){

                int book_ID = resultSet.getInt("code");
                String title = resultSet.getString("Name");
                String author = resultSet.getString("Author");
                String language = resultSet.getString("Language");
                String publisher = resultSet.getString("Publisher");
                int quantity = resultSet.getInt("Quantity");
                int numAvailable = resultSet.getInt("Number_Availble");
                int numBorrowed = resultSet.getInt("Number_Borrowed");

                borrowedBooks.add(new Book(book_ID, title, author, language, publisher, quantity, numAvailable, numBorrowed) );
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
            jdbc.disconnect();
        }
        return borrowedBooks;
    }

    public ArrayList<Book> getAvailableBooks() throws SQLException {

        jdbc.connect();
        ArrayList<Book> borrowedBooks = new ArrayList<>();
        String query = "SELECT * FROM book WHERE Number_Availble > 0";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        try {

            while (resultSet.next()) {

                int book_ID = resultSet.getInt("code");
                String title = resultSet.getString("Name");
                String author = resultSet.getString("Author");
                String language = resultSet.getString("Language");
                String publisher = resultSet.getString("Publisher");
                int quantity = resultSet.getInt("Quantity");
                int numAvailable = resultSet.getInt("Number_Availble");
                int numBorrowed = resultSet.getInt("Number_Borrowed");

                borrowedBooks.add(new Book(book_ID, title, author, language, publisher, quantity, numAvailable, numBorrowed));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            jdbc.disconnect();
        }
        return borrowedBooks;
    }

    public int[] getNum(String bookName) throws SQLException { //Get Available and Borrowed number of a certain book
                                                               //(Helper Function)
        jdbc.connect();
        ArrayList<Book> borrowedBooks = new ArrayList<>();
        String query = "SELECT * FROM book WHERE Name = '" + bookName+"'";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        int[] available_borrowed = {-1 , -1};

        try{

            while(resultSet.next()){

                int numAvailable = resultSet.getInt("Number_Availble");
                int numBorrowed = resultSet.getInt("Number_Borrowed");
                if(numAvailable != 0)
                {
                    available_borrowed[0] = numAvailable-1;
                    available_borrowed[1] = numBorrowed+1;
                    return available_borrowed;
                }

            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return available_borrowed;
    }

    public void borrowBook(String memberName, String bookName) throws SQLException {

        jdbc.connect();
        String query = "UPDATE member SET borrowed_book = '" + bookName +"'"+ "WHERE name = '" + memberName+"'";

        int[] available_borrowed = getNum(bookName); // Calling the helper function above;

        String query2 = "UPDATE book SET Number_Availble = " + (available_borrowed[0]) + ", Number_Borrowed = "+ available_borrowed[1] + " WHERE Name = '" + bookName+ "'";
        System.out.println(query2);
        Statement statement = conn.createStatement();

        try {
            System.out.println(available_borrowed[0]);
            if(available_borrowed[0] == -1)
                throw new Exception("No Numbers Available!");

            int resultSet = statement.executeUpdate(query);

            statement.executeUpdate(query2);


        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            jdbc.disconnect();
        }

    }

    public void deleteMember(Member member) throws SQLException {
        jdbc.connect();
        String query = "DELETE FROM member WHERE memberid = " + member.getMemberID();
        Statement statement = conn.createStatement();
        try {
            int resultSet = statement.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e.getMessage());

        } finally {
            jdbc.disconnect();
        }
    }

    public void deleteBook(Book book) throws SQLException {
        jdbc.connect();
        String query = "DELETE FROM book WHERE code = " + book.getBook_ID();
        Statement statement = conn.createStatement();
        try {
            int resultSet = statement.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e.getMessage());

        } finally {
            jdbc.disconnect();
        }
    }

}
