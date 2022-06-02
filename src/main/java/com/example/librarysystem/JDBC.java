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
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "rootpassword");
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

        query = "INSERT INTO `sys`.`member`" +
                "(`name`,`phone_number`,`address`,`national_id`,`age`,`gender`,`memberid`,`membercol`,`date`)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.setString(1, member.getFullName());
            preparedStmt.setString(2, member.getContactNumber());
            preparedStmt.setString(3, member.getAddress());
            preparedStmt.setString(4, member.getNationalID());
            preparedStmt.setInt(5, member.getAge());
            preparedStmt.setString(6, member.getGender());
            preparedStmt.setInt(7, last);
            preparedStmt.setString(8, member.getMemberCol());
            preparedStmt.setDate(9, (Date) member.getDate());

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

        query = "INSERT INTO `sys`.`book` (code, Name, Author, Quantity, Publisher, Number_Availble, Number_Borrowed, Language"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
                String membercol = resultSet.getString("membercol");
                Date date = resultSet.getDate("date");

                members.add(new Member(fullname, contactNumber, address, nationalID, age, gender, memberid, membercol, date));
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
