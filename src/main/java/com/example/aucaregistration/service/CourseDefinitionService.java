package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.CourseDefinition;
import com.example.aucaregistration.repository.CourseDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDefinitionService {
    private final CourseDefinitionRepository courseDefinitionRepository;
    
    @Autowired
    public CourseDefinitionService(CourseDefinitionRepository courseDefinitionRepository) {
        this.courseDefinitionRepository = courseDefinitionRepository;
    }
    
    public CourseDefinition saveCourseDefinition(CourseDefinition courseDefinition) throws Exception {
        if (courseDefinition != null) {
            return courseDefinitionRepository.save(courseDefinition);
        } else {
            throw new Exception("Unable to save Course Definition");
        }
    }

    public List<CourseDefinition> getCourseDefinitions() {
        return courseDefinitionRepository.findAll();
    }

    public void deleteCourseDefinition(Long coursedDefinitionId) throws Exception {
        if (courseDefinitionRepository.findById(coursedDefinitionId).isPresent()) {
            courseDefinitionRepository.deleteById(coursedDefinitionId);
        } else {
            throw new Exception("Course not found");
        }
    }
}
