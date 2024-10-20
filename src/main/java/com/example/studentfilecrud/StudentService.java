package com.example.studentfilecrud;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService 
{
    private static final String FILE_PATH = "src/main/resources/students.txt";

    // Create a new student record
    public void addStudent(Student student) throws IOException 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) 
        {
            writer.write(student.toString());
            writer.newLine();
        }
    }

    // Read all student records
    public List<Student> getAllStudents() throws IOException
    {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] data = line.split(",");
                Student student = new Student();
                student.setId(Integer.parseInt(data[0]));
                student.setName(data[1]);
                student.setAge(Integer.parseInt(data[2]));
                student.setEmail(data[3]);
                students.add(student);
            }
        }
        return students;
    }

    // Update a student record
    public void updateStudent(Student updatedStudent) throws IOException 
    {
        List<Student> students = getAllStudents();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) 
        {
            for (Student student : students)
            {
                if (student.getId() == updatedStudent.getId()) 
                {
                    writer.write(updatedStudent.toString());
                } 
                else
                {
                    writer.write(student.toString());
                }
                writer.newLine();
            }
        }
    }

    // Delete a student record
    public void deleteStudent(int studentId) throws IOException 
    {
        List<Student> students = getAllStudents();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) 
        {
            for (Student student : students) 
            {
                if (student.getId() != studentId) 
                {
                    writer.write(student.toString());
                    writer.newLine();
                }
            }
        }
    }
}
