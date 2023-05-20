/*
 * 5. Write a Java application which reads a set of text files that contain
 * students data (CSV files). The files are stored on the local machine under
 * the names Year_Y_Group_XXXX.txt. Aggregate the information in these files
 * using a SequenceInputStream and generate a new file which contains all the
 * students ordered alphabetically.
 */

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lab8_Ex5_FufezanMihai {
    public static void main(String[] args) throws IOException {
        List<List<String>> records = new ArrayList<>();

        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("regex:src/Year_[0-4]{1}_Group_[0-9]{4}.txt");
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(new File("src").toPath(), pathMatcher::matches)) {
            List<List<String>> finalRecords = records;
            dirStream.forEach(path -> {
                System.out.println(path.toString());
                try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile())))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(",");
                        finalRecords.add(Arrays.asList(values));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(records);
            List<String> header = new ArrayList<>();
            header.add("name");
            header.add("grade");
            records = (List<List<String>>) records.stream().filter(obj -> !Objects.equals(obj, header));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
