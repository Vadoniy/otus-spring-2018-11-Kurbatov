package homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.shell.commands.services.impl;

import homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.services.ExamService;
import homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl.MessageResourceImpl;
import homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.shell.commands.services.ExamServiceShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class ExamServiceShellImpl implements ExamServiceShell {

    private MessageResourceImpl ms;
    private ExamService examService;
    private String name;
    private String last_name;
    private boolean isAccessed;

    @Autowired
    public ExamServiceShellImpl(MessageResourceImpl ms, ExamService examService){
        this.ms = ms;
        this.examService = examService;
    }

    @Override
    public String hello(String name, String last_name) {

        isAccessed = (name.length()>0 && last_name.length()>0) ? true : false;

        if (!isAccessed){
            return String.format(ms.getI18nString("introducingError"));
        } else {
            this.name = name;
            this.last_name = last_name;
            return String.format(ms.getI18nString("takeQuestion"), name, last_name);
        }
    }

    @Override
    public String startExam() {
        if (isAccessed){
            examService.setNameAndSurname(name, last_name);
            examService.run();
        } else {
            return ms.getI18nString("introducingError");
        }
        return examService.getResult();
    }

    @Override
    public void finishExam() {
        examService.finish();
    }
}
