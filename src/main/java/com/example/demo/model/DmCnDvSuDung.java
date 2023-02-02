package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "DM_CNDV_SUDUNG")
@Table(name = "DM_CNDV_SUDUNG")

public class DmCnDvSuDung {

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_CNDV_SUDUNG_SEQ")
	@SequenceGenerator(sequenceName = "DM_CNDV_SUDUNG_SEQ", allocationSize = 1, name = "DM_CNDV_SUDUNG_SEQ")
	private Long id;

	@Column(name = "MA", nullable = true)
	private String ma;

	@Column(name = "TEN_NGAN",nullable = false)
	private String tenNgan;

	@Column(name = "DIA_CHI_CN", nullable = true)
	private String diaChiCn;

	@Column(name = "LIEN_HE_DIEN_TOAN", nullable = true)
	private String lienHeDienToan;

	@Column(name = "LIEN_HE_KE_TOAN", nullable = true)
	private String lienHeKeToan;

	@CreationTimestamp
	@Column(name = "NGAY_TAO", nullable = false, updatable = false)
	private Date ngayTao;

	@UpdateTimestamp
	@Column(name = "NGAY_SUA", nullable = true)
	private Date ngaySua;

	@Column(name = "NGUOI_TAO", nullable = true)
	private String nguoiTao;

	@Column(name = "NGUOI_SUA", nullable = true)
	private String nguoiSua;

	@Column(name = "TEN_DAY_DU", nullable = true)
	private String tenDayDu;

	@Column(name = "MA_SO_THUE", nullable = true)
	private String maSoThue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTenNgan() {
		return tenNgan;
	}

	public void setTenNgan(String tenNgan) {
		this.tenNgan = tenNgan;
	}

	public String getDiaChiCn() {
		return diaChiCn;
	}

	public void setDiaChiCn(String diaChiCn) {
		this.diaChiCn = diaChiCn;
	}

	public String getLienHeDienToan() {
		return lienHeDienToan;
	}

	public void setLienHeDienToan(String lienHeDienToan) {
		this.lienHeDienToan = lienHeDienToan;
	}

	public String getLienHeKeToan() {
		return lienHeKeToan;
	}

	public void setLienHeKeToan(String lienHeKeToan) {
		this.lienHeKeToan = lienHeKeToan;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgaySua() {
		return ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		this.ngaySua = ngaySua;
	}

	public String getNguoiTao() {
		return nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}

	public String getNguoiSua() {
		return nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		this.nguoiSua = nguoiSua;
	}

	public String getTenDayDu() {
		return tenDayDu;
	}

	public void setTenDayDu(String tenDayDu) {
		this.tenDayDu = tenDayDu;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

}
