package com.educare.dao;

import java.sql.Time;
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

import com.educare.admin.mapper.AdminCreateExamMapper;
import com.educare.admin.mapper.AdminSubmitExamMapper;
import com.educare.admin.sqlStatements.UserSqlQueries;
import com.educare.mapper.BookmarkAnalysisMapper;
import com.educare.mapper.DisplayQuestionsMapper;
import com.educare.mapper.ErrorAnalysisMapper;
import com.educare.mapper.ExamStateMapper;
import com.educare.mapper.ExamSubjectsMapper;
import com.educare.mapper.ExamTotalMarks_and_TotalAvailablestudents;
import com.educare.mapper.FilterResultMapper;
import com.educare.mapper.FilterResultMapper1;
import com.educare.mapper.GetAllStudenyDetaislMapper;
import com.educare.mapper.InstructionDetailsMapper;
import com.educare.mapper.LoginMapper;
import com.educare.mapper.QuestionIdsInTempHistory;
import com.educare.mapper.RegisterMapper;
import com.educare.mapper.RegisterMapper1;
import com.educare.mapper.SelfPerformanceAnalysisDetailsMapper;
import com.educare.mapper.SelfPerformanceAnalysisMapper;
import com.educare.mapper.SubjectTableMapper;
import com.educare.mapper.TempHistoryExamMapper;
import com.educare.mapper.TemphistoryPackageMapper;
import com.educare.mapper.ToppersListBasedonExamanmeMapper;
import com.educare.mapper.UserDashboardViewResultsMapper;
import com.educare.mapper.UserDataMapper;
import com.educare.mapper.UserExamDetilsMapper;
import com.educare.mapper.UserGetExamnamesForTopRanksMapper;
import com.educare.mapper.UserResultsMapper;
import com.educare.model.BookmarkPojo;
import com.educare.model.ErrorAnalysisPojo;
import com.educare.model.ExamCompletionState;
import com.educare.model.FilterResultPojo;
import com.educare.model.Instructionspojo;
import com.educare.model.LoginPojo;
import com.educare.model.QuestionPojo;
import com.educare.model.Register;
import com.educare.model.SelfassessmentModel;
import com.educare.model.TempHistoryPackage;
import com.educare.model.UserResultsPojo;
import com.educare.model.UserTopRankersModel;
import com.educare.model.WelcomeUserPojo;

@Repository("RegisterDao")
public class RegisterDaoImpl extends JdbcDaoSupport implements RegisterDao {

	@Value("${exam.withoutslot}")
	String isslotNo;
	@Value("${exam.withslot}")
	String isslotyes;

