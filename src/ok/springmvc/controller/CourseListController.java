package ok.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ok.springmvc.model.Course;
import ok.springmvc.model.Hole;
import ok.springmvc.service.CourseService;
import ok.springmvc.service.HoleService;

@Controller
public class CourseListController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	HoleService holeService;

	@RequestMapping(value = "/courseList", method = RequestMethod.GET)
	public ModelAndView listCourses(HttpServletRequest request, HttpServletResponse response) {
		List<Course> courseList = courseService.selectAll();
		ModelAndView mav = new ModelAndView("courseList");
		mav.addObject("courseList", courseList);
		Hole hole = holeService.selectByNumber(1);
		mav.addObject("hole",hole);
		return mav;
	}
}
