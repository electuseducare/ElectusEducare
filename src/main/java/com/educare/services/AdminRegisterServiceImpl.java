package com.educare.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educare.admin.model.AdminAddCompQuesInExamModel;
import com.educare.admin.model.AdminAddEditDeleteAccessforRolesPojo;
import com.educare.admin.model.AdminAddNewStudent;
import com.educare.admin.model.AdminAddOrganizationLogoModel;
import com.educare.admin.model.AdminAddStudent;
import com.educare.admin.model.AdminAllIndiaMarksAnalysisPojo;
import com.educare.admin.model.AdminBelow100RanksInSubjectInCampusPojo;
import com.educare.admin.model.AdminCategory;
import com.educare.admin.model.AdminExamNameforReport;
import com.educare.admin.model.AdminFileUploadExampleModel;
import com.educare.admin.model.AdminFilterCriteria;
import com.educare.admin.model.AdminQtypesFromSlectedFileNamesModel;
import com.educare.admin.model.AdminSecwiseAttendeesWithAvgPojo;
import com.educare.admin.model.AdminSetExamPojo;
import com.educare.admin.model.AdminSetStartExamPatternModel;
import com.educare.admin.model.AdminSubjectWiserightwrongrepo;
import com.educare.admin.model.AdminSubjectwisemarksRanges;
import com.educare.admin.model.AdminTopicSubTopicsNameMoidifyModel;
import com.educare.admin.model.AdminUploadClientLogoModel;
import com.educare.admin.model.AdminViewAuditLogsModel;
import com.educare.admin.model.AdminViewExamQuesPaperModel;
import com.educare.admin.model.Adminofflinedatapojo;
import com.educare.admin.model.Adminstudentwisequestionerror;
import com.educare.admin.model.CampuswiseErrorreportPojo;
import com.educare.admin.model.Questionanalysispojo;
import com.educare.admin.model.ResultCalculationModel;
import com.educare.admin.model.StudentExamCountModel;
import com.educare.admin.model.SubjectWiseHighestReport;
import com.educare.admin.model.UpdateKeyModel;
import com.educare.dao.AdminRegisterDaoImpl;
import com.educare.model.QuestionPojo;
import com.educare.model.StudentExamAssignModel;

@Service("adminuserservice")
public class AdminRegisterServiceImpl implements AdminRegisterService {

	@Autowired
	AdminRegisterDaoImpl adminRegisterDao;

	@Override
	public List<AdminAddEditDeleteAccessforRolesPojo> getpermissionsforloggedusers(String studentid) {
		return adminRegisterDao.getpermissionsforloggedusers(studentid);
	}

	@Override
	public int generateClassTypeId() {
		return adminRegisterDao.generateClassTypeId();
	}

	@Override
	public int generateBranchTypeId() {
		return adminRegisterDao.generateBranchTypeId();
	}

	@Override
	public int generateLocationTypeId() {
		return adminRegisterDao.generateLocationTypeId();
	}

	@Override
	public int generateStateTypeId() {
		return adminRegisterDao.generateStateTypeId();
	}

	@Override
	public int generateSubjectTypeId() {
		return adminRegisterDao.generateSubjectTypeId();
	}

	@Override
	public int generateSectionTypeId() {
		return adminRegisterDao.generateSectionTypeId();
	}

	@Override
	public int getMaxSectionId() {
		return adminRegisterDao.getMaxSectionId();
	}

	@Override
	public int getMaxBranchId() {
		return adminRegisterDao.getMaxBranchId();
	}

	@Override
	public int getMaxLocationId() {
		return adminRegisterDao.getMaxLocationId();
	}

	@Override
	public int getMaxStateId() {
		return adminRegisterDao.getMaxStateId();
	}

	@Override
	public int getMaxSubjectId() {
		return adminRegisterDao.getMaxSubjectId();
	}

	@Override
	public int getMaxClassId() {
		return adminRegisterDao.getMaxClassId();
	}

	@Override
	public int getLastNumberFromelclass() {
		return adminRegisterDao.getLastNumberFromelclass();
	}

	@Override
	public int insertClassesFromAdmin(String className) {
		return adminRegisterDao.insertClassesFromAdmin(className);
	}

	@Override
	public List<AdminCategory> searchClassesFromAdmin() {
		return adminRegisterDao.searchClassesFromAdmin();
	}

	public int searchClassesFromAdmin1(String classname) {
		return adminRegisterDao.searchClassesFromAdmin1(classname);
	}

	@Override
	public int updateclass(String classname, String classid) {
		return adminRegisterDao.updateclass(classname, classid);
	}

	@Override
	public int deleteclass(String classid) {
		return adminRegisterDao.deleteclass(classid);
	}

	@Override
	public List<AdminCategory> searchSectionFromAdmin() {
		return adminRegisterDao.searchSectionFromAdmin();
	}

	public int searchSectionFromAdmin1(String locationname, String state) {
		return adminRegisterDao.searchSectionFromAdmin1(locationname, state);
	}

	public List<AdminCategory> searchSectionFromAdmin1(int classid) {
		return adminRegisterDao.searchSectionFromAdmin1(classid);
	}

	@Override
	public int insertSectionsFromAdmin(String sectionname, int cnameid) {
		return adminRegisterDao.insertSectionsFromAdmin(sectionname, cnameid);
	}

	@Override
	public int updateSection(String sectionname, String secid) {
		return adminRegisterDao.updateSection(sectionname, secid);
	}

	@Override
	public int deleteSection(String secid) {
		return adminRegisterDao.deleteSection(secid);
	}

	@Override
	public List<AdminCategory> searchBranchesFromAdmin() {
		return adminRegisterDao.searchBranchesFromAdmin();
	}

	public int searchBranchesFromAdmin1(String statename, String location, String stateid) {
		return adminRegisterDao.searchBranchesFromAdmin1(statename, location, stateid);
	}

	@Override
	public List<AdminCategory> searchStateFromAdmin() {
		return adminRegisterDao.searchStateFromAdmin();
	}

	@Override
	public List<AdminCategory> searchSubjectFromAdmin() {
		return adminRegisterDao.searchSubjectFromAdmin();
	}

	public int searchSubjectFromAdmin1(String statename, String classname) {
		return adminRegisterDao.searchSubjectFromAdmin1(statename, classname);
	}

	public List<AdminCategory> searchSubjectFromAdmin1(int classid) {
		return adminRegisterDao.searchSubjectFromAdmin1(classid);
	}

	@Override
	public int insertBranchFromAdmin(String branchname, int locationid) {
		return adminRegisterDao.insertBranchFromAdmin(branchname, locationid);
	}

	@Override
	public int updateBranch(String branchname, String bid) {
		return adminRegisterDao.updateBranch(branchname, bid);
	}

	@Override
	public int updateState(String statename, String stateid) {
		return adminRegisterDao.updateState(statename, stateid);
	}

	@Override
	public int deleteBranch(String bid) {
		return adminRegisterDao.deleteBranch(bid);
	}

	@Override
	public int deleteState(String bid) {
		return adminRegisterDao.deleteState(bid);
	}

	@Override
	public int deleteLocationbasedonState(String stateid) {
		return adminRegisterDao.deleteLocationbasedonState(stateid);
	}

	@Override
	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuser1(AdminAddNewStudent adc) {
		return adminRegisterDao.getUserNamenadEmailofAdminfromuser1(adc);
	}

	@Override
	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuser12(AdminAddNewStudent adc) {
		return adminRegisterDao.getUserNamenadEmailofAdminfromuser12(adc);
	}

	@Override
	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuserforLecturer() {
		return adminRegisterDao.getUserNamenadEmailofAdminfromuserforLecturer();
	}

	@Override
	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuserforAdmin() {
		return adminRegisterDao.getUserNamenadEmailofAdminfromuserforAdmin();
	}

	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuserforAdmin1(String roleid) {
		return adminRegisterDao.getUserNamenadEmailofAdminfromuserforAdmin1(roleid);
	}

	@Override
	public int insertstudentDetailsFromAdmin(String studentid, String firstname, String lastname, String username,
			String pass, String state, String location, String branch, String stcls, String section, String email,
			String phone) {
		return adminRegisterDao.insertstudentDetailsFromAdmin(studentid, firstname, lastname, username, pass, state,
				location, branch, stcls, section, email, phone);
	}

	public int updatestudentDetailsFromAdmin(String sid, String firstname, String lastname, String username,
			String email, String password, String mobile, String statenames, String locationname, String branch,
			String stdclass, String section, String userid, String status) {

		return adminRegisterDao.updatestudentDetailsFromAdmin(sid, firstname, lastname, username, email, password,
				mobile, statenames, locationname, branch, stdclass, section, userid, status);
	}

	@Override
	public int deleteStudent(String userid) {
		return adminRegisterDao.deleteStudent(userid);
	}

	@Override
	public int insertSubjectFromAdmin(String subjectname, int classid) {
		return adminRegisterDao.insertSubjectFromAdmin(subjectname, classid);
	}

	@Override
	public int updateSubject(String subject, String bid) {
		return adminRegisterDao.updateSubject(subject, bid);
	}

	@Override
	public int deleteSubject(String bid) {
		return adminRegisterDao.deleteSubject(bid);
	}

	public List<Map<String, Object>> getTopicIdsBasedonSubjectId(String subjectid) {
		return adminRegisterDao.getTopicIdsBasedonSubjectId(subjectid);
	}

	public int deletesubtopicsbasedontopicid(int topicid) {
		return adminRegisterDao.deletesubtopicsbasedontopicid(topicid);
	}

	public int deletetopicsbasedonsubjectid(String subjectid) {
		return adminRegisterDao.deletetopicsbasedonsubjectid(subjectid);
	}

	@Override
	public int deleteSubjectbasedonClass(String classid) {
		return adminRegisterDao.deleteSubjectbasedonClass(classid);
	}

	@Override
	public int deleteSectionbasedonClass(String classid) {
		return adminRegisterDao.deleteSectionbasedonClass(classid);
	}

	public int deleteSujectTopicsOnClass(String classid) {
		return adminRegisterDao.deleteSujectTopicsOnClass(classid);
	}

	@Override
	public List<AdminCategory> searchLocationsFromAdmin() {
		return adminRegisterDao.searchLocationsFromAdmin();
	}

	public int searchLocationsFromAdmin1(String locationname, String state) {
		return adminRegisterDao.searchLocationsFromAdmin1(locationname, state);
	}

	@Override
	public int insertLocationFromAdmin(String location, int stateid) {
		return adminRegisterDao.insertLocationFromAdmin(location, stateid);
	}

