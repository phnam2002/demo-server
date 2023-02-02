package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.DmCnDvSuDung;
import com.example.demo.request.DmCnDvSuDungDTO;
import com.example.demo.request.Request;

public interface DCDSudungService {

	Request saveDmCnDvSuDung(DmCnDvSuDung dmCnDvSuDung);

	Request<String> deleteDmCnDvSuDung(DmCnDvSuDung dmCnDvSuDung);

	Request updateDmCnDvSuDung(DmCnDvSuDung dmCnDvSuDung);
	
	Request findByCriteria(DmCnDvSuDungDTO dcdsdDTO);
	
}
