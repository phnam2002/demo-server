package com.example.demo.request;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.demo.model.DmCnDvSuDung;

public class DmCnDvSuDungDTO {
	DateDto dateDto;
	
	public DateDto getDateDto() {
		return dateDto;
	}

	public void setDateDto(DateDto dateDto) {
		this.dateDto = dateDto;
	}

	DCDSDPageRequest dcdsdPageRequest;
	
	DmCnDvSuDung dCDSD;
	public DmCnDvSuDungDTO(DCDSDPageRequest dcdsdPageRequest, DmCnDvSuDung dCDSD) {
		super();
		this.dcdsdPageRequest = dcdsdPageRequest;
		this.dCDSD = dCDSD;
	}

	public DCDSDPageRequest getDcdsdPageRequest() {
		return dcdsdPageRequest;
	}

	public void setDcdsdPageRequest(DCDSDPageRequest dcdsdPageRequest) {
		this.dcdsdPageRequest = dcdsdPageRequest;
	}

	public DmCnDvSuDung getdCDSD() {
		return dCDSD;
	}

	public void setdCDSD(DmCnDvSuDung dCDSD) {
		this.dCDSD = dCDSD;
	}


}
