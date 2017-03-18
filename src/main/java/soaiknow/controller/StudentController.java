package soaiknow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soaiknow.models.RegisterSubject;
import soaiknow.models.Student;
import soaiknow.repository.RegisterSubjectRepository;

import java.util.List;

/**
 * Created by SimonaS on 17/03/2017.
 */

@RestController
public class StudentController {
    @Autowired
    RegisterSubjectRepository registerSubjectRepository;

    @RequestMapping(value = "/studentRegistry")
    public List<RegisterSubject> listStudentRegisters(@RequestParam(value = "student") Student student){
        List<RegisterSubject> registers = registerSubjectRepository.findByStudent(student);
        return registers;
    }
}
