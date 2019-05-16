package com.educare.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.educare.admin.model.AdminUploadClientLogoModel;

public class GetAllClientContactMapper implements RowMapper<AdminUploadClientLogoModel> {

	@Override
	public AdminUploadClientLogoModel mapRow(ResultSet rs, int arg1) throws SQLException {
		AdminUploadClientLogoModel getdet=new AdminUploadClientLogoModel();
		getdet.setContactinfo(rs.getString("mobile_number"));
		getdet.setAddress(rs.getString("address"));
		getdet.setEmailid(rs.getString("emailid"));
		getdet.setContactid(rs.getInt("client_contactl_id"));
		
		
		return getdet;
	}

}
