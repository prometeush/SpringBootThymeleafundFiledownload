package com.project.control;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.dao.DocumentsRepository;
import com.project.entity.Documents;
import com.project.service.DocumentsService;

@Controller
public class DocumentsController {
	
	@Autowired
	private DocumentsService service2;
	
	@Autowired
	private DocumentsRepository repository3;
	
	@RequestMapping("/document")
	public String documentPage() {
		return "document-page";
	}
	
	@RequestMapping("/documentform")
	public String documentForm(Model model) {
		model.addAttribute("documentmodel", new Documents());		
		return "document-form";
	}
	
	@PostMapping("/documentSave")
	public String documentSave(@RequestParam("document")MultipartFile multipartFile,
			RedirectAttributes reat) throws IOException {
		Documents document=new Documents();
		String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
		document.setName(fileName);
		document.setContent(multipartFile.getBytes());
		document.setSize(multipartFile.getSize());
		document.setUpload_time(new Date());
		
		reat.addFlashAttribute("message", "die Datei wurde hochgeladen");
		this.service2.saveDocuments(document);
		
		
		return "redirect:/document";
		
	}
	@RequestMapping("/documentinfo")
	public String documentList(Model model) {
		List<Documents> list2=service2.listDocuments();
		model.addAttribute("documentlist", list2);
		return "document-info";
	}
	
	@GetMapping("/download")
	public void herunterladenDocument(@Param("id")Integer id, HttpServletResponse responce) throws Exception {
		Optional<Documents> result=repository3.findById(id);
		if(!result.isPresent()) {
			throw new Exception("datei  wurde nicht heruntergeladen");
		}
		Documents document=result.get();
		responce.setContentType("application/octet-stream");
		String headerKey="Content-Disposition";
		String headerValue="attachment; filename="+document.getName();
		
		responce.setHeader(headerKey, headerValue);
		
		ServletOutputStream outputStream=responce.getOutputStream();
		outputStream.write(document.getContent());
		outputStream.flush();
		outputStream.close();
	}
	

}
