package fa.training.controller;

import java.util.List;

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
import fa.training.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	// send the course list from database to view
	@GetMapping("/list")
	public String getCourse(ModelMap theModel) {
		List<Course> theCourse = courseService.getCourses();
		theModel.addAttribute("courses", theCourse);
		return "list-courses";
	}

	// redirect to another page to display the student list of the selected course
	// based on courseID
	@GetMapping("/detail/{courseId}")
	public String getCourse(ModelMap theModel, @PathVariable("courseId") String courseId) {
		return "redirect:/student/" + courseId + "/list";
	}

	// send an empty object to store the data of a new course
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Course theCourse = new Course();
		theModel.addAttribute("course", theCourse);
		return "course-form";
	}

	// delete the seleted course based on courseID then redirect to course list page
	@GetMapping("/delete")
	public String deleteCourse(ModelMap theModel, @RequestParam("courseId") String theId) {
		courseService.deleteCourse(theId);
		return "redirect:/course/list";
	}

	// get data of a course from view then update database and send the updated
	// course list to View
	@PostMapping(value = "/save-course")
	public String saveCustomer(@Valid @ModelAttribute("course") Course theCourse, BindingResult theBindingResult,
			ModelMap theModel) {

		// if having errors, return to the form that uses to input data of the course
		// rather than update database
		if (theBindingResult.hasErrors()) {
			return "course-form";
		} else {
			courseService.saveCourse(theCourse);
			List<Course> theCourses = courseService.getCourses();
			theModel.addAttribute("courses", theCourses);
			return "list-courses";
		}
	}

	// send data of the selected course based on courseID to view to modify
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") String theId, ModelMap theModel) {
		Course theCourse = courseService.getCourse(theId);
		// if the course doesn't exist, return 404 page
		if (theCourse == null) {
			return "404";
		}
		theModel.addAttribute("course", theCourse);
		return "course-form";
	}

}
