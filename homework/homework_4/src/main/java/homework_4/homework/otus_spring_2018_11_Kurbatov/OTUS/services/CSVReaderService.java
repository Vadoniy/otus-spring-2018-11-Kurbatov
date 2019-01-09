package homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.services;

public interface CSVReaderService {
    String readQuestion(int num);
    String getCorrectAnswer(int num);
    int getRecordsAmount();
    boolean checkAnswer(String answer, int num);
}