package soaiknow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soaiknow.models.RegisterSubject;
import soaiknow.models.Student;
import soaiknow.models.Subject;
import soaiknow.models.User;
import soaiknow.repository.RegisterSubjectRepository;
import soaiknow.repository.SubjectRepository;
import soaiknow.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimonaS on 17/03/2017.
 */

@RestController
@RequestMapping(value = "/")
public class StudentController {

    @Autowired
    private RegisterSubjectRepository registerSubjectRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @RequestMapping(value = "studentRegistry")
    public List<RegisterSubject> listStudentRegisters(@RequestParam(value = "student") long id){
        User user = userRepository.findOne(id);
        List<RegisterSubject> registers = registerSubjectRepository.findByStudent(user);
        return registers;
    }
    @RequestMapping(value = "personalInfo")
    public String personInfo(@RequestParam(value = "student") long id){
        User user = userRepository.findOne(id);
        return user.getPersonalinfo();
    }

    @RequestMapping(value = "listSubjects")
    public List<Subject> listSubjects(){
        List<Subject> subjects = new ArrayList<>();
        subjectRepository.findAll().forEach(subjects::add);
        return subjects;
    }
}
