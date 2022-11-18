package tutorial;

public class HelloWorld {
    static String databaseUrl = "jdbc:mysql://localhost:3306/testing_db";

    static String databaseUsername = "root";
    static String databasePassword = "1234";

    public static String getDatabaseUrl() {return databaseUrl;}

    public static String getDatabaseUsername() {return databaseUsername;}
    public static String getDatabasePassword(){return databasePassword;}

    public static void main(String[] args) {

    }


}
