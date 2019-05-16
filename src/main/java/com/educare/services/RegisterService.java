package com.educare.services;

import java.util.List;
import java.util.Map;

import com.educare.model.FilterResultPojo;
import com.educare.model.LoginPojo;
import com.educare.model.QuestionPojo;
import com.educare.model.Register;
import com.educare.model.SelfassessmentModel;
import com.educare.model.UserTopRankersModel;

public interface RegisterService {

	int getRoleIDfromUserRole(String getusernames);

	List<LoginPojo> loginDetails(LoginPojo lp);

	String getUserPWD(LoginPojo lp);

	int getEmailIDfromusername(String username);

	List<Map<String, Object>> retriveEmailIDfromUsername(String username);

	int updateOTP(String username, String email, String otpnumber);

	List<Map<String, Object>> validateOTP(String username, String otpvalue);

	List<Register> findAll(Register register);

	int register(Register reg);

	String generateStudentID();

	int getMaxUserIDfromUsers();

	int getUserIDfromUsers(String username);

	void insertUserRole(int uid, int rid);

	List<Map<String, Object>> getPasswordFromForgotPasswordPage(String emailId);

	String generateLecturerID();

	String generateAdminID();

	List<LoginPojo> getUserdetails(String sid);

	List<QuestionPojo> getExams(String stateid, String locationid, String branchid, String classid, String sectionid);

	List<UserTopRankersModel> getExamnamesForTopRanks();

	List<UserTopRankersModel> getToppersListBasedonExamanme(String examname);

	List<FilterResultPojo> getquestionidfromfilterpojo(String sid, String examname, String val);

	int getminTimefromfilterresults(Object examname, int questionId, String val);

	List<SelfassessmentModel> getExamtypeforSelfassessment();

	List<SelfassessmentModel> getSelfAsssessmentdetails(String studentid, String examtype);

	List<QuestionPojo> getStudentDetailsFromUserTable(String studentid);

	int getmarkforreivewcnt(String examname, String studentId, String subjectid);

	int getExamTypeIdBasedOnExamName(String examname);

	int getPatternIdBasedOnExamType(int examtypeid);

}
