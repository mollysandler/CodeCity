import java.io.*;
import java.nio.file.Files;
import java.util.regex.*;
import org.json.JSONObject;

public class Parsing {
    public static JSONObject loadData(String fileEntry){ //main method

        File inputFile = new File(fileEntry);
        JSONObject result = new JSONObject(); //result with classes and their details
        File[] files;

        // Check if the file entry is dir
        if(inputFile.isDirectory()) { //if input is a dir, grab all files from that dir
            files = inputFile.listFiles((dir, name) -> name.endsWith(".java"));
        }else{ //if not dir, then just set files to our single input, if empty will just return empty jsonObject
            files = new File[1];
            files[0] = inputFile;
        }

        assert files != null;
        for(File file: files){ //for each file grab the json data from each class

            JSONObject classData = fileParser(file); //returns loc and localvars from class

            result.put(file.getName(), classData); //add class with its respective data

        }

        return result;

    }

    private static JSONObject fileParser(File inputFile){
        JSONObject classDetails = new JSONObject();
        //JSONObject result = new JSONObject();

        try {

            long lineCount = Files.lines(inputFile.toPath()).count();

            //pattern for local variables
            Pattern pattern = Pattern.compile("\\b(int|long|double|float|char|boolean|String)\\s+\\w+\\s*(=\\s*[^;]+)?;");

            //create a matcher that will find matches of a given pattern
            Matcher matcher = pattern.matcher(Files.readString(inputFile.toPath()));

            int localCount = 0;
            while (matcher.find()) {
                localCount++;
            }


            classDetails.put("loc", lineCount);
            classDetails.put("localVars", localCount);

            return classDetails;


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}