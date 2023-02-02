package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.DmCnDvSuDungDAO;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.DmCnDvSuDung;
import com.example.demo.request.DCDSDPageRequest;
import com.example.demo.request.DmCnDvSuDungDTO;
import com.example.demo.request.Request;
import com.example.demo.service.DCDSudungService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dcdsd")
public class DmCnDvSuDungController {
	@Autowired
	private DCDSudungService dService;

	@Autowired
	private DmCnDvSuDungDAO dDAO;

	@PostMapping("/add")
	public ResponseEntity<Request> addDmCnDvSuDung(@RequestBody DmCnDvSuDung dmCnDvSuDung) {
		return new ResponseEntity<>(dService.saveDmCnDvSuDung(dmCnDvSuDung), HttpStatus.CREATED);
	}

	@PostMapping("/find")
	public ResponseEntity<Request> findByCriteria(@RequestBody DmCnDvSuDungDTO dcdsdDTO) {
		return new ResponseEntity<>(dService.findByCriteria(dcdsdDTO), HttpStatus.OK);
	}

	@PostMapping("/delete")
	public Request<String> deleteDmCnDvSuDung(@RequestBody DmCnDvSuDung dmCnDvSuDung) {
		return dService.deleteDmCnDvSuDung(dmCnDvSuDung);
	}

	@PostMapping("/update")
	public ResponseEntity<Request> updateDmCnDvSuDung(@RequestBody DmCnDvSuDung dmCnDvSuDung) {
		return new ResponseEntity<>(dService.updateDmCnDvSuDung(dmCnDvSuDung), HttpStatus.OK);
	}

	@PostMapping("/jdbc")
	public Map<String, Object> getAll(@RequestBody String pi_input) {
		return dDAO.getAll(pi_input);
	}

}
