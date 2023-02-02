package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.common.Constant;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.DmCnDvSuDung;
import com.example.demo.repository.DCDSudungRepository;
import com.example.demo.request.DmCnDvSuDungDTO;
import com.example.demo.request.Request;
import com.example.demo.service.DCDSudungService;

@Service
public class DCDSudungServiceImpl implements DCDSudungService {

	public int pageTotal;

	@Autowired
	private DCDSudungRepository dRepo;
	
	

	@Override
	public Request saveDmCnDvSuDung(DmCnDvSuDung dmCnDvSuDung) {
//		Optional<DmCnDvSuDung> requestOptional = dRepo.findById(dmCnDvSuDung.getId());
		
		try {
//			if (requestOptional.isEmpty()) {
				this.dRepo.save(dmCnDvSuDung);
				return new Request<DmCnDvSuDung>(200, Constant.Success, dmCnDvSuDung);
//			}

		} catch (Exception e) {
			return new Request<String>(400, Constant.BadRequest, e.toString());
		}
//		return new Request<String>(400, Constant.BadRequest, Constant.Failed);
	}

	@Override
	public Request<String> deleteDmCnDvSuDung(DmCnDvSuDung dmCnDvSuDung) {
		Optional<DmCnDvSuDung> requestOptional = dRepo.findById(dmCnDvSuDung.getId());
		try {
			DmCnDvSuDung oldDCDSD = requestOptional.get();
			if (requestOptional.isPresent()) {
				oldDCDSD.setId(dmCnDvSuDung.getId());
				dRepo.deleteById(dmCnDvSuDung.getId());
			}
			return new Request<String>(200, Constant.Success, "Deleted id : " + dmCnDvSuDung.getId());
		} catch (Exception e) {
			return new Request<String>(400, Constant.Failed, Constant.DataID);
		}
	}

	@Override
	public Request updateDmCnDvSuDung(DmCnDvSuDung dmCnDvSuDung) {
		Optional<DmCnDvSuDung> requestOptional = dRepo.findById(dmCnDvSuDung.getId());
		try {
			DmCnDvSuDung oldDCDSD = requestOptional.get();
			if (requestOptional.isPresent()) {
				if (dmCnDvSuDung.getMa() != null) {
					oldDCDSD.setMa(dmCnDvSuDung.getMa());
				}
				if (dmCnDvSuDung.getTenNgan() != null) {
					oldDCDSD.setTenNgan(dmCnDvSuDung.getTenNgan());
				}
				if (dmCnDvSuDung.getDiaChiCn() != null) {
					oldDCDSD.setDiaChiCn(dmCnDvSuDung.getDiaChiCn());
				}
				if (dmCnDvSuDung.getLienHeDienToan() != null) {
					oldDCDSD.setLienHeDienToan(dmCnDvSuDung.getLienHeDienToan());
				}
				if (dmCnDvSuDung.getLienHeKeToan() != null) {
					oldDCDSD.setLienHeKeToan(dmCnDvSuDung.getLienHeKeToan());
				}
				if (dmCnDvSuDung.getMaSoThue() != null) {
					oldDCDSD.setMaSoThue(dmCnDvSuDung.getMaSoThue());
				}
				if (dmCnDvSuDung.getTenDayDu() != null) {
					oldDCDSD.setTenDayDu(dmCnDvSuDung.getTenDayDu());
				}
				if (dmCnDvSuDung.getNguoiTao() != null) {
					oldDCDSD.setNguoiTao(dmCnDvSuDung.getNguoiTao());
				}
				if (dmCnDvSuDung.getNguoiSua() != null) {
					oldDCDSD.setNguoiSua(dmCnDvSuDung.getNguoiSua());
				}
				if (dmCnDvSuDung.getMaSoThue() != null) {
					oldDCDSD.setMaSoThue(dmCnDvSuDung.getMaSoThue());
				}
				this.dRepo.save(oldDCDSD);
			}
			return new Request<DmCnDvSuDung>(200, Constant.Success, dmCnDvSuDung);
		} catch (Exception e) {
			return new Request<String>(400, Constant.Failed, Constant.DataID);
		}
	}

