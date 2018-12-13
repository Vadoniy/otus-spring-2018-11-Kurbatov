package homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl;

import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.services.CSVReaderService;
import homework_2.homework.otus_spring_2018_11_Kurbatov.OTUS.utils.Constants;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Service
public class CSVReaderServiceImpl implements CSVReaderService {
    private CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader();
    private Reader input = null;
    private CSVParser csvFileParser = null;
    private List<CSVRecord> csvRecords = null;
    private int recordsAmount;

    public CSVReaderServiceImpl() throws IOException {
        input = new FileReader(Constants.FILE_PATH);
        csvFileParser = new CSVParser(input, csvFileFormat);
        csvRecords = csvFileParser.getRecords();
        recordsAmount = csvRecords.size();
    }

    //For tests
    public CSVReaderServiceImpl(String testPath) throws IOException {
        input = new FileReader(testPath);
        csvFileParser = new CSVParser(input, csvFileFormat);
        csvRecords = csvFileParser.getRecords();
        recordsAmount = csvRecords.size();
    }

    @Override
    public String readQuestion(int num){
        return String.format(Constants.QUESTION_TEMPLATE, csvRecords.get(num).get("QUESTION").toString(),
                csvRecords.get(num).get("ANSWERA").toString(),
                csvRecords.get(num).get("ANSWERB").toString(),
                csvRecords.get(num).get("ANSWERC").toString(),
                csvRecords.get(num).get("ANSWERD").toString());
    }

    @Override
    public String getCorrectAnswer(int num){
        return csvRecords.get(num).get("RIGHTANSWER");
    }

    public boolean checkAnswer(String answer, int num){
        return csvRecords.get(num).get("RIGHTANSWER").equalsIgnoreCase(answer);
    }

    @Override
    public int getRecordsAmount() {
        return recordsAmount;
    }
}
