import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GitClone {

    private String url;

    public GitClone(String url) {
        this.url = url;
    }

    public void clone_repo() {
        String command = "git clone " + this.url;

        Process process = null;
        try {
            process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }
}
