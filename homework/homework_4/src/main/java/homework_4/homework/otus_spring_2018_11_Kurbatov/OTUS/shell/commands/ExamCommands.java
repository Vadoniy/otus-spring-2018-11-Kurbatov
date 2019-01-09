package homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.shell.commands;

import homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.shell.commands.services.ExamServiceShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ExamCommands {

    private final ExamServiceShell examShellService;

    @Autowired
    public ExamCommands(ExamServiceShell service){
        this.examShellService = service;
    }

    @ShellMethod("Introduce yourself. Use \"--name\" and \"--last_name\" as an options")
    public String hello(
            @ShellOption String name, @ShellOption String last_name
    ){
        return examShellService.hello(name, last_name);
    }

    @ShellMethod("Start exam")
    public String start(){
        return examShellService.startExam();
    }

    @ShellMethod("Finish exam")
    public void finish(){
        examShellService.finishExam();
    }
}
