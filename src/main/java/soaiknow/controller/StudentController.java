package soaiknow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soaiknow.models.*;
import soaiknow.repository.RegisterSubjectRepository;
import soaiknow.repository.SemesterRepository;
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

    @Autowired
    private SemesterRepository semesterRepository;


    @RequestMapping(value = "studentRegistry")
    public List<RegisterSubject> listStudentRegisters(@RequestParam(value = "student") long id){
        User user = userRepository.findOne(id);
        return user.getRegisterSubjects();
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
    @RequestMapping(value = "semestars")
     public List<Semester> listSemestars(@RequestParam(value = "student") long id){
        User user = userRepository.findOne(id);
        return user.getSemesters();
    }

    @RequestMapping(value = "insertSemestar", method = RequestMethod.POST)
    public Semester registration(@RequestParam("name") String name,
                                @RequestParam("field") String field,
                                @RequestParam("quota") String quota,
                                 @RequestParam("paid") double paid,
                                @RequestParam("price") double price){
        Semester semester = new Semester();
        semester.setName(name);
        semester.setAreTaxesPaid(false);
        semester.setField(field);
        semester.setIsRegistered(true);
        semester.setPaid(paid);
        semester.setQuota(quota);
        semester.setPrice(price);
        return semesterRepository.save(semester);
    }

}
