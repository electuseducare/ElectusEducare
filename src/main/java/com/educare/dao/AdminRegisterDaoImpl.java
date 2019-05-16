package com.educare.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.educare.admin.mapper.AdminAddEditDeleteAccessforPermissionsMapper;
import com.educare.admin.mapper.AdminAddEditDeleteAccessforRolesMapper;
import com.educare.admin.mapper.AdminAddEditDeleteAccessforUsersMapper;
import com.educare.admin.mapper.AdminAddLecturerValuesForRoleMapper;
import com.educare.admin.mapper.AdminAddSubjectTopicMapper;
import com.educare.admin.mapper.AdminAddSubjectTopicMapper1;
import com.educare.admin.mapper.AdminAllIndiaMarksAnalysisMapper;
import com.educare.admin.mapper.AdminAllIndiaMarksAnalysisMapper1;
import com.educare.admin.mapper.AdminBranchClassMapper;
import com.educare.admin.mapper.AdminBranchNamesMapper;
import com.educare.admin.mapper.AdminCategoryClassMapper;
import com.educare.admin.mapper.AdminCreateExamMapper;
import com.educare.admin.mapper.AdminExamTypeMapper;
import com.educare.admin.mapper.AdminFilterCriteriaMapper;
import com.educare.admin.mapper.AdminGetCampusnamesInBelow100RanksIncampuswiseReportMapper;
import com.educare.admin.mapper.AdminGetExamNameTypeForCopyExamMapper;
import com.educare.admin.mapper.AdminGetFilenamesMapper;
import com.educare.admin.mapper.AdminGetQustypeidFromOfflineMapper;
import com.educare.admin.mapper.AdminGetSubjectidsFromOfflineMapper;
import com.educare.admin.mapper.AdminGetSubtopicIdsMapper;
import com.educare.admin.mapper.AdminGetSubtopicIdsMapperForEdit;
import com.educare.admin.mapper.AdminGetTopicIdsMapper;
import com.educare.admin.mapper.AdminLocationClassMapper;
import com.educare.admin.mapper.AdminLocationNamesMapper;
import com.educare.admin.mapper.AdminOfflineExamNamesReportMapper;
import com.educare.admin.mapper.AdminOfflineQuestionidforqerrormapper;
import com.educare.admin.mapper.AdminQtypesFromSlectedFileNamesMapper;
import com.educare.admin.mapper.AdminQuestionLevelTypeMapper;
import com.educare.admin.mapper.AdminQuestionTypeMapper;
import com.educare.admin.mapper.AdminQuestionidforqerrormapper;
import com.educare.admin.mapper.AdminQuestionsFromSelectedFilenamesMapper;
import com.educare.admin.mapper.AdminRightAnswerforReportMapper;
import com.educare.admin.mapper.AdminSearchExamtypeMapper;
import com.educare.admin.mapper.AdminSearchQuestionlevelMapper;
import com.educare.admin.mapper.AdminSectionClassMapper;
import com.educare.admin.mapper.AdminSecwiseAttendeesWithAvgMapper;
import com.educare.admin.mapper.AdminStateAssociatedLCAndBRMapper;
import com.educare.admin.mapper.AdminStateMapper;
import com.educare.admin.mapper.AdminSubjectClassMapper;
import com.educare.admin.mapper.AdminSubjectWiseRightwrongMapper;
import com.educare.admin.mapper.AdminTopicListClassMapper;
import com.educare.admin.mapper.AdminTopicSubTopicsNameMoidifyMapper;
import com.educare.admin.mapper.AdminUnattemptanswersforreportMapper;
import com.educare.admin.mapper.AdminUsernameValuesForRoleMapper;
import com.educare.admin.mapper.AdminUsernameValuesForRoleMapper1;
import com.educare.admin.mapper.AdminViewAuditLogsMapper;
import com.educare.admin.mapper.AdminWrongAnsweredforrepomapper;
import com.educare.admin.mapper.AdmingetExamNameReportMapper;
import com.educare.admin.mapper.AdmingetExamdataBasedonexamnamemapper;
import com.educare.admin.mapper.Admingetsubjectidforpresentprevreportmapper;
import com.educare.admin.mapper.AdminquestionwiseerrorreportMapper;
import com.educare.admin.mapper.Adminsubjectwisemarksrangemapper;
import com.educare.admin.mapper.CampusNamesInCampuswiseErrorReportMapper;
import com.educare.admin.mapper.GetAllClientCarouselMapper;
import com.educare.admin.mapper.GetAllClientContactMapper;
import com.educare.admin.mapper.GetAllExamPatternsMapper;
import com.educare.admin.mapper.GetAllExamtypesMapper;
import com.educare.admin.mapper.GetAllStuIdExamNamMapper;
import com.educare.admin.mapper.GetAllUpdateKeyMapper;
import com.educare.admin.mapper.GetDetailsForBulkSmsMapper;
import com.educare.admin.mapper.GetDisplayQuesToViewQuepaperMapper;
import com.educare.admin.mapper.GetExamNameAndExamTypeInfoMapper;
import com.educare.admin.mapper.GetExamNameForAddComphQusExamMapper;
import com.educare.admin.mapper.GetExamNameForCopyExamMapper;
import com.educare.admin.mapper.GetExamNameForSeendingBulkSmsMapper;
import com.educare.admin.mapper.GetPreviousBranchesForCopyExamMapper;
import com.educare.admin.mapper.GetPreviousClassForCopyExamMapper;
import com.educare.admin.mapper.GetPreviousLocationForCopyExamMapper;
import com.educare.admin.mapper.GetPreviousQuestiontypeDataForCopyExamMapper;
import com.educare.admin.mapper.GetPreviousQuestiontypeForCopyExamMapper;
import com.educare.admin.mapper.GetPreviousQusLevelsForCopyExamMapper;
import com.educare.admin.mapper.GetPreviousSectionForCopyExamMapper;
import com.educare.admin.mapper.GetPreviousStatesForCopyExamMapper;
import com.educare.admin.mapper.GetPreviousSubjectsForCopyExamMapper;
import com.educare.admin.mapper.GetScoredMarksForBulkSmsMapper;
import com.educare.admin.mapper.GetSelectedClassSubjectsForCopyExamMapper;
import com.educare.admin.mapper.GetSelectedSubjectQnsForCopyExamMapper;
import com.educare.admin.mapper.GetSetedPatternValueMapper;
import com.educare.admin.mapper.GetStudentIDsFromEstimateStudentAvgMapper;
import com.educare.admin.mapper.GetStudentIdForBulkSmsMapper;
import com.educare.admin.mapper.GetStudsForExamCountMapper;
import com.educare.admin.mapper.GetSubjectIdExamNameInfoMapper;
import com.educare.admin.mapper.GetSubjectnameFromSubjectidMapper;
import com.educare.admin.mapper.GetstudentAveragedetailsMapper;
import com.educare.admin.mapper.GetsubjectAveragedetailsMapper;
import com.educare.admin.mapper.OfflineExamNamesMapper;
import com.educare.admin.mapper.OfflineExamSubjectsMapper;
import com.educare.admin.mapper.OfflineQiestionIdsInCampusWiseErrorReportMapper;
import com.educare.admin.mapper.OfflineQuestiondataMapper;
import com.educare.admin.mapper.OfflineUserDataMapper;
import com.educare.admin.mapper.QiestionIdsInCampusWiseErrorReportMapper;
import com.educare.admin.mapper.QuestionTimeDifferenceMapper;
import com.educare.admin.mapper.QuestionwiseAnalysisMapper;
import com.educare.admin.mapper.StateNamesInCampuswiseErrorReportMapper;
import com.educare.admin.mapper.StudentProfileAverageMarks;
import com.educare.admin.mapper.StudentidsFromOfflineExamMapper;
import com.educare.admin.mapper.SubjectWiseHighestMapper;
import com.educare.admin.mapper.getAvgtimeBasedonExamnameMapper;
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
import com.educare.admin.sqlStatements.AdminSqlQueries;
import com.educare.admin.sqlStatements.UserSqlQueries;
import com.educare.mapper.AdminSubTopicListClassMapper;
import com.educare.mapper.AdmingetExamNameMapper;
import com.educare.mapper.GetAllExamPaperDetMApper;
import com.educare.mapper.GetClassSectionBaseOnExamMapper;
import com.educare.mapper.GetExamDetailsBasedonExamnameMapper;
import com.educare.mapper.GetExamResultStausDetailsMapper;
import com.educare.mapper.GetNotFishedStdsBasedonExamnameMapper;
import com.educare.mapper.GetStudentDetBasClsSecMapper;
import com.educare.mapper.GetStudentDetMApper;
import com.educare.mapper.GetStudentIdsMapper;
import com.educare.mapper.GetStudentNames;
import com.educare.mapper.GetSubjectMapper;
import com.educare.model.QuestionPojo;
import com.educare.model.StudentExamAssignModel;

@Repository
public class AdminRegisterDaoImpl extends JdbcDaoSupport implements AdminRegisterDao {

	@Value("${exam.completion.status}")
	String examstatus;

	@Autowired
	public AdminRegisterDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public String getDateFromSimpleDateFormat() {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		return fmt.format(now);
	}

	public String getCurrentDate() {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		return fmt.format(now);
	}

	public List<AdminCategory> getSubtopicsFromAdminInEditModule(int subtopicid, int topicid) {
		/*** Don't change SQL query ***/
		String sql = "select * from el_subject_subtopic_type where subject_topic_type_id=" + topicid + "";
		return this.getJdbcTemplate().query(sql, new AdminGetSubtopicIdsMapperForEdit());

	}

	public int insertintoOmrSheetData(String examname, String userid, String series, int j, String finalval,
			String answer, String columname, int stateid, int locationid, int branchid, int classid, int sectionid,
			String firstname, String subjectid, String offline_keyid) {
		/*** Don't change SQL query ***/
		String sql = "insert into el_offline_exam_resulthistory(exam_name,student_id,series,question_id,selected_keys,created_date,modified_date,"
				+ columname
				+ ",state,el_location_id,campus,class_id,section,studentname,el_subject_id,offline_key_id) values('"
				+ examname + "','" + userid + "','" + series + "','" + j + "','" + finalval + "','"
				+ getDateFromSimpleDateFormat() + "','" + getDateFromSimpleDateFormat() + "','" + answer + "',"
				+ stateid + "," + locationid + "," + branchid + "," + classid + "," + sectionid + ",'" + firstname
				+ "','" + subjectid + "'," + offline_keyid + ")";
		return this.getJdbcTemplate().update(sql);
	}

	public List<AdminCategory> getQuestionsFromFileName(String filenames) {
		/*** Don't change SQL query ***/
		String sql = "select  ques,import_file_name from el_questions where import_file_name in ('" + filenames + "')";
		logger.info("getQuestionsFromFileName: " + sql);
		return this.getJdbcTemplate().query(sql, new AdminQuestionsFromSelectedFilenamesMapper());
	}

	public List<Map<String, Object>> getsubjectwisemarksforOfflineExam(String examname, String subid) {
		/*** Don't change SQL query ***/
		String sql = "select sum(question_type_total_marks) as total_marks from (select question_type_total_marks from el_offline_key where exam_name='"
				+ examname + "' and el_subject_id=" + subid + " group by question_type_id) as tbl;";
		return this.getJdbcTemplate().queryForList(sql);
	}

	public List<Map<String, Object>> getSubTopicNameFromSubtopicTable(int topicid, int subtopicid) {
		/*** Don't change SQL query ***/
		String sql = "select * from el_subject_subtopic_type where subject_topic_type_id=" + topicid
				+ " and subject_subtopic_type_id=" + subtopicid + " ";
		return this.getJdbcTemplate().queryForList(sql);
	}

	public List<Adminstudentwisequestionerror> admingetQuestionIdsforQerror(String examname, String campusid) {
		/*** Don't change SQL query ***/
		String sql = "SELECT  sr.Question_Id, sr.exam_paper_id FROM el_exam_paper sr  where  sr.Exam_Name='" + examname
				+ "' and sr.branch_id like '%" + campusid + "%'  order by sr.Question_Id";
		return this.getJdbcTemplate().query(sql, new AdminQuestionidforqerrormapper());
	}

	public List<QuestionPojo> getAllSelectedQuestions(String filenames, int subid, int qulid) {
		/*** Don't change SQL query ***/
		String sql = "select * from el_questions where import_file_name in('" + filenames + "') and subject_type="
				+ subid + " and Question_Type=(select question_type from el_question_type where question_type_id="
				+ qulid + ") ";
		logger.info("getAllSelectedQuestions: " + sql);
		return this.getJdbcTemplate().query(sql, new AdminCreateExamMapper());
	}

	public String getTopicsForSelectedQuestions(String filenames) {
		/*** Don't change SQL query ***/
		String sql = "select GROUP_CONCAT(tbl.topic SEPARATOR ', ') as topic from (select topic from el_questions where import_file_name in('"
				+ filenames + "') group by topic) as tbl";
		logger.info("getTopicsForSelectedQuestions: " + sql);
		return this.getJdbcTemplate().queryForObject(sql, String.class);
	}

	public String getSubTopicsForSelectedQuestions(String filenames) {
		/*** Don't change SQL query ***/
		String sql = "select GROUP_CONCAT(tbl.subTopic SEPARATOR ', ') as subTopic from (select subTopic from el_questions where import_file_name in('"
				+ filenames + "') group by subTopic) as tbl";
		logger.info("getSubTopicsForSelectedQuestions: " + sql);
		return this.getJdbcTemplate().queryForObject(sql, String.class);
	}

	public String getQuesidsForSelectedQuestions(String filenames) {
		/*** Don't change SQL query ***/
		String sql = "select GROUP_CONCAT(tbl.question_type_id SEPARATOR ', ') as question_type_id from (select qt.question_type_id from el_questions qs,el_question_type qt where qs.import_file_name in('"
				+ filenames + "') and qs.Question_Type=qt.question_type group by qs.Question_Type) as tbl";
		logger.info("getQuesidsForSelectedQuestions: " + sql);
		return this.getJdbcTemplate().queryForObject(sql, String.class);
	}

	public String getQuslvlIdsForSelectedQuestions(String filenames) {
		/*** Don't change SQL query ***/
		String sql = "select GROUP_CONCAT(tbl.Question_Level_Type_Id SEPARATOR ', ') as quslevelid from (select Question_Level_Type_Id from el_questions where import_file_name in('"
				+ filenames + "') group by Question_Level_Type_Id) as tbl";
		logger.info("getQuslvlIdsForSelectedQuestions: " + sql);
		return this.getJdbcTemplate().queryForObject(sql, String.class);
	}

	public List<AdminQtypesFromSlectedFileNamesModel> getQtypesFromFileName(String filenames) {
		/*** Don't change SQL query ***/
		String sql = "select  concat(qs.subject_type,'_',qt.question_type_id) as questiontypeid, count(import_file_name) as numberofqns, "
				+ "concat(qs.question_type,'_',st.el_subject_name) as question_type from el_questions qs, el_question_type qt, el_subject st "
				+ "where import_file_name in ('" + filenames
				+ "') and qs.Question_Type = qt.question_type and qs.subject_type = st.el_subject_id "
				+ "group by qs.subject_type,qs.Question_Type";
		return this.getJdbcTemplate().query(sql, new AdminQtypesFromSlectedFileNamesMapper());
	}

	@Override
	public List<AdminSetExamPojo> getsubtopicsinsubject(String examtypeid, String sujid, String topicids) {
		/*** Don't change SQL query ***/
		String sql = "SELECT st.*,concat(substring_index(tt.subject_topic_type,' ',1),' - ',st.subject_subtopic_type) as topicname FROM el_subject_subtopic_type st,el_subject_topic_type tt where st.exam_type_id="
				+ examtypeid + " and  st.subject_type_id=" + sujid + " and st.subject_topic_type_id in(" + topicids
				+ ") and st.subject_topic_type_id=tt.subject_topic_type_id and st.exam_type_id=tt.exam_type_id and st.subject_type_id=tt.subject_type_id  group by st.subject_subtopic_type order by st.subject_type_id";
		return this.getJdbcTemplate().query(sql, new AdminSubTopicListClassMapper());
	}

	public List<AdminViewExamQuesPaperModel> getsubjectnamefromsubjectid(String subjid) {
		/*** Don't change SQL query ***/
		String sql = "select el_subject_name,el_subject_id from el_subject where el_subject_id in (" + subjid
				+ ") order by el_subject_id";
		return this.getJdbcTemplate().query(sql, new GetSubjectnameFromSubjectidMapper());
	}

	public List<Questionanalysispojo> getQuestionWiseAnalysisData(String examname, String examstatus,
			String subjoinedstudentids) {
		/*** Don't change SQL query ***/
		String sql = "select ur.first_name,ur.last_name,ur.user_name,ec.el_class_name,ur.Student_Id,es.el_section_name "
				+ " from temp_exam_history tmp,users ur,el_class ec,el_section es "
				+ "where ec.el_class_generated_id=tmp.class_id and tmp.section_id=es.el_section_id and ur.el_section_id=es.el_section_id and ur.el_class_generated_id=ec.el_class_generated_id "
				+ "and tmp.examname='" + examname + "' and ur.student_id in('" + subjoinedstudentids + "') "
				+ "and tmp.Exam_Completion_Status='" + examstatus + "' group by ur.student_id ";
		return this.getJdbcTemplate().query(sql, new QuestionwiseAnalysisMapper());
	}

	public List<AdminCategory> getPreviousSectionidsForCopyExam(String selectedExam, int classid) {
		String sectids = sectionIds(selectedExam);
		/*** Don't change SQL query ***/
		String sql = "select group_concat(distinct sc.el_section_id separator ',')as el_section_id ,group_concat( distinct sc.el_section_name separator ',') as el_section_name from el_exam ex, el_section sc where ex.exam_name='"
				+ selectedExam + "' and ex.class_id=" + classid + " and sc.el_class_generated_id=" + classid
				+ " and sc.el_section_id in (" + sectids + ")";
		return this.getJdbcTemplate().query(sql, new GetPreviousSectionForCopyExamMapper());
	}

	public List<Map<String, Object>> getTopicNameListFromTopicTable(int classid, int subji, String listtids,
			int examtypeid) {
		/*** Don't change SQL query ***/
		String sql = "select group_concat(subject_topic_type) as subject_topic_type from el_subject_topic_type where el_class_generated_id="
				+ classid + " and subject_type_id=" + subji + "  and subject_topic_type_id in(" + listtids
				+ ") and exam_type_id=" + examtypeid + "";
		return this.getJdbcTemplate().queryForList(sql);
	}

