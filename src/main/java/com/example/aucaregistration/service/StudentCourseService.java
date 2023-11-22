package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.Course;
import com.example.aucaregistration.domain.Semester;
import com.example.aucaregistration.domain.StudentCourse;
import com.example.aucaregistration.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {
    private final StudentCourseRepository studentCourseRepository;

    @Autowired
    public StudentCourseService(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    public StudentCourse saveStudentCourse(StudentCourse studentCourse) throws Exception {
        if (studentCourse != null) {
            return studentCourseRepository.save(studentCourse);
        } else {
            throw new Exception("Unable to save Student Course");
        }
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourseRepository.findAll();
    }

    public  List<StudentCourse> getStudentByCourseAndSemester(Long courseId, Long semesterId) {
        return studentCourseRepository.findByCourseCourseDefinitionIdAndStudentRegistrationSemesterId(courseId, semesterId);
    }


    public List<StudentCourse> findCoursesStudentId(Long studentId) {
        return studentCourseRepository.findByStudentRegistrationStudentStudentId(studentId);
    }

    public boolean deleteStudentCourse(Long studentCourseId) {
        if (studentCourseRepository.findById(studentCourseId).isPresent()) {
            studentCourseRepository.deleteById(studentCourseId);
            return true;
        } else {
            return false;
        }
    }
}
