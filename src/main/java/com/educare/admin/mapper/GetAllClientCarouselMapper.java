package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminUploadClientLogoModel;

public class GetAllClientCarouselMapper implements RowMapper<AdminUploadClientLogoModel> {

	@Override
	public AdminUploadClientLogoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminUploadClientLogoModel getdet=new AdminUploadClientLogoModel();
		getdet.setCarousel(rs.getString("client_carousel_image"));
		getdet.setClientlogoid(rs.getInt("client_carousel_id"));
		return getdet;
	}

}