	@Autowired
	public RegisterDaoImpl(DataSource dataSource) {
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

	
	@Override
	public List<QuestionPojo> getExams(String stateid, String locationid, String branchid, String classid,
			String sectionid) {
		/*** Don't change SQL query ***/
		String sql = "SELECT *,(select ifnull((select ifnull(ept.pattern_type_id,1) from el_exam_pattern ept where ept.Exam_Type_Id=et.Exam_Type_Id),2) as t) as pattern_type_id FROM el_exam_paper ep, el_subject sb,el_exam_type et "
				+ "where ep.state_type_id LIKE '%" + stateid + "%' and ep.location_id LIKE '%" + locationid + "%' "
				+ "and ep.branch_id LIKE '%" + branchid + "%' and ep.class_id LIKE '%" + classid + "%' and "
				+ "ep.section_id LIKE '%" + sectionid + "%' and ep.is_slot='" + isslotyes + "' "
				+ "and ep.subject_id = sb.el_subject_id and et.Exam_Type_Id=ep.exam_type_id "
				+ "and ep.enddate>=curdate() group by ep.exam_name order by ep.createddate desc";
		logger.info("getExams: " + sql);
		return this.getJdbcTemplate().query(sql, new UserExamDetilsMapper());
	}

	public int updateIntoTempHistoryWithSlot(String examstatus, String endtime, String currenttime,
			String examstartdate, String examstartime, String examendtime, String examenddate, String sid,
			String examname) {
		/*** Don't change SQL query ***/
		String sql = "update temp_exam_history set Exam_Completion_Status='" + examstatus + "',endtime='" + endtime
				+ "',actual_exam_start_time='" + currenttime + "',exam_start_date='" + examstartdate
				+ "',exam_end_date='" + examenddate + "',exam_start_time='" + examstartime + "',exam_end_time='"
				+ examendtime + "' where Student_Id='" + sid + "' and examname='" + examname + "'";
		return this.getJdbcTemplate().update(sql);
	}

	public List<QuestionPojo> getAllQuestionsfromtable(int examtypeid, int spltsubjecttypeid, String questionlevelid,
			int questiontypeidvalue, String topic, String subtopic, int spltqnsfromquestiontype) {
		/*** Don't change SQL query ***/
		String sql = "select * from el_questions ql where exam_type= (select exam_type from el_exam_type where Exam_Type_Id="
				+ examtypeid + ") and subject_type=" + spltsubjecttypeid + " and question_level_type_id in("
				+ questionlevelid
				+ ") and Question_Type = (select Question_Type from el_question_type where question_type_id="
				+ questiontypeidvalue + ") and topic in(" + topic + ") and subtopic in(" + subtopic
				+ ") order by rand() limit " + spltqnsfromquestiontype + "";
		logger.info("getAllQuestionsfromtable: " + sql);
		return this.getJdbcTemplate().query(sql, new AdminCreateExamMapper());
	}

	public int getCompareQuestionsCount(String subid, String questiontypeids, String subtopicids, String topicids,
			String qlevelids, String etid, String subjectquestions) {
		/*** Don't change SQL query ***/
		String sql = "select count(*) as quscount from ( select * from el_questions ql where exam_type= (select exam_type from el_exam_type where Exam_Type_Id="
				+ etid + ") and subject_type=" + subid + " " + "and question_level_type_id in(" + qlevelids
				+ ") and Question_Type = (select Question_Type from el_question_type " + "where question_type_id="
				+ questiontypeids + ") and topic in(" + topicids + ") and subtopic in(" + subtopicids
				+ ") order by rand() limit " + subjectquestions + ") as tbl ";
		logger.info("getCompareQuestionsCount: "+sql);
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public List<QuestionPojo> getExams1(String stateid, String locationid, String branchid, String classid,
			String sectionid) {
		/*** Don't change SQL query ***/
		String sql = "SELECT *,(select ifnull((select ifnull(ept.pattern_type_id,1) from el_exam_pattern ept where ept.Exam_Type_Id=et.Exam_Type_Id),2) as t) as pattern_type_id FROM el_exam_paper ep, el_subject sb,el_exam_type et "
				+ "where ep.state_type_id LIKE '%" + stateid + "%' and ep.location_id LIKE '%" + locationid + "%' "
				+ "and ep.branch_id LIKE '%" + branchid + "%' and ep.class_id LIKE '%" + classid + "%' and "
				+ "ep.section_id LIKE '%" + sectionid + "%' and ep.is_slot='" + isslotNo + "' "
				+ "and ep.subject_id = sb.el_subject_id and et.Exam_Type_Id=ep.exam_type_id "
				+ "and ep.enddate>=curdate() group by ep.exam_name order by ep.createddate desc";
		logger.info("getExams1: "+sql);
		return this.getJdbcTemplate().query(sql, new UserExamDetilsMapper());
	}

	public List<QuestionPojo> getsubjectnamefromsubjectid(String subjectids) {
		/*** Don't change SQL query ***/
		String sql = "select * from el_subject where el_subject_id in (" + subjectids + ") order by el_subject_id";
		return this.getJdbcTemplate().query(sql, new SubjectTableMapper());
	}

	public List<QuestionPojo> getDisplayQuestions(String examname, int subjectid, String random) {
		/*** Don't change SQL query ***/
		String sql = null;
		if (random.equalsIgnoreCase("yes")) {
			sql = "SELECT * FROM el_exam_paper1 ep,el_questions eq where ep.exam_name='" + examname + "' "
					+ "and ep.Question_id=eq.Question_Id " + "and ep.subject_id=eq.subject_type and eq.subject_type="
					+ subjectid + " order by ep.Question_type_id,rand(),eq.import_file_name";
		} else {
			sql = "SELECT * FROM el_exam_paper1 ep,el_questions eq where ep.exam_name='" + examname + "' "
					+ "and ep.Question_id=eq.Question_Id " + "and ep.subject_id=eq.subject_type and eq.subject_type="
					+ subjectid + " order by ep.Question_type_id,eq.import_file_name";
		}
		return this.getJdbcTemplate().query(sql, new DisplayQuestionsMapper());
	}

	public List<QuestionPojo> getQuestyionsFromTempHistoryPackage(String studentid, String examname, int locationid,
			int branchid, int classid, int sectionid, String subjectid, String isjumbling) {
		/*** Don't change SQL query ***/
		String sql = null;
		if (isjumbling.equalsIgnoreCase("yes")) {
			sql = "select * from temp_exam_history elh, el_questions qs where elh.question_Id = qs.Question_Id and elh.Student_Id='"
					+ studentid + "' and elh.examname='" + examname + "' and elh.location_id='" + locationid
					+ "' and elh.branch_id='" + branchid + "' and elh.class_id='" + classid + "' and elh.section_id='"
					+ sectionid + "' and elh.subjectid='" + subjectid
					+ "' order by elh.question_type_id,rand(),elh.filenames";
		} else {
			sql = "select * from temp_exam_history elh, el_questions qs where elh.question_Id = qs.Question_Id and elh.Student_Id='"
					+ studentid + "' and elh.examname='" + examname + "' and elh.location_id='" + locationid
					+ "' and elh.branch_id='" + branchid + "' and elh.class_id='" + classid + "' and elh.section_id='"
					+ sectionid + "' and elh.subjectid='" + subjectid + "' order by elh.question_type_id,elh.filenames";
		}
		logger.info(" Get All Exam questions  from Temp Exam : " + sql);
		return this.getJdbcTemplate().query(sql, new TempHistoryExamMapper());
	}

	@Override
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
		String studentid = educareName + "-" + year + "-" + id;
		logger.info(studentid);
		return studentid;
	}

	@Override
	public String generateAdminID() {
		DateFormat yyFormat = new SimpleDateFormat("yy");
		Date now = new Date();
		String id = "0";
		String year = yyFormat.format(now);
		String educareName = "AD";
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
		String adminid = educareName + "-" + year + "-" + id;

		return adminid;
	}

	@Override
	public String generateLecturerID() {
		DateFormat yyFormat = new SimpleDateFormat("yy");
		Date now = new Date();
		String id = "0";
		String year = yyFormat.format(now);
		String educareName = "LE";
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
		String Lecturerid = educareName + "-" + year + "-" + id;

		return Lecturerid;
	}

	@Override
	public int getMaxUserIDfromUsers() {
		String sql = "select max(user_id) from users";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public String getUserPWD(LoginPojo lp) {
		return lp.getPassword();
	}

	public String getEmaiid(Register register) {
		return register.getEmail_id();
	}

	/*** Error Analysis ***/
	public List<ErrorAnalysisPojo> getAnalysis(String qusid) {
		String sql = UserSqlQueries.GETANALYSIS_QUERY;
		Object[] parm = { qusid };
		return this.getJdbcTemplate().query(sql, parm, new ErrorAnalysisMapper());
	}

	/*** AED Admin / AED Lecturer ***/
	@Override
	public void insertUserRole(int uid, int rid) {
		String query = UserSqlQueries.INSERTUSERROLE_QUERY;
		Object[] parm = { uid, rid };
		this.getJdbcTemplate().update(query, parm);
	}

	@Override
	public int getUserIDfromUsers(String username) {
		String query = UserSqlQueries.GETUSERIDFROMUSERS_QUERY;
		Object[] parm = { username };
		return this.getJdbcTemplate().queryForObject(query, parm, Integer.class);
	}

	/*** Login ***/
	@Override
	public int getRoleIDfromUserRole(String getusernames) {
		String sql = UserSqlQueries.GETROLEIDFROMUSERROLE_QUERY;
		Object[] params = { getusernames };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	@Override
	public List<LoginPojo> loginDetails(LoginPojo lp) {
		String sql = UserSqlQueries.LOGINDETAILS_QUERY;
		Object[] params = { lp.getUsername(), lp.getPassword(), lp.getUserstatus() };
		return this.getJdbcTemplate().query(sql, params, new LoginMapper());
	}

	public int getUserStatus(String studentid) {
		String sql = UserSqlQueries.GETUSERSTATUS_QUERY;
		Object[] params = { studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int insertAuditlogs(String studentid, String username, String logintime) {
		String sql = UserSqlQueries.INSERTAUDITLOGS_QUERY;
		Object[] params = { studentid, username, logintime };
		return this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public List<LoginPojo> getUserdetails(String sid) {
		String sql = UserSqlQueries.GETUSERDETAILS_QUERY;
		Object[] params = new Object[] { sid };
		return this.getJdbcTemplate().query(sql, params, new UserDataMapper());
	}

	/*** Logout ***/
	public int insertUserStatus(String studentid, int userstatus) {
		String sql = UserSqlQueries.INSERTUSERSTATUS_QUERY;
		Object[] params = { userstatus, studentid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int updateLogouttimeInAuditlogs(String studentid, String username, String logintime) {
		String sql = UserSqlQueries.UPDATELOGOUTTIMEINAUDITLOGS_QUERY;
		Object[] params = { getDateFromSimpleDateFormat(), studentid, username, logintime };
		return this.getJdbcTemplate().update(sql, params);
	}

	/*** Student profile ***/
	public List<Register> getUserProfile1(String username) {
		String sql = UserSqlQueries.GETUSERPROFILE1_QUERY;
		Object[] params = { username };
		return this.getJdbcTemplate().query(sql, params, new RegisterMapper1());
	}

	public List<Register> getUserProfile(String username) {
		String sql = UserSqlQueries.GETUSERPROFILE_QUERY;
		Object[] params = { username };
		return this.getJdbcTemplate().query(sql, params, new RegisterMapper());
	}

	public String getuserExistingPassword(String studentid) {
		String sql = UserSqlQueries.GETUSEREXISTINGPASSWORD_QUERY;
		Object[] parm = { studentid };
		return this.getJdbcTemplate().queryForObject(sql, parm, String.class);
	}

	public List<Register> getStudentDetBaseOnId(String studentid) {
		String sql = UserSqlQueries.GETSTUDENTDETBASEONID_QUERY;
		Object[] param = { studentid };
		return this.getJdbcTemplate().query(sql, new GetAllStudenyDetaislMapper(), param);
	}

	public void changeUserPassword(String studentid, String newpwd) {
		String sql = UserSqlQueries.CHANGEUSERPASSWORD_QUERY;
		Object[] parm = { newpwd, studentid };
		this.getJdbcTemplate().update(sql, parm);
	}

	public int updateUserProfile(String firstname, String lastname, String email, String phone, String studentid,
			String collegename) {
		String sql = UserSqlQueries.UPDATEUSERPROFILE_QUERY;
		Object[] parm = { firstname, lastname, email, phone, collegename, studentid };
		return this.getJdbcTemplate().update(sql, parm);
	}

	/*** Welcome User ***/
	public List<QuestionPojo> getSubjectnamesInSubjectTable(String examname) {
		String sql = UserSqlQueries.GETSUBJECTNAMESINSUBJECTTABLE_QUERY;
		Object[] parms = { examname };
		return this.getJdbcTemplate().query(sql, parms, new SubjectTableMapper());
	}

	public List<ExamCompletionState> getExamCompletionStatusQuery(String studentid, String stateid, String locationid,
			String branchid, String classid, String sectionid, String examname) {
		String sql = UserSqlQueries.GETEXAMCOMPLETIONSTATUS_QUERY;
		Object[] params = { studentid, locationid, branchid, classid, sectionid, examname };
		return this.getJdbcTemplate().query(sql, params, new ExamStateMapper());
	}

	public List<Instructionspojo> getAllInstructionDetails(String examname) {
		String sql = UserSqlQueries.GETALLINSTRUCTIONDETAILS_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new InstructionDetailsMapper());
	}

	/*** View Result ***/
	public List<WelcomeUserPojo> userResults(String studentid) {
		String sql = UserSqlQueries.USERRESULTS_QUERY;
		Object[] params = { studentid };
		return this.getJdbcTemplate().query(sql, params, new UserDashboardViewResultsMapper());
	}

	/*** View Detailed Result ***/
	public List<FilterResultPojo> getAllUnattemtedFromFilterResultPojo(String sid, Object examname, String val) {
		String sql = UserSqlQueries.GETALLUNATTEMTEDFROMFILTERRESULTPOJO_QUERY;
		Object[] params = { sid, examname };
		return this.getJdbcTemplate().query(sql, params, new FilterResultMapper());
	}

	public List<FilterResultPojo> getAllInccorrectFromFilterResultPojo(String sid, Object examname, String val) {
		String sql = UserSqlQueries.GETALLINCCORRECTFROMFILTERRESULTPOJO_QUERY;
		Object[] params = { sid, examname };
		return this.getJdbcTemplate().query(sql, params, new FilterResultMapper());
	}

	public List<FilterResultPojo> getAllFromFilterResultPojo(String sid, Object examname) {
		String sql = UserSqlQueries.GETALLFROMFILTERRESULTPOJO_QUERY;
		Object[] params = { sid, examname };
		return this.getJdbcTemplate().query(sql, params, new FilterResultMapper());
	}

	public String getExamEndtime(String examname) {
		String sql = UserSqlQueries.GETEXAMENDTIME_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getExamEndDate(String examname) {
		String sql = UserSqlQueries.GETEXAMENDDATE_QUERY;
		Object[] parm = { examname };
		return this.getJdbcTemplate().queryForObject(sql, parm, String.class);
	}

	@Override
	public List<FilterResultPojo> getquestionidfromfilterpojo(String sid, String examname, String val) {
		String sql = UserSqlQueries.GETQUESTIONIDFROMFILTERPOJO_QUERY;
		Object[] params = { sid, examname, examname, sid };
		return this.getJdbcTemplate().query(sql, params, new FilterResultMapper1());
	}

	@Override
	public int getminTimefromfilterresults(Object examname, int questionId, String val) {
		String sql = UserSqlQueries.GETMINTIMEFROMFILTERRESULTS_QUERY;
		Object[] params = { examname, examname, questionId };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	/*** Book mark Analysis ***/
	public List<BookmarkPojo> getBookmarkQuestions(String sid) {
		String sql = UserSqlQueries.GETBOOKMARKQUESTIONS_QUERY;
		Object[] parm = { sid };
		return this.getJdbcTemplate().query(sql, parm, new BookmarkAnalysisMapper());
	}

	/*** Self Performance Analysis ***/
	@Override
	public List<SelfassessmentModel> getExamtypeforSelfassessment() {
		String sql = UserSqlQueries.GETEXAMTYPEFORSELFASSESSMENT_QUERY;
		return this.getJdbcTemplate().query(sql, new SelfPerformanceAnalysisMapper());
	}

	@Override
	public List<SelfassessmentModel> getSelfAsssessmentdetails(String studentid, String examtype) {
		String sql = UserSqlQueries.GETSELFASSSESSMENTDETAILS_QUERY;
		Object[] params = { examtype, studentid };
		return this.getJdbcTemplate().query(sql, params, new SelfPerformanceAnalysisDetailsMapper());
	}

	/*** Ranks ***/
	@Override
	public List<UserTopRankersModel> getExamnamesForTopRanks() {
		String sql = UserSqlQueries.GETEXAMNAMESFORTOPRANKS_QUERY;
		return this.getJdbcTemplate().query(sql, new UserGetExamnamesForTopRanksMapper());
	}

	/*** View Toppers list ***/
	@Override
	public List<UserTopRankersModel> getToppersListBasedonExamanme(String examname) {
		String sql = UserSqlQueries.GETTOPPERSLISTBASEDONEXAMANME_QUERY;
		Object[] params = { examname, examname };
		return this.getJdbcTemplate().query(sql, params, new ToppersListBasedonExamanmeMapper());
	}

	/*** Resume Exam ***/
	public int getNoOfquestions(String examname, String studentid) {
		String sql = UserSqlQueries.GETNOOFQUESTIONS1_QUERY;
		Object[] params = { examname, studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getLeastTimeFromTempHistoryPackage(String studentid, int locationid, int branchid, int classid,
			int sectionid, String examname) {
		String sql = UserSqlQueries.GETLEASTTIMEFROMTEMPHISTORYPACKAGE_QUERY;
		Object[] params = { studentid, locationid, branchid, classid, sectionid, examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);

	}

	/*** Login OTP ***/
	@Override
	public List<Map<String, Object>> retriveEmailIDfromUsername(String username) {
		String sql = UserSqlQueries.RETRIVEEMAILIDFROMUSERNAME_QUERY;
		Object[] parm = { username };
		return this.getJdbcTemplate().queryForList(sql, parm);
	}

	@Override
	public List<Map<String, Object>> retriveStudentIDfromUsername(String username) {
		String sql = UserSqlQueries.RETRIVESTUDENTIDFROMUSERNAME_QUERY;
		Object[] parm = { username };
		return this.getJdbcTemplate().queryForList(sql, parm);
	}

	@Override
	public int getEmailIDfromusername(String username) {
		String sql = UserSqlQueries.GETEMAILIDFROMUSERNAME_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, new Object[] { username }, Integer.class);
	}

	@Override
	public int updateOTP(String username, String email, String otpnumber) {
		String sql = UserSqlQueries.UPDATEOTP_QUERY;
		Object[] parm = { otpnumber, email, username };
		return this.getJdbcTemplate().update(sql, parm);
	}

	@Override
	public List<Map<String, Object>> validateOTP(String username, String otpvalue) {
		String sql = UserSqlQueries.VALIDATEOTP_QUERY;
		Object[] parm = { username, otpvalue };
		return this.getJdbcTemplate().queryForList(sql, parm);
	}

	/*** Create Exam without slot ***/
	public int getMaxExampaperid() {
		String sql = UserSqlQueries.GETMAXEXAMPAPERID_QUERY;
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public void insertQuestionsForTestExams(String examname, int qid, String statechckbox, String state, String branch,
			String classname, String sectionname, int spltsubjecttypeid, String topic, String subtopic,
			int questiontypeidvalue, String startdate, String enddate, String starttime, String endtime,
			String examtime, int noofqnsperqntype, int totalMarks, String negativemarksperqustype,
			int toatlStdsAvailable, String questionlevelid, int examtypeid, String isslotNo) {
		String sql = UserSqlQueries.INSERTQUESTIONSFORTESTEXAMS_QUERY;
		Object[] params = { examname, qid, statechckbox, state, branch, classname, sectionname, spltsubjecttypeid,
				topic, subtopic, questiontypeidvalue, startdate, enddate, starttime, endtime, examtime,
				noofqnsperqntype, totalMarks, negativemarksperqustype, toatlStdsAvailable, examtypeid, questionlevelid,
				getDateFromSimpleDateFormat(), isslotNo };
		this.getJdbcTemplate().update(sql, params);

	}

	public void insertQuestionsForTestExams1(String examname, int qid, String statechckbox, String state, String branch,
			String classname, String sectionname, int spltsubjecttypeid, String topic, String subtopic,
			int questiontypeidvalue, String startdate, String enddate, String starttime, String endtime,
			String examtime, int noofqnsperqntype, int totalmarks, String negativemarksperqustype,
			int toatlStdsAvailable, String questionlevelid, int examtypeid, int maxid, String isslotNo) {
		String sql = UserSqlQueries.INSERTQUESTIONSFORTESTEXAMS1_QUERY;
		Object[] params = { examname, qid, statechckbox, state, branch, classname, sectionname, spltsubjecttypeid,
				topic, subtopic, questiontypeidvalue, startdate, enddate, starttime, endtime, examtime,
				noofqnsperqntype, totalmarks, negativemarksperqustype, toatlStdsAvailable, examtypeid, questionlevelid,
				getDateFromSimpleDateFormat(), maxid, isslotNo };
		this.getJdbcTemplate().update(sql, params);

	}

	/*** Registration ***/
	@Override
	public List<Register> findAll(Register register) {
		String email = register.getEmail_id();
		int mobile = getMobile(register);
		String username = register.getUsername();
		String sql = UserSqlQueries.FINDALL_QUERY;
		Object[] parm = { email, mobile, username };
		return this.getJdbcTemplate().query(sql, parm, new RegisterMapper());
	}

	private int getMobile(Register reg) {

		return +91;
	}

	@Override
	public int register(Register reg) {
		int userStatus = 1;
		String studentId = generateStudentID();
		String query = UserSqlQueries.REGISTER_QUERY;
		Object[] parm = { reg.getName(), reg.getLname(), reg.getPassword(), reg.getUsername(), reg.getEmail_id(),
				reg.getMobile_Number(), userStatus, studentId, getDateFromSimpleDateFormat(),
				getDateFromSimpleDateFormat(), reg.getCollegename() };
		return this.getJdbcTemplate().update(query, parm);
	}

	/*** Forgot Password ***/
	@Override
	public List<Map<String, Object>> getPasswordFromForgotPasswordPage(String emailid) {
		String sql = UserSqlQueries.GETPASSWORDFROMFORGOTPASSWORDPAGE_QUERY;
		Object[] parm = { emailid };
		return this.getJdbcTemplate().queryForList(sql, parm);
	}

	/*** Delete Exam paper ***/
	public int deleteExampaperInTab(String examname) {
		String sql = UserSqlQueries.DELETEEXAMPAPERINTAB_QUERY;
		Object[] param = { examname };
		return this.getJdbcTemplate().update(sql, param);
	}

	public List<Map<String, Object>> getExamInBetDate(String cdate) {
		String sql = UserSqlQueries.GETEXAMINBETDATE_QUERY;
		Object[] param = { cdate };
		return this.getJdbcTemplate().queryForList(sql, param);
	}

	public int delTempNotStartedExams(String examNotStartedStatus, String examname) {
		String sql = UserSqlQueries.DELTEMPNOTSTARTEDEXAMS_QUERY;
		Object[] param = { examname, examNotStartedStatus };
		return this.getJdbcTemplate().update(sql, param);
	}

	/*** Login Service calls ***/
	public String getUserPassword(LoginPojo lp) {
		String sql = UserSqlQueries.GETUSERPASSWORD_QUERY;
		Object parm[] = { lp.getUsername() };
		return this.getJdbcTemplate().queryForObject(sql, String.class, parm);
	}

	public int checkUserExistOrNot(LoginPojo lp) {
		String sql = UserSqlQueries.CHECKUSEREXISTORNOT_QUERY;
		Object parm[] = { lp.getUsername() };
		return this.getJdbcTemplate().queryForObject(sql, Integer.class, parm);
	}

	/*** Admin Submit exam ***/
	@Override
	public List<QuestionPojo> getStudentDetailsFromUserTable(String studentid) {
		String sql = UserSqlQueries.GETSTUDENTDETAILSFROMUSERTABLE_QUERY;
		Object[] params = { studentid };
		return this.getJdbcTemplate().query(sql, params, new AdminSubmitExamMapper());
	}

	/*** Result calculation ***/
	public List<UserResultsPojo> getresultsfordisplay(String examname, String studentid) {
		String sql = UserSqlQueries.GETRESULTSFORDISPLAY_QUERY;
		Object[] params = { examname, studentid };
		return this.getJdbcTemplate().query(sql, params, new UserResultsMapper());
	}

	public String getCorrectAnswer(String bquestionid) {
		String sql = UserSqlQueries.GETCORRECTANSWER_QUERY;
		Object[] params = { bquestionid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public List<QuestionPojo> getSubjectnamesInExam(String examname) {
		String sql = UserSqlQueries.GETSUBJECTNAMESINEXAM_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new ExamSubjectsMapper());
	}

	public int getCountOfSubjectnamesInExam(String examname) {
		String sql = UserSqlQueries.GETCOUNTOFSUBJECTNAMESINEXAM_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getQustypeBasedonQuestionIb(int bquestionid) {
		String sql = UserSqlQueries.GETQUSTYPEBASEDONQUESTIONIB_QUERY;
		Object[] params = { bquestionid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getScoredmarksInDemoExam(int qustype, String examname, String subjecttypeid) {
		String sql = UserSqlQueries.GETSCOREDMARKSINDEMOEXAM_QUERY;
		Object[] params = { examname, qustype, subjecttypeid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getNegativeMarksInExamPaper(int qustype, String examname, String subid) {
		String sql = UserSqlQueries.GETNEGATIVEMARKSINEXAMPAPER_QUERY;
		Object[] params = { examname, qustype, subid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int updateStudentResultsHistory(String studentid, String examname, int qid, String rightanswer,
			String notanswered, String wronganswer, String subid, float actualscore, int questionrowid) {
		String sql = UserSqlQueries.UPDATESTUDENTRESULTSHISTORY_QUERY;
		Object[] params = { rightanswer, notanswered, wronganswer, actualscore, examname, studentid, qid, subid,
				questionrowid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int updateStudentResultsSubjMarks(String studentid, String examname, String subjid, float yourMarks1,
			int totalAnswered, int totalWrongAnswered, int totalnotAnswered) {
		String sql = UserSqlQueries.UPDATESTUDENTRESULTSSUBJMARKS_QUERY;
		Object[] params = { totalAnswered, totalWrongAnswered, totalnotAnswered, yourMarks1, studentid, examname,
				subjid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int updateExamscoredMarks(String studentid, String examname, double examscoredmarks) {
		String sql = UserSqlQueries.UPDATEEXAMSCOREDMARKS_QUERY;
		Object[] params = { examscoredmarks, studentid, examname };
		return this.getJdbcTemplate().update(sql, params);
	}

	public void insertDataintoFilterResult(String studentid, String examname, int qidval1, String rightanswer,
			String notanswered, String wronganswer, String subject, String correctAnswer, float marksperqustype,
			float nmarks, double yourMarks, String state, String locationid, String branchname, String classname,
			String sectionname, String examconducteddate, String username, int questionrowid) {
		String sql = UserSqlQueries.INSERTDATAINTOFILTERRESULT_QUERY;
		Object[] params = { studentid, examname, qidval1, rightanswer, notanswered, wronganswer, subject,
				getDateFromSimpleDateFormat(), getDateFromSimpleDateFormat(), correctAnswer, marksperqustype, nmarks,
				sectionname, branchname, state, locationid, classname, yourMarks, examconducteddate, username,
				questionrowid };
		this.getJdbcTemplate().update(sql, params);

	}

	/*** Temp history ***/
	public int getmarkforreivewcnt(String examname, String studentid, String subjectid) {
		String sql = UserSqlQueries.GETMARKFORREIVEWCNT_QUERY;
		Object[] params = { examname, studentid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public List<TempHistoryPackage> getAllTempHisyPackage(String questionid, String examname, String subjectid,
			String studentid, String qrowid) {
		String sql = UserSqlQueries.GETALLTEMPHISYPACKAGE_QUERY1(questionid, examname, subjectid, studentid, qrowid);
		return this.getJdbcTemplate().query(sql, new TemphistoryPackageMapper());

	}

	public int getIntialTimeValueintemp1(String examname, String studentid) {
		String sql = UserSqlQueries.GETINTIALTIMEVALUEINTEMP1_QUERY;
		Object[] params = { examname, studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getIntialTimeValueintemp(String examname, String studentid) {
		String sql = UserSqlQueries.GETINTIALTIMEVALUEINTEMP_QUERY;
		Object[] params = { examname, studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int updateTempHisyPackage(String sid, String examname, String subjectid, String qid, String selectedanswer,
			String timetakenval, String qrowidval, String currenttime, String timediff) {
		String sql = UserSqlQueries.UPDATETEMPHISYPACKAGE1_QUERY;
		Object[] params = { selectedanswer, timetakenval, currenttime, timediff, qid, sid, examname, qrowidval };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int getcountforUnattemptforexam(String examname, String studentid) {
		String sql = UserSqlQueries.GETCOUNTFORUNATTEMPTFOREXAM_QUERY;
		Object[] params = { examname, studentid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getUnattemptedCountForSubj(String examname, String studentid, String subjectid) {
		String sql = UserSqlQueries.GETUNATTEMPTEDCOUNTFORSUBJ_QUERY;
		Object[] params = { examname, studentid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getAttemptedCountForSubj(String examname, String studentid, String subjectid) {
		String sql = UserSqlQueries.GETATTEMPTEDCOUNTFORSUBJ_QUERY;
		Object[] params = { examname, studentid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int insertMarkForReviewValue(String markvalue, String examname, String studentid, String subjectid,
			String questionid, String questionrowid) {
		String sql = UserSqlQueries.INSERTMARKFORREVIEWVALUE_QUERY;
		Object[] params = { markvalue, examname, studentid, subjectid, questionid, questionrowid };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int getMarkForReviewNotAnsweredCountForSubj(String markvalue, String examname, String studentid,
			String subjectid) {
		String sql = UserSqlQueries.GETMARKFORREVIEWNOTANSWEREDCOUNTFORSUBJ_QUERY;
		Object[] params = { markvalue, examname, studentid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getMarkForReviewAnsweredCountForSubj(String markvalue, String examname, String studentid,
			String subjectid) {
		String sql = UserSqlQueries.GETMARKFORREVIEWANSWEREDCOUNTFORSUBJ_QUERY;
		Object[] params = { markvalue, examname, studentid, subjectid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getResumetimeDiffrenceBasedonQid1(String studentid, String examname, String questionid, String qrowid) {
		return 0;
	}

	/** Dash board user start exam ***/
	public String getTimeBasedOnSelectedExam(String examname) {
		String sql = UserSqlQueries.GETTIMEBASEDONSELECTEDEXAM_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getCountOfQuestionsInExampaper(String examname) {
		String sql = UserSqlQueries.GETCOUNTOFQUESTIONSINEXAMPAPER_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getNoOfquestions(String examname) {
		String sql = UserSqlQueries.GETNOOFQUESTIONS_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int insertBookmarkAnalysisData(String examname, int currentquestionid, String studentid, int subjectid,
			int bookmarkStatusTypeId, int classid, int branchid, int sectionid, int locationid) {
		String sql = UserSqlQueries.INSERTBOOKMARKANALYSISDATA_QUERY;
		Object[] parm = { examname, currentquestionid, studentid, subjectid, bookmarkStatusTypeId, classid, branchid,
				sectionid, locationid, getDateFromSimpleDateFormat(), getDateFromSimpleDateFormat() };
		return this.getJdbcTemplate().update(sql, parm);

	}

	public int findQuestionIDAvailableinBookmark(String examname, String studentId, int questionId) {
		String sql = UserSqlQueries.FINDQUESTIONIDAVAILABLEINBOOKMARK_QUERY;
		Object[] parm = { studentId, questionId, examname };
		return this.getJdbcTemplate().queryForObject(sql, parm, Integer.class);
	}

	public int updateResumetimeInAuditlogs(String studentid, String username, String examname, String examstarttime) {
		String sql = UserSqlQueries.UPDATERESUMETIMEINAUDITLOGS_QUERY;
		Object[] params = { getDateFromSimpleDateFormat(), studentid, username, examname };
		return this.getJdbcTemplate().update(sql, params);
	}

	public String getEndTimeinExamPaper(String examname) {
		String sql = UserSqlQueries.GETENDTIMEINEXAMPAPER_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getExamTypeIdBasedOnExamName(String examname) {
		String sql = UserSqlQueries.GETEXAMTYPEIDBASEDONEXAMNAME_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int getPatternIdBasedOnExamType(int examtypeid) {
		String sql = UserSqlQueries.GETPATTERNIDBASEDONEXAMTYPE_QUERY;
		Object[] params = { examtypeid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int updateIntoTempHistory(String examstatuses, String endtime, String currenttime, String sid,
			String examname) {
		String sql = UserSqlQueries.UPDATEINTOTEMPHISTORY_QUERY;
		Object[] param = { examstatuses, endtime, currenttime, sid, examname };
		return this.getJdbcTemplate().update(sql, param);
	}

	public String getEndTimeinTempHostory(String examname, String sid) {
		String sql = UserSqlQueries.GETENDTIMEINTEMPHOSTORY_QUERY;
		Object[] params = { examname, sid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public String getEndDateinTempHostory(String examname, String sid) {
		String sql = UserSqlQueries.GETENDDATEINTEMPHOSTORY_QUERY;
		Object[] params = { examname, sid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getCountOfAnswersFromTempHistoryPackage(String studentid, String examname, int locationid, int branchid,
			int classid, int sectionid) {
		String sql = UserSqlQueries.GETCOUNTOFANSWERSFROMTEMPHISTORYPACKAGE_QUERY;
		Object[] params = { studentid, examname, locationid, branchid, classid, sectionid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getEndTimeFromTempHistoryPackage(String studentid, String examname, int locationid, int branchid,
			int classid, int sectionid) {
		String sql = UserSqlQueries.GETENDTIMEFROMTEMPHISTORYPACKAGE_QUERY;
		Object[] params = { studentid, examname, locationid, branchid, classid, sectionid };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public List<QuestionPojo> getDisplayQuestions(String examname) {
		String sql = UserSqlQueries.GETDISPLAYQUESTIONS_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new DisplayQuestionsMapper());
	}

	public int getCountForExistingTempHistory(String examname, String sid) {
		String sql = UserSqlQueries.GETCOUNTFOREXISTINGTEMPHISTORY_QUERY;
		Object[] params = { examname, sid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public String getIsjumblingYesOrnoBasedonExamname(String examname) {
		String sql = UserSqlQueries.GETISJUMBLINGYESORNOBASEDONEXAMNAME_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().queryForObject(sql, params, String.class);
	}

	public int getCountForExistingResults(String examname, String sid) {
		String sql = UserSqlQueries.GETCOUNTFOREXISTINGRESULTS_QUERY;
		Object[] params = { examname, sid };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int countOfExistingTest(String studentid, String username, String logintime, String examname) {
		String sql = UserSqlQueries.COUNTOFEXISTINGTEST_QUERY;
		Object[] params = { studentid, username, logintime, examname };
		return this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
	}

	public int insertNextRowdataInAuditlogs(String studentid, String username, String logintime, String examname,
			String examstarttime) {
		String sql = UserSqlQueries.INSERTNEXTROWDATAINAUDITLOGS_QUERY;
		Object[] params = { studentid, username, logintime, examname, examstarttime };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int insertExamstartTime(String studentid, String username, String examname, String examstarttime,
			String logintime) {
		String sql = UserSqlQueries.INSERTEXAMSTARTTIME_QUERY;
		Object[] params = { examname, examstarttime, studentid, username, logintime };
		return this.getJdbcTemplate().update(sql, params);
	}

	public int deleteTempDataBasedonExamname(String sid, String examname) {
		String sql = UserSqlQueries.DELETETEMPDATABASEDONEXAMNAME_QUERY;
		Object[] params = { sid, examname };
		return this.getJdbcTemplate().update(sql, params);
	}

	/*** Submit exam ***/
	public List<QuestionPojo> getExamdataIntempHistory(String examname, String studentid, String examstatus,
			String subarray) {
		String sql = UserSqlQueries.GETEXAMDATAINTEMPHISTORY_QUERY;
		Object[] params = { examname, studentid, examstatus, subarray };
		return this.getJdbcTemplate().query(sql, params, new QuestionIdsInTempHistory());
	}

	public List<Map<String, Object>> getsubjectwisemarksforExam(String examname, String subject) {
		String sql = UserSqlQueries.GETSUBJECTWISEMARKSFOREXAM_QUERY;
		Object[] params = { examname, subject };
		return this.getJdbcTemplate().queryForList(sql, params);
	}

	public void insertStudentResults(String studentid, String examname, String subjectId, double yourMarks1,
			int totalQuestions, int totalAnswered, String totalqtime, String username, String sectionname,
			String branchname, String state, String classname, String locationid, Time timeqtaken, double toatalmarks,
			int totalAvailableStudents, String examConductedDate, double nmarks, int totalWrongAnswered,
			int totalnotAnswered, double subjecttotalmarks) {
		String sql = UserSqlQueries.INSERTSTUDENTRESULTS_QUERY;
		Object[] params = { studentid, examname, subjectId, yourMarks1, totalQuestions, totalAnswered, totalqtime,
				getDateFromSimpleDateFormat(), username, sectionname, branchname, state, classname, locationid,
				timeqtaken, toatalmarks, totalAvailableStudents, examConductedDate, nmarks, totalWrongAnswered,
				totalnotAnswered, subjecttotalmarks };
		this.getJdbcTemplate().update(sql, params);

	}

	public List<QuestionPojo> getTotalMarksAndTotalAvailablestudents(String examname) {
		String sql = UserSqlQueries.GETTOTALMARKSANDTOTALAVAILABLESTUDENTS_QUERY;
		Object[] params = { examname };
		return this.getJdbcTemplate().query(sql, params, new ExamTotalMarks_and_TotalAvailablestudents());
	}

	public int getUpdateExamCompletionStatus(String studentid, String examname, int locationid, int branchid,
			int classid, int sectionid) {
		String sql = UserSqlQueries.GETUPDATEEXAMCOMPLETIONSTATUS_QUERY;
		Object[] pareams = { studentid, examname, locationid, branchid, classid, sectionid };
		return this.getJdbcTemplate().update(sql, pareams);
	}

	public int updateExamendtimeInAuditLogs(String studentid, String examname, String username) {
		String sql = UserSqlQueries.UPDATEEXAMENDTIMEINAUDITLOGS_QUERY;
		Object[] params = { getDateFromSimpleDateFormat(), studentid, username, examname };
		return this.getJdbcTemplate().update(sql, params);
	}

}