	@Override
	public Request findByCriteria(DmCnDvSuDungDTO dcdsdDTO) {
		Pageable pageable = PageRequest.of(dcdsdDTO.getDcdsdPageRequest().getPageNumber(),
				dcdsdDTO.getDcdsdPageRequest().getPageSize());
		try {
			Page<DmCnDvSuDung> page = dRepo.findAll(new Specification<DmCnDvSuDung>() {
				@Override
				public Predicate toPredicate(Root<DmCnDvSuDung> root, CriteriaQuery<?> query,
						CriteriaBuilder criteriaBuilder) {
					List<Predicate> predicates = new ArrayList<>();
					if (dcdsdDTO.getdCDSD().getId() != null) {
						predicates.add(criteriaBuilder
								.and(criteriaBuilder.equal(root.get("id"), dcdsdDTO.getdCDSD().getId())));
					}
					if (dcdsdDTO.getdCDSD().getMa() != null && dcdsdDTO.getdCDSD().getMa() != "") {
						predicates.add(criteriaBuilder
								.and(criteriaBuilder.like(root.get("ma"), "%" + dcdsdDTO.getdCDSD().getMa() + "%")));
					}
					if (dcdsdDTO.getdCDSD().getTenNgan() != null && dcdsdDTO.getdCDSD().getTenNgan() != "") {
						predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("tenNgan"),
								"%" + dcdsdDTO.getdCDSD().getTenNgan() + "%")));
					}
					if (dcdsdDTO.getdCDSD().getDiaChiCn() != null && dcdsdDTO.getdCDSD().getDiaChiCn() != "") {
						predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("diaChiCn"),
								"%" + dcdsdDTO.getdCDSD().getDiaChiCn() + "%")));
					}
					if (dcdsdDTO.getdCDSD().getLienHeDienToan() != null
							&& dcdsdDTO.getdCDSD().getLienHeDienToan() != "") {
						predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("lienHeDienToan"),
								"%" + dcdsdDTO.getdCDSD().getMa() + "%")));
					}
					if (dcdsdDTO.getdCDSD().getLienHeKeToan() != null && dcdsdDTO.getdCDSD().getLienHeKeToan() != "") {
						predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("lienHeKeToan"),
								"%" + dcdsdDTO.getdCDSD().getLienHeKeToan() + "%")));
					}
					if (dcdsdDTO.getdCDSD().getNguoiSua() != null && dcdsdDTO.getdCDSD().getNguoiSua() != "") {
						predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("nguoiSua"),
								"%" + dcdsdDTO.getdCDSD().getNguoiSua() + "%")));
					}
					if (dcdsdDTO.getdCDSD().getNguoiTao() != null && dcdsdDTO.getdCDSD().getNguoiTao() != "") {
						predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("nguoiTao"),
								"%" + dcdsdDTO.getdCDSD().getNguoiTao() + "%")));
					}
					if (dcdsdDTO.getdCDSD().getTenDayDu() != null && dcdsdDTO.getdCDSD().getTenDayDu() != "") {
						predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("tenDayDu"),
								"%" + dcdsdDTO.getdCDSD().getTenDayDu() + "%")));
					}
					if (dcdsdDTO.getdCDSD().getMaSoThue() != null && dcdsdDTO.getdCDSD().getMaSoThue() != "") {
						predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("maSoThue"),
								"%" + dcdsdDTO.getdCDSD().getMaSoThue() + "%")));
					}
					if (dcdsdDTO.getDateDto().getNgayTaoFrom() != null) {
						System.out.println("Ngay Tao From : " + dcdsdDTO.getDateDto().getNgayTaoFrom());
						predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("ngayTao"),
								dcdsdDTO.getDateDto().getNgayTaoFrom())));
					}
					if (dcdsdDTO.getDateDto().getNgayTaoTo() != null) {
						Date dateTo = dcdsdDTO.getDateDto().getNgayTaoTo();
						dateTo.setDate(dateTo.getDate() + 1);
						System.out.println("Ngay Tao To : " + dateTo);
						predicates.add(
								criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("ngayTao"), dateTo)));
					}
					return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
				}
			}, pageable);
			page.getTotalElements();
			System.out.println(page.getTotalElements());
			pageTotal = page.getTotalPages();
			System.out.println(page.getTotalPages());
			return new Request<Page<DmCnDvSuDung>>(200, Constant.Success, page);
		} catch (Exception e) {
			return new Request<String>(400, Constant.BadRequest, Constant.Failed);
		}
	}


}
