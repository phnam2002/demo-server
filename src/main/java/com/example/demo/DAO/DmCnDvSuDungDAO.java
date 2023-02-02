package com.example.demo.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.example.demo.model.DmCnDvSuDung;

@Service
public class DmCnDvSuDungDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> getAll(String pi_input) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		Iterable<DmCnDvSuDung> list = new ArrayList<>();
		Long total = 1L;
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PCK_DM_CNDV_SUDUNG")
					.withProcedureName("GET_ALL");
			Map<String, Object> inParamMap = new HashMap<String, Object>();
			inParamMap.put("pi_input", pi_input);
			SqlParameterSource in = new MapSqlParameterSource(inParamMap);
			Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
			System.out.println(simpleJdbcCallResult);
			String errCode = String.valueOf(simpleJdbcCallResult.get("PO_ERR"));
			String errDesc = String.valueOf(simpleJdbcCallResult.get("PO_DESC"));
			if (errCode != null && "0".equals(errCode)) {
				list = (Iterable<DmCnDvSuDung>) simpleJdbcCallResult.get("PO_DATA");
				total = Long.parseLong(String.valueOf(simpleJdbcCallResult.get("PO_TOTAL")));
			}
		} catch (Exception e) {
		}
		map.put("list", list);
		map.put("total", total);
		return map;
	}

}