	@Override
	public int insertStateFromAdmin(String statename) {
		return adminRegisterDao.insertStateFromAdmin(statename);
	}

	@Override
	public int updateLocation(String location, String bid) {
		return adminRegisterDao.updateLocation(location, bid);
	}

	@Override
	public int deleteLocation(String bid) {
		return adminRegisterDao.deleteLocation(bid);
	}

	@Override
	public int deleteBranchbasedonLocation(String locationid) {
		return adminRegisterDao.deleteBranchbasedonLocation(locationid);
	}

	@Override
	public List<AdminSetExamPojo> gettopicsinsubject(String subjecttypeid, String examtypeid) {
		return adminRegisterDao.gettopicsinsubject(subjecttypeid, examtypeid);
	}

	@Override
	public List<AdminSetExamPojo> getAllsubtopicsinsubject(String examtypeid, String sujid) {
		return adminRegisterDao.getAllsubtopicsinsubject(examtypeid, sujid);
	}

	@Override
	public List<AdminSetExamPojo> getsubtopicsinsubject(String examtypeid, String sujid, String topicids) {
		return adminRegisterDao.getsubtopicsinsubject(examtypeid, sujid, topicids);
	}

	public List<AdminCategory> searchQuestiontypeFromAdmin() {
		return adminRegisterDao.searchQuestiontypeFromAdmin();
	}

	public List<AdminCategory> searchexamtypesFromAdmin() {
		return adminRegisterDao.searchexamtypesFromAdmin();
	}

	public List<AdminCategory> searchquestionleveltypesFromAdmin() {
		return adminRegisterDao.searchquestionleveltypesFromAdmin();
	}

	public List<Map<String, Object>> validateExamnameinelexamtable(String examnamevalue) {
		return adminRegisterDao.validateExamnameinelexamtable(examnamevalue);
	}

	public int deleteuserfromUserRole(String userid) {
		return adminRegisterDao.deleteuserfromUserRole(userid);
	}

	public List<AdminExamNameforReport> getExamNameWiseReportFromAdmin() {
		return adminRegisterDao.getExamNameWiseReportFromAdmin();
	}

	@Override
	public int updateQuestiontype(String subject, String bid) {
		return adminRegisterDao.updateQuestiontype(subject, bid);
	}

	public int getCountOfTotalStudentsAvailable(String classname, String sectionname, String branch,
			String statechckbox, String state) {
		return adminRegisterDao.getCountOfTotalStudentsAvailable(classname, sectionname, branch, statechckbox, state);
	}

	public List<AdminAddEditDeleteAccessforRolesPojo> getRolesforAdmin(String superadmroleid) {
		return adminRegisterDao.getRolesforAdmin(superadmroleid);
	}

	public List<AdminAddEditDeleteAccessforRolesPojo> getListofPermissions() {
		return adminRegisterDao.getListofPermissions();
	}

	public List<Map<String, Object>> getUserIDsbasedonRoleId(int roleid) {
		return adminRegisterDao.getUserIDsbasedonRoleId(roleid);
	}

	public List<AdminAddEditDeleteAccessforRolesPojo> getUsersbasedonRoleIds(String useridsjoined) {
		return adminRegisterDao.getUsersbasedonRoleIds(useridsjoined);
	}

	public int getalreadyinsertedinPermissions(int roleid, int permssionid, String studentid) {
		return adminRegisterDao.getalreadyinsertedinPermissions(roleid, permssionid, studentid);
	}

	public int insertPermissions(int roleid, int permssionid, String studentid) {
		return adminRegisterDao.insertPermissions(roleid, permssionid, studentid);
	}

	public List<AdminAddStudent> getUserNamenadEmailofAdminfromuser1() {
		return adminRegisterDao.getUserNamenadEmailofAdminfromuser1();
	}

	public List<AdminAddEditDeleteAccessforRolesPojo> getListofeditPermissions(int roleid, String studentid) {
		return adminRegisterDao.getListofeditPermissions(roleid, studentid);
	}

	public int updateuserpermissions(int permissionid, int roleid, String studentid) {
		return adminRegisterDao.updateuserpermissions(permissionid, roleid, studentid);

	}

	public List<AdminAllIndiaMarksAnalysisPojo> getuserdetailsfromStudentResults(String examname, String subjs) {
		return adminRegisterDao.getuserdetailsfromStudentResults(examname, subjs);

	}

