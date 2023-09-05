package ino.web.freeBoard.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ino.web.freeBoard.dto.ArchiveDto;
import ino.web.freeBoard.dto.Criteria;
import ino.web.freeBoard.dto.FreeBoardDto;
import ino.web.freeBoard.dto.PageDTO;
import ino.web.freeBoard.service.FreeBoardService;

@Controller
public class FreeBoardController {

	@Autowired
	private FreeBoardService freeBoardService;

	@RequestMapping(value= "/main.ino", method = RequestMethod.GET)
	public ModelAndView main(
	        @RequestParam(defaultValue = "1") int pageNum,
	        
	        HttpServletRequest request
	        ) {
	    
	    ModelAndView mav = new ModelAndView();
	    
	    String type = request.getParameter("type");
	    String keyword = request.getParameter("keyword");
	    
	    
	    int amount = 5;
	    Criteria criteria = new Criteria(pageNum, amount);
	    
	    criteria.setKeyword(keyword);
	    criteria.setType(type);
	    
	    List<FreeBoardDto> list;
	    
	    int total;

	    if (keyword != null && !keyword.isEmpty()) {
	        list = freeBoardService.searchFreeBoardListByType(criteria);
	        total = freeBoardService.getTotal(criteria);
	    } else {
	        list = freeBoardService.getFreeBoardList(criteria);
	        total = freeBoardService.getTotal(criteria);
	    }

	    PageDTO pageDTO = new PageDTO(criteria, total);
	    
	    mav.setViewName("boardMain");
	    mav.addObject("freeBoardList", list);
	    mav.addObject("pageMaker", pageDTO);

	    return mav;
	}
	
	
	@RequestMapping("/freeBoardInsert.ino")
	public String freeBoardInsert() {
		return "freeBoardInsert";
	}

	@RequestMapping("/freeBoardInsertPro.ino")
	public String freeBoardInsertPro(HttpServletRequest request, FreeBoardDto dto) {

		ModelAndView mav = new ModelAndView();
		freeBoardService.freeBoardInsertPro(dto);
		return "redirect:freeBoardDetail.ino?num=" + dto.getNum();

	}

	@RequestMapping("/freeBoardDetail.ino")
	public ModelAndView freeBoardDetail(
			HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num);

		return new ModelAndView("freeBoardDetail", "freeBoardDto", dto);
	}

	@RequestMapping("/freeBoardModify.ino")
	public ModelAndView freeBoardModify(
			HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("num"));
		FreeBoardDto dto = freeBoardService.getDetailByNum(num);

		return new ModelAndView("freeBoardModify", "freeBoardDto", dto);
	}

	@RequestMapping(
			value = "/freeBoardUpdate.ino", 
			method = RequestMethod.POST)
	public String freeBoardUpdate(
			HttpServletRequest request,
			FreeBoardDto dto
			) throws IOException, ServletException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		
	    String name = request.getParameter("name");
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    
	    FreeBoardDto update = freeBoardService.getDetailByNum(num);
	    
	    
	    update.setName(name);
	    update.setTitle(title);
	    update.setContent(content);

	    freeBoardService.freeBoardUpdate(update);
		return "redirect:/main.ino";
	}
	
	@RequestMapping("/freeBoardDelete.ino")
	public String freeBoardDelete(
	    @ModelAttribute("delete") 
	    FreeBoardDto delete
	) {
	    int num = delete.getNum(); // delete 객체에서 num 필드 얻기
	    freeBoardService.freeBoardDelete(num);
	    
	    return "redirect:/main.ino";
	}

}
