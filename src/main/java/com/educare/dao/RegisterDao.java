package com.educare.dao;

import java.util.List;
import java.util.Map;

import com.educare.model.FilterResultPojo;
import com.educare.model.LoginPojo;
import com.educare.model.QuestionPojo;
import com.educare.model.Register;
import com.educare.model.SelfassessmentModel;
import com.educare.model.UserTopRankersModel;

public interface RegisterDao {

	public int getRoleIDfromUserRole(String getusernames);

	public List<LoginPojo> loginDetails(LoginPojo lp);

	public int getEmailIDfromusername(String username);

	public List<Map<String, Object>> retriveEmailIDfromUsername(String username);

	public int updateOTP(String username, String email, String otpnumber);

	public List<Map<String, Object>> validateOTP(String username, String otpvalue);

	public List<Register> findAll(Register register);

	public int register(Register reg);

	public String generateStudentID();

	public int getMaxUserIDfromUsers();

	public int getUserIDfromUsers(String username);

	public void insertUserRole(int uid, int rid);

	public List<Map<String, Object>> getPasswordFromForgotPasswordPage(String emailId);

	public String generateLecturerID();

	public String generateAdminID();

	public List<LoginPojo> getUserdetails(String sid);

	public List<QuestionPojo> getExams(String stateid, String locationid, String branchid, String classid,
			String sectionid);

	public List<Map<String, Object>> retriveStudentIDfromUsername(String username);

	List<UserTopRankersModel> getExamnamesForTopRanks();

	List<UserTopRankersModel> getToppersListBasedonExamanme(String examname);

	List<FilterResultPojo> getquestionidfromfilterpojo(String sid, String examname, String val);

	int getminTimefromfilterresults(Object examname, int questionId, String val);

	List<SelfassessmentModel> getExamtypeforSelfassessment();

	List<SelfassessmentModel> getSelfAsssessmentdetails(String studentid, String examtype);

	List<QuestionPojo> getStudentDetailsFromUserTable(String studentid);

}