	public List<Map<String, Object>> getSubTopicNameListFromTopicTable(int classid, int subji, String stlisttids,
			int examtypeid) {
		/*** Don't change SQL query ***/
		String sql = "select group_concat(subject_subtopic_type) as subject_subtopic_type from el_subject_subtopic_type where el_class_generated_id="
				+ classid + " and subject_type_id=" + subji + "  and subject_subtopic_type_id in(" + stlisttids
				+ ") and exam_type_id=" + examtypeid + "";
		return this.getJdbcTemplate().queryForList(sql);
	}

	public List<AdminCategory> getFilenamesforSubjects1(String subjid, String examtypeid, String topicid,
			String subtopicid) {
		/*** Don't change SQL query ***/
		String sql = "select eq.ques,eq.import_file_name,concat(sb.el_subject_name,' - ',st.subject_topic_type) as subjtopic FROM el_questions eq,"
				+ "el_subject sb,el_subject_topic_type st  where eq.Exam_Type=( select Exam_Type from el_exam_type where Exam_Type_Id="+examtypeid+") "
				+ "and eq.subject_type ="+subjid+" and eq.topic in("+topicid+") and eq.subTopic in ("+subtopicid+") and eq.subject_type=sb.el_subject_id "
				+ "and st.subject_topic_type_id=eq.topic and st.subject_type_id=eq.subject_type and st.subject_type_id=sb.el_subject_id and st.exam_type_id="+examtypeid+"";
		logger.info("getFilenamesforSubjects1: " + sql);
		return this.getJdbcTemplate().query(sql, new AdminGetFilenamesMapper());
	}

	public List<StudentExamAssignModel> getStuDetBAsOnSecClassid(StudentExamAssignModel sem) {
		/*** Don't change SQL query ***/
		String sql = "select student_id,user_name from users where el_class_generated_id=" + sem.getClassid()
				+ " and el_section_id in(" + sem.getSection() + ") and state_type_id in (" + sem.getStatidval()
				+ ") and el_location_id in (" + sem.getLocationidval() + ") and el_branch_id in (" + sem.getBrachidval()
				+ ")";
		logger.info("getStuDetBAsOnSecClassid: " + sql);
		return this.getJdbcTemplate().query(sql, new GetStudentDetBasClsSecMapper());
	}

	public List<StudentExamAssignModel> getStuDetBAsOnSecClassid1(StudentExamAssignModel sem) {
		/*** Don't change SQL query ***/
		String sql = "select distinct(us.Student_Id),us.user_name from users us,temp_exam_history te where us.Student_Id !=te.Student_Id and us.el_class_generated_id=te.class_Id and us.el_class_generated_id="
				+ sem.getClassid() + " and us.el_section_id in(" + sem.getSection() + ") and us.state_type_id in ("
				+ sem.getStatidval() + ") and us.el_location_id in (" + sem.getLocationidval()
				+ ") and us.el_branch_id in (" + sem.getBrachidval() + ") and te.examname='" + sem.getExamname() + "'";
		logger.info("getStuDetBAsOnSecClassid1: " + sql);
		return this.getJdbcTemplate().query(sql, new GetStudentDetBasClsSecMapper());
	}

	public List<CampuswiseErrorreportPojo> getAllQidsInCampuswiseOffline(String examname, int campusid,
			String subjectid) {
		/*** Don't change SQL query ***/
		String sql = "SELECT sr.question_id,sr.offline_key_id FROM el_offline_key sr,el_offline_exam_resulthistory sr1  where  sr.Exam_Name='"
				+ examname + "' and sr.question_id=sr1.question_id and sr.class_id=sr1.class_id and  sr1.campus like '%"
				+ campusid + "%' and sr.el_subject_id='" + subjectid
				+ "' and sr.el_subject_id=sr1.el_subject_id  group by sr1.question_id order by sr1.question_id";
		return this.getJdbcTemplate().query(sql, new OfflineQiestionIdsInCampusWiseErrorReportMapper());
	}

	public List<AdminAddEditDeleteAccessforRolesPojo> getUsersbasedonRoleIds(String useridsjoined) {
		/*** Don't change SQL query ***/
		String sql = "select * from users where user_id in(" + useridsjoined + ")  ";
		return this.getJdbcTemplate().query(sql, new AdminAddEditDeleteAccessforUsersMapper());
	}

	public List<CampuswiseErrorreportPojo> getAllQidsInCampuswise(String examname, int campusid, String subjectid) {
		/*** Don't change SQL query ***/
		String sql = "SELECT  sr.Question_Id, sr.exam_paper_id FROM el_exam_paper sr where  sr.Exam_Name='" + examname
				+ "' and sr.branch_id like '%" + campusid + "%' and subject_id='" + subjectid + "' "
				+ " order by sr.Question_Id";
		return this.getJdbcTemplate().query(sql, new QiestionIdsInCampusWiseErrorReportMapper());
	}

	public List<CampuswiseErrorreportPojo> getAllQidsInStatewise(String examname, int stateid, String subjectid) {
		/*** Don't change SQL query ***/
		String sql = "SELECT  sr.Question_Id, sr.exam_paper_id FROM el_exam_paper sr where  sr.Exam_Name='" + examname
				+ "' and sr.state_type_id like '%" + stateid + "%' and sr.subject_id='" + subjectid + "' "
				+ " order by sr.Question_Id";
		return this.getJdbcTemplate().query(sql, new QiestionIdsInCampusWiseErrorReportMapper());
	}

