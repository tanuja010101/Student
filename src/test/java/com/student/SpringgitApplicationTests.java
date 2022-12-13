package com.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.controller.StudentController;
import com.student.exceptions.DataNotFoundException;
import com.student.exceptions.EnterValidDataException;
import com.student.exceptions.StudentAlreadyExistsException;
import com.student.model.Student;
import com.student.service.StudentService;
import com.student.service.StudentServiceImp;

import org.junit.Ignore;
import org.junit.jupiter.api.*;

import org.junit.platform.engine.TestExecutionResult;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
class SpringgitApplicationTests{


	Student student;
    @Mock
	@Autowired
	StudentService studentService;

	@Autowired
	MockMvc mockMvc;



	@Autowired
	StudentController studentController;

	@BeforeEach
	public void setUp() {
		student = new Student();
		student.setStudentName("Lavanya");
		student.setRollNo(1);
		student.setGrade("A");
		student.setAddress("XYA");
		student.setMarks(79);
		student.setStudentClass(10);
	}

	@Order(1)
	@Test
	void testAddStudent() throws EnterValidDataException, DataNotFoundException {
	Student actual = studentService.addStudent(student);
	Student expect  = studentService.getStudentById(student.getRollNo());
	assertEquals(expect ,actual);
	}

	@Order(2)
	@Test
	void testStudentAlreadyPresentForAdd() throws EnterValidDataException {
		studentService.addStudent(student);
		student.setRollNo(1);
		assertThrows(StudentAlreadyExistsException.class, () -> studentService.addStudent(student), "student already exist with the given roll no.");
	}

	@Order(5)
	@Test
	void testInvalidAddDataForStudent(){
		student.setRollNo(200);
		assertThrows(EnterValidDataException.class, () -> studentService.addStudent(student), "invalid rollNo,roll no. can only be between 1 to 100");
		student.setRollNo(2);

		student.setStudentName("La123");
		assertThrows(EnterValidDataException.class, () -> studentService.addStudent(student), "Invalid Student Name or entered null name");
		student.setStudentName("Lavanya");

		student.setGrade("A1");
		assertThrows(EnterValidDataException.class, () -> studentService.addStudent(student), "Grades can only be between A to F and can not be a null value");
		student.setGrade("A");

		student.setAddress("Xyz#$%");
		assertThrows(EnterValidDataException.class, () -> studentService.addStudent(student), "Invalid Address or entered null address");
		student.setAddress("XYZ");

		student.setMarks(101);
		assertThrows(EnterValidDataException.class, () -> studentService.addStudent(student), "marks can only be between 0 to 100");
		student.setMarks(90);

		student.setStudentClass(15);
		assertThrows(EnterValidDataException.class, () -> studentService.addStudent(student), "Student class can only be between 1 to 12");
		student.setStudentClass(9);
	}


	@Order(8)
	@Test
	void testControllerAddStudent() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		student.setRollNo(1);
		this.mockMvc.perform(post("/student/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(student)))
				.andExpect(status().isCreated());

	}
    @Order(7)
	@Test
	void testControllerViewStudent() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		student.setRollNo(10);
		this.mockMvc.perform(get("/student/view")
						.contentType(MediaType.APPLICATION_JSON));
	}
	@Order(4)
	@Test
	void testServiceDeleteStudent() throws DataNotFoundException,EnterValidDataException
	{
		//studentService.addStudent(student);
		String expected="deleted successfully";
		String actual=studentService.deleteStudent(1);
		assertEquals(expected,actual);

	}
	@Order(3)
	@Test
	void testServiceUpdateStudent() throws EnterValidDataException,DataNotFoundException
	{
		Student student1=new Student();
		student1.setRollNo(1);
		student1.setStudentName("tanuja");
		student1.setGrade("B");
		student1.setAddress("abc krishna nagar");
		student1.setMarks(90);
		student1.setStudentClass(5);
		//studentService.addStudent(student);
		Student actual=studentService.updateStudent(student1);
		Student expected=studentService.getStudentById(1);
		assertEquals(actual,expected);
		/*assertThrows(EnterValidDataException.class,()->studentService.updateStudent(student),"student roll no already exist");*/

	}
	@Order(6)
	@Test
	void testServiceViewStudent()throws DataNotFoundException,EnterValidDataException
	{
		//studentService.addStudent(student);
		ArrayList<Student> list=studentService.getStudent();
		assertEquals(1,list.size());
	}

	@Order(10)
	@Test
	void testControllerUpdate() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		student.setStudentName("XYZ");
		student.setRollNo(2);
		studentService.addStudent(student);
		this.mockMvc.perform(put("/student/update")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(student)))
				.andExpect(status().isOk());

	}

	@Order(9)
	@Test
	void  testControllerDelete() throws Exception {
		ObjectMapper mapper=new ObjectMapper();
		student.setRollNo(2);
		studentService.addStudent(student);
		this.mockMvc.perform(delete("/student/delete/2"))
				.andExpect(status().isAccepted());

	}

}

