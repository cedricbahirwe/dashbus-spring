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

    public Boolean saveTeacher(Teacher teacher) {
        if (teacher != null) {
            teacherRepository.save(teacher);
            return true;
        } else {
            return false;
        }
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public boolean deleteTeacher(Integer teacherId) {
        if (teacherRepository.findById(teacherId).isPresent()) {
            teacherRepository.deleteById(teacherId);
            return true;
        } else {
            return false;
        }
    }
}
