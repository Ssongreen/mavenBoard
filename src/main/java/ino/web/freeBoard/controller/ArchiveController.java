package ino.web.freeBoard.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ino.web.freeBoard.dto.ArchiveDto;
import ino.web.freeBoard.dto.Criteria;
import ino.web.freeBoard.dto.FreeBoardDto;
import ino.web.freeBoard.dto.PageDTO;
import ino.web.freeBoard.service.ArchiveService;

//@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)

@Controller
public class ArchiveController {

	@Autowired
	private ArchiveService archiveService;

	@RequestMapping(value = "/archiveMain.ino")
	public ModelAndView main(
			@RequestParam(defaultValue = "1") int pageNum, 
			HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		
		int amount = 5;
		Criteria criteria = new Criteria(pageNum, amount);

		criteria.setKeyword(keyword);
		criteria.setType(type);

		List<ArchiveDto> list;

		int total;
		
		if (keyword != null && !keyword.isEmpty()) {
			list = archiveService.searchArchiveListByType(criteria);
			total = archiveService.getArchiveTotal(criteria);
		} else {
			list = archiveService.getArchiveList(criteria);
			total = archiveService.getArchiveTotal(criteria);
		}
		PageDTO pageDTO = new PageDTO(criteria, total);

		mav.setViewName("archiveMain");
		mav.addObject("archiveList", list);
		mav.addObject("pageMaker", pageDTO);

		return mav;
	}

	@RequestMapping("/archiveInsert.ino")
	public String freeBoardInsert() {
		return "archiveInsert";
	}
	
	@RequestMapping(value = "/archiveInsertPro.ino", method = RequestMethod.POST)
	public String archiveInsertPro(
	        HttpServletRequest request,
	        ArchiveDto dto,
	        HttpServletResponse response
	) throws IOException, ServletException {

		
	    String name = request.getParameter("name");
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");

	    Part filePart = request.getPart("fileLoad"); // 단일 파일 업로드

	    if (filePart.getSize() > 0) {
	        String fileName = filePart.getSubmittedFileName();
	        InputStream fis = filePart.getInputStream();

	        // 경로 지정
	        String realpath = request.getSession().getServletContext().getRealPath("/upload");
	        File path = new File(realpath);
	        if (!path.exists())
	            path.mkdir();

	        String filePath = realpath + File.separator + fileName;
	        
	        System.out.println(realpath);
	        
	        FileOutputStream fos = new FileOutputStream(filePath);
	        int b;
	        
	        byte[] buf = new byte[1024];
	        int size = 0;
	        while ((size = fis.read(buf)) != -1)
	            fos.write(buf, 0, size);

	        fos.close();
	        fis.close();

	        dto.setFileLoad(fileName);
	    }

	    dto.setName(name);
	    dto.setTitle(title);
	    dto.setContent(content);

	    archiveService.archiveInsertPro(dto);

	    return "redirect:archiveDetail.ino?num=" + dto.getNum();
	}

	
	
	@RequestMapping("/archiveDetail.ino")
	public ModelAndView archiveDetail(
			HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("num"));
		ArchiveDto dto = archiveService.getArchiveDetailByNum(num);
		
		return new ModelAndView("archiveDetail", "archiveDto", dto);
	}

	@RequestMapping("/archiveModify.ino")
	public ModelAndView archiveModify(
			HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("num"));
		ArchiveDto dto = archiveService.getArchiveDetailByNum(num);
		return new ModelAndView("archiveModify", "archiveDto", dto);
	}

	@RequestMapping(
			value= "/archiveUpdate.ino",
			method = RequestMethod.POST)
	public String archiveUpdate(
	        HttpServletRequest request, 
	        ArchiveDto dto
	        ) throws IOException, ServletException {
	    
		int num = Integer.parseInt(request.getParameter("num"));
	    
	    String name = request.getParameter("name");
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    
	    ArchiveDto update = archiveService.getArchiveDetailByNum(num);
//	    System.out.println("update" + update);
	    
	    Part filePart = request.getPart("fileLoad"); 

	    if (filePart.getSize() > 0) {
	        String fileName = filePart.getSubmittedFileName();
	        InputStream fis = filePart.getInputStream();

	        String realpath = request.getSession().getServletContext().getRealPath("/upload");

	        File path = new File(realpath);
	        if (!path.exists())
	            path.mkdir();

	        String filePath = realpath + File.separator + fileName;
	        FileOutputStream fos = new FileOutputStream(filePath);
	        int b;
	        
	        byte[] buf = new byte[1024];
	        int size = 0;
	        while ((size = fis.read(buf)) != -1)
	            fos.write(buf, 0, size);

	        fos.close();
	        fis.close();
	        
	        update.setFileLoad(fileName); 
	        
	    }
	        
	    update.setName(name);
	    update.setTitle(title);
	    update.setContent(content);

	    
	    archiveService.archiveUpdate(update);
	    return "redirect:/archiveMain.ino";
	}





	@RequestMapping("/archiveDelete.ino")
	public String archiveDelete(
			@ModelAttribute("delete") 
			ArchiveDto delete) {
		
		archiveService.archiveDelete(delete);
		return "redirect:/archiveMain.ino";
	}
	
	@RequestMapping(
			value = "/archiveDeleteFile.ino", 
			method = RequestMethod.POST)
	public String archiveDeleteFile(
			HttpServletRequest request
			) {
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		ArchiveDto delete = archiveService.getArchiveDetailByNum(num);
		
		
		
		String filePath = request.getServletContext().getRealPath("/upload/") + delete.getFileLoad();
	    
	    File file = new File(filePath);
	    
	    if (file.exists()) {
	        file.delete();
	    }
	    
	   
	    archiveService.archiveFileDelete(delete); 
	    
	    
	    return "redirect:/archiveModify.ino?num=" + delete.getNum();
	}

	
}
