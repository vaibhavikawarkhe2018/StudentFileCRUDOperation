package com.example.studentfilecrud;



import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController 
{
    private final StudentService studentService = new StudentService();

    @PostMapping
    public String addStudent(@RequestBody Student student) 
    {
        try 
        {
            studentService.addStudent(student);
            return "Student added successfully!";
        }
        catch (IOException e)
        {
            return "Error adding student: " + e.getMessage();
        }
    }

    @GetMapping
    public List<Student> getAllStudents() 
    {
        try 
        {
            return studentService.getAllStudents();
        }
        catch (IOException e)
        {
            throw new RuntimeException("Error retrieving students: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public String updateStudent(@RequestBody Student student) 
    {
        try
        {
            studentService.updateStudent(student);
            return "Student updated successfully!";
        }
        catch (IOException e) 
        {
            return "Error updating student: " + e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id)
    {
        try 
        {
            studentService.deleteStudent(id);
            return "Student deleted successfully!";
        } 
        catch (IOException e) 
        {
            return "Error deleting student: " + e.getMessage();
        }
    }
}
