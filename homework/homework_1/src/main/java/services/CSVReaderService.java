package services;

public interface CSVReaderService {

    String readQuestion(int num);
    String getCorrectAnswer(int num);
    int getRecordsAmount();
}
