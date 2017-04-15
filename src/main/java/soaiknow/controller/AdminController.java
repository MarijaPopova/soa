package soaiknow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soaiknow.models.Subject;
import soaiknow.repository.SubjectRepository;

/**
 * Created by Popov on 14.4.2017.
 */
@RestController
@RequestMapping(value = "/")
public class AdminController {

    @Autowired
    private SubjectRepository subjectRepository;

    @RequestMapping(value = "insertSubject", method = RequestMethod.POST)
    public Subject registration(@RequestParam("code") String code,
                                @RequestParam("nameSubject") String nameSubject,
                                @RequestParam("description") String description,
                                @RequestParam("profesor") String profesor) {
       Subject subject = new Subject();
        subject.setCode(code);
        subject.setDescription(description);
        subject.setName(nameSubject);
        subject.setProfessor(profesor);
      return  subjectRepository.save(subject);
    }

}