package homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.services;

public interface ExamService {
    void run();
    void setNameAndSurname(String name, String last_name);
    String getResult();
    void finish();
}