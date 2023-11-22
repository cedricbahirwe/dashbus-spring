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
    
    public boolean saveCourseDefinition(CourseDefinition courseDefinition) {
        if (courseDefinition != null) {
            courseDefinitionRepository.save(courseDefinition);
            return true;
        } else {
            return false;
        }
    }

    public List<CourseDefinition> getCourseDefinitions() {
        return courseDefinitionRepository.findAll();
    }

    public boolean deleteCourseDefinition(Integer coursedDefinitionId) {
        if (courseDefinitionRepository.findById(coursedDefinitionId).isPresent()) {
            courseDefinitionRepository.deleteById(coursedDefinitionId);
            return true;
        } else {
            return false;
        }
    }
}
