package soaiknow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
 * Created by SimonaS on 15/04/2017.
 */
@RestController
@RequestMapping(value = "/")
public class ProfessorController {

    @Autowired
    RegisterSubjectRepository registerSubjectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SubjectRepository subjectRepository;

    @RequestMapping(value = "studentsForSubject")
    public List<User> listStudentsForSubject(@RequestParam("subject") long id){
        List<RegisterSubject> registers =  registerSubjectRepository.findBySubjectId(id);
        List<User> students = new ArrayList<>();

        for(RegisterSubject register : registers){
            students.add(register.getUser());
        }

        return students;
    }

    @RequestMapping(value = "insertGrade", method = RequestMethod.POST)
    public void insertGrade(@RequestParam("student") long student_id, @RequestParam("subject") long subject_id, @RequestParam("grade") String grade){
        RegisterSubject registerSubject = registerSubjectRepository.findByUserIdAndSubjectId(student_id, subject_id);
        Subject subject = registerSubject.getSubject();
        subject.setGrade(grade);
        subjectRepository.save(subject);
    }

    @RequestMapping(value = "insertSignature", method = RequestMethod.POST)
    public void insertSignature(@RequestParam("student") long student_id, @RequestParam("subject") long subject_id){
        RegisterSubject registerSubject = registerSubjectRepository.findByUserIdAndSubjectId(student_id, subject_id);
        Subject subject = registerSubject.getSubject();
        subject.setHasSignature(true);
        subjectRepository.save(subject);
    }
}
