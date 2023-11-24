package com.example.aucaregistration.service;


import com.example.aucaregistration.domain.Teacher;
import com.example.aucaregistration.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher saveTeacher(Teacher teacher) throws Exception {
        if (teacher != null) {
            return teacherRepository.save(teacher);
        } else {
            throw new Exception("Unable to save teacher");
        }
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void deleteTeacher(Long teacherId) throws Exception {
        if (teacherRepository.findById(teacherId).isPresent()) {
            teacherRepository.deleteById(teacherId);
        } else {
            throw new Exception("Unable to find this teacher");
        }
    }
}
