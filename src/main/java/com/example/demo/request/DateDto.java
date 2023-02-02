package com.example.demo.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


public class DateDto {


	private Date ngayTaoFrom;

	private Date ngayTaoTo;
	public Date getNgayTaoFrom() {
		return ngayTaoFrom;
	}
	public void setNgayTaoFrom(Date ngayTaoFrom) {
		this.ngayTaoFrom = ngayTaoFrom;
	}
	public Date getNgayTaoTo() {
		return ngayTaoTo;
	}
	public void setNgayTaoTo(Date ngayTaoTo) {
		this.ngayTaoTo = ngayTaoTo;
	}
}