	public int getCountOfAllErrorQuestionIdsInstatewise(String examname, int stateid, int questionid, String subjectid,
			int questionrowid) {
		/*** Don't change SQL query ***/
		String sql = "     SELECT Count(*) as errorcnt from  el_student_result_history sr,el_state_type br "
				+ "where  sr.Exam_Name='" + examname + "' and sr.state='" + stateid + "' and el_subject_id= '"
				+ subjectid + "' and sr.state=br.state_type_id and sr.Question_Id='" + questionid
				+ "'  and exam_paper_id=" + questionrowid + " and sr.wrong_answered is not null";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public List<CampuswiseErrorreportPojo> getAllQidsInStatewiseOffline(String examname, int stateid,
			String subjectid) {
		/*** Don't change SQL query ***/
		String sql = "SELECT sr.question_id,sr.offline_key_id FROM el_offline_key sr,el_offline_exam_resulthistory sr1  where  sr.Exam_Name='"
				+ examname + "' and sr.question_id=sr1.question_id and sr.class_id=sr1.class_id and  sr1.state like '%"
				+ stateid + "%' and sr.el_subject_id='" + subjectid
				+ "' and sr.el_subject_id=sr1.el_subject_id  group by sr1.question_id order by sr1.question_id;";
		return this.getJdbcTemplate().query(sql, new OfflineQiestionIdsInCampusWiseErrorReportMapper());
	}

	public int getCountOfAllErrorQuestionIdsInstatewiseOffline(String examname, int stateid, int questionid,
			String subjectid, int questionrowid) {
		/*** Don't change SQL query ***/
		String sql = "     SELECT Count(*) as errorcnt from  el_offline_exam_resulthistory sr,el_state_type br "
				+ "where  sr.Exam_Name='" + examname + "' and sr.state='" + stateid + "' and el_subject_id='"
				+ subjectid + "'" + "and sr.state=br.state_type_id and sr.Question_Id='" + questionid
				+ "'  and offline_key_id=" + questionrowid + " and sr.wrong_answered is not null";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public List<AdminExamNameforReport> getExamResultsStatus(AdminExamNameforReport submitexam) {
		/*** Don't change SQL query ***/
		String sql = "select st.Student_Id,(select user_name from users u where u.student_id=st.Student_Id ) as "
				+ "username,st.EXAM_SCORED_MARKS,'Present' as examstatus from (select student_id from users where"
				+ " state_type_id in(" + submitexam.getStateid() + ") and el_location_id in("
				+ submitexam.getLocationid() + ") " + "and el_branch_id in(" + submitexam.getBrancid()
				+ ") and el_class_generated_id=" + submitexam.getClassid() + " " + "and el_section_id in("
				+ submitexam.getSectionid() + ")) as tb,el_student_results st where " + "st.Exam_Name='"
				+ submitexam.getExamname() + "' and tb.student_id=st.Student_Id group by st.Student_Id "
				+ "union Select student_id,user_name,'0' as EXAM_SCORED_MARKS,'Absent' as examstatus from users where "
				+ "student_id not in (select Student_Id from el_student_results where Exam_Name='"
				+ submitexam.getExamname() + "' " + "group by Student_Id) and state_type_id in("
				+ submitexam.getStateid() + ") and el_location_id " + "in(" + submitexam.getLocationid()
				+ ") and el_branch_id in(" + submitexam.getBrancid() + ") and " + "el_class_generated_id="
				+ submitexam.getClassid() + " and el_section_id in(" + submitexam.getSectionid() + ")";
		return this.getJdbcTemplate().query(sql, new GetExamResultStausDetailsMapper());
	}

	public int activeStudentsBasedOnClassAndSec(AdminAddNewStudent actstud) {
		/*** Don't change SQL query ***/
		String sql = "UPDATE users SET session_id ='" + actstud.getSessionid() + "' WHERE (el_class_generated_id='"
				+ actstud.getClassid() + "' and el_section_id in(" + actstud.getSectionid() + "));";
		return this.getJdbcTemplate().update(sql);
	}
	
	public List<AdminCategory> getquestionsforSubjects1(String subid, String examtypeid, String file1, String file2) {
		/*** Don't change SQL query ***/
		String sql = "select eq.ques,eq.import_file_name,concat(sb.el_subject_name,' - ',st.subject_topic_type) as subjtopic FROM el_questions eq,el_subject sb,el_subject_topic_type st  where eq.Exam_Type=( select Exam_Type from el_exam_type where Exam_Type_Id="+examtypeid+") and eq.subject_type ="+subid+" and   eq.subject_type=sb.el_subject_id and st.subject_topic_type_id=eq.topic and st.subject_type_id=eq.subject_type and st.subject_type_id=sb.el_subject_id and st.exam_type_id="+examtypeid+" and  eq.import_file_name between '"+file1+"' and '"+file2+"'";
		return this.getJdbcTemplate().query(sql, new AdminGetFilenamesMapper());
	}

	@Override
	public int generateClassTypeId() {
		int getPackageId = getMaxClassId();
		int getCountOfPackageOrder;
		int id = 899;
		if (getPackageId == 0 && getPackageId < id) {
			id++;
		} else {
			getCountOfPackageOrder = getLastNumberFromelclass();
			id = getCountOfPackageOrder + 1;
		}
		return id;
	}

	@Override
	public int generateBranchTypeId() {
		int getPackageId = getMaxBranchId();
		int getCountOfPackageOrder;
		int id = 599;
		if (getPackageId == 0 && getPackageId < id) {
			id++;
		} else {
			getCountOfPackageOrder = getLastNumberFromelBranch();
			id = getCountOfPackageOrder + 1;
		}
		return id;
	}

	@Override
	public int generateLocationTypeId() {
		int getPackageId = getMaxLocationId();
		int getCountOfPackageOrder;
		int id = 299;
		if (getPackageId == 0 && getPackageId < id) {
			id++;
		} else {
			getCountOfPackageOrder = getLastNumberFromelLocation();
			id = getCountOfPackageOrder + 1;
		}
		return id;
	}

	@Override
	public int generateStateTypeId() {
		int getPackageId = getMaxStateId();
		int getCountOfPackageOrder;
		int id = 4000;
		if (getPackageId == 0 && getPackageId < id) {
			id++;
		} else {
			getCountOfPackageOrder = getLastNumberFromelstatetype();
			id = getCountOfPackageOrder + 1;
		}
		return id;
	}

	@Override
	public int generateSubjectTypeId() {
		int getPackageId = getMaxSubjectId();
		int getCountOfPackageOrder;
		int id = 399;
		if (getPackageId == 0 && getPackageId < id) {
			id++;
		} else {
			getCountOfPackageOrder = getLastNumberFromelSubject();
			id = getCountOfPackageOrder + 1;
		}
		return id;
	}

	@Override
	public int generateSectionTypeId() {
		int getPackageId = getMaxSectionId();
		int getCountOfPackageOrder;
		int id = 799;
		if (getPackageId == 0 && getPackageId < id) {
			id++;
		} else {
			getCountOfPackageOrder = getLastNumberFromelsection();
			id = getCountOfPackageOrder + 1;
		}
		return id;
	}

	@Override
	public int getLastNumberFromelsection() {
		String sql = AdminSqlQueries.GETLASTNUMBERFROMSECTION_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int getMaxSectionId() {
		String sql = AdminSqlQueries.GETMAXSECTIONUSERID_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int getMaxBranchId() {
		String sql = AdminSqlQueries.GETMAXBRANCHUSERID_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int getMaxLocationId() {
		String sql = AdminSqlQueries.GETMAXLOCATIONUSERID_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int getMaxStateId() {
		String sql = AdminSqlQueries.GETMAXSTATEID_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int getMaxSubjectId() {
		String sql = AdminSqlQueries.GETMAXSUBJECTUSERID_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int getMaxClassId() {
		String sql = AdminSqlQueries.GETMAXCLASSUSERID_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int getLastNumberFromelclass() {
		String sql = AdminSqlQueries.GETLASTNUMBERFROMCLASS_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int getLastNumberFromelBranch() {
		String sql = AdminSqlQueries.GETLASTNUMBERFROMBRANCH_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int getLastNumberFromelLocation() {
		String sql = AdminSqlQueries.GETLASTNUMBERFROMLOCATION_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int getLastNumberFromelstatetype() {
		String sql = AdminSqlQueries.GETLASTNUMBERFROMEL_STATE_TYPE_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int getLastNumberFromelSubject() {
		String sql = AdminSqlQueries.GETLASTNUMBERFROMSUBJECT_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public int insertClassesFromAdmin(String classname) {
		String sql = AdminSqlQueries.INSERTCLASSFROMADMIN_QUERY;
		Object[] params = { classname, generateClassTypeId(), getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat() };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public List<AdminCategory> searchClassesFromAdmin() {
		String sql = AdminSqlQueries.SEARCHEXISTCLASSFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminCategoryClassMapper());
	}

	@Override
	public int updateclass(String classname, String classid) {
		String sql = AdminSqlQueries.UPDATECLASSFROMADMIN_QUERY;
		Object[] params = new Object[] { classname, classid };

		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int deleteclass(String classid) {
		String sql = AdminSqlQueries.DELETECLASSFROMADMIN_QUERY;
		Object[] params = new Object[] { classid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public List<AdminCategory> searchSectionFromAdmin() {
		String sql = AdminSqlQueries.SEARCHEXISTSECTIONFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminSectionClassMapper());
	}

	public List<AdminCategory> searchSectionFromAdmin1(int classid) {
		String sql = AdminSqlQueries.SEARCHEXISTSECTIONFROMADMIN1_QUERY;
		Object[] params = new Object[] { classid };
		return this.getJdbcTemplate().query(sql, params, new AdminSectionClassMapper());
	}

	@Override
	public int insertSectionsFromAdmin(String sectionname, int cnameid) {
		String sql = AdminSqlQueries.INSERTSECTIONFROMADMIN_QUERY;
		Object[] params = new Object[] { sectionname, generateSectionTypeId(), getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat(), cnameid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public List<AdminCategory> searchBranchesFromAdmin() {
		String sql = AdminSqlQueries.SEARCHEXISTBRANCHFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminBranchClassMapper());
	}

	@Override
	public List<AdminCategory> searchStateFromAdmin() {
		String sql = AdminSqlQueries.SEARCHSTATESFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminStateMapper());
	}

	@Override
	public List<AdminCategory> searchSubjectFromAdmin() {
		String sql = AdminSqlQueries.SEARCHEXISTSUBJECTFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminSubjectClassMapper());
	}

	public List<AdminCategory> searchSubjectFromAdmin1(int classid) {
		String sql = AdminSqlQueries.SEARCHEXISTSUBJECTFROMADMIN1_QUERY;
		Object[] params = new Object[] { classid };
		return this.getJdbcTemplate().query(sql, params, new AdminSubjectClassMapper());
	}

	@Override
	public int insertBranchFromAdmin(String branchname, int locationid) {
		String sql = AdminSqlQueries.INSERTBRANCHFROMADMIN_QUERY;
		Object[] params = new Object[] { branchname, generateBranchTypeId(), getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat(), locationid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int updateBranch(String branchname, String bid) {
		String sql = AdminSqlQueries.UPDATEBRANCHFROMADMIN_QUERY;
		Object[] params = new Object[] { branchname, bid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int deleteBranch(String bid) {
		String sql = AdminSqlQueries.DELETEBRANCHFROMADMIN_QUERY;
		Object[] params = new Object[] { bid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuserforLecturer() {
		String sql = AdminSqlQueries.GETDETAILSOFALLLECTURERFORADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminAddLecturerValuesForRoleMapper());
	}

	@Override
	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuserforAdmin() {
		String sql = AdminSqlQueries.GETDETAILSOFALLADMINFORADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminAddLecturerValuesForRoleMapper());
	}

	@Override
	public int insertstudentDetailsFromAdmin(String studentid, String firstname, String lastname, String username,
			String pass, String state, String location, String branch, String stcls, String section, String email,
			String phone) {
		int statusid = 0;
		String sql = AdminSqlQueries.INSERTSTUDENTFROMADMIN_QUERY;
		Object[] params = new Object[] { studentid, firstname, lastname, username, pass, state, location, branch, stcls,
				section, email, phone, getDateFromSimpleDateFormat(), getDateFromSimpleDateFormat(), statusid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int deleteStudent(String userid) {
		String sql = AdminSqlQueries.DELETESTUDENTFROMADMIN_QUERY;
		Object[] params = new Object[] { userid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int insertSubjectFromAdmin(String subjectname, int classid) {
		String sql = AdminSqlQueries.INSERTSUBJECTFROMADMIN_QUERY;
		Object[] params = new Object[] { subjectname, generateSubjectTypeId(), getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat(), classid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int updateSubject(String subject, String bid) {
		String sql = AdminSqlQueries.UPDATESUBJECTFROMADMIN_QUERY;
		Object[] params = new Object[] { subject, bid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int deleteSubject(String bid) {
		String sql = AdminSqlQueries.DELETESUBJECTFROMADMIN_QUERY;
		Object[] params = new Object[] { bid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public List<Map<String, Object>> getTopicIdsBasedonSubjectId(String subjectid) {
		String sql = AdminSqlQueries.GETTOPICIDSBASEDONSUBJECTID_QUERY;
		Object[] params = new Object[] { subjectid };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public int deletesubtopicsbasedontopicid(int topicid) {
		String sql = AdminSqlQueries.DELETESUBTOPICSBASEDONTOPICID_QUERY;
		Object[] params = new Object[] { topicid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int deletetopicsbasedonsubjectid(String subjectid) {
		String sql = AdminSqlQueries.DELETETOPICSBASEDONSUBJECTID_QUERY;
		Object[] params = new Object[] { subjectid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int deleteSubjectbasedonClass(String classid) {
		String sql = AdminSqlQueries.DELETESUBJECTBASEDONCLASS_QUERY;
		Object[] params = new Object[] { classid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int deleteSectionbasedonClass(String classid) {
		String sql = AdminSqlQueries.DELETESECTIONBASEDONCLASS_QUERY;
		Object[] params = new Object[] { classid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int insertLocationFromAdmin(String location, int stateid) {
		String sql = AdminSqlQueries.INSERTLOCATIONFROMADMIN_QUERY;
		Object[] params = new Object[] { location, generateLocationTypeId(), getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat(), stateid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int insertStateFromAdmin(String statename) {
		String sql = AdminSqlQueries.INSERTSTATEFROMADMIN_QUERY;
		Object[] params = new Object[] { statename, generateStateTypeId(), getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat() };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int updateLocation(String location, String bid) {
		String sql = AdminSqlQueries.UPDATELOCATIONFROMADMIN_QUERY;
		Object[] params = new Object[] { location, bid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int deleteLocation(String bid) {
		String sql = AdminSqlQueries.DELETELOCATIONFROMADMIN_QUERY;
		Object[] params = new Object[] { bid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int deleteBranchbasedonLocation(String locationid) {
		String sql = AdminSqlQueries.DELETEBRANCHBASEDONLOCATION_QUERY;
		Object[] params = new Object[] { locationid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public List<AdminCategory> searchQuestiontypeFromAdmin() {
		String sql = AdminSqlQueries.SEARCHEXISTQUESTIONTYPFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminQuestionTypeMapper());
	}

	public List<AdminExamNameforReport> getExamNameWiseReportFromAdmin() {
		String sql = AdminSqlQueries.GETEXAMNAMEFORADMINREPORTS_QUERY;
		return this.getJdbcTemplate().query(sql, new AdmingetExamNameReportMapper());
	}

	@Override
	public int updateQuestiontype(String subject, String bid) {
		String sql = AdminSqlQueries.UPDATEQUESTIONTYPEFROMADMIN_QUERY;
		Object[] params = new Object[] { subject, bid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public List<AdminAddEditDeleteAccessforRolesPojo> getListofPermissions() {
		String sql = AdminSqlQueries.GETLISTOFPERMISSIONS_QUERY;
		logger.info("getListofPermissions:" + sql);
		return this.getJdbcTemplate().query(sql, new AdminAddEditDeleteAccessforPermissionsMapper());
	}

	public List<Map<String, Object>> getUserIDsbasedonRoleId(int roleid) {
		String sql = AdminSqlQueries.GETUSERIDSBASEDONROLEID_QUERY;
		Object[] param = { roleid };
		logger.info("getUserIDsbasedonRoleId: " + sql);
		return this.getJdbcTemplate().queryForList(sql, param);
	}

	public int getalreadyinsertedinPermissions(int roleid, int permssionid, String studentid) {
		String sql = AdminSqlQueries.GETALREADYINSERTEDINPERMISSIONS_QUERY;
		Object[] cnt = { roleid, permssionid, studentid };
		return this.getJdbcTemplate().queryForObject(sql, cnt, Integer.class);
	}

	public int insertPermissions(int roleid, int permssionid, String studentid) {
		String sql = AdminSqlQueries.INSERTPERMISSIONS_QUERY;
		Object[] param = { roleid, permssionid, studentid };
		return this.getJdbcTemplate().update(sql, param);
	}

	public List<AdminAddStudent> getUserNamenadEmailofAdminfromuser1() {
		String sql = AdminSqlQueries.GETDETAILSOFALLUSERSFORADMIN1;
		return this.getJdbcTemplate().query(sql, new AdminUsernameValuesForRoleMapper1());
	}

	public List<AdminAddEditDeleteAccessforRolesPojo> getListofeditPermissions(int roleid, String studentid) {
		String sql = AdminSqlQueries.GETLISTOFEDITPERMISSIONS_QUERY;
		Object[] param = { roleid, studentid };
		return this.getJdbcTemplate().query(sql, param, new AdminAddEditDeleteAccessforPermissionsMapper());
	}

	public int updateuserpermissions(int permissionid, int roleid, String studentid) {
		String sql = AdminSqlQueries.UPDATEUSERPERMISSIONS_QUERY;
		Object[] param = { permissionid, roleid, studentid };
		return this.getJdbcTemplate().update(sql, param);
	}

	public List<AdminSubjectWiserightwrongrepo> adminSujectwiseRightWrongReportFromAdmin(String examname,
			String subjid) {
		String sql = AdminSqlQueries.GETSUBJECTWISERIGHTWRONGCOUNTREPORTFORADMIN_QUERY;
		logger.info("adminSujectwiseRightWrongReportFromAdmin: " + sql);
		Object[] params = new Object[] { examname, subjid };
		return this.getJdbcTemplate().query(sql, params, new AdminSubjectWiseRightwrongMapper());
	}

	public List<AdminSubjectWiserightwrongrepo> adminSujectwiseRightWrongReportFromAdminOffline(String examname,
			String subjid) {
		String sql = AdminSqlQueries.GETSUBJECTWISERIGHTWRONGCOUNTREPORTFORADMIN_QUERY1;
		logger.info("adminSujectwiseRightWrongReportFromAdminOffline: " + sql);
		Object[] params = new Object[] { examname, subjid };
		return this.getJdbcTemplate().query(sql, params, new AdminSubjectWiseRightwrongMapper());
	}

	@Override
	public List<AdminSubjectwisemarksRanges> adminSujectwiseMarksRangesFromAdmin(String examname, String subjectid) {
		String sql = AdminSqlQueries.GETSUBJECTWISERMARKSRANGESFORADMIN_QUERY;
		logger.info("adminSujectwiseMarksRangesFromAdmin: " + sql);
		Object[] params = new Object[] { examname, subjectid };
		return this.getJdbcTemplate().query(sql, params, new Adminsubjectwisemarksrangemapper());
	}

	public List<Adminstudentwisequestionerror> adminQuestionWiseErrorReport(String examname) {
		String sql = AdminSqlQueries.GETSTUDENTWISEQERROR_QUERY;
		Object[] params = new Object[] { examname };
		return this.getJdbcTemplate().query(sql, params, new AdminquestionwiseerrorreportMapper());
	}

	public List<Adminstudentwisequestionerror> adminQuestionWiseErrorReportOffline(String examname) {
		String sql = AdminSqlQueries.GETSTUDENTWISEQERROR_QUERY1;
		logger.info("adminQuestionWiseErrorReportOffline" + sql);
		Object[] params = new Object[] { examname };
		return this.getJdbcTemplate().query(sql, params, new AdminquestionwiseerrorreportMapper());
	}

	public List<Adminstudentwisequestionerror> admingetQuestionIdsforQerror1(String examname) {
		String sql = AdminSqlQueries.GETQUESTIONIDFROMWISEQERROR_QUERY;
		logger.info("admingetQuestionIdsforQerror1: " + sql);
		Object[] params = new Object[] { examname };
		return this.getJdbcTemplate().query(sql, params, new AdminQuestionidforqerrormapper());
	}

	public List<AdminCategory> searchExamtypeFromAdmin() {
		String sql = AdminSqlQueries.SEARCHEXAMTYPEFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminSearchExamtypeMapper());
	}

	public int insertExamtypeFromAdmin(String examtype) {
		String sql = AdminSqlQueries.INSERTEXAMTYPEFROMADMIN_QUERY;
		logger.info("insertExamtypeFromAdmin: " + sql);
		Object[] params = new Object[] { examtype, generateExamTypeId(), getDateFromSimpleDateFormat() };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int generateExamTypeId() {
		int getPackageId = getMaxExamtypeId();
		int getCountOfPackageOrder;
		int id = 999;
		if (getPackageId == 0 && getPackageId < id) {
			id++;
		} else {
			getCountOfPackageOrder = getLastNumberFromelExamtype();
			id = getCountOfPackageOrder + 1;
		}
		return id;
	}

	public int getLastNumberFromelExamtype() {
		String sql = AdminSqlQueries.GETLASTNUMBERFROMELEXAMTYPE_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public int getMaxExamtypeId() {
		String sql = AdminSqlQueries.GETMAXEXAMTYPEID_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public List<AdminCategory> searchQuestionlevelFromAdmin() {
		String sql = AdminSqlQueries.SEARCHQUESTIONLEVELFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminSearchQuestionlevelMapper());
	}

	public int insertQuestionlevelFromAdmin(String queslavel) {
		String sql = AdminSqlQueries.INSERTQUESTIONLEVELFROMADMIN_QUERY;
		Object[] params = new Object[] { queslavel, generateQuestionlevelId(), getDateFromSimpleDateFormat() };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int generateQuestionlevelId() {
		int getPackageId = getMaxQuestionlevelId();
		int getCountOfPackageOrder;
		int id = 0;
		if (getPackageId == 0 && getPackageId <= id) {
			id++;
		} else {
			getCountOfPackageOrder = getLastNumberFromQuestionlevel();
			id = getCountOfPackageOrder + 1;
		}
		return id;
	}

	public int getMaxQuestionlevelId() {
		String sql = AdminSqlQueries.GETMAXQUESTIONLEVELID_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public int getLastNumberFromQuestionlevel() {
		String sql = AdminSqlQueries.GETLASTNUMBERFROMQUESTIONLEVEL_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public int updateEXamtype(String examtype, String examtypeid) {
		String sql = AdminSqlQueries.UPDATEEXAMTYPEFROMADMIN_QUERY;
		Object[] params = new Object[] { examtype, examtypeid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int updateQuestionlevel(String examtype, String examtypeid) {
		String sql = AdminSqlQueries.UPDATEQUESTIONLEVELFROMADMIN_QUERY;
		Object[] params = new Object[] { examtype, examtypeid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int deleteExamtype(String classid) {
		String sql = AdminSqlQueries.DELETEEXAMTYPEFROMADMIN_QUERY;
		Object[] params = new Object[] { classid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int deleteQuestionlevelFromAdmin(String classid) {
		String sql = AdminSqlQueries.DELETEQUESTIONLEVELFROMADMIN_QUERY;
		Object[] params = new Object[] { classid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public List<AdminFilterCriteria> adminFilterCriteriaForCreateExam(AdminFilterCriteria adc) {
		String sql= "select eq.ques,  eq.import_file_name,"
				+ "eq.exam_type,es.el_subject_name,et.subject_topic_type,sbj.subject_subtopic_type,eq.Question_Type,"
				+ "ql.Question_Level_Type,cl.el_class_name from el_questions eq,el_subject es,el_subject_topic_type et,"
				+ "el_subject_subtopic_type sbj,el_question_level_type ql,el_class cl where eq.subject_type=es.el_subject_id "
				+ "and eq.topic=et.subject_topic_type_id  and eq.subtopic=sbj.subject_subtopic_type_id and "
				+ "et.subject_type_id=sbj.subject_type_id and et.exam_type_id = sbj.exam_type_id and "
				+ "et.subject_type_id=es.el_subject_id and ql.Question_Level_Type_Id=eq.question_level_type_id and "
				+ "cl.el_class_generated_id=es.el_class_generated_id and cl.el_class_generated_id="+adc.getClassid()+" and eq.exam_type=(select Exam_Type from el_exam_type where Exam_Type_Id="+adc.getExamtype()+") and eq.subject_type="+adc.getSubjectype()+" and eq.topic in ("+adc.getTopicids()+") group by eq.import_file_name";
		logger.info("adminFilterCriteriaForCreateExam: "+sql);
		return this.getJdbcTemplate().query(sql, new AdminFilterCriteriaMapper());
	}

	public String generateStudentID() {
		DateFormat yyFormat = new SimpleDateFormat("yy");
		Date now = new Date();
		String id = "0";
		String year = yyFormat.format(now);
		String educareName = "ED";
		int lastUid = getMaxUserIDfromUsers();
		lastUid = lastUid + 1;
		int lenoflastUid = String.valueOf(lastUid).length();
		if (lenoflastUid == 1) {
			id = "0000" + lastUid;
		}
		if (lenoflastUid == 2) {
			id = "000" + lastUid;
		}
		if (lenoflastUid == 3) {
			id = "00" + lastUid;
		}
		if (lenoflastUid == 4) {
			id = "0" + lastUid;
		}
		if (lenoflastUid == 5) {
			int id1 = lastUid;
			id = Integer.toString(id1);
		}
		String studentId = educareName + "-" + year + "-" + id;
		logger.info(studentId);
		return studentId;
	}

	public int getMaxUserIDfromUsers() {
		String sql = AdminSqlQueries.GETMAXUSERIDFROMUSERS_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public List<AdminSubjectwisemarksRanges> adminSujectwiseMarksRangesFromAdminoffline(String examname,
			String subjectid) {
		String sql = AdminSqlQueries.GETSUBJECTWISERMARKSRANGESFORADMINOFFLINE_QUERY;
		logger.info(sql);
		Object[] params = new Object[] { examname, subjectid };
		return this.getJdbcTemplate().query(sql, params, new Adminsubjectwisemarksrangemapper());
	}

	public int getQustypetotalmarks(String examname, String examtypeid, String subjectids, String quntypeid) {
		String sql = AdminSqlQueries.GETQUSTYPETOTALMARKS_QUERY;
		Object[] params = new Object[] { examname, subjectids, examtypeid, quntypeid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getMaxRowIdFromLogo() {
		String sql = "select ifnull(max(el_organization_logo_id),0) as maxid from  el_organization_logo";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public int insertOrganization(AdminAddOrganizationLogoModel orglogo, String filename) {
		String sql = "insert into el_organization_logo (el_organization_name,el_organization_logo,createddate) values('"
				+ orglogo.getOrganizationname() + "','" + filename + "','" + getDateFromSimpleDateFormat() + "') ";
		return this.getJdbcTemplate().update(sql);
	}

	/*** SMS ***/
	public List<AdminCategory> getExamNameForBulkSms(int classid, int sectionid, int campusid, int locationid,
			int stateid) {
		String sql = "select Exam_Name from el_student_results where campus='" + campusid + "' and class_id='" + classid
				+ "' and section='" + sectionid + "' and  state='" + stateid + "' and el_location_id='" + locationid
				+ "' group by Exam_Name";
		return this.getJdbcTemplate().query(sql, new GetExamNameForSeendingBulkSmsMapper());
	}

	public List<AdminCategory> getAllstudentResultsForBulkSms(AdminCategory ac) {
		String sql = "select * from (select Student_Id as std ,first_name,phone from users where el_branch_id='"
				+ ac.getBranchcheckname() + "' " + "and el_class_generated_id='" + ac.getClassname()
				+ "' and el_location_id='" + ac.getLoactioncheckvalue() + "' and el_section_id='"
				+ ac.getSectioncheckname() + "' and state_type_id='" + ac.getStatechckbox()
				+ "') as tb1 left outer join  "
				+ "(select er.Student_Id from el_student_results er,users ur where er.campus='"
				+ ac.getBranchcheckname() + "'  and er.class_id='" + ac.getClassname() + "'  and er.section='"
				+ ac.getSectioncheckname() + "'" + " and  er.state='" + ac.getStatechckbox()
				+ "' and er.el_location_id='" + ac.getLoactioncheckvalue() + "' and er.Exam_Name='" + ac.getExamname()
				+ "' and ur.student_id=er.Student_Id group by Student_Id) as tb2 on tb1.std=tb2.Student_Id";
		return this.getJdbcTemplate().query(sql, new GetStudentIdForBulkSmsMapper());
	}

	public List<AdminCategory> getAllScoredmarksForBulkUpdate(String studentid, String examname) {
		String sql = "select er.SCORED_MARKS,er.el_subject_id,er.Student_Id,es.el_subject_name,ur.first_name,ur.phone "
				+ "from el_student_results er,el_subject es,users ur where er.Exam_Name='" + examname + "'  "
				+ "and er.Student_Id='" + studentid + "' "
				+ "and ur.student_id=er.Student_Id and er.el_subject_id=es.el_subject_id ";
		return this.getJdbcTemplate().query(sql, new GetScoredMarksForBulkSmsMapper());
	}

	public List<AdminCategory> getAllUserDetailsTosentSms(AdminCategory ac) {
		String sql = "select Student_Id,first_name,phone from users where el_branch_id='" + ac.getBranchcheckname()
				+ "' and el_class_generated_id='" + ac.getClassname() + "' and el_location_id='"
				+ ac.getLoactioncheckvalue() + "' and el_section_id='" + ac.getSectioncheckname()
				+ "' and state_type_id='" + ac.getStatechckbox() + "'";
		return this.getJdbcTemplate().query(sql, new GetDetailsForBulkSmsMapper());
	}

	public List<AdminExamNameforReport> getExamnamesForSubmitExam() {
		String sql = AdminSqlQueries.GETEXAMNAMESFORSUBMITEXAM_QUERY;
		return this.getJdbcTemplate().query(sql, new AdmingetExamNameReportMapper());
	}

	public List<AdminExamNameforReport> getNotFishedStdsBasedonExamname(AdminExamNameforReport submitexam) {
		String sql = AdminSqlQueries.GETNOTFISHEDSTDSBASEDONEXAMNAME_QUERY;
		Object[] params = new Object[] { submitexam.getExamname() };
		return this.getJdbcTemplate().query(sql, params, new GetNotFishedStdsBasedonExamnameMapper());
	}

	public List<AdminExamNameforReport> getExamnamesForExamStatus1() {
		String sql = AdminSqlQueries.GETEXAMNAMESFOREXAMSTATUS_QUERY1;
		return this.getJdbcTemplate().query(sql, new AdmingetExamNameReportMapper());
	}

	public List<AdminExamNameforReport> getExamdetailsBasedonExamanme(AdminExamNameforReport submitexam) {
		String sql = AdminSqlQueries.GETEXAMDETAILSBASEDONEXAMANME_QUERY;
		Object[] params = new Object[] { submitexam.getExamname() };
		return this.getJdbcTemplate().query(sql, params, new GetExamDetailsBasedonExamnameMapper());
	}

	public List<AdminExamNameforReport> getExamnamesFromExampaper() {
		String sql = AdminSqlQueries.GETEXAMNAMESFROMEXAMPAPER_QUERY;
		return this.getJdbcTemplate().query(sql, new AdmingetExamNameReportMapper());
	}

	public String getSubjectidBasedonExamname(AdminViewExamQuesPaperModel epaper) {
		String sql = AdminSqlQueries.GETSUBJECTIDBASEDONEXAMNAME_QUERY;
		Object[] params = new Object[] { epaper.getExamname() };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public List<AdminSetStartExamPatternModel> getAllExamPatterns() {
		String sql = AdminSqlQueries.GETALLEXAMPATTERNS_QUERY;
		return this.getJdbcTemplate().query(sql, new GetAllExamPatternsMapper());
	}

	public List<AdminSetStartExamPatternModel> getAllExamtypes() {
		String sql = AdminSqlQueries.GETALLEXAMTYPES_QUERY;
		return this.getJdbcTemplate().query(sql, new GetAllExamtypesMapper());
	}

	public int insertStartExamPatternData(String patternid, String extypeid) {
		String sql = AdminSqlQueries.INSERTSTARTEXAMPATTERNDATA_QUERY;
		Object[] parms = { extypeid, patternid };
		return this.getJdbcTemplate().update(sql, parms);
	}

	public List<AdminSetStartExamPatternModel> getSetPatternValue() {
		String sql = AdminSqlQueries.GETSETPATTERNVALUE_QUERY;
		return this.getJdbcTemplate().query(sql, new GetSetedPatternValueMapper());
	}

	public int checkExistinExamPattern(String patternid, String extypeid) {
		String sql = AdminSqlQueries.CHECKEXISTINEXAMPATTERN_QUERY;
		Object[] parms = { extypeid };
		return this.getJdbcTemplate().queryForObject(sql, parms, Integer.class);
	}

	public int updateStartExamPattern(String patternid, String extypeid) {
		String sql = AdminSqlQueries.UPDATESTARTEXAMPATTERN_QUERY;
		Object[] parms = { patternid, extypeid };
		return this.getJdbcTemplate().update(sql, parms);
	}

	public int getInsertClientLogo(AdminUploadClientLogoModel getlogo) {
		String sql = AdminSqlQueries.GETINSERTCLIENTDETAILS_QUERY;
		Object[] params = { getlogo.getSchoolid(), getlogo.getLogo(), getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat() };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int getUpdateClientLogo(AdminUploadClientLogoModel getlogo) {
		String sql = AdminSqlQueries.GETUPLOADCLIENTDETAILS_QUERY;
		Object[] params = { getlogo.getSchoolid(), getlogo.getLogo(), getDateFromSimpleDateFormat(),
				getlogo.getClientlogoid() };
		return this.getJdbcTemplate().update(sql, params);
	}

	public String getClientLogoBasedOnSchoolId(String school) {
		String sql = AdminSqlQueries.GETCLIENTLOGOBASEDONSCHOOLID_QUERY;
		Object[] param = { school };
		return this.getJdbcTemplate().queryForObject(sql, param, String.class);
	}

	@Override
	public int getInsertClientCarousel(AdminUploadClientLogoModel getlogo) {
		String sql = AdminSqlQueries.GETINSERTCLIENTCAROUSEL_QUERY;
		Object[] params = { getlogo.getCarousel(), getlogo.getSchoolid(), getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat() };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int getMaxRowIdFromClientCarousel() {
		String sql = AdminSqlQueries.GETMAXROWIDFROMINTROCAROUSEL_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	@Override
	public List<AdminUploadClientLogoModel> getClientCarouselBasedOnSchool(String schoolid) {
		String sql = AdminSqlQueries.GETALLCLIENTCAROUSEL_QUERY;
		Object[] params = { schoolid };
		return this.getJdbcTemplate().query(sql, params, new GetAllClientCarouselMapper());
	}

	@Override
	public List<Map<String, Object>> getClientlogoTblSize(String school) {
		String sql = AdminSqlQueries.GETCLIENTLOGODBSIZE_QUERY;
		Object[] params = { school };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	@Override
	public List<UpdateKeyModel> editUpdateKeyExam(UpdateKeyModel ukm) {
		String sql = AdminSqlQueries.EDITUPDATEKEYEXAM_QUERY;
		Object[] params = { ukm.getExamname() };
		return this.getJdbcTemplate().query(sql, params, new GetAllUpdateKeyMapper());
	}

	@Override
	public int updateKeyValuesInQues(String qid, String key) {
		String sql = AdminSqlQueries.UPDATEKEYVALUESINQUES_QUERY;
		Object[] params = { key, qid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int updateKEyInStuResHis(String key, String qid, String exmnam) {
		String sql = AdminSqlQueries.UPDATEKEYINSTURESHIS_QUERY;
		Object[] params = { key, qid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public List<ResultCalculationModel> getStudentidsBaseExam(ResultCalculationModel rcm) {
		String sql = AdminSqlQueries.GETSTUDENTIDSBASEEXAM_QUERY;
		Object[] params = { rcm.getExamname() };
		return this.getJdbcTemplate().query(sql, params, new GetAllStuIdExamNamMapper());
	}

	@Override
	public List<AdminUploadClientLogoModel> getExistingCountFromClientContactDetTb(String school) {
		String sql = AdminSqlQueries.GETEXISTINGCOUNTFROMCLIENTCONTACTDETTB_QUERY;
		Object[] params = { school };
		return this.getJdbcTemplate().query(sql, params, new GetAllClientContactMapper());
	}

	@Override
	public int getUpdateContactDet(AdminUploadClientLogoModel insertcont) {
		String sql = AdminSqlQueries.GETUPDATECONTACTDET_QUERY;
		Object[] params = { insertcont.getContactinfo(), insertcont.getEmailid(), insertcont.getAddress(),
				insertcont.getSchoolid(), getDateFromSimpleDateFormat(), insertcont.getContactid() };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int getInsertContactDet(AdminUploadClientLogoModel insertcont) {
		String sql = AdminSqlQueries.GETINSERTCONTACTDET_QUERY;
		Object[] params = { insertcont.getContactinfo(), insertcont.getEmailid(), insertcont.getAddress(),
				insertcont.getSchoolid(), getDateFromSimpleDateFormat() };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public List<AdminCategory> getStudentNames(int classid, int sectionid) {
		String sql = AdminSqlQueries.GETSTUDENTNAMES_QUERY;
		Object[] params = { classid, sectionid };
		return this.getJdbcTemplate().query(sql, params, new GetStudentNames());
	}

	@Override
	public List<StudentExamCountModel> getStudentsForExam(StudentExamCountModel stud) {
		String sql = AdminSqlQueries.GETSTUDENTSFOREXAM_QUERY;
		Object[] params = { stud.getExamname(), stud.getExamstatus() };
		return this.getJdbcTemplate().query(sql, params, new GetStudsForExamCountMapper());
	}

	@Override
	public int getClassidBasedonFilenmae(String filename) {
		String sql = AdminSqlQueries.GETCLASSIDBASEDONFILENMAE_QUERY;
		Object[] params = { filename };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getExamtypeBasedOnFilename(String filename) {
		String sql = AdminSqlQueries.GETEXAMTYPEBASEDONFILENAME_QUERY;
		Object[] param = { filename };
		return this.getJdbcTemplate().queryForObject(sql, param, String.class);
	}
	public String getSubjidBasedOnFilename(String filename) {
		String sql = AdminSqlQueries.GETSUBJIDBASEDONFILENAME_QUERY;
		Object[] param = { filename };
		return this.getJdbcTemplate().queryForObject(sql, param, String.class);
	}
	public String getTopicidsBasedonFilename(String filename) {
		String sql = AdminSqlQueries.GETTOPICIDSBASEDONFILENAME_QUERY;
		Object[] param = { filename };
		return this.getJdbcTemplate().queryForObject(sql, param, String.class);
	}

	@Override
	public int deleteCarouselImage(String carouselid) {
		String sql = AdminSqlQueries.DELETECLIENTCAROUSEL_QUERY;
		Object[] params = new Object[] { carouselid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public String getSubjTotalMarks(String examname, String subjid) {
		String sql = AdminSqlQueries.GETSUBJTOTALMARKS_QUERY;
		Object[] params = new Object[] { examname, subjid };
		return this.getJdbcTemplate().queryForObject(sql, String.class, params);
	}

	public List<AdminViewAuditLogsModel> getStuentIds() {
		String sql = AdminSqlQueries.GETSTUENTIDS_QUERY;
		return this.getJdbcTemplate().query(sql, new GetStudentIdsMapper());
	}

	public List<Map<String, Object>> getMailId() {
		String sql = AdminSqlQueries.GETMAILID_QUERY;
		return this.getJdbcTemplate().queryForList(sql);
	}

	public List<Map<String, Object>> getPasswordBaseOnId(String sid) {
		String sql = AdminSqlQueries.GETPASSWORDBASEONID_QUERY;
		Object[] param = { sid };
		return this.getJdbcTemplate().queryForList(sql, param);
	}

	/* Copy previous created exam pattern with out slot */
	public List<AdminCategory> getExamNameForCopyExamwithNoslot(String isslotNo) {
		String sql = AdminSqlQueries.GETEXAMNAMEFORCOPYEXAMWITHNOSLOT_QUERY;
		Object[] param = { isslotNo };
		return this.getJdbcTemplate().query(sql, new GetExamNameForCopyExamMapper(), param);
	}

	/*** AED State ***/
	public int searchstatesFromAdmin1(String statename) {
		String sql = AdminSqlQueries.SEARCHSTATESFROMADMIN1_QUERY;
		Object[] params = { statename };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);

	}

	@Override
	public int updateState(String statename, String stateid) {
		String sql = AdminSqlQueries.UPDATESTATE_QUERY;
		Object[] params = new Object[] { statename, stateid };
		return this.getJdbcTemplate().update(sql, params);
	}

	/*** get Admin Details ***/
	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuserforAdmin1(String roleid) {
		String sql = AdminSqlQueries.GETDETAILSOFALLADMINFORADMIN1_QUERY;
		Object[] param = { roleid };
		return this.getJdbcTemplate().query(sql, new AdminAddLecturerValuesForRoleMapper(), param);
	}

	/*** Delete state ***/
	@Override
	public int deleteState(String bid) {
		String sql = AdminSqlQueries.DELETESTATEFROMADMIN_QUERY;
		Object[] params = new Object[] { bid };
		return this.getJdbcTemplate().update(sql, params);
	}

	/*** Delete Locations Based on State ***/
	@Override
	public int deleteLocationbasedonState(String stateid) {
		String sql = AdminSqlQueries.DELETELOCATIONBASEDONSTATE_QUERY;
		Object[] params = new Object[] { stateid };
		return this.getJdbcTemplate().update(sql, params);
	}

	/*** Search Locations ***/
	@Override
	public List<AdminCategory> searchLocationsFromAdmin() {
		String sql = AdminSqlQueries.SEARCHEXISTLOCATIONFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminLocationClassMapper());
	}

	/*** Search Locations Based on location ***/
	public int searchLocationsFromAdmin1(String locationname, String state) {
		String sql = AdminSqlQueries.SEARCHLOCATIONSFROMADMIN1_QUERY;
		Object[] params = { locationname, state };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);

	}

	/*** Search Locations Based on state ***/
	public List<AdminCategory> searchLocationsFromAdminBasedonStates(String stateid) {
		String sql = AdminSqlQueries.SEARCHLOCATIONSFROMADMINBASEDONSTATES_QUERY;
		Object[] params = { stateid };
		return this.getJdbcTemplate().query(sql, new AdminLocationNamesMapper(), params);
	}

	/*** Search Branches Based on Locations ***/
	public List<AdminCategory> searchBranchesFromAdminBasedonLocation(String locationid) {
		String sql = AdminSqlQueries.SEARCHBRANCHESFROMADMINBASEDONLOCATION_QUERY;
		Object[] params = { locationid };
		return this.getJdbcTemplate().query(sql, new AdminBranchNamesMapper(), params);
	}

	/*** Search Branches Based on Locations,states ***/
	public int searchBranchesFromAdmin1(String statename, String location, String stateid) {
		String sql = AdminSqlQueries.SEARCHBRANCHESFROMADMIN1_QUERY;
		Object[] params = { statename, location, stateid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int searchClassesFromAdmin1(String classname) {
		String sql = AdminSqlQueries.SEARCHCLASSESFROMADMIN1_QUERY;
		Object[] param = { classname };
		return this.getJdbcTemplate().queryForObject(sql, param, Integer.class);
	}

	public int deleteSujectTopicsOnClass(String classid) {
		String sql = AdminSqlQueries.DELETESUJECTTOPICSONCLASS_QUERY;
		Object[] params = { classid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int searchSectionFromAdmin1(String sectionname, String classname) {
		String sql = AdminSqlQueries.SEARCHSECTIONFROMADMIN1_QUERY;
		Object[] params = { sectionname, classname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	@Override
	public int updateSection(String sectionname, String secid) {
		String sql = AdminSqlQueries.UPDATESECTIONFROMADMIN_QUERY;
		Object[] params = new Object[] { sectionname, secid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public int deleteSection(String secid) {
		String sql = AdminSqlQueries.DELETESECTIONFROMADMIN_QUERY;
		Object[] params = new Object[] { secid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int searchSubjectFromAdmin1(String statename, String classname) {
		String sql = AdminSqlQueries.SEARCHSUBJECTFROMADMIN1_QUERY;
		Object[] params = { statename, classname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int searchExamtypeFromAdmin1(String statename) {
		String sql = AdminSqlQueries.SEARCHEXAMTYPEFROMADMIN1_QUERY;
		Object[] param = { statename };
		return this.getJdbcTemplate().queryForObject(sql, param, Integer.class);
	}

	public List<AdminTopicSubTopicsNameMoidifyModel> getTopicsSubTopicsFromQuestions(
			AdminTopicSubTopicsNameMoidifyModel tsm) {
		String sql = AdminSqlQueries.GETTOPICSSUBTOPICSFROMQUESTIONS_QUERY;
		Object[] parms = { tsm.getClassid(), tsm.getExamtypeid() };
		return this.getJdbcTemplate().query(sql, parms, new AdminTopicSubTopicsNameMoidifyMapper());
	}

	public int getCountOfTopicsAvailable(String classid, String subjectid, String topicid, int examtypeid) {
		String sql = AdminSqlQueries.GETCOUNTOFTOPICSAVAILABLE_QUERY;
		Object[] prams = { classid, subjectid, topicid, examtypeid };
		return this.getJdbcTemplate().queryForObject(sql, prams, Integer.class);
	}

	public int getCountOfSubTopicsAvailable(String classid1, String subjectid1, String topicid1, int examtypeid,
			int subtopicid) {
		String sql = AdminSqlQueries.GETCOUNTOFSUBTOPICSAVAILABLE_QUERY;
		Object[] params = { examtypeid, classid1, topicid1, subtopicid, subjectid1 };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int insertDataintosubjecttopictypeTable(int classid, int subjectid, int topicid, String topictext,
			int examtypeid) {
		String sql = AdminSqlQueries.INSERTDATAINTOSUBJECTTOPICTYPETABLE_QUERY;
		Object[] params = { classid, subjectid, topicid, topictext, getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat(), examtypeid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int updateDataintosubjecttopictypeTable(int classid, int subjectid, int topicid, String topictext,
			int examtypeid) {
		String sql = AdminSqlQueries.UPDATEDATAINTOSUBJECTTOPICTYPETABLE_QUERY;
		Object[] params = new Object[] { topictext, classid, subjectid, topicid, examtypeid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int insertDataintosubjectsubtopictypeTable(int subjectid, int topicid, int subtopicid, String subtopictext,
			int classid, int examtypeid) {
		String sql = AdminSqlQueries.INSERTDATAINTOSUBJECTSUBTOPICTYPETABLE_QUERY;
		Object[] params = { subtopictext, subtopicid, topicid, getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat(), classid, subjectid, examtypeid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int updateDataintosubjectsubtopictypeTable(int subjectid, int topicid, int subtopicid, String subtopictext,
			int classid, int examtypeid) {
		String sql = AdminSqlQueries.UPDATEDATAINTOSUBJECTSUBTOPICTYPETABLE_QUERY;
		Object[] params = { subtopictext, topicid, subtopicid, classid, subjectid, examtypeid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int searchQuestionlevelFromAdmin1(String statename) {
		String sql = AdminSqlQueries.SEARCHQUESTIONLEVELFROMADMIN1_QUERY;
		Object[] params = { statename };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);

	}

	public int getUsernameAndEmail(AdminFileUploadExampleModel val) {
		String sql = AdminSqlQueries.GETUSERNAMEANDEMAIL_QUERY;
		Object[] param = { val.getUsername(), val.getEmail() };
		return this.getJdbcTemplate().queryForObject(sql, param, Integer.class);
	}

	public int insertBulkdataintoUsers(AdminFileUploadExampleModel val) {
		val.setStudentid(generateStudentID());
		String sql = AdminSqlQueries.INSERTBULKDATAINTOUSERS_QUERY;
		Object[] params = { val.getStudentid(), val.getFirstname(), val.getLastname(), val.getUsername(),
				val.getEmail(), val.getPassword(), val.getMobilenumber1(), val.getStatusid(), val.getClassid(),
				val.getSectionid(), val.getBranchid(), val.getStateid(), val.getLocationid(),
				getDateFromSimpleDateFormat(), getDateFromSimpleDateFormat(), val.getSessionid() };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int getUsernameAndEmail1(AdminFileUploadExampleModel val) {
		String sql = AdminSqlQueries.GETUSERNAMEANDEMAIL1_QUERY;
		Object[] param = { val.getUsername(), val.getEmail() };
		return this.getJdbcTemplate().queryForObject(sql, param, Integer.class);
	}

	public int userroleIdAlreadyexistCount(AdminFileUploadExampleModel user) {
		String sql = AdminSqlQueries.USERROLEIDALREADYEXISTCOUNT_QUERY;
		Object[] params = { user.getUsername() };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getUpdateUseridInUSerRoles(int userid, int roleid) {
		String sql = UserSqlQueries.GETUPDATEUSERIDINUSERROLES_QUERY;
		Object[] param = { userid, roleid };
		return this.getJdbcTemplate().update(sql, param);
	}

	@Override
	public int getUserIDfromUsers(String username) {
		String query = UserSqlQueries.GETUSERIDFROMUSERS_QUERY;
		Object[] parm = { username };
		return this.getJdbcTemplate().queryForObject(query, parm, Integer.class);
	}

	public int updatestudentDetailsFromAdmin(String sid, String firstname, String lastname, String username,
			String email, String password, String mobile, String statenames, String locationname, String branch,
			String stdclass, String section, String userid, String status) {
		String sql = AdminSqlQueries.UPDATESTUDENTDETAILSFROMADMIN_QUERY;
		Object[] params = { sid, firstname, lastname, username, email, password, mobile, statenames, locationname,
				branch, stdclass, section, status, userid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int deleteuserfromUserRole(String userid) {
		String sql = AdminSqlQueries.DELETEUSERFROMUSERROLE_QUERY;
		Object[] params = { userid };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuser1(AdminAddNewStudent adc) {
		String sql = AdminSqlQueries.GETUSERNAMENADEMAILOFADMINFROMUSERBASDONCLASSSEC_QUERY;
		Object[] params = new Object[] { adc.getClassid(), adc.getSectionid() };
		return this.getJdbcTemplate().query(sql, params, new AdminUsernameValuesForRoleMapper());
	}

	@Override
	public List<AdminAddNewStudent> getUserNamenadEmailofAdminfromuser12(AdminAddNewStudent adc) {
		String sql = AdminSqlQueries.GETDETAILSOFALLUSERSFORADMINBASEDONSTUD_QUERY;
		Object[] params = new Object[] { adc.getClassid(), adc.getSectionid(), adc.getStudentid() };
		return this.getJdbcTemplate().query(sql, params, new AdminUsernameValuesForRoleMapper());
	}

	public int getUserNamenadEmailofAdminfromuser2(AdminAddNewStudent adc) {
		String sql = AdminSqlQueries.GETUSERNAMENADEMAILOFADMINFROMUSER_QUERY;
		Object[] params = new Object[] { adc.getUsername(), adc.getEmail() };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public List<AdminCategory> getsectionsfromClass(int classid) {
		String sql = AdminSqlQueries.GETSECTIONSFROMCLASS_QUERY;
		Object[] params = new Object[] { classid };
		return this.getJdbcTemplate().query(sql, params, new AdminSectionClassMapper());
	}

	public List<AdminCategory> searchexamtypesFromAdmin() {
		String sql = AdminSqlQueries.SEARCHEXAMTYPESFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminExamTypeMapper());
	}

	public List<AdminCategory> searchquestionleveltypesFromAdmin() {
		String sql = AdminSqlQueries.SEARCHQUESTIONLEVELTYPESFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminQuestionLevelTypeMapper());
	}

	public List<AdminCategory> getsubjectsfromClass(int classid) {
		String sql = AdminSqlQueries.GETSUBJECTSFROMCLASS_QUERY;
		Object[] params = new Object[] { classid };
		return this.getJdbcTemplate().query(sql, params, new AdminSubjectClassMapper());
	}

	@Override
	public List<AdminSetExamPojo> gettopicsinsubject(String subjecttypeid, String examtypeid) {
		String sql = AdminSqlQueries.GETTOPICSINSUBJECT_QUERY;
		Object[] params = { subjecttypeid, examtypeid };
		return this.getJdbcTemplate().query(sql, params, new AdminTopicListClassMapper());
	}

	@Override
	public List<AdminSetExamPojo> getAllsubtopicsinsubject(String examtypeid, String sujid) {
		String sql = AdminSqlQueries.GETALLSUBTOPICSINSUBJECT1_QUERY;
		Object[] params = { examtypeid, sujid };
		return this.getJdbcTemplate().query(sql, params, new AdminSubTopicListClassMapper());
	}

	public int getCountOfTotalStudentsAvailable(String classname, String sectionname, String branch,
			String statechckbox, String state) {
		String sql = AdminSqlQueries.GETCOUNTOFTOTALSTUDENTSAVAILABLE_QUERY;
		Object[] params = { classname, sectionname, branch, statechckbox, state };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public void insertcreatedExaminexamTable(String examname, String statechckbox, String state, String branch,
			String classname, String sectionname, int spltsubjecttypeid, String topicjoined,
			String subjoinedsubtopicids, int questiontypeidvalue, String questionlevelid, int examtypeid,
			String startdate, String enddate, String starttime, String endtime, String examtime, int noofqnsperqntype,
			int marksperqn, String negativemarksperqustype, int totalmarks, int toatlStdsAvailable,
			int spltqnsfromquestiontype, String fixedmarks, String isslotNo) {
		String sql = AdminSqlQueries.INSERTCREATEDEXAMINEXAMTABLE_QUERY;
		Object[] params = { examname, statechckbox, state, branch, classname, sectionname, spltsubjecttypeid,
				topicjoined, subjoinedsubtopicids, questiontypeidvalue, questionlevelid, examtypeid, startdate, enddate,
				starttime, endtime, examtime, spltqnsfromquestiontype, noofqnsperqntype, negativemarksperqustype,
				totalmarks, toatlStdsAvailable, getDateFromSimpleDateFormat(), fixedmarks, isslotNo };
		this.getJdbcTemplate().update(sql, params);
	}

	public List<Map<String, Object>> validateExamnameinelexamtable(String examnamevalue) {
		String sql = AdminSqlQueries.VALIDATEEXAMNAMEINELEXAMTABLE_QUERY;
		Object[] params = { examnamevalue };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public List<AdminTopicSubTopicsNameMoidifyModel> getTopicsSubTopicsFromQuestionsAll(
			AdminTopicSubTopicsNameMoidifyModel tsm) {
		String sql = AdminSqlQueries.GETTOPICSSUBTOPICSFROMQUESTIONSALL_QUERY;
		Object[] parm = { tsm.getClassid(), tsm.getExamtypeid(), tsm.getSubjecttypeid() };
		return this.getJdbcTemplate().query(sql, new AdminTopicSubTopicsNameMoidifyMapper(), parm);
	}

	public List<AdminCategory> getSunBaseOnClass(String classids) {
		String sql = AdminSqlQueries.GETSUNBASEONCLASS_QUERY;
		Object[] param = { classids };
		return this.getJdbcTemplate().query(sql, new GetSubjectMapper(), param);
	}

	public List<AdminAddEditDeleteAccessforRolesPojo> getRolesforAdmin(String superadmroleid) {
		String sql = AdminSqlQueries.GETROLESFORADMIN_QUERY;
		Object[] params = { superadmroleid };
		return this.getJdbcTemplate().query(sql, params, new AdminAddEditDeleteAccessforRolesMapper());
	}

	public List<AdminViewAuditLogsModel> getAllAuditslogsDetails(AdminViewAuditLogsModel av) {
		String sql = AdminSqlQueries.GETALLAUDITLOGDATA_QUERY;
		Object[] params = { av.getStudentid() };
		return this.getJdbcTemplate().query(sql, new AdminViewAuditLogsMapper(), params);
	}

	public List<AdminViewExamQuesPaperModel> getDisplayQuesToViewQuepaper(AdminViewExamQuesPaperModel epaper) {
		String sql = AdminSqlQueries.GETDISPLAYQUESTOVIEWQUEPAPER_QUERY;
		Object[] params = { epaper.getExamname(), epaper.getSubjectid() };
		return this.getJdbcTemplate().query(sql, params, new GetDisplayQuesToViewQuepaperMapper());
	}

	/*** All India Marks Analysis ***/
	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResults(String examname) {
		String sql = AdminSqlQueries.GETSUBJECTSFROMSTUDENTRESULTS_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new AdminAllIndiaMarksAnalysisMapper1());
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getuserdetailsfromStudentResults(String examname, String subjs) {
		String sql = AdminSqlQueries.GETUSERDETAILSFROMSTUDENTRESULTS_QUERY;
		Object[] params = { examname, subjs };
		return this.getJdbcTemplate().query(sql, params, new AdminAllIndiaMarksAnalysisMapper());
	}

	public String getAllIndiaReportSubjectRank(String examname, String studentid, String subjs) {
		String sql = AdminSqlQueries.GETALLINDIAREPORTSUBJECTRANK_QUERY;
		Object[] params = { examname, examname, studentid, subjs, subjs };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getuserdetailsfromStudentResultsInAnotherSubj(String examname, String subj, int classid,
			int sectionid, int campusid, int stateid, String studentid) {
		String sql = AdminSqlQueries.GETUSERDETAILSFROMSTUDENTRESULTSINANOTHERSUBJ_QUERY;
		Object[] params = { examname, subj, campusid, sectionid, stateid, classid, studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public float getScoredmarksPerSubject(String examname, String studentid, String subjs1) {
		String sql = AdminSqlQueries.GETSCOREDMARKSPERSUBJECT_QUERY;
		Object[] params = { examname, studentid, subjs1 };
		return this.getJdbcTemplate().queryForObject(sql, params, Float.class);
	}

	public int getAllIndiaRankBasedOnExamname(String examname, String studentid) {
		String sql = AdminSqlQueries.GETALLINDIARANKBASEDONEXAMNAME_QUERY;
		Object[] params = { examname, examname, studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getAllIndiaCampusRankBasedOnExamname(String examname, String studentid, int campusid) {
		String sql = AdminSqlQueries.GETALLINDIACAMPUSRANKBASEDONEXAMNAME_QUERY;
		Object[] params = { examname, examname, studentid, campusid, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getAllIndiaStateRankBasedOnExamname(String examname, String studentid, int stateid) {
		String sql = AdminSqlQueries.GETALLINDIASTATERANKBASEDONEXAMNAME_QUERY;
		Object[] params = { examname, examname, studentid, stateid, stateid };
		logger.info("getAllIndiaStateRankBasedOnExamname " + sql);
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getAllIndiaSectionRankBasedOnExamname(String examname, String studentid, int sectionid) {
		String sql = AdminSqlQueries.GETALLINDIASECTIONRANKBASEDONEXAMNAME_QUERY;
		Object[] params = { examname, examname, studentid, sectionid, sectionid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	/*** Student-wise Question-wise Error Report ***/
	public List<Adminstudentwisequestionerror> getrightvalueforerrorreport(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		String sql = AdminSqlQueries.GETRIGHTVALUEFORERRORREPORT_QUERY;
		Object[] params = new Object[] { questionid, examname, studentid, campus, section, questionrowid };
		return this.getJdbcTemplate().query(sql, params, new AdminRightAnswerforReportMapper());
	}

	public List<Adminstudentwisequestionerror> getwrongvalueforerrorreport(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		String sql = AdminSqlQueries.GETWRONGVALUEFORERRORREPORT_QUERY;
		Object[] params = { questionid, examname, studentid, campus, section, questionrowid };
		return this.getJdbcTemplate().query(sql, new AdminWrongAnsweredforrepomapper(), params);
	}

	public List<Adminstudentwisequestionerror> getnotansweredvalueforerrorreport(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		String sql = AdminSqlQueries.GETNOTANSWEREDVALUEFORERRORREPORT_QUERY;
		Object[] params = { questionid, examname, studentid, campus, section, questionrowid };
		return this.getJdbcTemplate().query(sql, params, new AdminUnattemptanswersforreportMapper());
	}

	/*** Subject-wise_Wrong, Right & Un-attempted Counts ***/
	public int getsubjectwisewrongcount(String studid, String section, String campus, String examname,
			String subjectid) {
		String sql = AdminSqlQueries.GETSUBJECTWISEWRONGCOUNT_QUERY;
		Object[] params = { studid, section, campus, examname, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getsubjectwisecorrectcount(String studid, String section, String campus, String examname,
			String subjectid) {
		String sql = AdminSqlQueries.GETSUBJECTWISECORRECTCOUNT_QUERY;
		Object[] params = { studid, section, campus, examname, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getsubjectwiseunattemptcount(String studid, String section, String campus, String examname,
			String subjectid) {
		String sql = AdminSqlQueries.GETSUBJECTWISEUNATTEMPTCOUNT_QUERY;
		Object[] params = { studid, section, campus, examname, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getCampuswiseExamstrength(String examname, int campusid) {
		String sql = AdminSqlQueries.GETCAMPUSWISEEXAMSTRENGTH_QUERY;
		Object[] params = { examname, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getmaxquestionlength(String examname, String subjectid) {
		String sql = AdminSqlQueries.GETMAXQUESTIONLENGTH_QUERY;
		Object[] param = { examname, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, param, Integer.class);
	}

	public int getCountOfAllErrorQuestionIdsIncampuswise(String examname, int campusid, int questionid,
			String subjectid, int questionrowid) {
		String sql = AdminSqlQueries.GETCOUNTOFALLERRORQUESTIONIDSINCAMPUSWISE_QUERY;
		Object[] params = { examname, campusid, questionid, subjectid, questionrowid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	/*** STATE-WISE-ERROR-REPORT ***/
	public List<CampuswiseErrorreportPojo> getuserdetailsfromStudentResultsHistoryforState(String examname) {
		String sql = AdminSqlQueries.GETUSERDETAILSFROMSTUDENTRESULTSHISTORYFORSTATE_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new StateNamesInCampuswiseErrorReportMapper());
	}

	/*** Campus Wise Error Report ***/
	public List<CampuswiseErrorreportPojo> getAllQidsInCampuswise1(String examname) {
		String sql = AdminSqlQueries.GETALLQIDSINCAMPUSWISE1_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new QiestionIdsInCampusWiseErrorReportMapper());
	}

	public int getStatewiseExamstrength(String examname, int stateid) {
		String sql = AdminSqlQueries.GETSTATEWISEEXAMSTRENGTH_QUERY;
		Object[] params = { examname, stateid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResultsforstate(String examname, int stateid) {
		String sql = AdminSqlQueries.GETSUBJECTSFROMSTUDENTRESULTSFORSTATE_QUERY;
		Object[] params = { examname, stateid };
		return this.getJdbcTemplate().query(sql, params, new AdminAllIndiaMarksAnalysisMapper1());
	}

	/*** Subject-Wise-Marks-Ranges ***/
	public int getexamstrengthformarksrangerepo(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMSTRENGTHFORMARKSRANGEREPO_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getexammarksrangegreaterthanfiftyrepo(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGEGREATERTHANFIFTYREPO_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getexammarksrangegreaterthanfourtyyrepo(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGEGREATERTHANFOURTYYREPO_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getexammarksrangegreaterthanthirtyyrepo(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGEGREATERTHANTHIRTYYREPO_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getexammarksrangegreaterthantwentyyrepo(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGEGREATERTHANTWENTYYREPO_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getexammarksrangelessthantwentyyrepo(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGELESSTHANTWENTYYREPO_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	/*** Subject Wise Highest Marks Report ***/
	public List<SubjectWiseHighestReport> getSubjectWiseHighestCampusName(String examname) {
		String sql = AdminSqlQueries.GETSUBJECTWISEHIGHESTCAMPUSNAME_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new SubjectWiseHighestMapper());
	}

	public int getExamStrength(String examname, String campusid) {
		String sql = AdminSqlQueries.GETEXAMSTRENGTH_QUERY;
		Object[] params = { examname, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public float gettotalscoreforsubjecthighestmarkrepo(String examname, String campusid) {
		String sql = AdminSqlQueries.GETTOTALSCOREFORSUBJECTHIGHESTMARKREPO_QUERY;
		Object[] params = { examname, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Float.class);
	}

	public String getstudentifforhighestmarkreport(String examname, String campusid, float totalscore) {
		String sql = AdminSqlQueries.GETSTUDENTIFFORHIGHESTMARKREPORT_QUERY;
		Object[] params = { examname, campusid, totalscore };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getallindiarankforhighestmarkreport(String examname, String studenid) {
		String sql = AdminSqlQueries.GETALLINDIARANKFORHIGHESTMARKREPORT_QUERY;
		Object[] params = { examname, examname, studenid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getscoremarksforhighestmarkrepo(String examname, String studenid, String subjectid) {
		String sql = AdminSqlQueries.GETSCOREMARKSFORHIGHESTMARKREPO_QUERY;
		Object[] params = { examname, studenid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getscoremarksforhighestreportsubjectwises(String examname, String campusid, String subjectid) {
		String sql = AdminSqlQueries.GETSCOREMARKSFORHIGHESTREPORTSUBJECTWISES_QUERY;
		Object[] params = { examname, campusid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getcampuswiserankforsubjecthighest(String studenid, String examname, String subjectid, String campusid) {
		String sql = AdminSqlQueries.GETCAMPUSWISERANKFORSUBJECTHIGHEST_QUERY;
		Object[] params = { examname, examname, campusid, campusid, studenid, subjectid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getstudentifforhighestmarkreportforsubject(String examname, String campusid,
			String scoredmarkssubjectwise) {
		String sql = AdminSqlQueries.GETSTUDENTIFFORHIGHESTMARKREPORTFORSUBJECT_QUERY;
		Object[] params = { examname, campusid, scoredmarkssubjectwise };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getSubjectRankInCampuswiseSubjectTopper(String examname, String studentidval, String campusid,
			String subjs) {
		String sql = AdminSqlQueries.GETSUBJECTRANKINCAMPUSWISESUBJECTTOPPER_QUERY;
		Object[] params = { examname, examname, campusid, campusid, studentidval, subjs, subjs };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	/*** Above 50% Marks_Subject-wise ***/
	public int getexammarksrangegreaterthanfourtyfourrepo(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGEGREATERTHANFOURTYFOURREPO_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getmaxmarksinsubjectwiserange(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETMAXMARKSINSUBJECTWISERANGE_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public List<Map<String, Object>> getDetailsOfPresentExam(String examname) {
		String sql = AdminSqlQueries.GETDETAILSOFPRESENTEXAM_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public List<Map<String, Object>> getpreviousexamnameforreport(String examname, String presstateid,
			String preslocationid, String presbranchid, String presclassid, String pressectionid) {
		String sql = AdminSqlQueries.GETPREVIOUSEXAMNAMEFORREPORT_QUERY;
		Object[] params = { examname, examname, presstateid, preslocationid, presbranchid, presclassid, pressectionid };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getpreviousexamSubjectforreport(String examname) {
		String sql = AdminSqlQueries.GETPREVIOUSEXAMSUBJECTFORREPORT_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new Admingetsubjectidforpresentprevreportmapper());
	}

	public int getAllIndiaReportSubjectRank1(String examname, String studentid, String subjs) {
		String sql = AdminSqlQueries.GETALLINDIAREPORTSUBJECTRANK1_QUERY;
		Object[] params = { examname, examname, studentid, subjs, subjs };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);

	}

	public int getCountofScoredmarksForExam2(String examname1, int campusid, int stateid, String subjectid,
			String studentid, int sectionid) {
		String sql = AdminSqlQueries.GETCOUNTOFSCOREDMARKSFOREXAM2_QUERY;
		Object[] params = { examname1, sectionid, stateid, studentid, campusid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getScoredmarksForExam2(String examname1, int campusid, int stateid, String subjectid,
			String studentid, int sectionid) {
		String sql = AdminSqlQueries.GETSCOREDMARKSFOREXAM2_QUERY;
		Object[] params = { examname1, sectionid, stateid, studentid, campusid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	/*** Below 100 RNK_Subject-wise ***/
	public List<AdminBelow100RanksInSubjectInCampusPojo> getCampusnamesInStudentResults(String examname) {
		String sql = AdminSqlQueries.GETCAMPUSNAMESINSTUDENTRESULTS_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params,
				new AdminGetCampusnamesInBelow100RanksIncampuswiseReportMapper());
	}

	public int getExamstrengthInCampuswiseBelow100Ranks(String examname, int campusid) {
		String sql = AdminSqlQueries.GETEXAMSTRENGTHINCAMPUSWISEBELOW100RANKS_QUERY;
		Object[] params = { examname, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getRankcountInCampuswiseBelow100Ranks(String examname, int campusid, String subjs1) {
		String sql = AdminSqlQueries.GETRANKCOUNTINCAMPUSWISEBELOW100RANKS_QUERY;
		Object[] params = { campusid, campusid, subjs1, subjs1, campusid, subjs1, examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getMaxmarksInCampuswiseBelow100Ranks(String examname, int campusid, String subjs1) {
		String sql = AdminSqlQueries.GETMAXMARKSINCAMPUSWISEBELOW100RANKS_QUERY;
		Object[] params = { campusid, subjs1, examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	/*** Section wise attendees with averages ***/
	public List<AdminSecwiseAttendeesWithAvgPojo> getCampusSectionfromStudentResults(String examname) {
		String sql = AdminSqlQueries.GETCAMPUSSECTIONFROMSTUDENTRESULTS_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new AdminSecwiseAttendeesWithAvgMapper());
	}

	public int getActualStudentsPresencePerSection(int sectionid, int campusid) {
		String sql = AdminSqlQueries.GETACTUALSTUDENTSPRESENCEPERSECTION_QUERY;
		Object[] params = { sectionid, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getActualStudentsPresencePerSectionInExam(int sectionid, String examname, int campusid) {
		String sql = AdminSqlQueries.GETACTUALSTUDENTSPRESENCEPERSECTIONINEXAM_QUERY;
		Object[] params = { sectionid, examname, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getAvginSubjectsfromCampusSection(int campusid, int sectionid, String subjs1, String examname) {
		String sql = AdminSqlQueries.GETAVGINSUBJECTSFROMCAMPUSSECTION_QUERY;
		Object[] params = { sectionid, campusid, subjs1, examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getAvgInTotalmarksFromCampusSection(int campusid, int sectionid, String examname) {
		String sql = AdminSqlQueries.GETAVGINTOTALMARKSFROMCAMPUSSECTION_QUERY;
		Object[] params = { sectionid, campusid, examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	/*** Order of Attempted Questions ***/
	public List<Map<String, Object>> getStudentidforQuestionanalysis(String examname) {
		String sql = AdminSqlQueries.GETSTUDENTIDFORQUESTIONANALYSIS_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public List<Questionanalysispojo> getAvgtimeBasedonExamname(String examname, String examstatus) {
		String sql = AdminSqlQueries.GETAVGTIMEBASEDONEXAMNAME_QUERY;
		Object[] params = { examname, examstatus };
		return this.getJdbcTemplate().query(sql, params, new getAvgtimeBasedonExamnameMapper());
	}

	public int getQuestionsCountBasedonExamname(String examname) {
		String sql = AdminSqlQueries.GETQUESTIONSCOUNTBASEDONEXAMNAME_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getQuestionWiseCountforAnalalysis(String examname, String studentid) {
		String sql = AdminSqlQueries.GETQUESTIONWISECOUNTFORANALALYSIS_QUERY;
		Object[] params = { examname, studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public List<Questionanalysispojo> getQuestinonWiseTimeDifferencevalues(String examname, String studentid) {
		String sql = AdminSqlQueries.GETQUESTINONWISETIMEDIFFERENCEVALUES_QUERY;
		Object[] params = { examname, studentid };
		return this.getJdbcTemplate().query(sql, params, new QuestionTimeDifferenceMapper());
	}

	public String getActualStartTimeFromTemp(String examname, String studentid) {
		String sql = AdminSqlQueries.GETACTUALSTARTTIMEFROMTEMP_QUERY;
		Object[] params = { studentid, examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getcountNextQuestionTimetakenvalue(String presenttime, String examname, String studentid) {
		String sql = AdminSqlQueries.GETCOUNTNEXTQUESTIONTIMETAKENVALUE_QUERY;
		Object[] params = { examname, studentid, presenttime };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getNextQuestionTimetakenvalue(String presenttime, String examname, String studentid) {
		String sql = AdminSqlQueries.GETNEXTQUESTIONTIMETAKENVALUE_QUERY;
		Object[] params = { examname, studentid, presenttime };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	/*** Progress Report ***/
	public List<AdminCategory> getallStudentsFromAllInputs(String stateid, String locationid, String branchid,
			String classids, String sectionid) {
		String sql = AdminSqlQueries.GETALLSTUDENTSFROMALLINPUTS_QUERY;
		Object[] parms = { stateid, locationid, branchid, classids, sectionid };
		return this.getJdbcTemplate().query(sql, new GetStudentIDsFromEstimateStudentAvgMapper(), parms);
	}

	public String getclassnamefromclassis(String classid) {
		String sql = AdminSqlQueries.GETCLASSNAMEFROMCLASSIS_QUERY;
		Object[] params = { classid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getsectionnamefromsection(String section) {
		String sql = AdminSqlQueries.GETSECTIONNAMEFROMSECTION_QUERY;
		Object[] params = { section };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getbranchnamefrombranch(String branch) {
		String sql = AdminSqlQueries.GETBRANCHNAMEFROMBRANCH_QUERY;
		Object[] params = { branch };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getlocationnamefromlocation(String location) {
		String sql = AdminSqlQueries.GETLOCATIONNAMEFROMLOCATION_QUERY;
		Object[] params = { location };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getstatenamefromstate(String state) {
		String sql = AdminSqlQueries.GETSTATENAMEFROMSTATE_QUERY;
		Object[] params = { state };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public List<AdminCategory> getstudentaveragereportmrksforstudent(String classid, String section, String branch,
			String location, String state) {
		String sql = AdminSqlQueries.GETSTUDENTAVERAGEREPORTMRKSFORSTUDENT_QUERY;
		Object[] params = { classid, section, branch, state, location };
		return this.getJdbcTemplate().query(sql, params, new GetstudentAveragedetailsMapper());
	}

	public List<AdminCategory> getsubjectaveragereportmrksforstudent(String classid, String section, String branch,
			String location, String state) {
		String sql = AdminSqlQueries.GETSUBJECTAVERAGEREPORTMRKSFORSTUDENT_QUERY;
		Object[] params = { classid, section, branch, state, location };
		return this.getJdbcTemplate().query(sql, params, new GetsubjectAveragedetailsMapper());
	}

	public String getUserIDsbasedonstudentid(String studentid) {
		String sql = AdminSqlQueries.GETUSERIDSBASEDONSTUDENTID_QUERY;
		Object[] params = { studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getexamcountforrepo(String studentid) {
		String sql = AdminSqlQueries.GETEXAMCOUNTFORREPO_QUERY;
		Object[] params = { studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getsubjectaveragescorereportmrksforstudent(String classid, String section, String branch,
			String location, String state, String studentid, String subjectid) {
		String sql = AdminSqlQueries.GETSUBJECTAVERAGESCOREREPORTMRKSFORSTUDENT_QUERY;
		Object[] params = { classid, section, branch, state, location, subjectid, studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getrankforaverage(String classid, String section, String branch, String location, String state,
			String studentid, String subjectid) {
		String sql = AdminSqlQueries.GETRANKFORAVERAGE_QUERY;
		Object[] params = { studentid, subjectid, subjectid, classid, classid, section, section, branch, branch, state,
				state, location, location };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public List<Map<String, Object>> getSelectedStudentInformation(String studentidchkname) {
	/*	String sql = AdminSqlQueries.GETSELECTEDSTUDENTINFORMATION_QUERY;
		Object[] params = { studentidchkname };*/
		String sql= "select user_name, concat(ur.first_name, ' ', ur.last_name) as stuname, cl.el_class_name, "
				+ "sc.el_section_name, st.state_type, lc.el_location_name, br.el_branch_name from "
				+ "el_state_type st, el_location lc, el_branch br, users ur, el_class cl, el_section sc "
				+ "where st.state_type_id = lc.state_type_id and lc.el_location_id =br.el_location_id and "
				+ "ur.state_type_id = st.state_type_id and ur.el_location_id = lc.el_location_id and "
				+ "ur.el_branch_id = br.el_branch_id and ur.student_id='"+studentidchkname+"' and "
				+ "ur.el_class_generated_id = cl.el_class_generated_id and ur.el_section_id = sc.el_section_id and "
				+ "cl.el_class_generated_id = sc.el_class_generated_id";
		logger.info("getSelectedStudentInformation: "+sql);
		return this.getJdbcTemplate().queryForList(sql);
	}

	public List<AdminCategory> getSubjectIdsForStudent(String studentidchkname, String examtypeid) {
		String sql = AdminSqlQueries.GETSUBJECTIDSFORSTUDENT_QUERY;
		Object[] params = { studentidchkname, examtypeid };
		return this.getJdbcTemplate().query(sql, params, new GetSubjectIdExamNameInfoMapper());
	}

	public List<AdminCategory> getExamTypeAndExamNameFromElExam(String studentidchkname, String examtypeid) {
		String sql = AdminSqlQueries.GETEXAMTYPEANDEXAMNAMEFROMELEXAM_QUERY;
		Object[] params = { studentidchkname, examtypeid };
		return this.getJdbcTemplate().query(sql, params, new GetExamNameAndExamTypeInfoMapper());
	}

	public List<Map<String, Object>> getStudentMarksperSubject(String studentid, String examname, String subjs1) {
		String sql = AdminSqlQueries.GETSTUDENTMARKSPERSUBJECT_QUERY;
		Object[] params = { studentid, examname, subjs1 };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public List<Map<String, Object>> getExamTotalMarksPerExam(String studentidchkname, String examname) {
		String sql = AdminSqlQueries.GETEXAMTOTALMARKSPEREXAM_QUERY;
		Object[] params = { studentidchkname, examname };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public int getExamRankPerExam(String studentidchkname, String examname) {
		String sql = AdminSqlQueries.GETEXAMRANKPEREXAM_QUERY;
		Object[] params = { examname, examname, studentidchkname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public List<AdminCategory> calculateStudentAverageMarks(String studentidchkname, String examtypeid) {
		String sql = AdminSqlQueries.CALCULATESTUDENTAVERAGEMARKS_QUERY;
		Object[] params = { studentidchkname, examtypeid };
		return this.getJdbcTemplate().query(sql, params, new StudentProfileAverageMarks());
	}

	/*** Upload Student Records ***/
	public List<AdminCategory> viewStateAssociateLcBr() {
		String sql = AdminSqlQueries.VIEWSTATEASSOCIATELCBR_QUERY;
		return this.getJdbcTemplate().query(sql, new AdminStateAssociatedLCAndBRMapper());
	}

	/*** Upload Offline Key ***/
	public int insertOfflineKeyFromExcel(String examname, String examtypeid, String classid, int numberofqns,
			Adminofflinedatapojo keydata) {
		String sql = AdminSqlQueries.INSERTOFFLINEKEYFROMEXCEL_QUERY;
		Object[] parms = { examname, classid, keydata.getSubjectid(), examtypeid, keydata.getQnid(),
				keydata.getSelected_answer(), keydata.getMarksperqn(), keydata.getNegamarksperqn(),
				keydata.getQuestiontypeid(), numberofqns, getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat() };
		return this.getJdbcTemplate().update(sql, parms);
	}

	public int getTotalmarksFromExamOffline(String examname) {
		String sql = AdminSqlQueries.GETTOTALMARKSFROMEXAMOFFLINE_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int updateTotalmarksFrommExamOffline(String examname, int totalmarks) {
		String sql = AdminSqlQueries.UPDATETOTALMARKSFROMMEXAMOFFLINE_QUERY;
		Object[] params = { totalmarks, examname };
		return this.getJdbcTemplate().update(sql, params);
	}

	public List<Adminofflinedatapojo> getSubjectidsFromExamOffline(String examname) {
		String sql = AdminSqlQueries.GETSUBJECTIDSFROMEXAMOFFLINE_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new AdminGetSubjectidsFromOfflineMapper());
	}

	public int getSubjectTotalqusOffline(String examname, String examtypeid, String subjectids) {
		String sql = AdminSqlQueries.GETSUBJECTTOTALQUSOFFLINE_QUERY;
		Object[] params = { examname, subjectids, examtypeid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public List<Adminofflinedatapojo> getQntypeidFromExamOffline(String examname, String subjectids) {
		String sql = AdminSqlQueries.GETQNTYPEIDFROMEXAMOFFLINE_QUERY;
		Object[] params = { examname, subjectids };
		return this.getJdbcTemplate().query(sql, params, new AdminGetQustypeidFromOfflineMapper());
	}

	public int getnumofQusperqunstype(String examname, String examtypeid, String subjectids, String quntypeid) {
		String sql = AdminSqlQueries.GETNUMOFQUSPERQUNSTYPE_QUERY;
		Object[] params = { examname, subjectids, examtypeid, quntypeid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int updateNumofquestionperQustype(String examname, String subjectids, String quntypeid,
			int numofqusperQustype) {
		String sql = AdminSqlQueries.UPDATENUMOFQUESTIONPERQUSTYPE_QUERY;
		Object[] params = { numofqusperQustype, examname, subjectids, quntypeid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int updateQuestypeToatlamarks(String examname, String subjectids, String quntypeid, int qustypetotalmarks) {
		String sql = AdminSqlQueries.UPDATEQUESTYPETOATLAMARKS_QUERY;
		Object[] params = { qustypetotalmarks, examname, subjectids, quntypeid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public List<Map<String, Object>> validateExamnameforofflinekey(String examnamevalue) {
		String sql = AdminSqlQueries.VALIDATEEXAMNAMEFOROFFLINEKEY_QUERY;
		Object[] params = { examnamevalue };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public int deleteOfflineInvalidKeyEntries(String examname) {
		String sql = AdminSqlQueries.DELETEOFFLINEINVALIDKEYENTRIES_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int insertOfflineKey(String examname, String classid, String subjid, String examtypeid, int questionid,
			String keyvalues, String numberofQnsPerSubj, String qntypeid, int qnsPerQntype1, int marksPerQntype1,
			String negPerQntype, int totalmarksperQntype, int totalquestions, int totalmarks) {
		String sql = AdminSqlQueries.INSERTOFFLINEKEY_QUERY;
		Object[] parms = { examname, classid, subjid, examtypeid, questionid, keyvalues, marksPerQntype1, negPerQntype,
				qntypeid, totalquestions, numberofQnsPerSubj, qnsPerQntype1, totalmarks, totalmarksperQntype,
				getDateFromSimpleDateFormat(), getDateFromSimpleDateFormat() };
		return this.getJdbcTemplate().update(sql, parms);
	}

	public int updateSubjectTotalQusfromExamOffline(String examname, String subjectids, int subjtotalques) {
		String sql = AdminSqlQueries.UPDATESUBJECTTOTALQUSFROMEXAMOFFLINE_QUERY;
		Object[] params = { subjtotalques, examname, subjectids };
		return this.getJdbcTemplate().update(sql, params);
	}

	/*** Upload Offline Key ***/
	public List<Map<String, Object>> getExamnameFromKeyTable(String isgenerated) {
		String sql = AdminSqlQueries.GETEXAMNAMEFROMKEYTABLE_QUERY;
		Object[] params = { isgenerated };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	/*** Offline Reports ***/

	/*** All India_Marks_Analysis ***/
	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResultsIncampusOffline(String examname,
			int campusid) {
		String sql = AdminSqlQueries.GETSUBJECTSFROMSTUDENTRESULTSINCAMPUSOFFLINE_QUERIES;
		Object[] paarams = { examname, campusid };
		return this.getJdbcTemplate().query(sql, paarams, new AdminAllIndiaMarksAnalysisMapper1());
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResultsOffline(String examname) {
		String sql = AdminSqlQueries.GETSUBJECTSFROMSTUDENTRESULTSOFFLINE_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new AdminAllIndiaMarksAnalysisMapper1());
	}

	public String getAllIndiaReportSubjectRankOffline(String examname, String studentid, String subjs) {
		String sql = AdminSqlQueries.GETALLINDIAREPORTSUBJECTRANKOFFLINE_QUERY;
		Object[] params = { examname, examname, studentid, subjs, subjs };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getScoredmarksPerSubjectOffline(String examname, String studentid, String subjs1) {
		String sql = AdminSqlQueries.GETSCOREDMARKSPERSUBJECTOFFLINE_QUERY;
		Object[] params = { examname, studentid, subjs1 };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getuserdetailsfromStudentResultsInAnotherSubjOffline(String examname, String subj, int classid,
			int sectionid, int campusid, int stateid, String studentid) {
		String sql = AdminSqlQueries.GETUSERDETAILSFROMSTUDENTRESULTSINANOTHERSUBJOFFLINE_QUERY;
		Object[] params = { examname, subj, campusid, sectionid, stateid, classid, studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getAllIndiaRankBasedOnExamnameOffline(String examname, String studentid) {
		String sql = AdminSqlQueries.GETALLINDIARANKBASEDONEXAMNAMEOFFLINE_QUERY;
		Object[] params = { examname, examname, studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getAllIndiaCampusRankBasedOnExamnameOffline(String examname, String studentid, int campusid) {
		String sql = AdminSqlQueries.GETALLINDIACAMPUSRANKBASEDONEXAMNAMEOFFLINE_QUERY;
		Object[] params = { examname, examname, studentid, campusid, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getAllIndiaStateRankBasedOnExamnameOffline(String examname, String studentid, int stateid) {
		String sql = AdminSqlQueries.GETALLINDIASTATERANKBASEDONEXAMNAMEOFFLINE_QUERY;
		Object[] params = { examname, examname, studentid, stateid, stateid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getAllIndiaSectionRankBasedOnExamnameOffline(String examname, String studentid, int sectionid) {
		String sql = AdminSqlQueries.GETALLINDIASECTIONRANKBASEDONEXAMNAMEOFFLINE_QUERY;
		Object[] params = { examname, examname, studentid, sectionid, sectionid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	/*** Subject-Wise-Marks-Ranges ***/
	public int getexamstrengthformarksrangerepooffline(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMSTRENGTHFORMARKSRANGEREPOOFFLINE_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getexammarksrangegreaterthanfiftyrepooffline(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGEGREATERTHANFIFTYREPOOFFLINE_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getexammarksrangegreaterthanfourtyyrepooffline(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGEGREATERTHANFOURTYYREPOOFFLINE_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getexammarksrangegreaterthanthirtyyrepooffline(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGEGREATERTHANTHIRTYYREPOOFFLINE_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getexammarksrangegreaterthantwentyyrepooffline(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGEGREATERTHANTWENTYYREPOOFFLINE_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getexammarksrangelessthantwentyyrepooffline(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGELESSTHANTWENTYYREPOOFFLINE_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public List<Adminstudentwisequestionerror> admingetQuestionIdsforQerror1Offline(String examname) {
		String sql = AdminSqlQueries.GETQUESTIONIDFROMWISEQERROROFFLINE_QUERY;
		Object[] params = new Object[] { examname };
		return this.getJdbcTemplate().query(sql, params, new AdminOfflineQuestionidforqerrormapper());
	}

	public List<Adminstudentwisequestionerror> admingetQuestionIdsforQerrorOffline(String examname, String campusid) {
		String sql = AdminSqlQueries.ADMINGETQUESTIONIDSFORQERROROFFLINE_QUERY;
		Object[] params = new Object[] { examname };
		return this.getJdbcTemplate().query(sql, params, new AdminOfflineQuestionidforqerrormapper());
	}

	public List<Adminstudentwisequestionerror> getrightvalueforerrorreportOffline(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		String sql = AdminSqlQueries.GETRIGHTVALUEFORERRORREPORTOFFLINE_QUERY;
		Object[] params = new Object[] { questionid, examname, studentid, campus, section, questionrowid };
		return this.getJdbcTemplate().query(sql, params, new AdminRightAnswerforReportMapper());
	}

	public List<Adminstudentwisequestionerror> getwrongvalueforerrorreportOffline(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		String sql = AdminSqlQueries.GETWRONGVALUEFORERRORREPORTOFFLINE_QUERY;
		Object[] params = { questionid, examname, studentid, campus, section, questionrowid };
		return this.getJdbcTemplate().query(sql, params, new AdminWrongAnsweredforrepomapper());
	}

	public List<Adminstudentwisequestionerror> getnotansweredvalueforerrorreportOffline(int questionid, String examname,
			String studentid, String section, String campus, int questionrowid) {
		String sql = AdminSqlQueries.GETNOTANSWEREDVALUEFORERRORREPORTOFFLINE_QUERY;
		Object[] params = { questionid, examname, studentid, campus, section, questionrowid };
		return this.getJdbcTemplate().query(sql, params, new AdminUnattemptanswersforreportMapper());
	}

	/*** Subject-wise_Wrong, Right & Un-attempted Counts ***/
	public int getsubjectwisewrongcountOffline(String studid, String section, String campus, String examname,
			String subjectid) {
		String sql = AdminSqlQueries.GETSUBJECTWISEWRONGCOUNTOFFLINE_QUERY;
		Object[] params = { studid, section, campus, examname, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getsubjectwisecorrectcountOffline(String studid, String section, String campus, String examname,
			String subjectid) {
		String sql = AdminSqlQueries.GETSUBJECTWISECORRECTCOUNTOFFLINE_QUERY;
		Object[] params = { studid, section, campus, examname, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getsubjectwiseunattemptcountOffline(String studid, String section, String campus, String examname,
			String subjectid) {
		String sql = AdminSqlQueries.GETSUBJECTWISEUNATTEMPTCOUNTOFFLINE_QUERY;
		Object[] params = { studid, section, campus, examname, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	/*** Campus Wise Error Offline Report ***/
	public List<CampuswiseErrorreportPojo> getAllQidsInCampuswise1Offline(String examname) {
		String sql = AdminSqlQueries.GETALLQIDSINCAMPUSWISE1OFFLINE_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new OfflineQiestionIdsInCampusWiseErrorReportMapper());
	}

	public int getCampuswiseExamstrengthOffline(String examname, int campusid) {
		String sql = AdminSqlQueries.GETCAMPUSWISEEXAMSTRENGTHOFFLINE_QUERY;
		Object[] params = { examname, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getmaxquestionlengthOffline(String examname, String subjectid) {
		String sql = AdminSqlQueries.GETMAXQUESTIONLENGTHOFFLINE_QUERY;
		Object[] param = { examname, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, param, Integer.class);
	}

	public int getCountOfAllErrorQuestionIdsIncampuswiseOffline(String examname, int campusid, int questionid,
			String subjectid, int questionrowid) {
		String sql = AdminSqlQueries.GETCOUNTOFALLERRORQUESTIONIDSINCAMPUSWISEOFFLINE_QUERY;
		Object[] params = { examname, campusid, questionid, subjectid, questionrowid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	/*** State Wise Error Offline Report ***/
	public int getStatewiseExamstrengthOffline(String examname, int stateid) {
		String sql = AdminSqlQueries.GETSTATEWISEEXAMSTRENGTHOFFLINE_QUERY;
		Object[] params = { examname, stateid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResultsforstateOffline(String examname,
			int stateid) {
		String sql = AdminSqlQueries.GETSUBJECTSFROMSTUDENTRESULTSFORSTATEOFFLINE_QUERY;
		Object[] params = { examname, stateid };
		return this.getJdbcTemplate().query(sql, params, new AdminAllIndiaMarksAnalysisMapper1());
	}

	public List<CampuswiseErrorreportPojo> getuserdetailsfromStudentResultsHistoryforStateOffline(String examname) {
		String sql = AdminSqlQueries.GETUSERDETAILSFROMSTUDENTRESULTSHISTORYFORSTATEOFFLINE_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new StateNamesInCampuswiseErrorReportMapper());
	}

	/*** Subject Wise Highest Marks Report ***/
	public List<SubjectWiseHighestReport> getSubjectWiseHighestCampusNameoffline(String examname) {
		String sql = AdminSqlQueries.GETSUBJECTWISEHIGHESTCAMPUSNAMEOFFLINE_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new SubjectWiseHighestMapper());
	}

	public int gettotalscoreforsubjecthighestmarkrepooffline(String examname, String campusid) {
		String sql = AdminSqlQueries.GETTOTALSCOREFORSUBJECTHIGHESTMARKREPOOFFLINE_QUERY;
		Object[] params = { examname, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getstudentifforhighestmarkreportoffline(String examname, String campusid, int totalscore) {
		String sql = AdminSqlQueries.GETSTUDENTIFFORHIGHESTMARKREPORTOFFLINE_QUERY;
		Object[] params = { examname, campusid, totalscore };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getallindiarankforhighestmarkreportoffline(String examname, String studenid) {
		String sql = AdminSqlQueries.GETALLINDIARANKFORHIGHESTMARKREPORTOFFLINE_QUERY;
		Object[] params = { examname, examname, studenid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getscoremarksforhighestmarkrepooffline(String examname, String studenid, String subjectid) {
		String sql = AdminSqlQueries.GETSCOREMARKSFORHIGHESTMARKREPOOFFLINE_QUERY;
		Object[] params = { examname, studenid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getcampuswiserankforsubjecthighestoffline(String studenid, String examname, String subjectid,
			String campusid) {
		String sql = AdminSqlQueries.GETCAMPUSWISERANKFORSUBJECTHIGHESTOFFLINE_QUERY;
		Object[] params = { examname, examname, campusid, campusid, studenid, subjectid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getscoremarksforhighestreportsubjectwisesoffline(String examname, String campusid, String subjectid) {
		String sql = AdminSqlQueries.GETSCOREMARKSFORHIGHESTREPORTSUBJECTWISESOFFLINE_QUERY;
		Object[] params = { examname, campusid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getstudentifforhighestmarkreportforsubjectoffline(String examname, String campusid,
			String scoredmarkssubjectwise) {
		String sql = AdminSqlQueries.GETSTUDENTIFFORHIGHESTMARKREPORTFORSUBJECTOFFLINE_QUERY;
		Object[] params = { examname, campusid, scoredmarkssubjectwise };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getSubjectRankInCampuswiseSubjectTopperoffline(String examname, String studentidval, String campusid,
			String subjs) {
		String sql = AdminSqlQueries.GETSUBJECTRANKINCAMPUSWISESUBJECTTOPPEROFFLINE_QUERY;
		Object[] params = { examname, examname, campusid, campusid, studentidval, subjs, subjs };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	/*** Above 50% Marks_Subject-wise ***/
	public int getExamStrengthoffline(String examname, String campusid) {
		String sql = AdminSqlQueries.GETEXAMSTRENGTHOFFLINE_QUERY;
		Object[] params = { examname, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getmaxmarksinsubjectwiserangeoffline(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETMAXMARKSINSUBJECTWISERANGEOFFLINE_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getexammarksrangegreaterthanfourtyfourrepooffline(String examname, String campus, String subjectid) {
		String sql = AdminSqlQueries.GETEXAMMARKSRANGEGREATERTHANFOURTYFOURREPOOFFLINE_QUERY;
		Object[] params = { examname, campus, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	/*** Present & Previous Test Comparative Report ***/
	public List<Map<String, Object>> getDetailsOfPresentExamoffline(String examname) {
		String sql = AdminSqlQueries.GETDETAILSOFPRESENTEXAMOFFLINE_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public List<Map<String, Object>> getpreviousexamnameforreportoffline(String examname, String presstateid,
			String preslocationid, String presbranchid, String presclassid, String pressectionid) {
		String sql = AdminSqlQueries.GETPREVIOUSEXAMNAMEFORREPORTOFFLINE_QUERY;
		Object[] params = { examname, examname, presstateid, preslocationid, presbranchid, presclassid, pressectionid };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public int getAllIndiaRankBasedOnExamnameoffline(String examname, String studentid) {
		String sql = AdminSqlQueries.GETALLINDIARANKBASEDONEXAMNAMEOFFLINE1_QUERY;
		Object[] params = { examname, examname, studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getAllIndiaReportSubjectRank1offline(String examname, String studentid, String subjs) {
		String sql = AdminSqlQueries.GETALLINDIAREPORTSUBJECTRANK1OFFLINE_QUERY;
		Object[] params = { examname, examname, studentid, subjs, subjs };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getCountofScoredmarksForExam2offline(String examname1, int campusid, int stateid, String subjectid,
			String studentid, int sectionid) {
		String sql = AdminSqlQueries.GETCOUNTOFSCOREDMARKSFOREXAM2OFFLINE_QUERY;
		Object[] params = { examname1, sectionid, stateid, studentid, campusid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getScoredmarksForExam2offline(String examname1, int campusid, int stateid, String subjectid,
			String studentid, int sectionid) {
		String sql = AdminSqlQueries.GETSCOREDMARKSFOREXAM2OFFLINE_QUERY;
		Object[] params = { examname1, sectionid, stateid, studentid, campusid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getpreviousexamSubjectforreportoffline(String examname) {
		String sql = AdminSqlQueries.GETPREVIOUSEXAMSUBJECTFORREPORTOFFLINE_QUERY;
		Object[] parm = { examname };
		logger.info("getpreviousexamSubjectforreport" + sql);
		return this.getJdbcTemplate().query(sql, parm, new Admingetsubjectidforpresentprevreportmapper());
	}

	/*** Below 100 RNK_Subject-wise ***/
	public int getExamstrengthInCampuswiseBelow100Ranksoffline(String examname, int campusid) {
		String sql = AdminSqlQueries.GETEXAMSTRENGTHINCAMPUSWISEBELOW100RANKSOFFLINE_QUERY;
		Object[] params = { examname, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getRankcountInCampuswiseBelow100Ranksoffline(String examname, int campusid, String subjs1) {
		String sql = AdminSqlQueries.GETRANKCOUNTINCAMPUSWISEBELOW100RANKSOFFLINE_QUERY;
		Object[] params = { campusid, campusid, subjs1, subjs1, campusid, subjs1, examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getMaxmarksInCampuswiseBelow100Ranksoffline(String examname, int campusid, String subjs1) {
		String sql = AdminSqlQueries.GETMAXMARKSINCAMPUSWISEBELOW100RANKSOFFLINE_QUERY;
		Object[] params = { campusid, subjs1, examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public List<AdminBelow100RanksInSubjectInCampusPojo> getCampusnamesInStudentResultsoffline(String examname) {
		String sql = AdminSqlQueries.GETCAMPUSNAMESINSTUDENTRESULTSOFFLINE_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params,
				new AdminGetCampusnamesInBelow100RanksIncampuswiseReportMapper());
	}

	/*** Section wise attendees with averages ***/
	public int getActualStudentsPresencePerSectionoffline(int sectionid, int campusid) {
		String sql = AdminSqlQueries.GETACTUALSTUDENTSPRESENCEPERSECTIONOFFLINE_QUERY;
		Object[] params = { sectionid, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getActualStudentsPresencePerSectionInExamoffline(int sectionid, String examname, int campusid) {
		String sql = AdminSqlQueries.GETACTUALSTUDENTSPRESENCEPERSECTIONINEXAMOFFLINE_QUERY;
		Object[] params = { sectionid, examname, campusid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getAvginSubjectsfromCampusSectionoffline(int campusid, int sectionid, String subjs1,
			String examname) {
		String sql = AdminSqlQueries.GETAVGINSUBJECTSFROMCAMPUSSECTIONOFFLINE_QUERY;
		Object[] params = { sectionid, campusid, subjs1, examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getAvgInTotalmarksFromCampusSectionoffline(int campusid, int sectionid, String examname) {
		String sql = AdminSqlQueries.GETAVGINTOTALMARKSFROMCAMPUSSECTIONOFFLINE_QUERY;
		Object[] params = { sectionid, campusid, examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public List<AdminSecwiseAttendeesWithAvgPojo> getCampusSectionfromStudentResultsoffline(String examname) {
		String sql = AdminSqlQueries.GETCAMPUSSECTIONFROMSTUDENTRESULTSOFFLINE_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new AdminSecwiseAttendeesWithAvgMapper());
	}

	/*** Slot based copy previous created exam pattern ***/
	public List<AdminCategory> getExamNameForCopySlotExam(String isslotYes) {
		String sql = AdminSqlQueries.GETEXAMNAMEFORCOPYSLOTEXAM_QUERY;
		Object[] params = new Object[] { isslotYes };
		return this.getJdbcTemplate().query(sql, params, new GetExamNameForCopyExamMapper());
	}

	public List<AdminCategory> getExamnameAndExamTypeForCopyExam(String selectedExam) {
		String sql = AdminSqlQueries.GETEXAMNAMEANDEXAMTYPEFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().query(sql, params, new AdminGetExamNameTypeForCopyExamMapper());
	}

	public List<AdminCategory> getPreviousStatesForCopyExam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSSTATESFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().query(sql, params, new GetPreviousStatesForCopyExamMapper());
	}

	public List<AdminCategory> getPreviousLocationsForCopyExam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSLOCATIONSFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().query(sql, params, new GetPreviousLocationForCopyExamMapper());
	}

	public List<AdminCategory> getPreviousBranchesForCopyExam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSBRANCHESFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().query(sql, params, new GetPreviousBranchesForCopyExamMapper());
	}

	public List<AdminCategory> getPreviousQuelevelidsForCopyExam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSQUELEVELIDSFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().query(sql, params, new GetPreviousQusLevelsForCopyExamMapper());
	}

	public List<AdminCategory> getPreviousClassidsForCopyExam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSCLASSIDSFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().query(sql, params, new GetPreviousClassForCopyExamMapper());
	}

	private String sectionIds(String selectedExam) {
		String sql = AdminSqlQueries.SECTIONIDS_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public List<AdminCategory> getPreviousSubjectsForCopyExam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSSUBJECTSFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().query(sql, params, new GetPreviousSubjectsForCopyExamMapper());
	}

	public List<AdminCategory> getSelectedClassSubjectsForCopyExam(String selectedExam) {
		String sql = AdminSqlQueries.GETSELECTEDCLASSSUBJECTSFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam, selectedExam };
		return this.getJdbcTemplate().query(sql, params, new GetSelectedClassSubjectsForCopyExamMapper());
	}

	public List<AdminCategory> getSelectedSubjectQnsForCopyExam(String selectedExam) {
		String sql = AdminSqlQueries.GETSELECTEDSUBJECTQNSFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().query(sql, params, new GetSelectedSubjectQnsForCopyExamMapper());
	}

	/*** Get subject name based on subjid ***/
	public String getSubjectNameBasedonSubjid(String subid) {
		String sql = AdminSqlQueries.GETSUBJECTNAMEBASEDONSUBJID_QUERY;
		Object[] params = { subid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getSelectedTopicIdsForCopyExamPerSubj(String selectedExam, String subjectid) {
		String sql = AdminSqlQueries.GETSELECTEDTOPICIDSFORCOPYEXAMPERSUBJ_QUERY;
		Object[] params = { selectedExam, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getSelectedSubTopicIdsForCopyExamPerSubj(String selectedExam, String subjid) {
		String sql = AdminSqlQueries.GETSELECTEDSUBTOPICIDSFORCOPYEXAMPERSUBJ_QUERY;
		Object[] params = { selectedExam, subjid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	/**
	 * Get SubTopic Name From Sub Topic Table based on Sub Topic# and Subject#
	 * and Examtype#
	 **/
	public String getPreviousIsmarksForCopyExam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSISMARKSFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public List<AdminCategory> getPreviousQuestionstypeDataForCopyExam(String selectedExam, String qustype) {
		String sql = AdminSqlQueries.GETPREVIOUSQUESTIONSTYPEDATAFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam, qustype };
		return this.getJdbcTemplate().query(sql, params, new GetPreviousQuestiontypeDataForCopyExamMapper());
	}

	public List<AdminCategory> getPreviousQtypeMarksDataForCopyExam(String selectedExam, String qustypeid,
			String subjectids) {
		String sql = AdminSqlQueries.GETPREVIOUSQTYPEMARKSDATAFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam, qustypeid, subjectids };
		return this.getJdbcTemplate().query(sql, params, new GetPreviousQuestiontypeDataForCopyExamMapper());
	}

	public List<AdminCategory> getPreviousQuestiontypeForCopyExam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSQUESTIONTYPEFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		logger.info("getPreviousQuestiontypeForCopyExam: " + sql);
		return this.getJdbcTemplate().query(sql, params, new GetPreviousQuestiontypeForCopyExamMapper());
	}

	public int getPreviousMarksperQustypeForCopyexam(String selectedExam, String ismarks) {
		String sql = AdminSqlQueries.GETPREVIOUSMARKSPERQUSTYPEFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam, ismarks };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getPreviousNegativemarksForCopyexam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSNEGATIVEMARKSFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getPreviousStarttimeForCopyexam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSSTARTTIMEFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getPreviousEndtimeForCopyexam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSENDTIMEFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getPreviousTestdurationForCopyexam(String selectedExam) {
		String sql = AdminSqlQueries.GETPREVIOUSTESTDURATIONFORCOPYEXAM_QUERY;
		Object[] params = { selectedExam };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getAllTopicIds(String subjid, int examtypeid) {
		String sql = AdminSqlQueries.GETALLTOPICIDS_QUERY;
		Object[] params = { subjid, examtypeid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getAllSubTopicIds(String subjid, int examtypeid) {
		String sql = AdminSqlQueries.GETALLSUBTOPICIDS_QUERY;
		Object[] params = { subjid, examtypeid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	/*** Student exam assign ***/
	public List<StudentExamAssignModel> getExamnamesBaseOnDate() {
		String sql = AdminSqlQueries.GETEXAMNAMESBASEONDATE_QUERY;
		return this.getJdbcTemplate().query(sql, new AdmingetExamNameMapper());
	}

	public List<StudentExamAssignModel> getClassBaseOnExamName(String examname, String ex) {
		String sql = AdminSqlQueries.GETCLASSBASEONEXAMNAME_QUERY;
		Object[] param = { examname, ex };
		return this.getJdbcTemplate().query(sql, new GetClassSectionBaseOnExamMapper(), param);
	}

	public List<StudentExamAssignModel> getExamPaperDetBaseOnExmName(String exname) {
		String sql = AdminSqlQueries.GETEXAMPAPERDETBASEONEXMNAME_QUERY;
		Object[] param = { exname };
		return this.getJdbcTemplate().query(sql, param, new GetAllExamPaperDetMApper());
	}

	public int insertIntoTempHistory(StudentExamAssignModel pap, String stuid, String exname) {
		String sql = AdminSqlQueries.INSERTINTOTEMPHISTORY_QUERY;
		Object[] param = { stuid, exname, pap.getSubjectid(), pap.getQuestionid(), examstatus, pap.getLocationid(),
				pap.getBranchid(), pap.getClassid(), pap.getSectionid(), pap.getExampaperid(), pap.getMarksperques(),
				pap.getNegmarks(), pap.getFilename(), pap.getQuestypeid(), pap.getIsjumbling() };
		return this.getJdbcTemplate().update(sql, param);
	}

	public int getAlredyStudentCount(String stuid, String exname) {
		String sql = AdminSqlQueries.GETALREDYSTUDENTCOUNT_QUERY;
		Object[] param = { stuid, exname };
		return this.getJdbcTemplate().queryForObject(sql, param, Integer.class);
	}

	public List<AdminAddCompQuesInExamModel> getExamdataBasedonExamname(String examname) {
		String sql = AdminSqlQueries.GETEXAMDATABASEDONEXAMNAME_QUERY;
		Object[] parms = { examname };
		return this.getJdbcTemplate().query(sql, parms, new AdmingetExamdataBasedonexamnamemapper());
	}

	public int getCountInTempHistrory(StudentExamAssignModel sem) {
		String sql = AdminSqlQueries.GETCOUNTINTEMPHISTRORY_QUERY;
		Object[] param = { sem.getClassid(), sem.getSection(), sem.getStatidval(), sem.getLocationidval(),
				sem.getBrachidval(), sem.getExamname() };
		return this.getJdbcTemplate().queryForObject(sql, param, Integer.class);
	}

	/**** Upload Dat file ***/
	public int getcountforOfflinekeys(String examname) {
		String sql = AdminSqlQueries.GETCOUNTFOROFFLINEKEYS_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public List<Map<String, Object>> getActualOfflineKey(String examname, int j) {
		String sql = AdminSqlQueries.GETACTUALOFFLINEKEY_QUERY;
		Object[] params = { j, examname };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public int updateKeyStatus(String examname, String isdatfilegenerated) {
		String sql = AdminSqlQueries.UPDATEKEYSTATUS_QUERY;
		Object[] params = { isdatfilegenerated, examname };
		return this.getJdbcTemplate().update(sql, params);
	}

	/*** Offline Result calculation ***/
	public List<Adminofflinedatapojo> getExamNameforoffline(String isresult) {
		String sql = AdminSqlQueries.GETEXAMNAMEFOROFFLINEOFFLINE_QUERY;
		Object[] params = { isresult };
		return this.getJdbcTemplate().query(sql, params, new OfflineExamNamesMapper());
	}

	public List<Adminofflinedatapojo> getStudentidsBasedonExamname(String examname) {
		String sql = AdminSqlQueries.GETSTUDENTIDSBASEDONEXAMNAME_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new StudentidsFromOfflineExamMapper());
	}

	public List<Adminofflinedatapojo> getSubjectnamesInOfflineExam(String examname) {
		String sql = AdminSqlQueries.GETSUBJECTNAMESINOFFLINEEXAM_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new OfflineExamSubjectsMapper());
	}

	public int getCountOfSubjectnamesInOfflineExam(String examname) {
		String sql = AdminSqlQueries.GETCOUNTOFSUBJECTNAMESINOFFLINEEXAM_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getTotalmarksForOfflineexam(String examname) {
		String sql = AdminSqlQueries.GETTOTALMARKSFOROFFLINEEXAM_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getTotalQuestionsInOfflineExam(String examname) {
		String sql = AdminSqlQueries.GETTOTALQUESTIONSINOFFLINEEXAM_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);

	}

	public List<Adminofflinedatapojo> getOfflineExamdataInHistory(String examname, String studentid, String subid) {
		String sql = AdminSqlQueries.GETOFFLINEEXAMDATAINHISTORY_QUERY;
		Object[] params = { examname, studentid, subid };
		return this.getJdbcTemplate().query(sql, params, new OfflineQuestiondataMapper());
	}

	public int getQustypeBasedonQidInofflineexam(int qid, String examname) {
		String sql = AdminSqlQueries.GETQUSTYPEBASEDONQIDINOFFLINEEXAM_QUERY;
		Object[] params = { examname, qid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getCorrectKeyInKeySheet(int qid, String examname) {
		String sql = AdminSqlQueries.GETCORRECTKEYINKEYSHEET_QUERY;
		Object[] params = { examname, qid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int insertStudentResultsForOfflineexam(String studentid, String examname, String subid, int yourMarks1,
			int totalquestions, int totalAnswered, String firstname, int stateid, int locationid, int branchid,
			int classid, int sectionid, int totalmarks, int nmarks, int totalWrongAnswered, int totalnotAnswered,
			int subjecttotalmarks) {
		String sql = AdminSqlQueries.INSERTSTUDENTRESULTSFOROFFLINEEXAM_QUERY;
		Object[] params = { studentid, examname, subid, totalmarks, totalquestions, totalAnswered, totalWrongAnswered,
				totalnotAnswered, subjecttotalmarks, yourMarks1, nmarks, firstname, classid, sectionid, branchid,
				stateid, locationid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int updateExamscoredMarksOfflinexam(String studentid, String examname, int examScoredMarks) {
		String sql = AdminSqlQueries.UPDATEEXAMSCOREDMARKSOFFLINEXAM_QUERY;
		Object[] params = { examScoredMarks, examname, studentid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int updateIsresultscalculationsStatus(String studentid, String examname, String isResultscal) {
		String sql = AdminSqlQueries.UPDATEISRESULTSCALCULATIONSSTATUS_QUERY;
		Object[] params = { isResultscal, studentid, examname };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int getScoredmarksInOfflineExam(int qustype, String examname, String subid) {
		String sql = AdminSqlQueries.GETSCOREDMARKSINOFFLINEEXAM_QUERY;
		Object[] params = { examname, qustype, subid, };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getNegativeMarksInOfflineExam(int qustype, String examname, String subid) {
		String sql = AdminSqlQueries.GETNEGATIVEMARKSINOFFLINEEXAM_QUERY;
		Object[] params = { examname, qustype, subid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	/*** Upload Offline Key ***/
	public List<Adminofflinedatapojo> getofflineUserDataBasedonstudentid(String studentid) {
		String sql = AdminSqlQueries.GETOFFLINEUSERDATABASEDONSTUDENTID_QUERY;
		Object[] params = { studentid };
		return this.getJdbcTemplate().query(sql, params, new OfflineUserDataMapper());
	}

	public List<Adminofflinedatapojo> getofflineUserDataBasedonUserName(String studentid) {
		String sql = AdminSqlQueries.GETOFFLINEUSERDATABASEDONUSERNAME_QUERY;
		Object[] params = { studentid };
		return this.getJdbcTemplate().query(sql, params, new OfflineUserDataMapper());
	}

	/*** Offline AllIndiaRank Analysis ***/
	public List<AdminAllIndiaMarksAnalysisPojo> getuserdetailsfromStudentResultsOffline(String examname, String subjs) {
		String sql = AdminSqlQueries.GETUSERDETAILSFROMSTUDENTRESULTSOFFLINE_QUERY;
		Object[] params = { examname, subjs };
		return this.getJdbcTemplate().query(sql, params, new AdminAllIndiaMarksAnalysisMapper());
	}

	/*** CampusWiseErrorReport ***/
	public List<CampuswiseErrorreportPojo> getuserdetailsfromStudentResultsHistory(String examname) {
		String sql = AdminSqlQueries.GETUSERDETAILSFROMSTUDENTRESULTSHISTORY_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new CampusNamesInCampuswiseErrorReportMapper());
	}

	/*** Offline CampusWiseErrorReport ***/
	public List<CampuswiseErrorreportPojo> getuserdetailsfromStudentResultsHistoryOffline(String examname) {
		String sql = AdminSqlQueries.GETUSERDETAILSFROMSTUDENTRESULTSHISTORYOFFLINE_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new CampusNamesInCampuswiseErrorReportMapper());
	}

	/*** Add Subject sub topic ***/
	public List<AdminCategory> getSubtopicsFromAdmin(int classid, int subjectid, int topicid) {
		String sql = AdminSqlQueries.GETSUBTOPICSFROMADMIN_QUERY;
		Object[] params = { subjectid, topicid };
		return this.getJdbcTemplate().query(sql, params, new AdminGetSubtopicIdsMapper());
	}

	public List<AdminCategory> searchSubjectforClassFromAdmin(int classid) {
		String sql = AdminSqlQueries.SEARCHSUBJECTFORCLASSFROMADMIN_QUERY;
		return this.getJdbcTemplate().query(sql, new Object[] { classid }, new AdminAddSubjectTopicMapper());
	}

	public List<AdminCategory> getTopicsFromAdmin(int classid, int subjectid) {
		String sql = AdminSqlQueries.GETTOPICSFROMADMIN_QUERY;
		Object[] params = { classid, subjectid };
		return this.getJdbcTemplate().query(sql, params, new AdminGetTopicIdsMapper());
	}

	public List<AdminCategory> searchTopicsforSubjectsFromAdmin(int classid, int subjectid) {
		String sql = AdminSqlQueries.SEARCHTOPICSFORSUBJECTSFROMADMIN_QUERY;
		Object[] params = { subjectid };
		return this.getJdbcTemplate().query(sql, params, new AdminAddSubjectTopicMapper1());
	}

	public List<Map<String, Object>> getTopicNameFromTopicTable(int classid, int subjectid, int topicid) {
		String sql = AdminSqlQueries.GETTOPICNAMEFROMTOPICTABLE_QUERY;
		Object[] params = { classid, subjectid, topicid };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public int deleteDataintosubjecttopictypeTable(int classid, int subjectid, int topicid, String topictext) {
		deleteALLDataintosubjectsubtopictypeTable(topicid);
		String sql = AdminSqlQueries.DELETEDATAINTOSUBJECTTOPICTYPETABLE_QUERY;
		Object[] params = new Object[] { topictext, classid, subjectid, topicid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int deleteALLDataintosubjectsubtopictypeTable(int topicid) {
		String sql = AdminSqlQueries.DELETEALLDATAINTOSUBJECTSUBTOPICTYPETABLE_QUERY;
		Object[] params = new Object[] { topicid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int deleteDataintosubjectsubtopictypeTable(int topicid, int subtopicid, String subtopictext) {
		String sql = AdminSqlQueries.DELETEDATAINTOSUBJECTSUBTOPICTYPETABLE_QUERY;
		Object[] params = { subtopictext, topicid, subtopicid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public List<AdminAllIndiaMarksAnalysisPojo> getsubjectsfromStudentResultsIncampus(String examname, int campusid) {
		String sql = AdminSqlQueries.GETSUBJECTSFROMSTUDENTRESULTSINCAMPUS_QUERY;
		Object[] params = { examname, campusid };
		return this.getJdbcTemplate().query(sql, params, new AdminAllIndiaMarksAnalysisMapper1());
	}

	/*** View Offline reports ***/
	public List<Adminofflinedatapojo> getExamNameforofflineReport(String isresult) {
		String sql = AdminSqlQueries.GETEXAMNAMEFOROFFLINEREPORT_QUERIES;
		Object[] params = { isresult };
		return this.getJdbcTemplate().query(sql, params, new AdminOfflineExamNamesReportMapper());
	}

	/*** Offline analysis ***/
	public List<Map<String, Object>> validateExamnameforoffline(String examnamevalue) {
		String sql = AdminSqlQueries.VALIDATEEXAMNAMEFOROFFLINE_QUERY;
		Object[] params = { examnamevalue };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	/*** Delete exam ***/
	public List<AdminCategory> getExamNameForCopyExam() {
		String sql = AdminSqlQueries.GETEXAMNAMEFORCOPYEXAM_QUERY;
		return this.getJdbcTemplate().query(sql, new GetExamNameForCopyExamMapper());
	}

	public int getSelectExamnameInstudentResults(String selExam) {
		String sql = AdminSqlQueries.GETSELECTEXAMNAMEINSTUDENTRESULTS_QUERY;
		Object[] params = { selExam };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getSelectExamnameInstudentResultsHistory(String selexam) {
		String sql = AdminSqlQueries.GETSELECTEXAMNAMEINSTUDENTRESULTSHISTORY_QUERY;
		Object[] parms = { selexam };
		return this.getJdbcTemplate().queryForObject(sql, parms, Integer.class);
	}

	public int getDeleteExamname(String selexam) {
		String sql = AdminSqlQueries.GETDELETEEXAMNAME_QUERY;
		Object[] parms = { selexam };
		return this.getJdbcTemplate().update(sql, parms);
	}

	public int getDeleteExamnameInExampaper(String selexam) {
		String sql = AdminSqlQueries.GETDELETEEXAMNAMEINEXAMPAPER_QUERY;
		Object[] parms = { selexam };
		return this.getJdbcTemplate().update(sql, parms);
	}

	public int getDeleteExamnameInExampaper1(String selexam) {
		String sql = AdminSqlQueries.GETDELETEEXAMNAMEINEXAMPAPER1_QUERY;
		Object[] parms = { selexam };
		return this.getJdbcTemplate().update(sql, parms);
	}

	public int getDeleteExamnameInTempHistrory(String selexam) {
		String sql = AdminSqlQueries.GETDELETEEXAMNAMEINTEMPHISTRORY_QUERY;
		Object[] parms = { selexam };
		return this.getJdbcTemplate().update(sql, parms);
	}

	public List<StudentExamAssignModel> getStudentDetails(String stuid) {
		String sql = AdminSqlQueries.GETSTUDENTDETAILS_QUERY;
		Object[] param = { stuid };
		return this.getJdbcTemplate().query(sql, param, new GetStudentDetMApper());
	}

	/*** Login ***/
	@Override
	public List<AdminAddEditDeleteAccessforRolesPojo> getpermissionsforloggedusers(String studentid) {
		String sql = AdminSqlQueries.GETPERMISSIONSFORLOGGEDUSERS_QUERY;
		Object[] param = { studentid };
		return this.getJdbcTemplate().query(sql, param, new AdminAddEditDeleteAccessforPermissionsMapper());
	}

	/*** Set exam with random questions ***/
	public List<AdminAddCompQuesInExamModel> getExamNameForAddComphQues() {
		String sql = AdminSqlQueries.GETEXAMNAMEFORADDCOMPHQUES_QUERY;
		return this.getJdbcTemplate().query(sql, new GetExamNameForAddComphQusExamMapper());
	}

	public int updateRandomQuestionsInExampaper(String selectedExam, String isJumbling) {
		String sql = AdminSqlQueries.UPDATERANDOMQUESTIONSINEXAMPAPER_QUERY;
		Object[] param = { isJumbling, selectedExam };
		return this.getJdbcTemplate().update(sql, param);
	}

}
