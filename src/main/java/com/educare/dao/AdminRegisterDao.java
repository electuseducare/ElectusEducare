package com.educare.dao;

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

public interface AdminRegisterDao {

	public List<AdminAddEditDeleteAccessforRolesPojo> getpermissionsforloggedusers(String studentid);

	public int generateClassTypeId();

	public int getMaxClassId();

	public int getLastNumberFromelclass();

	public int insertClassesFromAdmin(String classname);

	public List<AdminCategory> searchClassesFromAdmin();

	public int updateclass(String classname, String classid);

	public int deleteclass(String classid);

	public List<AdminCategory> searchSectionFromAdmin();

	public int generateSectionTypeId();

	public int getMaxSectionId();

	public int insertSectionsFromAdmin(String sectionname, int cnameid);

	public int updateSection(String sectionname, String secid);

	public int deleteSection(String secid);

	public List<AdminCategory> searchBranchesFromAdmin();

	public int insertBranchFromAdmin(String branchname, int locationid);

	public int generateBranchTypeId();

	public int getMaxBranchId();

	public int getLastNumberFromelBranch();

	public int deleteBranch(String bid);

	public int updateBranch(String branchname, String bid);

	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuser1(AdminAddNewStudent adc);

	public int insertstudentDetailsFromAdmin(String studentid, String firstname, String lastname, String username,
			String pass, String state, String location, String branch, String stcls, String section, String email,
			String phone);

	public int deleteStudent(String userid);

	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuserforLecturer();

	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuserforAdmin();

	public List<AdminCategory> searchSubjectFromAdmin();

	public int getMaxSubjectId();

	public int getLastNumberFromelSubject();

	public int generateSubjectTypeId();

	public int insertSubjectFromAdmin(String subjectname, int classid);

	public int updateSubject(String subject, String bid);

	public int deleteSubject(String bid);

	List<AdminCategory> searchLocationsFromAdmin();

	public int insertLocationFromAdmin(String location, int stateid);

	public int generateLocationTypeId();

	public int getMaxLocationId();

	public int getLastNumberFromelLocation();

	public int updateLocation(String location, String bid);

	public int deleteLocation(String bid);

	List<AdminSetExamPojo> gettopicsinsubject(String subjecttypeid,String examtypeid);

	List<AdminSetExamPojo> getsubtopicsinsubject(String examtypeid, String sujid, String topicids);

	public int insertStateFromAdmin(String statename);

	public int getMaxStateId();

	public int getLastNumberFromelstatetype();

	public int generateStateTypeId();

	public int updateState(String statename, String stateid);

	List<AdminCategory> searchStateFromAdmin();

	public int deleteState(String bid);

	public int deleteSubjectbasedonClass(String classid);

	public int deleteSectionbasedonClass(String classid);

	public int deleteLocationbasedonState(String stateid);

	public int deleteBranchbasedonLocation(String locationid);

	public int updateQuestiontype(String subject, String bid);

	List<AdminSubjectwisemarksRanges> adminSujectwiseMarksRangesFromAdmin(String examname, String subjectid);

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

	String getSubjTotalMarks(String examname, String subjid);

	int getUserIDfromUsers(String username);

	List<AdminSetExamPojo> getAllsubtopicsinsubject(String examtypeid, String sujid);

	int getLastNumberFromelsection();


}
