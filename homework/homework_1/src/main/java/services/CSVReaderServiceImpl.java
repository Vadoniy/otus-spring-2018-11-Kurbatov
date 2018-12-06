package services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import utils.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CSVReaderServiceImpl implements CSVReaderService {
    private CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader();
    private Reader input = null;
    private String question = "%s\n\na) %s;\nb)%s;\nc)%s;\nd)$s;";
    private CSVParser csvFileParser = null;
    private List<CSVRecord> csvRecords = null;
    private int recordsAmount;

    public CSVReaderServiceImpl() throws IOException {
        input = new FileReader(Constants.FILE_PATH);
        csvFileParser = new CSVParser(input, csvFileFormat);
        csvRecords = csvFileParser.getRecords();
        recordsAmount = csvRecords.size();
    }

    public void init() throws IOException {
        input = new FileReader(Constants.FILE_PATH);
        csvFileParser = new CSVParser(input, csvFileFormat);
        csvRecords = csvFileParser.getRecords();
        recordsAmount = csvRecords.size();
    }

    public String readQuestion(int num){
        return String.format(question, csvRecords.get(num).get("QUESTION").toString(),
                csvRecords.get(num).get("ANSWERA").toString(),
                csvRecords.get(num).get("ANSWERB").toString(),
                csvRecords.get(num).get("ANSWERC").toString(),
                csvRecords.get(num).get("ANSWERD").toString());
    }

    public String getCorrectAnswer(int num){
        return csvRecords.get(num).get("RIGHTANSWER");
    }

    public boolean checkAnswer(String answer, int num){
        return csvRecords.get(num).get("RIGHTANSWER").equalsIgnoreCase(answer);
    }

    public int getRecordsAmount() {
        return recordsAmount;
    }
}
