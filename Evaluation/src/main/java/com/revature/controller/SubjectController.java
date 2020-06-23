package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Subject;
import com.revature.service.SubjectService;
import com.revature.util.LogThis;

@RestController
@RequestMapping(value="/subject")
public class SubjectController {
	
	@Autowired
    SubjectService ss;
	
	@GetMapping("/all")
    public List<Subject> getAllSubjects() {
        return this.ss.subjectList();
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public String insertSubject (@RequestBody Subject s) {
		//Log4j
		LogThis.LogIt("info","Subject added"+""+s.getSubjectName());
		return this.ss.insertSubject(s);
			
	}
}
