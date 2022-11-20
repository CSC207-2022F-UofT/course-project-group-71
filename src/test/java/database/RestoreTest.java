package database;

import java.io.IOException;

public class RestoreTest {
    public static void main(String[] args) throws IOException {
        restoreDB("testing_db", "root", "1234", "G:\\Projects\\CSC207 File\\course-project-group-71\\src\\test\\java\\database\\sql_file_to_import\\testing_db.sql");
    }
    public static boolean restoreDB(String dbName, String dbUserName, String dbPassword, String source) throws IOException {
        String[] executeCmd = new String[]{"mysql", "--user=" + dbUserName, "--password=" + dbPassword, dbName,"-e", " source "+source};
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("Backup restored successfully");
                return true;
            } else {
            System.out.println("Could not restore the backup");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
        return false;
}
}
