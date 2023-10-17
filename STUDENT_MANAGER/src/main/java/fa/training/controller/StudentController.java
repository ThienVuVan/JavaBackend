package fa.training.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.models.Course;
import fa.training.models.Student;
import fa.training.service.CourseService;
import fa.training.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	// send a student list of the selected course to view based on courseID
	@RequestMapping("{courseId}/list")
	private String listStudents(ModelMap theModel, @PathVariable("courseId") String courseId) {
		Course theCourse = courseService.getCourse(courseId);
		// if the course doesn't exist, return 404 page
		if (theCourse == null) {
			return "404";
		}
		theModel.addAttribute("course", theCourse);
		theModel.addAttribute("students", theCourse.getStudents());
		return "list-students";
	}

	@PostMapping("{courseId}/save-student")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingResult,
			ModelMap theModel, @PathVariable("courseId") String courseId) {

		Course theCourse = courseService.getCourse(courseId);

		// if the course doesn't exist, return 404 page
		if (theCourse == null) {
			return "404";

			// if having errors, return to the form that uses to input data of the student rather than update database
		} else if (theBindingResult.hasErrors()) {
			theModel.addAttribute("course", theCourse);
			return "student-form";
		} else {
			// if the course is full, return to the form that uses to input data of the
			// student rather than update database
			if (theCourse.getEnrollment() <= theCourse.getStudents().size()
					&& studentService.getStudent(theStudent.getId()) == null) {
				theModel.addAttribute("message", "The course is full !");
				return "student-form";
			} else {
				theStudent.setCourse(theCourse);
				studentService.saveStudent(theStudent);
				return "redirect:/student/" + courseId + "/list";
			}
		}
	}

	// send data of the selected student based on studentID to view to modify
	@GetMapping("/{courseId}/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") String theId, ModelMap theModel,
			@PathVariable("courseId") String courseId) {
		Course theCourse = courseService.getCourse(courseId);
		Student theStudent = studentService.getStudent(theId);
		// if the course or the student doesn't exist, return 404 page
		if (theCourse == null || theStudent == null) {
			return "404";
		}
		theModel.addAttribute("course", theCourse);
		theModel.addAttribute("student", theStudent);

		return "student-form";
	}

	// send an empty object to store the data of a new student
	@GetMapping("/{courseId}/showFormForAdd")
	public String showFormForAdd(Model theModel, @PathVariable("courseId") String courseId) {
		Course theCourse = courseService.getCourse(courseId);

		// if the course doesn't exist, return 404 page
		if (theCourse == null) {
			return "404";
		}
		theModel.addAttribute("course", theCourse);
		theModel.addAttribute("student", new Student());
		return "student-form";
	}

	// delete the seleted student based on studentID then redirect to student list page
	@GetMapping("{courseId}/delete")
	public String deleteCustomer(@RequestParam("studentId") String theId, ModelMap theModel,
			@PathVariable("courseId") String courseId) {

		studentService.deleteStudent(theId);
		Course theCourse = courseService.getCourse(courseId);

		if (theCourse == null) {
			return "404";
		}
		return "redirect:/student/" + courseId + "/list";
	}

}
