package services;

import domain.Exam;
import utils.Constants;

import java.util.Scanner;

public class ExamServiceImpl implements ExamService {

    private CSVReaderService csvReaderService;
    private Exam ex;
    private String answer;

    public ExamServiceImpl(CSVReaderService csvReaderService){
        this.csvReaderService = csvReaderService;
    }

    @Override
    public void run() {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println(Constants.GREETINGS);
            String name = sc.nextLine();
            String last_name = sc.nextLine();

            for (int i = 0; i < csvReaderService.getRecordsAmount(); i++){
                    csvReaderService.readQuestion(i);
                ex.takeQuestion(i);
                answer = sc.nextLine();
                ex.setAnswer(answer, i);
            }

            ex.getResult(name, last_name, csvReaderService.getRecordsAmount());
        }
    }
}