	public List<AdminAllIndiaMarksAnalysisPojo> getuserdetailsfromStudentResultsOffline(String examname, String subjs) {
		return adminRegisterDao.getuserdetailsfromStudentResultsOffline(examname, subjs);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResults(String examname) {
		return adminRegisterDao.getsubjectsfromStudentResults(examname);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResultsOffline(String examname) {
		return adminRegisterDao.getsubjectsfromStudentResultsOffline(examname);
	}

	public List<CampuswiseErrorreportPojo> getuserdetailsfromStudentResultsHistory(String examname) {
		return adminRegisterDao.getuserdetailsfromStudentResultsHistory(examname);
	}

	public List<CampuswiseErrorreportPojo> getuserdetailsfromStudentResultsHistoryOffline(String examname) {
		return adminRegisterDao.getuserdetailsfromStudentResultsHistoryOffline(examname);
	}

	public List<CampuswiseErrorreportPojo> getuserdetailsfromStudentResultsHistoryforState(String examname) {
		return adminRegisterDao.getuserdetailsfromStudentResultsHistoryforState(examname);
	}

	public List<CampuswiseErrorreportPojo> getuserdetailsfromStudentResultsHistoryforStateOffline(String examname) {
		return adminRegisterDao.getuserdetailsfromStudentResultsHistoryforStateOffline(examname);
	}

	public int getCampuswiseExamstrength(String examname, int campusid) {
		return adminRegisterDao.getCampuswiseExamstrength(examname, campusid);
	}

	public int getCampuswiseExamstrengthOffline(String examname, int campusid) {
		return adminRegisterDao.getCampuswiseExamstrengthOffline(examname, campusid);
	}

	public int getStatewiseExamstrength(String examname, int stateid) {
		return adminRegisterDao.getStatewiseExamstrength(examname, stateid);
	}

	public int getStatewiseExamstrengthOffline(String examname, int stateid) {
		return adminRegisterDao.getStatewiseExamstrengthOffline(examname, stateid);
	}

	public List<CampuswiseErrorreportPojo> getAllQidsInCampuswise1(String examname) {
		return adminRegisterDao.getAllQidsInCampuswise1(examname);
	}

	public List<CampuswiseErrorreportPojo> getAllQidsInCampuswise1Offline(String examname) {
		return adminRegisterDao.getAllQidsInCampuswise1Offline(examname);
	}

	public List<CampuswiseErrorreportPojo> getAllQidsInCampuswise(String examname, int campusid, String subjectid) {
		return adminRegisterDao.getAllQidsInCampuswise(examname, campusid, subjectid);
	}

	public List<CampuswiseErrorreportPojo> getAllQidsInCampuswiseOffline(String examname, int campusid,
			String subjectid) {
		return adminRegisterDao.getAllQidsInCampuswiseOffline(examname, campusid, subjectid);
	}

	public List<CampuswiseErrorreportPojo> getAllQidsInStatewise(String examname, int stateid, String subjectid) {
		return adminRegisterDao.getAllQidsInStatewise(examname, stateid, subjectid);
	}

	public List<CampuswiseErrorreportPojo> getAllQidsInStatewiseOffline(String examname, int stateid,
			String subjectid) {
		return adminRegisterDao.getAllQidsInStatewiseOffline(examname, stateid, subjectid);
	}

	public int getCountOfAllErrorQuestionIdsIncampuswise(String examname, int campusid, int questionid,
			String subjectid, int questionrowid) {
		return adminRegisterDao.getCountOfAllErrorQuestionIdsIncampuswise(examname, campusid, questionid, subjectid,
				questionrowid);
	}

	public int getCountOfAllErrorQuestionIdsIncampuswiseOffline(String examname, int campusid, int questionid,
			String subjectid, int questionrowid) {
		return adminRegisterDao.getCountOfAllErrorQuestionIdsIncampuswiseOffline(examname, campusid, questionid,
				subjectid, questionrowid);
	}

	public int getCountOfAllErrorQuestionIdsInstatewise(String examname, int stateid, int questionid, String subjectid,
			int questionrowid) {
		return adminRegisterDao.getCountOfAllErrorQuestionIdsInstatewise(examname, stateid, questionid, subjectid,
				questionrowid);
	}

	public int getCountOfAllErrorQuestionIdsInstatewiseOffline(String examname, int stateid, int questionid,
			String subjectid, int questionrowid) {
		return adminRegisterDao.getCountOfAllErrorQuestionIdsInstatewiseOffline(examname, stateid, questionid,
				subjectid, questionrowid);
	}

	public List<AdminSubjectWiserightwrongrepo> adminSujectwiseRightWrongReportFromAdmin(String examname,
			String subjid) {
		return adminRegisterDao.adminSujectwiseRightWrongReportFromAdmin(examname, subjid);
	}

	public List<AdminSubjectWiserightwrongrepo> adminSujectwiseRightWrongReportFromAdminOffline(String examname,
			String subjid) {
		return adminRegisterDao.adminSujectwiseRightWrongReportFromAdminOffline(examname, subjid);
	}

	public int getsubjectwisewrongcount(String studid, String section, String campus, String examname,
			String subjectid) {
		return adminRegisterDao.getsubjectwisewrongcount(studid, section, campus, examname, subjectid);
	}

	public int getsubjectwisewrongcountOffline(String studid, String section, String campus, String examname,
			String subjectid) {
		return adminRegisterDao.getsubjectwisewrongcountOffline(studid, section, campus, examname, subjectid);
	}

	public int getsubjectwisecorrectcount(String studid, String section, String campus, String examname,
			String subjectid) {
		return adminRegisterDao.getsubjectwisecorrectcount(studid, section, campus, examname, subjectid);
	}

	public int getsubjectwisecorrectcountOffline(String studid, String section, String campus, String examname,
			String subjectid) {
		return adminRegisterDao.getsubjectwisecorrectcountOffline(studid, section, campus, examname, subjectid);
	}

	public int getsubjectwiseunattemptcount(String studid, String section, String campus, String examname,
			String subjectid) {
		return adminRegisterDao.getsubjectwiseunattemptcount(studid, section, campus, examname, subjectid);
	}

	public int getsubjectwiseunattemptcountOffline(String studid, String section, String campus, String examname,
			String subjectid) {
		return adminRegisterDao.getsubjectwiseunattemptcountOffline(studid, section, campus, examname, subjectid);
	}

	@Override
	public List<AdminSubjectwisemarksRanges> adminSujectwiseMarksRangesFromAdmin(String examname, String subjectid) {
		return adminRegisterDao.adminSujectwiseMarksRangesFromAdmin(examname, subjectid);
	}

	public int getexamstrengthformarksrangerepo(String examname, String campus, String subjectid) {
		return adminRegisterDao.getexamstrengthformarksrangerepo(examname, campus, subjectid);
	}

	public int getexammarksrangegreaterthanfiftyrepo(String examname, String campus, String subjectid) {
		return adminRegisterDao.getexammarksrangegreaterthanfiftyrepo(examname, campus, subjectid);
	}

	public int getexammarksrangegreaterthanfourtyyrepo(String examname, String campus, String subjectid) {
		return adminRegisterDao.getexammarksrangegreaterthanfourtyyrepo(examname, campus, subjectid);
	}

	public int getexammarksrangegreaterthanthirtyyrepo(String examname, String campus, String subjectid) {
		return adminRegisterDao.getexammarksrangegreaterthanthirtyyrepo(examname, campus, subjectid);
	}

	public int getexammarksrangegreaterthantwentyyrepo(String examname, String campus, String subjectid) {
		return adminRegisterDao.getexammarksrangegreaterthantwentyyrepo(examname, campus, subjectid);
	}

	public int getexammarksrangelessthantwentyyrepo(String examname, String campus, String subjectid) {
		return adminRegisterDao.getexammarksrangelessthantwentyyrepo(examname, campus, subjectid);
	}

	public int getexammarksrangegreaterthanfourtyfourrepo(String examname, String campus, String subjectid) {
		return adminRegisterDao.getexammarksrangegreaterthanfourtyfourrepo(examname, campus, subjectid);
	}

	public String getmaxmarksinsubjectwiserange(String examname, String campus, String subjectid) {
		return adminRegisterDao.getmaxmarksinsubjectwiserange(examname, campus, subjectid);
	}

	public List<Adminstudentwisequestionerror> adminQuestionWiseErrorReport(String examname) {
		return adminRegisterDao.adminQuestionWiseErrorReport(examname);
	}

	public List<Adminstudentwisequestionerror> adminQuestionWiseErrorReportOffline(String examname) {
		return adminRegisterDao.adminQuestionWiseErrorReportOffline(examname);
	}

	public List<Adminstudentwisequestionerror> admingetQuestionIdsforQerror(String examname, String campusid) {
		return adminRegisterDao.admingetQuestionIdsforQerror(examname, campusid);
	}

	public List<Adminstudentwisequestionerror> admingetQuestionIdsforQerrorOffline(String examname, String campusid) {
		return adminRegisterDao.admingetQuestionIdsforQerrorOffline(examname, campusid);
	}

	public List<Adminstudentwisequestionerror> admingetQuestionIdsforQerror1(String examname) {
		return adminRegisterDao.admingetQuestionIdsforQerror1(examname);
	}

	public List<Adminstudentwisequestionerror> admingetQuestionIdsforQerror1Offline(String examname) {
		return adminRegisterDao.admingetQuestionIdsforQerror1Offline(examname);
	}

	public List<Adminstudentwisequestionerror> getrightvalueforerrorreport(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		return adminRegisterDao.getrightvalueforerrorreport(questionid, examname, studentid, section, campus,
				questionrowid);
	}

	public List<Adminstudentwisequestionerror> getrightvalueforerrorreportOffline(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		return adminRegisterDao.getrightvalueforerrorreportOffline(questionid, examname, studentid, section, campus,
				questionrowid);
	}

	public List<Adminstudentwisequestionerror> getwrongvalueforerrorreport(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		return adminRegisterDao.getwrongvalueforerrorreport(questionid, examname, studentid, section, campus,
				questionrowid);
	}

	public List<Adminstudentwisequestionerror> getwrongvalueforerrorreportOffline(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		return adminRegisterDao.getwrongvalueforerrorreportOffline(questionid, examname, studentid, section, campus,
				questionrowid);
	}

	public List<Adminstudentwisequestionerror> getnotansweredvalueforerrorreport(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		return adminRegisterDao.getnotansweredvalueforerrorreport(questionid, examname, studentid, section, campus,
				questionrowid);
	}

	public List<Adminstudentwisequestionerror> getnotansweredvalueforerrorreportOffline(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		return adminRegisterDao.getnotansweredvalueforerrorreportOffline(questionid, examname, studentid, section,
				campus, questionrowid);
	}

	public int getAllIndiaRankBasedOnExamname(String examname, String studentid) {
		return adminRegisterDao.getAllIndiaRankBasedOnExamname(examname, studentid);
	}

	public int getAllIndiaRankBasedOnExamnameOffline(String examname, String studentid) {
		return adminRegisterDao.getAllIndiaRankBasedOnExamnameOffline(examname, studentid);
	}

	public String getScoredmarksForExam2(String examname1, int campusid, int stateid, String subjectid,
			String studentid, int sectionid) {
		return adminRegisterDao.getScoredmarksForExam2(examname1, campusid, stateid, subjectid, studentid, sectionid);
	}

	public int getAllIndiaCampusRankBasedOnExamname(String examname, String studentid, int campusid) {
		return adminRegisterDao.getAllIndiaCampusRankBasedOnExamname(examname, studentid, campusid);
	}

	public int getAllIndiaCampusRankBasedOnExamnameOffline(String examname, String studentid, int campusid) {
		return adminRegisterDao.getAllIndiaCampusRankBasedOnExamnameOffline(examname, studentid, campusid);
	}

	public int getAllIndiaStateRankBasedOnExamname(String examname, String studentid, int stateid) {
		return adminRegisterDao.getAllIndiaStateRankBasedOnExamname(examname, studentid, stateid);
	}

	public int getAllIndiaStateRankBasedOnExamnameOffline(String examname, String studentid, int stateid) {
		return adminRegisterDao.getAllIndiaStateRankBasedOnExamnameOffline(examname, studentid, stateid);
	}

	public int getAllIndiaSectionRankBasedOnExamname(String examname, String studentid, int sectionid) {
		return adminRegisterDao.getAllIndiaSectionRankBasedOnExamname(examname, studentid, sectionid);
	}

	public int getAllIndiaSectionRankBasedOnExamnameOffline(String examname, String studentid, int sectionid) {
		return adminRegisterDao.getAllIndiaSectionRankBasedOnExamnameOffline(examname, studentid, sectionid);
	}

	public List<AdminBelow100RanksInSubjectInCampusPojo> getCampusnamesInStudentResults(String examname) {
		return adminRegisterDao.getCampusnamesInStudentResults(examname);
	}

	public int getExamstrengthInCampuswiseBelow100Ranks(String examname, int campusid) {
		return adminRegisterDao.getExamstrengthInCampuswiseBelow100Ranks(examname, campusid);
	}

	public int getRankcountInCampuswiseBelow100Ranks(String examname, int campusid, String subjs1) {
		return adminRegisterDao.getRankcountInCampuswiseBelow100Ranks(examname, campusid, subjs1);
	}

	public String getMaxmarksInCampuswiseBelow100Ranks(String examname, int campusid, String subjs1) {
		return adminRegisterDao.getMaxmarksInCampuswiseBelow100Ranks(examname, campusid, subjs1);
	}

	public List<AdminSecwiseAttendeesWithAvgPojo> getCampusSectionfromStudentResults(String examname) {
		return adminRegisterDao.getCampusSectionfromStudentResults(examname);
	}

	public int getActualStudentsPresencePerSection(int sectionid, int campusid) {
		return adminRegisterDao.getActualStudentsPresencePerSection(sectionid, campusid);
	}

	public String getAvginSubjectsfromCampusSection(int campusid, int sectionid, String subjs1, String examname) {
		return adminRegisterDao.getAvginSubjectsfromCampusSection(campusid, sectionid, subjs1, examname);
	}

	public List<SubjectWiseHighestReport> getSubjectWiseHighestCampusName(String examname) {
		return adminRegisterDao.getSubjectWiseHighestCampusName(examname);
	}

	public int getExamStrength(String examname, String campusid) {
		return adminRegisterDao.getExamStrength(examname, campusid);
	}

	public List<Map<String, Object>> getDetailsOfPresentExam(String examname) {
		return adminRegisterDao.getDetailsOfPresentExam(examname);
	}

	public List<Map<String, Object>> getpreviousexamnameforreport(String examname, String presstateid,
			String preslocationid, String presbranchid, String presclassid, String pressectionid) {
		return adminRegisterDao.getpreviousexamnameforreport(examname, presstateid, preslocationid, presbranchid,
				presclassid, pressectionid);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getpreviousexamSubjectforreport(String examname) {
		return adminRegisterDao.getpreviousexamSubjectforreport(examname);
	}

	public List<AdminCategory> searchSubjectforClassFromAdmin(int classid) {
		return adminRegisterDao.searchSubjectforClassFromAdmin(classid);
	}

	public List<AdminCategory> searchTopicsforSubjectsFromAdmin(int classid, int subjectid) {
		return adminRegisterDao.searchTopicsforSubjectsFromAdmin(classid, subjectid);
	}

	public int insertDataintosubjecttopictypeTable(int classid, int subjectid, int topicid, String topictext,
			int examtypeid) {
		return adminRegisterDao.insertDataintosubjecttopictypeTable(classid, subjectid, topicid, topictext, examtypeid);
	}

	public List<AdminCategory> getTopicsFromAdmin(int classid, int subjectid) {
		return adminRegisterDao.getTopicsFromAdmin(classid, subjectid);
	}

	public List<AdminCategory> getSubtopicsFromAdmin(int classid, int subjectid, int topicid) {
		return adminRegisterDao.getSubtopicsFromAdmin(classid, subjectid, topicid);
	}

	public int insertDataintosubjectsubtopictypeTable(int subjectid, int topicid, int subtopicid, String subtopictext,
			int classid, int examtypeid) {
		return adminRegisterDao.insertDataintosubjectsubtopictypeTable(subjectid, topicid, subtopicid, subtopictext,
				classid, examtypeid);
	}

	public List<AdminCategory> getSubtopicsFromAdminInEditModule(int subtopicid, int topicid) {
		return adminRegisterDao.getSubtopicsFromAdminInEditModule(subtopicid, topicid);
	}

	public List<Map<String, Object>> getSubTopicNameFromSubtopicTable(int topicid, int subtopicid) {
		return adminRegisterDao.getSubTopicNameFromSubtopicTable(topicid, subtopicid);
	}

	public int updateDataintosubjectsubtopictypeTable(int subjectid, int topicid, int subtopicid, String subtopictext,
			int classid, int examtypeid) {
		return adminRegisterDao.updateDataintosubjectsubtopictypeTable(subjectid, topicid, subtopicid, subtopictext,
				classid, examtypeid);
	}

	public int deleteDataintosubjectsubtopictypeTable(int topicid, int subtopicid, String subtopictext) {
		return adminRegisterDao.deleteDataintosubjectsubtopictypeTable(topicid, subtopicid, subtopictext);
	}

	public List<Map<String, Object>> getTopicNameFromTopicTable(int classid, int subjectid, int topicid) {
		return adminRegisterDao.getTopicNameFromTopicTable(classid, subjectid, topicid);
	}

	public int updateDataintosubjecttopictypeTable(int classid, int subjectid, int topicid, String topictext,
			int examtypeid) {
		return adminRegisterDao.updateDataintosubjecttopictypeTable(classid, subjectid, topicid, topictext, examtypeid);
	}

	public int deleteDataintosubjecttopictypeTable(int classid, int subjectid, int topicid, String topictext) {
		return adminRegisterDao.deleteDataintosubjecttopictypeTable(classid, subjectid, topicid, topictext);
	}

	public int deleteALLDataintosubjectsubtopictypeTable(int topicid) {
		return adminRegisterDao.deleteALLDataintosubjectsubtopictypeTable(topicid);
	}

	public int getCountofScoredmarksForExam2(String examname1, int campusid, int stateid, String subjectid,
			String studentid, int sectionid) {
		return adminRegisterDao.getCountofScoredmarksForExam2(examname1, campusid, stateid, subjectid, studentid,
				sectionid);
	}

	public List<AdminCategory> getsectionsfromClass(int classid) {
		return adminRegisterDao.getsectionsfromClass(classid);
	}

	public List<AdminCategory> getsubjectsfromClass(int classid) {
		return adminRegisterDao.getsubjectsfromClass(classid);
	}

	public List<AdminCategory> searchExamtypeFromAdmin() {
		return adminRegisterDao.searchExamtypeFromAdmin();
	}

	public int searchExamtypeFromAdmin1(String statename) {
		return adminRegisterDao.searchExamtypeFromAdmin1(statename);
	}

	public int insertExamtypeFromAdmin(String examtype) {
		return adminRegisterDao.insertExamtypeFromAdmin(examtype);
	}

	public int generateExamTypeId() {
		return adminRegisterDao.generateExamTypeId();
	}

	public int getLastNumberFromelExamtype() {
		return adminRegisterDao.getLastNumberFromelExamtype();
	}

	public int getMaxExamtypeId() {
		return adminRegisterDao.getMaxExamtypeId();
	}

	public List<AdminCategory> searchQuestionlevelFromAdmin() {
		return adminRegisterDao.searchQuestionlevelFromAdmin();
	}

	public int searchQuestionlevelFromAdmin1(String statename) {
		return adminRegisterDao.searchQuestionlevelFromAdmin1(statename);
	}

	public int insertQuestionlevelFromAdmin(String examtype) {
		return adminRegisterDao.insertQuestionlevelFromAdmin(examtype);
	}

	public int generateQuestionlevelId() {
		return adminRegisterDao.generateQuestionlevelId();
	}

	public int getMaxQuestionlevelId() {
		return adminRegisterDao.getMaxQuestionlevelId();
	}

	public int getLastNumberFromQuestionlevel() {
		return adminRegisterDao.getLastNumberFromQuestionlevel();
	}

	public int updateEXamtype(String examtype, String examtypeid) {
		return adminRegisterDao.updateEXamtype(examtype, examtypeid);
	}

	public int updateQuestionlevel(String examtype, String examtypeid) {
		return adminRegisterDao.updateQuestionlevel(examtype, examtypeid);
	}

	public int deleteExamtype(String classid) {
		return adminRegisterDao.deleteExamtype(classid);
	}

	public int deleteQuestionlevelFromAdmin(String classid) {
		return adminRegisterDao.deleteQuestionlevelFromAdmin(classid);
	}

	public String getAllIndiaReportSubjectRank(String examname, String studentid, String subjs) {
		return adminRegisterDao.getAllIndiaReportSubjectRank(examname, studentid, subjs);
	}

	public String getAllIndiaReportSubjectRankOffline(String examname, String studentid, String subjs) {
		return adminRegisterDao.getAllIndiaReportSubjectRankOffline(examname, studentid, subjs);
	}

	public float getScoredmarksPerSubject(String examname, String studentid, String subjs1) {
		return adminRegisterDao.getScoredmarksPerSubject(examname, studentid, subjs1);
	}

	public int getScoredmarksPerSubjectOffline(String examname, String studentid, String subjs1) {
		return adminRegisterDao.getScoredmarksPerSubjectOffline(examname, studentid, subjs1);
	}

	public String getuserdetailsfromStudentResultsInAnotherSubj(String examname, String subj, int classid,
			int sectionid, int campusid, int stateid, String studentid) {
		return adminRegisterDao.getuserdetailsfromStudentResultsInAnotherSubj(examname, subj, classid, sectionid,
				campusid, stateid, studentid);
	}

	public String getuserdetailsfromStudentResultsInAnotherSubjOffline(String examname, String subj, int classid,
			int sectionid, int campusid, int stateid, String studentid) {
		return adminRegisterDao.getuserdetailsfromStudentResultsInAnotherSubjOffline(examname, subj, classid, sectionid,
				campusid, stateid, studentid);
	}

	public int getActualStudentsPresencePerSectionInExam(int sectionid, String examname, int campusid) {
		return adminRegisterDao.getActualStudentsPresencePerSectionInExam(sectionid, examname, campusid);
	}

	public String getAvgInTotalmarksFromCampusSection(int campusid, int sectionid, String examname) {
		return adminRegisterDao.getAvgInTotalmarksFromCampusSection(campusid, sectionid, examname);
	}

	public int getmaxquestionlength(String examname, String subjectid) {
		return adminRegisterDao.getmaxquestionlength(examname, subjectid);
	}

	public int getmaxquestionlengthOffline(String examname, String subjectid) {
		return adminRegisterDao.getmaxquestionlengthOffline(examname, subjectid);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResultsIncampus(String examname, int campusid) {
		return adminRegisterDao.getsubjectsfromStudentResultsIncampus(examname, campusid);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResultsIncampusOffline(String examname,
			int campusid) {
		return adminRegisterDao.getsubjectsfromStudentResultsIncampusOffline(examname, campusid);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResultsforstate(String examname, int stateid) {
		return adminRegisterDao.getsubjectsfromStudentResultsforstate(examname, stateid);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResultsforstateOffline(String examname,
			int stateid) {
		return adminRegisterDao.getsubjectsfromStudentResultsforstateOffline(examname, stateid);
	}

	public float gettotalscoreforsubjecthighestmarkrepo(String examname, String campusid) {
		return adminRegisterDao.gettotalscoreforsubjecthighestmarkrepo(examname, campusid);
	}

	public String getstudentifforhighestmarkreport(String examname, String campusid, float totalscore) {
		return adminRegisterDao.getstudentifforhighestmarkreport(examname, campusid, totalscore);
	}

	public String getscoremarksforhighestmarkrepo(String examname, String studenid, String subjectid) {
		return adminRegisterDao.getscoremarksforhighestmarkrepo(examname, studenid, subjectid);
	}

	public int getcampuswiserankforsubjecthighest(String studenid, String examname, String subjectid, String campusid) {
		return adminRegisterDao.getcampuswiserankforsubjecthighest(studenid, examname, subjectid, campusid);
	}

	public String getscoremarksforhighestreportsubjectwises(String examname, String campusid, String subjectid) {
		return adminRegisterDao.getscoremarksforhighestreportsubjectwises(examname, campusid, subjectid);
	}

	public String getstudentifforhighestmarkreportforsubject(String examname, String campusid,
			String scoredmarkssubjectwise) {
		return adminRegisterDao.getstudentifforhighestmarkreportforsubject(examname, campusid, scoredmarkssubjectwise);
	}

	public int getallindiarankforhighestmarkreport(String examname, String studenid) {
		return adminRegisterDao.getallindiarankforhighestmarkreport(examname, studenid);
	}

	public int getAllIndiaReportSubjectRank1(String examname, String studentid, String subjs) {
		return adminRegisterDao.getAllIndiaReportSubjectRank1(examname, studentid, subjs);
	}

	public int getSubjectRankInCampuswiseSubjectTopper(String examname, String studentidval, String campusid,
			String subjs) {
		return adminRegisterDao.getSubjectRankInCampuswiseSubjectTopper(examname, studentidval, campusid, subjs);
	}

	public List<AdminCategory> searchLocationsFromAdminBasedonStates(String stateid) {
		return adminRegisterDao.searchLocationsFromAdminBasedonStates(stateid);
	}

	public List<AdminCategory> searchBranchesFromAdminBasedonLocation(String locationid) {
		return adminRegisterDao.searchBranchesFromAdminBasedonLocation(locationid);
	}

	public List<AdminTopicSubTopicsNameMoidifyModel> getTopicsSubTopicsFromQuestions(
			AdminTopicSubTopicsNameMoidifyModel tsm) {
		return adminRegisterDao.getTopicsSubTopicsFromQuestions(tsm);
	}

	public int getCountOfTopicsAvailable(String classid, String subjectid, String topicid, int examtypeid) {
		return adminRegisterDao.getCountOfTopicsAvailable(classid, subjectid, topicid, examtypeid);
	}

	public int getCountOfSubTopicsAvailable(String classid1, String subjectid1, String topicid1, int examtypeid,
			int subtopicid) {
		return adminRegisterDao.getCountOfSubTopicsAvailable(classid1, subjectid1, topicid1, examtypeid, subtopicid);
	}

	public List<AdminFilterCriteria> adminFilterCriteriaForCreateExam(AdminFilterCriteria adc) {
		return adminRegisterDao.adminFilterCriteriaForCreateExam(adc);
	}

	public List<AdminCategory> getExamNameForCopyExam() {
		return adminRegisterDao.getExamNameForCopyExam();
	}

	public List<AdminCategory> getExamNameForCopySlotExam(String isslotYes) {
		return adminRegisterDao.getExamNameForCopySlotExam(isslotYes);
	}

	public List<AdminCategory> getExamnameAndExamTypeForCopyExam(String selectedExam) {
		return adminRegisterDao.getExamnameAndExamTypeForCopyExam(selectedExam);
	}

	public List<AdminCategory> getPreviousStatesForCopyExam(String selectedExam) {
		return adminRegisterDao.getPreviousStatesForCopyExam(selectedExam);
	}

	public List<AdminCategory> getPreviousLocationsForCopyExam(String selectedExam) {
		return adminRegisterDao.getPreviousLocationsForCopyExam(selectedExam);
	}

	public List<AdminCategory> getPreviousBranchesForCopyExam(String selectedExam) {
		return adminRegisterDao.getPreviousBranchesForCopyExam(selectedExam);
	}

	public List<AdminCategory> getPreviousQuelevelidsForCopyExam(String selectedExam) {
		return adminRegisterDao.getPreviousQuelevelidsForCopyExam(selectedExam);
	}

	public List<AdminCategory> getPreviousClassidsForCopyExam(String selectedExam) {
		return adminRegisterDao.getPreviousClassidsForCopyExam(selectedExam);
	}

	public List<AdminCategory> getPreviousSectionidsForCopyExam(String selectedExam, int classid) {
		return adminRegisterDao.getPreviousSectionidsForCopyExam(selectedExam, classid);
	}

	public List<AdminCategory> getPreviousSubjectsForCopyExam(String selectedExam) {
		return adminRegisterDao.getPreviousSubjectsForCopyExam(selectedExam);
	}

	public List<AdminCategory> getSelectedClassSubjectsForCopyExam(String selectedExam) {
		return adminRegisterDao.getSelectedClassSubjectsForCopyExam(selectedExam);
	}

	public List<AdminCategory> getSelectedSubjectQnsForCopyExam(String selectedExam) {
		return adminRegisterDao.getSelectedSubjectQnsForCopyExam(selectedExam);
	}

	public List<AdminCategory> getPreviousQuestiontypeForCopyExam(String selectedExam) {
		return adminRegisterDao.getPreviousQuestiontypeForCopyExam(selectedExam);
	}

	public List<AdminCategory> getPreviousQuestionstypeDataForCopyExam(String selectedExam, String qustype) {
		return adminRegisterDao.getPreviousQuestionstypeDataForCopyExam(selectedExam, qustype);
	}

	public List<AdminCategory> getPreviousQtypeMarksDataForCopyExam(String selectedExam, String qustypeid,
			String subjectids) {
		return adminRegisterDao.getPreviousQtypeMarksDataForCopyExam(selectedExam, qustypeid, subjectids);
	}

	public String getPreviousIsmarksForCopyExam(String selectedExam) {
		return adminRegisterDao.getPreviousIsmarksForCopyExam(selectedExam);
	}

	public int getPreviousMarksperQustypeForCopyexam(String selectedExam, String ismarks) {
		return adminRegisterDao.getPreviousMarksperQustypeForCopyexam(selectedExam, ismarks);
	}

	public String getPreviousNegativemarksForCopyexam(String selectedExam) {
		return adminRegisterDao.getPreviousNegativemarksForCopyexam(selectedExam);
	}

	public String getPreviousStarttimeForCopyexam(String selectedExam) {
		return adminRegisterDao.getPreviousStarttimeForCopyexam(selectedExam);
	}

	public String getPreviousEndtimeForCopyexam(String selectedExam) {
		return adminRegisterDao.getPreviousEndtimeForCopyexam(selectedExam);
	}

	public String getPreviousTestdurationForCopyexam(String selectedExam) {
		return adminRegisterDao.getPreviousTestdurationForCopyexam(selectedExam);
	}

	public int getDeleteExamname(String selectedExam) {
		return adminRegisterDao.getDeleteExamname(selectedExam);
	}

	public int getDeleteExamnameInExampaper(String selectedExam) {
		return adminRegisterDao.getDeleteExamnameInExampaper(selectedExam);
	}

	public int getDeleteExamnameInExampaper1(String selectedExam) {
		return adminRegisterDao.getDeleteExamnameInExampaper1(selectedExam);
	}
	public int getDeleteExamnameInTempHistrory(String selectedExam) {
		return adminRegisterDao.getDeleteExamnameInTempHistrory(selectedExam);
	}

	public int getSelectExamnameInstudentResults(String selectedExam) {
		return adminRegisterDao.getSelectExamnameInstudentResults(selectedExam);
	}

	public int getSelectExamnameInstudentResultsHistory(String selectedExam) {
		return adminRegisterDao.getSelectExamnameInstudentResultsHistory(selectedExam);
	}

	public int insertBulkdataintoUsers(AdminFileUploadExampleModel val) {
		return adminRegisterDao.insertBulkdataintoUsers(val);
	}

	public int getUpdateUseridInUSerRoles(int userid, int roleid) {
		return adminRegisterDao.getUpdateUseridInUSerRoles(userid, roleid);
	}

	public int userroleIdAlreadyexistCount(AdminFileUploadExampleModel user) {
		return adminRegisterDao.userroleIdAlreadyexistCount(user);
	}

	public int getUsernameAndEmail(AdminFileUploadExampleModel val) {
		return adminRegisterDao.getUsernameAndEmail(val);
	}

	public int getUsernameAndEmail1(AdminFileUploadExampleModel val) {
		return adminRegisterDao.getUsernameAndEmail1(val);
	}

	public List<AdminCategory> getFilenamesforSubjects1(String subjecttypeid, String examtypeid, String topicid,
			String subtopicid) {
		return adminRegisterDao.getFilenamesforSubjects1(subjecttypeid, examtypeid, topicid, subtopicid);
	}

	public List<QuestionPojo> getAllSelectedQuestions(String filenames, int subid, int qulid) {
		return adminRegisterDao.getAllSelectedQuestions(filenames, subid, qulid);
	}

	public String getTopicsForSelectedQuestions(String filenames) {
		return adminRegisterDao.getTopicsForSelectedQuestions(filenames);
	}

	public String getSubTopicsForSelectedQuestions(String filenames) {
		return adminRegisterDao.getSubTopicsForSelectedQuestions(filenames);
	}

	public String getQuesidsForSelectedQuestions(String filenames) {
		return adminRegisterDao.getQuesidsForSelectedQuestions(filenames);
	}

	public String getQuslvlIdsForSelectedQuestions(String filenames) {
		return adminRegisterDao.getQuslvlIdsForSelectedQuestions(filenames);
	}

	public List<AdminAddCompQuesInExamModel> getExamNameForAddComphQues() {
		return adminRegisterDao.getExamNameForAddComphQues();
	}

	public List<AdminAddCompQuesInExamModel> getExamdataBasedonExamname(String examname) {
		return adminRegisterDao.getExamdataBasedonExamname(examname);
	}

	public List<AdminQtypesFromSlectedFileNamesModel> getQtypesFromFileName(String filenames) {
		return adminRegisterDao.getQtypesFromFileName(filenames);
	}

	public List<AdminViewAuditLogsModel> getAllAuditslogsDetails(AdminViewAuditLogsModel av) {
		return adminRegisterDao.getAllAuditslogsDetails(av);
	}

	public List<Map<String, Object>> getStudentidforQuestionanalysis(String examname) {
		return adminRegisterDao.getStudentidforQuestionanalysis(examname);
	}

	public List<Questionanalysispojo> getQuestionWiseAnalysisData(String examname, String examstatus,
			String subjoinedstudentids) {
		return adminRegisterDao.getQuestionWiseAnalysisData(examname, examstatus, subjoinedstudentids);
	}

	public int getQuestionWiseCountforAnalalysis(String examname, String studentid) {
		return adminRegisterDao.getQuestionWiseCountforAnalalysis(examname, studentid);
	}

	public List<Questionanalysispojo> getQuestinonWiseTimeDifferencevalues(String examname, String studentid) {
		return adminRegisterDao.getQuestinonWiseTimeDifferencevalues(examname, studentid);
	}

	public int getcountNextQuestionTimetakenvalue(String presnttime, String examname, String studentid) {
		return adminRegisterDao.getcountNextQuestionTimetakenvalue(presnttime, examname, studentid);
	}

	public String getNextQuestionTimetakenvalue(String presnttime, String examname, String studentid) {
		return adminRegisterDao.getNextQuestionTimetakenvalue(presnttime, examname, studentid);
	}

	public List<Questionanalysispojo> getAvgtimeBasedonExamname(String examname, String examstatus) {
		return adminRegisterDao.getAvgtimeBasedonExamname(examname, examstatus);
	}

	public int getQuestionsCountBasedonExamname(String examname) {
		return adminRegisterDao.getQuestionsCountBasedonExamname(examname);
	}

	public int updateRandomQuestionsInExampaper(String selectedExam, String isJumbling) {
		return adminRegisterDao.updateRandomQuestionsInExampaper(selectedExam, isJumbling);
	}

	public List<AdminCategory> getQuestionsFromFileName(String filenames) {
		return adminRegisterDao.getQuestionsFromFileName(filenames);
	}

	public int insertintoOmrSheetData(String examname, String userid, String series, int j, String finalval,
			String rightanswer, String columname, int stateid, int locationid, int branchid, int classid, int sectionid,
			String firstname, String subjectid, String offlineKeyid) {
		return adminRegisterDao.insertintoOmrSheetData(examname, userid, series, j, finalval, rightanswer, columname,
				stateid, locationid, branchid, classid, sectionid, firstname, subjectid, offlineKeyid);
	}

	public List<Map<String, Object>> validateExamnameforoffline(String examnamevalue) {
		return adminRegisterDao.validateExamnameforoffline(examnamevalue);
	}

	public List<Map<String, Object>> validateExamnameforofflinekey(String examnamevalue) {
		return adminRegisterDao.validateExamnameforofflinekey(examnamevalue);
	}

	public List<Map<String, Object>> getActualOfflineKey(String examname, int j) {
		return adminRegisterDao.getActualOfflineKey(examname, j);
	}

	public int getcountforOfflinekeys(String examname) {
		return adminRegisterDao.getcountforOfflinekeys(examname);
	}

	public List<Adminofflinedatapojo> getofflineUserDataBasedonstudentid(String userid) {
		return adminRegisterDao.getofflineUserDataBasedonstudentid(userid);
	}

	public List<Adminofflinedatapojo> getExamNameforoffline(String isresult) {
		return adminRegisterDao.getExamNameforoffline(isresult);
	}

	public List<Adminofflinedatapojo> getStudentidsBasedonExamname(String examname) {
		return adminRegisterDao.getStudentidsBasedonExamname(examname);
	}

	public List<Adminofflinedatapojo> getSubjectnamesInOfflineExam(String examname) {
		return adminRegisterDao.getSubjectnamesInOfflineExam(examname);
	}

	public int getCountOfSubjectnamesInOfflineExam(String examname) {
		return adminRegisterDao.getCountOfSubjectnamesInOfflineExam(examname);
	}

	public int getTotalmarksForOfflineexam(String examname) {
		return adminRegisterDao.getTotalmarksForOfflineexam(examname);
	}

	public int getTotalQuestionsInOfflineExam(String examname) {
		return adminRegisterDao.getTotalQuestionsInOfflineExam(examname);
	}

	public List<Adminofflinedatapojo> getOfflineExamdataInHistory(String examname, String studentid, String subid) {
		return adminRegisterDao.getOfflineExamdataInHistory(examname, studentid, subid);
	}

	public List<Map<String, Object>> getsubjectwisemarksforOfflineExam(String examname, String subid) {
		return adminRegisterDao.getsubjectwisemarksforOfflineExam(examname, subid);
	}

	public int getQustypeBasedonQidInofflineexam(int qid, String examname) {
		return adminRegisterDao.getQustypeBasedonQidInofflineexam(qid, examname);
	}

	public int getScoredmarksInOfflineExam(int qustype, String examname, String subid) {
		return adminRegisterDao.getScoredmarksInOfflineExam(qustype, examname, subid);
	}

	public int getNegativeMarksInOfflineExam(int qustype, String examname, String subid) {
		return adminRegisterDao.getNegativeMarksInOfflineExam(qustype, examname, subid);
	}

	public String getCorrectKeyInKeySheet(int qid, String examname) {
		return adminRegisterDao.getCorrectKeyInKeySheet(qid, examname);
	}

	public int insertStudentResultsForOfflineexam(String studentid, String examname, String subid, int yourMarks1,
			int totalquestions, int totalAnswered, String firstname, int stateid, int locationid, int branchid,
			int classid, int sectionid, int totalmarks, int nmarks, int totalWrongAnswered, int totalnotAnswered,
			int subjecttotalmarks) {
		return adminRegisterDao.insertStudentResultsForOfflineexam(studentid, examname, subid, yourMarks1,
				totalquestions, totalAnswered, firstname, stateid, locationid, branchid, classid, sectionid, totalmarks,
				nmarks, totalWrongAnswered, totalnotAnswered, subjecttotalmarks);
	}

	public int updateExamscoredMarksOfflinexam(String studentid, String examname, int examScoredMarks) {
		return adminRegisterDao.updateExamscoredMarksOfflinexam(studentid, examname, examScoredMarks);
	}

	public int updateIsresultscalculationsStatus(String studentid, String examname, String isResultscal) {
		return adminRegisterDao.updateIsresultscalculationsStatus(studentid, examname, isResultscal);
	}

	public List<Adminofflinedatapojo> getExamNameforofflineReport(String isresult) {
		return adminRegisterDao.getExamNameforofflineReport(isresult);
	}

	public List<SubjectWiseHighestReport> getSubjectWiseHighestCampusNameoffline(String examname) {
		return adminRegisterDao.getSubjectWiseHighestCampusNameoffline(examname);
	}

	public int gettotalscoreforsubjecthighestmarkrepooffline(String examname, String campusid) {
		return adminRegisterDao.gettotalscoreforsubjecthighestmarkrepooffline(examname, campusid);
	}

	public String getstudentifforhighestmarkreportoffline(String examname, String campusid, int totalscore1) {
		return adminRegisterDao.getstudentifforhighestmarkreportoffline(examname, campusid, totalscore1);
	}

	public int getallindiarankforhighestmarkreportoffline(String examname, String studenid) {
		return adminRegisterDao.getallindiarankforhighestmarkreportoffline(examname, studenid);
	}

	public String getscoremarksforhighestmarkrepooffline(String examname, String studenid, String string) {
		return adminRegisterDao.getscoremarksforhighestmarkrepooffline(examname, studenid, string);
	}

	public int getcampuswiserankforsubjecthighestoffline(String studenid, String examname, String string,
			String campusid) {
		return adminRegisterDao.getcampuswiserankforsubjecthighestoffline(studenid, examname, string, campusid);
	}

	public String getscoremarksforhighestreportsubjectwisesoffline(String examname, String campusid, String string) {
		return adminRegisterDao.getscoremarksforhighestreportsubjectwisesoffline(examname, campusid, string);
	}

	public String getstudentifforhighestmarkreportforsubjectoffline(String examname, String campusid,
			String scoredmarkssubjectwise) {
		return adminRegisterDao.getstudentifforhighestmarkreportforsubjectoffline(examname, campusid,
				scoredmarkssubjectwise);
	}

	public int getSubjectRankInCampuswiseSubjectTopperoffline(String examname, String studentidval, String campusid,
			String string) {
		return adminRegisterDao.getSubjectRankInCampuswiseSubjectTopperoffline(examname, studentidval, campusid,
				string);
	}

	public int getExamStrengthoffline(String examname, String campusid) {
		return adminRegisterDao.getExamStrengthoffline(examname, campusid);
	}

	public List<AdminSubjectwisemarksRanges> adminSujectwiseMarksRangesFromAdminoffline(String examname,
			String string) {
		return adminRegisterDao.adminSujectwiseMarksRangesFromAdminoffline(examname, string);
	}

	public int getexammarksrangegreaterthanfourtyfourrepooffline(String examname, String campusid, String string) {
		return adminRegisterDao.getexammarksrangegreaterthanfourtyfourrepooffline(examname, campusid, string);
	}

	public String getmaxmarksinsubjectwiserangeoffline(String examname, String campusid, String string) {
		return adminRegisterDao.getmaxmarksinsubjectwiserangeoffline(examname, campusid, string);
	}

	public List<AdminBelow100RanksInSubjectInCampusPojo> getCampusnamesInStudentResultsoffline(String examname) {
		return adminRegisterDao.getCampusnamesInStudentResultsoffline(examname);
	}

	public int getExamstrengthInCampuswiseBelow100Ranksoffline(String examname, int campusid) {
		return adminRegisterDao.getExamstrengthInCampuswiseBelow100Ranksoffline(examname, campusid);
	}

	public int getRankcountInCampuswiseBelow100Ranksoffline(String examname, int campusid, String subjectid) {
		return adminRegisterDao.getRankcountInCampuswiseBelow100Ranksoffline(examname, campusid, subjectid);
	}

	public String getMaxmarksInCampuswiseBelow100Ranksoffline(String examname, int campusid, String subjectid) {
		return adminRegisterDao.getMaxmarksInCampuswiseBelow100Ranksoffline(examname, campusid, subjectid);
	}

	public List<AdminSecwiseAttendeesWithAvgPojo> getCampusSectionfromStudentResultsoffline(String examname) {
		return adminRegisterDao.getCampusSectionfromStudentResultsoffline(examname);
	}

	public int getActualStudentsPresencePerSectionoffline(int sectionid, int campusid) {
		return adminRegisterDao.getActualStudentsPresencePerSectionoffline(sectionid, campusid);
	}

	public int getActualStudentsPresencePerSectionInExamoffline(int sectionid, String examname, int campusid) {
		return adminRegisterDao.getActualStudentsPresencePerSectionInExamoffline(sectionid, examname, campusid);
	}

	public String getAvginSubjectsfromCampusSectionoffline(int campusid, int sectionid, String subjectid,
			String examname) {
		return adminRegisterDao.getAvginSubjectsfromCampusSectionoffline(campusid, sectionid, subjectid, examname);
	}

	public String getAvgInTotalmarksFromCampusSectionoffline(int campusid, int sectionid, String examname) {
		return adminRegisterDao.getAvgInTotalmarksFromCampusSectionoffline(campusid, sectionid, examname);
	}

	public List<Map<String, Object>> getDetailsOfPresentExamoffline(String examname) {
		return adminRegisterDao.getDetailsOfPresentExamoffline(examname);
	}

	public List<Map<String, Object>> getpreviousexamnameforreportoffline(String examname, String presstateid,
			String preslocationid, String presbranchid, String presclassid, String pressectionid) {
		return adminRegisterDao.getpreviousexamnameforreportoffline(examname, presstateid, preslocationid, presbranchid,
				presclassid, pressectionid);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getpreviousexamSubjectforreportoffline(String examname1) {
		return adminRegisterDao.getpreviousexamSubjectforreportoffline(examname1);
	}

	public int getAllIndiaRankBasedOnExamnameoffline(String examname, String studentid) {
		return adminRegisterDao.getAllIndiaRankBasedOnExamnameoffline(examname, studentid);
	}

	public int getAllIndiaReportSubjectRank1offline(String examname, String studentid, String subjectid) {
		return adminRegisterDao.getAllIndiaReportSubjectRank1offline(examname, studentid, subjectid);
	}

	public int getCountofScoredmarksForExam2offline(String examname, int campusid, int stateid, String subjectid,
			String studentid, int sectionid) {
		return adminRegisterDao.getCountofScoredmarksForExam2offline(examname, campusid, stateid, subjectid, studentid,
				sectionid);
	}

	public String getScoredmarksForExam2offline(String examname, int campusid, int stateid, String subjectid,
			String studentid, int sectionid) {
		return adminRegisterDao.getScoredmarksForExam2offline(examname, campusid, stateid, subjectid, studentid,
				sectionid);
	}

	public int getexamstrengthformarksrangerepooffline(String examname, String campusid, String subjectid) {
		return adminRegisterDao.getexamstrengthformarksrangerepooffline(examname, campusid, subjectid);
	}

	public int getexammarksrangegreaterthanfiftyrepooffline(String examname, String campusid, String string) {
		return adminRegisterDao.getexammarksrangegreaterthanfiftyrepooffline(examname, campusid, string);
	}

	public int getexammarksrangegreaterthanfourtyyrepooffline(String examname, String campusid, String string) {
		return adminRegisterDao.getexammarksrangegreaterthanfourtyyrepooffline(examname, campusid, string);
	}

	public int getexammarksrangegreaterthanthirtyyrepooffline(String examname, String campusid, String string) {
		return adminRegisterDao.getexammarksrangegreaterthanthirtyyrepooffline(examname, campusid, string);
	}

	public int getexammarksrangegreaterthantwentyyrepooffline(String examname, String campusid, String string) {
		return adminRegisterDao.getexammarksrangegreaterthantwentyyrepooffline(examname, campusid, string);
	}

	public int getexammarksrangelessthantwentyyrepooffline(String examname, String campusid, String string) {
		return adminRegisterDao.getexammarksrangelessthantwentyyrepooffline(examname, campusid, string);
	}

	public List<Map<String, Object>> getExamnameFromKeyTable(String isgenerated) {
		return adminRegisterDao.getExamnameFromKeyTable(isgenerated);
	}

	public int insertOfflineKey(String examname, String classid, String subjid, String examtypeid, int questionid,
			String keyvalues, String numberofQnsPerSubj, String qntypeid, int qnsPerQntype1, int marksPerQntype1,
			String negPerQntype, int totalmarksperQntype, int totalquestions, int totalmarks) {
		return adminRegisterDao.insertOfflineKey(examname, classid, subjid, examtypeid, questionid, keyvalues,
				numberofQnsPerSubj, qntypeid, qnsPerQntype1, marksPerQntype1, negPerQntype, totalmarksperQntype,
				totalquestions, totalmarks);
	}

	public int deleteOfflineInvalidKeyEntries(String examname) {
		return adminRegisterDao.deleteOfflineInvalidKeyEntries(examname);

	}

	public List<AdminCategory> viewStateAssociateLcBr() {
		return adminRegisterDao.viewStateAssociateLcBr();
	}

	public int updateKeyStatus(String examname, String isdatfilegenerated) {
		return adminRegisterDao.updateKeyStatus(examname, isdatfilegenerated);

	}

	public String getActualStartTimeFromTemp(String examname, String studentid) {
		return adminRegisterDao.getActualStartTimeFromTemp(examname, studentid);
	}

	public int insertOfflineKeyFromExcel(String examname, String examtypeid, String classid, int numberofqns,
			Adminofflinedatapojo keydata) {
		return adminRegisterDao.insertOfflineKeyFromExcel(examname, examtypeid, classid, numberofqns, keydata);
	}

	public int getTotalmarksFromExamOffline(String examname) {
		return adminRegisterDao.getTotalmarksFromExamOffline(examname);
	}

	public List<Adminofflinedatapojo> getSubjectidsFromExamOffline(String examname) {
		return adminRegisterDao.getSubjectidsFromExamOffline(examname);
	}

	public int getSubjectTotalqusOffline(String examname, String examtypeid, String subjectids) {
		return adminRegisterDao.getSubjectTotalqusOffline(examname, examtypeid, subjectids);
	}

	public List<Adminofflinedatapojo> getQntypeidFromExamOffline(String examname, String subjectids) {
		return adminRegisterDao.getQntypeidFromExamOffline(examname, subjectids);
	}

	public int getnumofQusperqunstype(String examname, String examtypeid, String subjectids, String quntypeid) {
		return adminRegisterDao.getnumofQusperqunstype(examname, examtypeid, subjectids, quntypeid);
	}

	public int getQustypetotalmarks(String examname, String examtypeid, String subjectids, String quntypeid) {
		return adminRegisterDao.getQustypetotalmarks(examname, examtypeid, subjectids, quntypeid);
	}

	public int updateTotalmarksFrommExamOffline(String examname, int totalmarks) {
		return adminRegisterDao.updateTotalmarksFrommExamOffline(examname, totalmarks);
	}

	public int updateSubjectTotalQusfromExamOffline(String examname, String subjectids, int subjtotalques) {
		return adminRegisterDao.updateSubjectTotalQusfromExamOffline(examname, subjectids, subjtotalques);
	}

	public int updateNumofquestionperQustype(String examname, String subjectids, String quntypeid,
			int numofqusperQustype) {
		return adminRegisterDao.updateNumofquestionperQustype(examname, subjectids, quntypeid, numofqusperQustype);
	}

	public int updateQuestypeToatlamarks(String examname, String subjectids, String quntypeid, int qustypetotalmarks) {
		return adminRegisterDao.updateQuestypeToatlamarks(examname, subjectids, quntypeid, qustypetotalmarks);
	}

	public List<AdminCategory> getallStudentsFromAllInputs(String stateid, String locationid, String branchid,
			String classids, String sectionid) {
		return adminRegisterDao.getallStudentsFromAllInputs(stateid, locationid, branchid, classids, sectionid);
	}

	public List<AdminCategory> getstudentaveragereportmrksforstudent(String classid, String section, String branch,
			String location, String state) {
		return adminRegisterDao.getstudentaveragereportmrksforstudent(classid, section, branch, location, state);
	}

	public List<AdminCategory> getsubjectaveragereportmrksforstudent(String classid, String section, String branch,
			String location, String state) {
		return adminRegisterDao.getsubjectaveragereportmrksforstudent(classid, section, branch, location, state);
	}

	public String getsubjectaveragescorereportmrksforstudent(String classid, String section, String branch,
			String location, String state, String studentid, String subjectid) {
		return adminRegisterDao.getsubjectaveragescorereportmrksforstudent(classid, section, branch, location, state,
				studentid, subjectid);
	}

	public int getexamcountforrepo(String studentid) {
		return adminRegisterDao.getexamcountforrepo(studentid);
	}

	public int getrankforaverage(String classid, String section, String branch, String location, String state,
			String studentid, String subjects) {
		return adminRegisterDao.getrankforaverage(classid, section, branch, location, state, studentid, subjects);
	}

	public String getUserIDsbasedonstudentid(String studentid) {
		return adminRegisterDao.getUserIDsbasedonstudentid(studentid);
	}

	public List<Map<String, Object>> getSelectedStudentInformation(String studentidchkname) {
		return adminRegisterDao.getSelectedStudentInformation(studentidchkname);
	}

	public List<AdminCategory> calculateStudentAverageMarks(String studentidchkname, String examtypeid) {
		return adminRegisterDao.calculateStudentAverageMarks(studentidchkname, examtypeid);
	}

	public int getExamRankPerExam(String studentidchkname, String examname) {
		return adminRegisterDao.getExamRankPerExam(studentidchkname, examname);
	}

	public List<AdminCategory> getSubjectIdsForStudent(String studentidchkname, String examtypeid) {
		return adminRegisterDao.getSubjectIdsForStudent(studentidchkname, examtypeid);
	}

	public List<AdminCategory> getExamTypeAndExamNameFromElExam(String studentidchkname, String examtypeid) {
		return adminRegisterDao.getExamTypeAndExamNameFromElExam(studentidchkname, examtypeid);
	}

	public List<Map<String, Object>> getStudentMarksperSubject(String studentid, String examname, String subjs1) {
		return adminRegisterDao.getStudentMarksperSubject(studentid, examname, subjs1);
	}

	public List<Map<String, Object>> getExamTotalMarksPerExam(String studentidchkname, String examname) {
		return adminRegisterDao.getExamTotalMarksPerExam(studentidchkname, examname);
	}

	public int getMaxRowIdFromLogo() {
		return adminRegisterDao.getMaxRowIdFromLogo();
	}

	public int insertOrganization(AdminAddOrganizationLogoModel orglogo, String filename) {
		return adminRegisterDao.insertOrganization(orglogo, filename);
	}

	public String getclassnamefromclassis(String classid) {
		return adminRegisterDao.getclassnamefromclassis(classid);
	}

	public String getsectionnamefromsection(String section) {
		return adminRegisterDao.getsectionnamefromsection(section);
	}

	public String getbranchnamefrombranch(String branch) {
		return adminRegisterDao.getbranchnamefrombranch(branch);
	}

	public String getlocationnamefromlocation(String location) {
		return adminRegisterDao.getlocationnamefromlocation(location);
	}

	public String getstatenamefromstate(String state) {
		return adminRegisterDao.getstatenamefromstate(state);
	}

	public List<AdminCategory> getExamNameForBulkSms(int classid, int sectionid, int campusid, int locationid,
			int stateid) {
		return adminRegisterDao.getExamNameForBulkSms(classid, sectionid, campusid, locationid, stateid);
	}

	public List<AdminCategory> getAllstudentResultsForBulkSms(AdminCategory ac) {
		return adminRegisterDao.getAllstudentResultsForBulkSms(ac);
	}

	public List<AdminCategory> getAllScoredmarksForBulkUpdate(String studentid, String examname) {
		return adminRegisterDao.getAllScoredmarksForBulkUpdate(studentid, examname);
	}

	public List<AdminCategory> getAllUserDetailsTosentSms(AdminCategory ac) {
		return adminRegisterDao.getAllUserDetailsTosentSms(ac);
	}

	public List<AdminExamNameforReport> getExamnamesForSubmitExam() {
		return adminRegisterDao.getExamnamesForSubmitExam();
	}

	public List<AdminExamNameforReport> getNotFishedStdsBasedonExamname(AdminExamNameforReport submitexam) {
		return adminRegisterDao.getNotFishedStdsBasedonExamname(submitexam);
	}

	public List<AdminExamNameforReport> getExamnamesForExamStatus1() {
		return adminRegisterDao.getExamnamesForExamStatus1();
	}

	public List<AdminExamNameforReport> getExamdetailsBasedonExamanme(AdminExamNameforReport submitexam) {
		return adminRegisterDao.getExamdetailsBasedonExamanme(submitexam);
	}

	public List<AdminExamNameforReport> getExamResultsStatus(AdminExamNameforReport submitexam) {
		return adminRegisterDao.getExamResultsStatus(submitexam);
	}

	public List<AdminExamNameforReport> getExamnamesFromExampaper() {
		return adminRegisterDao.getExamnamesFromExampaper();
	}

	public String getSubjectidBasedonExamname(AdminViewExamQuesPaperModel epaper) {
		return adminRegisterDao.getSubjectidBasedonExamname(epaper);
	}

	public List<AdminViewExamQuesPaperModel> getsubjectnamefromsubjectid(String subjid) {
		return adminRegisterDao.getsubjectnamefromsubjectid(subjid);
	}

	public List<AdminViewExamQuesPaperModel> getDisplayQuesToViewQuepaper(AdminViewExamQuesPaperModel epaper) {
		return adminRegisterDao.getDisplayQuesToViewQuepaper(epaper);
	}

	public List<AdminSetStartExamPatternModel> getAllExamPatterns() {
		return adminRegisterDao.getAllExamPatterns();
	}

	public List<AdminSetStartExamPatternModel> getAllExamtypes() {
		return adminRegisterDao.getAllExamtypes();
	}

	public int insertStartExamPatternData(String patternid, String extypeid) {
		return adminRegisterDao.insertStartExamPatternData(patternid, extypeid);
	}

	public List<AdminSetStartExamPatternModel> getSetPatternValue() {
		return adminRegisterDao.getSetPatternValue();
	}

	public int checkExistinExamPattern(String patternid, String extypeid) {
		return adminRegisterDao.checkExistinExamPattern(patternid, extypeid);
	}

	public int updateStartExamPattern(String patternid, String extypeid) {
		return adminRegisterDao.updateStartExamPattern(patternid, extypeid);
	}

	@Override
	public int getUserNamenadEmailofAdminfromuser2(AdminAddNewStudent adstud) {
		return adminRegisterDao.getUserNamenadEmailofAdminfromuser2(adstud);
	}

	@Override
	public int getUpdateClientLogo(AdminUploadClientLogoModel getlogo) {
		return adminRegisterDao.getUpdateClientLogo(getlogo);
	}

	@Override
	public int getInsertClientLogo(AdminUploadClientLogoModel getlogo) {
		return adminRegisterDao.getInsertClientLogo(getlogo);
	}

	@Override
	public String getClientLogoBasedOnSchoolId(String school) {
		return adminRegisterDao.getClientLogoBasedOnSchoolId(school);
	}

	@Override
	public List<Map<String, Object>> getClientlogoTblSize(String school) {
		return adminRegisterDao.getClientlogoTblSize(school);
	}

	@Override
	public int getInsertClientCarousel(AdminUploadClientLogoModel getlogo) {
		return adminRegisterDao.getInsertClientCarousel(getlogo);
	}

	@Override
	public int getMaxRowIdFromClientCarousel() {
		return adminRegisterDao.getMaxRowIdFromClientCarousel();
	}

	@Override
	public List<AdminUploadClientLogoModel> getClientCarouselBasedOnSchool(String schoolid) {
		return adminRegisterDao.getClientCarouselBasedOnSchool(schoolid);
	}

	@Override
	public List<UpdateKeyModel> editUpdateKeyExam(UpdateKeyModel ukm) {
		return adminRegisterDao.editUpdateKeyExam(ukm);
	}

	@Override
	public int updateKeyValuesInQues(String qid, String key) {
		return adminRegisterDao.updateKeyValuesInQues(qid, key);
	}

	@Override
	public int updateKEyInStuResHis(String key, String qid, String exmnam) {
		return adminRegisterDao.updateKEyInStuResHis(key, qid, exmnam);
	}

	public List<ResultCalculationModel> getStudentidsBaseExam(ResultCalculationModel rcm) {
		return adminRegisterDao.getStudentidsBaseExam(rcm);
	}

	@Override
	public List<AdminUploadClientLogoModel> getExistingCountFromClientContactDetTb(String school) {
		return adminRegisterDao.getExistingCountFromClientContactDetTb(school);
	}

	@Override
	public int getUpdateContactDet(AdminUploadClientLogoModel insertcont) {
		return adminRegisterDao.getUpdateContactDet(insertcont);
	}

	@Override
	public int getInsertContactDet(AdminUploadClientLogoModel insertcont) {
		return adminRegisterDao.getInsertContactDet(insertcont);
	}

	@Override
	public List<AdminCategory> getStudentNames(int classid, int sectionid) {
		return adminRegisterDao.getStudentNames(classid, sectionid);
	}

	@Override
	public List<StudentExamCountModel> getStudentsForExam(StudentExamCountModel stud) {
		return adminRegisterDao.getStudentsForExam(stud);
	}

	@Override
	public int getClassidBasedonFilenmae(String filename) {
		return adminRegisterDao.getClassidBasedonFilenmae(filename);
	}

	@Override
	public int deleteCarouselImage(String carouselid) {
		return adminRegisterDao.deleteCarouselImage(carouselid);
	}

	@Override
	public String getSubjTotalMarks(String examname, String subjid) {
		return adminRegisterDao.getSubjTotalMarks(examname, subjid);
	}

	public List<AdminViewAuditLogsModel> getStuentIds() {
		return adminRegisterDao.getStuentIds();
	}

	public List<Map<String, Object>> getMailId() {
		return adminRegisterDao.getMailId();
	}

	public List<Map<String, Object>> getPasswordBaseOnId(String sid) {
		return adminRegisterDao.getPasswordBaseOnId(sid);
	}

	public void insertcreatedExaminexamTable(String examname, String statechckbox, String state, String branch,
			String classname, String sectionname, int spltsubjecttypeid, String topicjoined,
			String subjoinedsubtopicids, int questiontypeidvalue, String questionlevelid, int examtypeid,
			String startdate, String enddate, String starttime, String endtime, String examtime, int noofqnsperqntype,
			int marksperqn, String negativemarksperqustype, int totalmarks, int toatlStdsAvailable,
			int spltqnsfromquestiontype, String fixedmarks, String isslotNo) {
		adminRegisterDao.insertcreatedExaminexamTable(examname, statechckbox, state, branch, classname, sectionname,
				spltsubjecttypeid, topicjoined, subjoinedsubtopicids, questiontypeidvalue, questionlevelid, examtypeid,
				startdate, enddate, starttime, endtime, examtime, noofqnsperqntype, marksperqn, negativemarksperqustype,
				totalmarks, toatlStdsAvailable, spltqnsfromquestiontype, fixedmarks, isslotNo);
	}

	public List<AdminCategory> getExamNameForCopyExamwithNoslot(String isslotNo) {
		return adminRegisterDao.getExamNameForCopyExamwithNoslot(isslotNo);
	}

	public int searchstateFromAdmin1(String statename) {
		return adminRegisterDao.searchstatesFromAdmin1(statename);
	}

	public List<AdminTopicSubTopicsNameMoidifyModel> getTopicsSubTopicsFromQuestionsAll(
			AdminTopicSubTopicsNameMoidifyModel tsm) {
		return adminRegisterDao.getTopicsSubTopicsFromQuestionsAll(tsm);
	}

	public List<AdminCategory> getSunBaseOnClass(String classids) {
		return adminRegisterDao.getSunBaseOnClass(classids);
	}

	/** Get Topic# from Exam Per Subject id **/
	public String getSelectedTopicIdsForCopyExamPerSubj(String selectedExam, String subjectid) {
		return adminRegisterDao.getSelectedTopicIdsForCopyExamPerSubj(selectedExam, subjectid);
	}

	/**
	 * Get Topic Name From Topic Table based on Topic# and Subject# and
	 * Examtype#
	 **/
	public List<Map<String, Object>> getTopicNameListFromTopicTable(int classid, int subji, String listtids,
			int examtypeid) {
		return adminRegisterDao.getTopicNameListFromTopicTable(classid, subji, listtids, examtypeid);
	}

	/** Get subject name based on subjid **/
	public String getSubjectNameBasedonSubjid(String subid) {
		return adminRegisterDao.getSubjectNameBasedonSubjid(subid);
	}

	/** Get Sub Topic# from el_exam Per Subject id **/
	public String getSelectedSubTopicIdsForCopyExamPerSubj(String selectedExam, String subjid) {
		return adminRegisterDao.getSelectedSubTopicIdsForCopyExamPerSubj(selectedExam, subjid);
	}

	/**
	 * Get SubTopic Name From Sub Topic Table based on Sub Topic# and Subject#
	 * and Examtype#
	 **/
	public List<Map<String, Object>> getSubTopicNameListFromTopicTable(int classid, int subji, String stlisttids,
			int examtypeid) {
		return adminRegisterDao.getSubTopicNameListFromTopicTable(classid, subji, stlisttids, examtypeid);
	}

	public String getAllTopicIds(String subjid, int examtypeid) {
		return adminRegisterDao.getAllTopicIds(subjid, examtypeid);
	}

	public String getAllSubTopicIds(String subjid, int examtypeid) {
		return adminRegisterDao.getAllSubTopicIds(subjid, examtypeid);
	}

	public List<StudentExamAssignModel> getExamnamesBaseOnDate() {
		return adminRegisterDao.getExamnamesBaseOnDate();
	}

	public List<StudentExamAssignModel> getClassBaseOnExamName(String examname, String ex) {
		return adminRegisterDao.getClassBaseOnExamName(examname, ex);
	}

	public List<StudentExamAssignModel> getStuDetBAsOnSecClassid(StudentExamAssignModel sem) {
		return adminRegisterDao.getStuDetBAsOnSecClassid(sem);
	}
	public List<StudentExamAssignModel> getStuDetBAsOnSecClassid1(StudentExamAssignModel sem) {
		return adminRegisterDao.getStuDetBAsOnSecClassid1(sem);
	}

	public List<StudentExamAssignModel> getExamPaperDetBaseOnExmName(String exname) {
		return adminRegisterDao.getExamPaperDetBaseOnExmName(exname);
	}

	public int insertIntoTempHistory(StudentExamAssignModel pap, String stuid, String exname) {
		return adminRegisterDao.insertIntoTempHistory(pap, stuid, exname);
	}

	public int getAlredyStudentCount(String stuid, String exname) {
		return adminRegisterDao.getAlredyStudentCount(stuid, exname);
	}

	public List<Adminofflinedatapojo> getofflineUserDataBasedonUserName(String userid) {
		return adminRegisterDao.getofflineUserDataBasedonUserName(userid);
	}

	public List<StudentExamAssignModel> getStudentDetails(String stuid) {
		return adminRegisterDao.getStudentDetails(stuid);
	}
	public int activeStudentsBasedOnClassAndSec(AdminAddNewStudent actstud) {
		return adminRegisterDao.activeStudentsBasedOnClassAndSec(actstud);
	}

	public String getExamtypeBasedOnFilename(String filename) {
		return adminRegisterDao.getExamtypeBasedOnFilename(filename);
	}
	public String getSubjidBasedOnFilename(String filename) {
		return adminRegisterDao.getSubjidBasedOnFilename(filename);
	}
	public String getTopicidsBasedonFilename(String filename) {
		return adminRegisterDao.getTopicidsBasedonFilename(filename);
	}

	public int getCountInTempHistrory(StudentExamAssignModel sem) {
		return adminRegisterDao.getCountInTempHistrory(sem);
	}

	public List<AdminCategory> getquestionsforSubjects1(String subid, String examtypeid, String file1, String file2) {
		return adminRegisterDao.getquestionsforSubjects1(subid,examtypeid,file1,file2);
	}


}
