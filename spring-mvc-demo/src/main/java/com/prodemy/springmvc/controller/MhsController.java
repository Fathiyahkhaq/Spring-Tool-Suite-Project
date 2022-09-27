package com.prodemy.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prodemy.springmvc.dao.MahasiswaDao;

@Controller
@RequestMapping("/mhs")


//@Service
//@Repository
//@Component
public class MhsController {
	
	@Autowired
	private MahasiswaDao dao;
	
	@GetMapping
	public String index(Model model) throws Exception {
		List<Mahasiswa> list = dao.findAll();
		model.addAttribute("mhslist",list);
		return "mahasiswa/index";
		
	}
	
	@GetMapping("/edit")
	public String edit(Model model,HttpServletRequest req)throws Exception{
		Mahasiswa mhs = dao.findById(Integer.parseInt(req.getParameter("id")));
		model.addAttribute("mahasiswa",mhs);
		
		List<Mahasiswa> list = dao.findAll();
		model.addAttribute("mhslist",list);
		return "mahasiswa/edit";
		
	}
	@PostMapping
	public String save( Model model,HttpServletRequest req) throws Exception{
		String mode = req.getParameter("mode");
		
		if ("tambah".equals(mode)) {
			Mahasiswa mhs = new Mahasiswa();
//			mhs.setId(Integer.parseInt(req.getParameter("id")));
			mhs.setKode(req.getParameter("kode"));
			mhs.setNama(req.getParameter("nama"));
			mhs.setAlamat(req.getParameter("alamat"));
			dao.insert(mhs);
		} else if ("hapus".equals(mode)) {
			dao.deleteById(Integer.parseInt(req.getParameter("id")));
		} else {
			Mahasiswa mhs = dao.findById(Integer.parseInt(req.getParameter("id")));
			mhs.setKode(req.getParameter("kode"));
			mhs.setNama(req.getParameter("nama"));
			mhs.setAlamat(req.getParameter("alamat"));
			dao.update(mhs);			
		}
		
		List<Mahasiswa> list = dao.findAll();
		model.addAttribute("mhslist", list);

		return "mahasiswa/index";
		
	}
	
//	@DeleteMapping("/")
//	public String hapusData ( Model model,HttpServletRequest req, HttpServletResponse resp){
//		
//		return "index";
//		
//	}
//	
//	@GetMapping("/byId")
//	public String display3 (Model model) {
//		
//		return "index";
//	}
}
