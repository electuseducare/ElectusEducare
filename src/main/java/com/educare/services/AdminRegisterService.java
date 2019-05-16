package com.educare.services;

import java.util.List;
import java.util.Map;

import com.educare.admin.model.AdminAddEditDeleteAccessforRolesPojo;
import com.educare.admin.model.AdminAddNewStudent;
import com.educare.admin.model.AdminCategory;
import com.educare.admin.model.AdminSetExamPojo;
import com.educare.admin.model.AdminSubjectwisemarksRanges;
import com.educare.admin.model.AdminUploadClientLogoModel;
import com.educare.admin.model.StudentExamCountModel;
import com.educare.admin.model.UpdateKeyModel;

public interface AdminRegisterService {

	List<AdminAddEditDeleteAccessforRolesPojo> getpermissionsforloggedusers(String studentid);

	int generateClassTypeId();

	int getMaxClassId();

	int getLastNumberFromelclass();

	int insertClassesFromAdmin(String classname);

	List<AdminCategory> searchClassesFromAdmin();

	int updateclass(String classname, String classid);

	int deleteclass(String classid);

	List<AdminCategory> searchSectionFromAdmin();

	int generateSectionTypeId();

	int getMaxSectionId();

	int insertSectionsFromAdmin(String sectionname, int cnameid);

	int updateSection(String sectionname, String secid);

	int deleteSection(String secid);

	List<AdminCategory> searchBranchesFromAdmin();

	int insertBranchFromAdmin(String branchname, int locationid);

	int generateBranchTypeId();

	int getMaxBranchId();

	int deleteBranch(String bid);

	int updateBranch(String branchname, String bid);

	List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuser1(AdminAddNewStudent adc);

	int insertstudentDetailsFromAdmin(String studentid, String firstname, String lastname, String username, String pass,
			String state, String location, String branch, String stcls, String section, String email, String phone);

	int deleteStudent(String userid);

	List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuserforLecturer();

	List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuserforAdmin();

	List<AdminCategory> searchSubjectFromAdmin();

	int getMaxSubjectId();

	int generateSubjectTypeId();

	int insertSubjectFromAdmin(String subjectname, int classid);

	int updateSubject(String subject, String bid);

	int deleteSubject(String bid);

	List<AdminCategory> searchLocationsFromAdmin();

	int insertLocationFromAdmin(String location, int stateid);

	int generateLocationTypeId();

	int getMaxLocationId();

	int updateLocation(String location, String bid);

	int deleteLocation(String bid);

	List<AdminSetExamPojo> gettopicsinsubject(String subjecttypeid,String examtypeid);

	int insertStateFromAdmin(String statename);

	int getMaxStateId();

	int generateStateTypeId();

	int updateState(String statename, String stateid);

	List<AdminCategory> searchStateFromAdmin();

	int deleteState(String bid);

	int deleteSubjectbasedonClass(String classid);

	int deleteSectionbasedonClass(String classid);

	int deleteLocationbasedonState(String stateid);

	int deleteBranchbasedonLocation(String locationid);

	int updateQuestiontype(String subject, String bid);

	List<AdminSubjectwisemarksRanges> adminSujectwiseMarksRangesFromAdmin(String examname, String subjectid);

	int getUserNamenadEmailofAdminfromuser2(AdminAddNewStudent adstud);

	int getUpdateClientLogo(AdminUploadClientLogoModel getlogo);

	int getInsertClientLogo(AdminUploadClientLogoModel getlogo);

	String getClientLogoBasedOnSchoolId(String school);

	int getInsertClientCarousel(AdminUploadClientLogoModel getlogo);

	int getMaxRowIdFromClientCarousel();

	List<AdminUploadClientLogoModel> getClientCarouselBasedOnSchool(String schoolid);

	List<Map<String, Object>> getClientlogoTblSize(String school);

	List<UpdateKeyModel> editUpdateKeyExam(UpdateKeyModel ukm);

	int updateKeyValuesInQues(String qid, String key);

	int updateKEyInStuResHis(String key, String qid, String exmnam);
	
	int getUpdateContactDet(AdminUploadClientLogoModel insertcont);

	int getInsertContactDet(AdminUploadClientLogoModel insertcont);

	List<AdminUploadClientLogoModel> getExistingCountFromClientContactDetTb(String school);

	List<AdminCategory> getStudentNames(int classid, int sectionid);

	List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuser12(AdminAddNewStudent adc);

	List<StudentExamCountModel> getStudentsForExam(StudentExamCountModel stud);

	int getClassidBasedonFilenmae(String filename);

	int deleteCarouselImage(String carouselid);

	String getSubjTotalMarks(String examname, String string);

	List<AdminSetExamPojo> getsubtopicsinsubject(String examtypeid, String sujid, String topic);

	List<AdminSetExamPojo> getAllsubtopicsinsubject(String examtypeid, String sujid);

}
