package com.educare.services;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educare.dao.RegisterDaoImpl;
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

@Service("userservice")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	RegisterDaoImpl registerDao;

	@Override
	public int getRoleIDfromUserRole(String getusernames) {
		return registerDao.getRoleIDfromUserRole(getusernames);
	}

	@Override
	public List<LoginPojo> loginDetails(LoginPojo lp) {
		return registerDao.loginDetails(lp);
	}

	@Override
	public String getUserPWD(LoginPojo lp) {
		return registerDao.getUserPWD(lp);
	}

	@Override
	public int getEmailIDfromusername(String username) {
		return registerDao.getEmailIDfromusername(username);
	}

	@Override
	public List<Map<String, Object>> retriveEmailIDfromUsername(String username) {
		return registerDao.retriveEmailIDfromUsername(username);
	}

	public List<Map<String, Object>> retriveStudentIDfromUsername(String username) {
		return registerDao.retriveStudentIDfromUsername(username);
	}

	@Override
	public int updateOTP(String username, String email, String otpnumber) {
		return registerDao.updateOTP(username, email, otpnumber);
	}

	@Override
	public List<Map<String, Object>> validateOTP(String username, String otpvalue) {
		return registerDao.validateOTP(username, otpvalue);
	}

	@Override
	public List<Register> findAll(Register register) {
		return registerDao.findAll(register);

	}

	public String getEmaiid(Register register) {
		return registerDao.getEmaiid(register);
	}

	@Override
	public int register(Register register) {
		return registerDao.register(register);
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
		String lecturerid = educareName + "-" + year + "-" + id;

		return lecturerid;
	}

	@Override
	public int getMaxUserIDfromUsers() {
		return registerDao.getMaxUserIDfromUsers();

	}

	@Override
	public int getUserIDfromUsers(String username) {
		return registerDao.getUserIDfromUsers(username);
	}

	@Override
	public void insertUserRole(int uid, int rid) {
		registerDao.insertUserRole(uid, rid);
	}

	@Override
	public List<Map<String, Object>> getPasswordFromForgotPasswordPage(String emailid) {
		return registerDao.getPasswordFromForgotPasswordPage(emailid);
	}

	@Override
	public List<LoginPojo> getUserdetails(String sid) {
		return registerDao.getUserdetails(sid);
	}

	@Override
	public List<QuestionPojo> getExams(String stateid, String locationid, String branchid, String classid,
			String sectionid) {
		return registerDao.getExams(stateid, locationid, branchid, classid, sectionid);
	}

	public String getTimeBasedOnSelectedExam(String examname) {
		return registerDao.getTimeBasedOnSelectedExam(examname);
	}

	public int getNoOfquestions(String examname, String studentid) {
		return registerDao.getNoOfquestions(examname, studentid);
	}

	public int getNoOfquestions(String examname) {
		return registerDao.getNoOfquestions(examname);
	}

	public String getCorrectAnswer(String bquestionid) {

		return registerDao.getCorrectAnswer(bquestionid);
	}

	public String getScoredmarksInDemoExam(int qustype, String examname, String subjecttypeid) {
		return registerDao.getScoredmarksInDemoExam(qustype, examname, subjecttypeid);
	}

	public int getQustypeBasedonQuestionIb(int bquestionid) {

		return registerDao.getQustypeBasedonQuestionIb(bquestionid);
	}

	public List<QuestionPojo> getDisplayQuestions(String examname) {
		return registerDao.getDisplayQuestions(examname);
	}

	public List<QuestionPojo> getDisplayQuestions(String examname, int subjectid, String random) {
		return registerDao.getDisplayQuestions(examname, subjectid, random);
	}

	public void insertStudentResults(String studentid, String examname, String subjectid, double yourMarks1,
			int totalQuestions, int totalAnswered, String totalqtime, String username, String sectionname,
			String branchname, String state, String classname, String locationid, Time timeqtaken, double toatalmarks,
			int totalAvailableStudents, String examConductedDate, double nmarks, int totalWrongAnswered,
			int totalnotAnswered, double subjecttotalmarks) {
		registerDao.insertStudentResults(studentid, examname, subjectid, yourMarks1, totalQuestions, totalAnswered,
				totalqtime, username, sectionname, branchname, state, classname, locationid, timeqtaken, toatalmarks,
				totalAvailableStudents, examConductedDate, nmarks, totalWrongAnswered, totalnotAnswered,
				subjecttotalmarks);

	}

	public List<FilterResultPojo> getAllFromFilterResultPojo(String sid, Object examname) {
		return registerDao.getAllFromFilterResultPojo(sid, examname);
	}

	public List<FilterResultPojo> getAllInccorrectFromFilterResultPojo(String sid, Object examname, String val) {
		return registerDao.getAllInccorrectFromFilterResultPojo(sid, examname, val);
	}

	public List<FilterResultPojo> getAllUnattemtedFromFilterResultPojo(String sid, Object examname, String val) {
		return registerDao.getAllUnattemtedFromFilterResultPojo(sid, examname, val);
	}

	public List<Register> getUserProfile(String username) {
		return registerDao.getUserProfile(username);
	}

	public int updateUserProfile(String firstname, String lastname, String email, String phone, String studentid,
			String collegename) {
		return registerDao.updateUserProfile(firstname, lastname, email, phone, studentid, collegename);
	}

	public String getuserExistingPassword(String studentid) {
		return registerDao.getuserExistingPassword(studentid);
	}

	public void changeUserPassword(String studentid, String newpwd) {
		registerDao.changeUserPassword(studentid, newpwd);
	}

	public void insertDataintoFilterResult(String studentid, String examname, int qidval1, String rightanswer,
			String notanswered, String wronganswer, String subject, String correctAnswer, float marksperqustype,
			float nmarks, double yourMarks, String state, String locationid, String branchname, String classname,
			String sectionname, String examconducteddate, String username, int questionrowid) {
		registerDao.insertDataintoFilterResult(studentid, examname, qidval1, rightanswer, notanswered, wronganswer,
				subject, correctAnswer, marksperqustype, nmarks, yourMarks, state, locationid, branchname, classname,
				sectionname, examconducteddate, username, questionrowid);
	}

	public List<WelcomeUserPojo> userResults(String studentid) {
		return registerDao.userResults(studentid);
	}

	public List<QuestionPojo> getTotalMarksAndTotalAvailablestudents(String examname) {
		return registerDao.getTotalMarksAndTotalAvailablestudents(examname);
	}

	public List<TempHistoryPackage> getAllTempHisyPackage(String questionid, String examname, String subjectid,
			String studentid, String qrowid) {
		return registerDao.getAllTempHisyPackage(questionid, examname, subjectid, studentid, qrowid);

	}

	public int updateTempHisyPackage(String sid, String examname, String subjectid, String qid, String selectedanswer,
			String timetakenval, String qrowidval, String currenttime1, String diffsec1) {
		return registerDao.updateTempHisyPackage(sid, examname, subjectid, qid, selectedanswer, timetakenval, qrowidval,
				currenttime1, diffsec1);
	}

	public List<QuestionPojo> getQuestyionsFromTempHistoryPackage(String studentid, String examname, int locationid,
			int branchid, int classid, int sectionid, String subjectid, String isjumbling) {
		return registerDao.getQuestyionsFromTempHistoryPackage(studentid, examname, locationid, branchid, classid,
				sectionid, subjectid, isjumbling);
	}

	public String getLeastTimeFromTempHistoryPackage(String studentid, int locationid, int branchid, int classid,
			int sectionid, String examname) {
		return registerDao.getLeastTimeFromTempHistoryPackage(studentid, locationid, branchid, classid, sectionid,
				examname);
	}

	public int getCountOfAnswersFromTempHistoryPackage(String studentid, String examname, int locationid, int branchid,
			int classid, int sectionid) {
		return registerDao.getCountOfAnswersFromTempHistoryPackage(studentid, examname, locationid, branchid, classid,
				sectionid);
	}

	public int getUpdateExamCompletionStatus(String studentid, String examname, int locationid, int branchid,
			int classid, int sectionid) {
		return registerDao.getUpdateExamCompletionStatus(studentid, examname, locationid, branchid, classid, sectionid);
	}

	public List<ExamCompletionState> getExamCompletionStatusQuery(String studentid, String stateid, String locationid,
			String branchid, String classid, String sectionid, String examname) {
		return registerDao.getExamCompletionStatusQuery(studentid, stateid, locationid, branchid, classid, sectionid,
				examname);
	}

	public int getcountforUnattemptforexam(String examname, String studentid) {
		return registerDao.getcountforUnattemptforexam(examname, studentid);
	}

	public int findQuestionIDAvailableinBookmark(String examname, String studentid, int questionid) {
		return registerDao.findQuestionIDAvailableinBookmark(examname, studentid, questionid);
	}

	public int insertBookmarkAnalysisData(String examname, int currentquestionid, String studentid, int subjectid,
			int bookmarkStatusTypeId, int classid, int branchid, int sectionid, int locationid) {
		return registerDao.insertBookmarkAnalysisData(examname, currentquestionid, studentid, subjectid,
				bookmarkStatusTypeId, classid, branchid, sectionid, locationid);
	}

	public List<BookmarkPojo> getBookmarkQuestions(String sid) {
		return registerDao.getBookmarkQuestions(sid);
	}

	public List<ErrorAnalysisPojo> getAnalysis(String qusid) {
		return registerDao.getAnalysis(qusid);
	}

	public List<QuestionPojo> getAllQuestionsfromtable(int examtypeid, int spltsubjecttypeid, String questionlevelid,
			int questiontypeidvalue, String topic, String subtopic, int spltqnsfromquestiontype) {
		return registerDao.getAllQuestionsfromtable(examtypeid, spltsubjecttypeid, questionlevelid, questiontypeidvalue,
				topic, subtopic, spltqnsfromquestiontype);
	}

	public List<QuestionPojo> getSubjectnamesInExam(String examname) {
		return registerDao.getSubjectnamesInExam(examname);
	}

	public List<QuestionPojo> getSubjectnamesInSubjectTable(String examname) {
		return registerDao.getSubjectnamesInSubjectTable(examname);
	}

	public int getCountOfSubjectnamesInExam(String examname) {
		return registerDao.getCountOfSubjectnamesInExam(examname);
	}

	public List<QuestionPojo> getExamdataIntempHistory(String examname, String studentid, String examstatus,
			String subj) {
		return registerDao.getExamdataIntempHistory(examname, studentid, examstatus, subj);
	}

	public int updateExamscoredMarks(String studentid, String examname, double examscoredmarks) {
		return registerDao.updateExamscoredMarks(studentid, examname, examscoredmarks);
	}

	public List<QuestionPojo> getsubjectnamefromsubjectid(String subjectids) {
		return registerDao.getsubjectnamefromsubjectid(subjectids);
	}

	public List<Map<String, Object>> getsubjectwisemarksforExam(String examname, String subject) {
		return registerDao.getsubjectwisemarksforExam(examname, subject);
	}

	public List<UserResultsPojo> getresultsfordisplay(String examname, String studentid) {
		return registerDao.getresultsfordisplay(examname, studentid);
	}

	public String getExamEndtime(String examname) {
		return registerDao.getExamEndtime(examname);
	}

	public String getNegativeMarksInExamPaper(int qustype, String examname, String subid) {
		return registerDao.getNegativeMarksInExamPaper(qustype, examname, subid);
	}

	public int getCountForExistingResults(String examname, String sid) {
		return registerDao.getCountForExistingResults(examname, sid);
	}

	public int getCountForExistingTempHistory(String examname, String sid) {
		return registerDao.getCountForExistingTempHistory(examname, sid);
	}

	public int insertUserStatus(String studentid, int userstatus) {
		return registerDao.insertUserStatus(studentid, userstatus);
	}

	public int getUserStatus(String studentid) {
		return registerDao.getUserStatus(studentid);
	}

	public int insertAuditlogs(String studentid, String username, String logintime) {
		return registerDao.insertAuditlogs(studentid, username, logintime);
	}

	public int updateLogouttimeInAuditlogs(String studentid, String username, String logintime) {
		return registerDao.updateLogouttimeInAuditlogs(studentid, username, logintime);
	}

	public int insertExamstartTime(String studentid, String username, String examname, String examstarttime,
			String logintime) {
		return registerDao.insertExamstartTime(studentid, username, examname, examstarttime, logintime);
	}

	public int updateExamendtimeInAuditLogs(String studentid, String examname, String username) {
		return registerDao.updateExamendtimeInAuditLogs(studentid, examname, username);
	}

	public int countOfExistingTest(String studentid, String username, String logintime, String examname) {
		return registerDao.countOfExistingTest(studentid, username, logintime, examname);
	}

	public int insertNextRowdataInAuditlogs(String studentid, String username, String logintime, String examname,
			String examstarttime) {
		return registerDao.insertNextRowdataInAuditlogs(studentid, username, logintime, examname, examstarttime);
	}

	public int updateResumetimeInAuditlogs(String studentid, String username, String examname, String examstarttime) {
		return registerDao.updateResumetimeInAuditlogs(studentid, username, examname, examstarttime);
	}

	public List<Instructionspojo> getAllInstructionDetails(String examname) {
		return registerDao.getAllInstructionDetails(examname);
	}

	public int getCountOfQuestionsInExampaper(String examname) {
		return registerDao.getCountOfQuestionsInExampaper(examname);
	}

	public int deleteTempDataBasedonExamname(String sid, String examname) {
		return registerDao.deleteTempDataBasedonExamname(sid, examname);
	}

	public String getEndTimeinExamPaper(String examname) {
		return registerDao.getEndTimeinExamPaper(examname);
	}

	public String getEndTimeFromTempHistoryPackage(String sid, String examname, int locationdival, int brcidval,
			int clsidval, int sectidval) {
		return registerDao.getEndTimeFromTempHistoryPackage(sid, examname, locationdival, brcidval, clsidval,
				sectidval);
	}

	public int getIntialTimeValueintemp1(String examname, String studentid) {
		return registerDao.getIntialTimeValueintemp1(examname, studentid);
	}

	public String getIntialTimeValueintemp(String examname, String studentid) {
		return registerDao.getIntialTimeValueintemp(examname, studentid);
	}

	public int getResumetimeDiffrenceBasedonQid1(String studentid, String examname, String questionid, String qrowid) {
		return registerDao.getResumetimeDiffrenceBasedonQid1(studentid, examname, questionid, qrowid);
	}

	public String getIsjumblingYesOrnoBasedonExamname(String examname) {
		return registerDao.getIsjumblingYesOrnoBasedonExamname(examname);
	}

	public int getCompareQuestionsCount(String subid, String questiontypeids, String subtopicids, String topicids,
			String qlevelids, String etid, String subjectquestions) {
		return registerDao.getCompareQuestionsCount(subid, questiontypeids, subtopicids, topicids, qlevelids, etid,
				subjectquestions);
	}

	public int getMaxExampaperid() {
		return registerDao.getMaxExampaperid();
	}

	public int getUnattemptedCountForSubj(String examname, String studentid, String subjectid) {
		return registerDao.getUnattemptedCountForSubj(examname, studentid, subjectid);
	}

	public int getAttemptedCountForSubj(String examname, String studentid, String subjectid) {
		return registerDao.getAttemptedCountForSubj(examname, studentid, subjectid);
	}

	public int insertMarkForReviewValue(String markvalue, String examname, String studentid, String subjectid,
			String questionid, String questionrowid) {
		return registerDao.insertMarkForReviewValue(markvalue, examname, studentid, subjectid, questionid,
				questionrowid);
	}

	public int getMarkForReviewNotAnsweredCountForSubj(String markvalue, String examname, String studentid,
			String subjectid) {
		return registerDao.getMarkForReviewNotAnsweredCountForSubj(markvalue, examname, studentid, subjectid);
	}

	public int getMarkForReviewAnsweredCountForSubj(String markvalue, String examname, String studentid,
			String subjectid) {
		return registerDao.getMarkForReviewAnsweredCountForSubj(markvalue, examname, studentid, subjectid);
	}

	@Override
	public List<UserTopRankersModel> getExamnamesForTopRanks() {
		return registerDao.getExamnamesForTopRanks();
	}

	@Override
	public List<UserTopRankersModel> getToppersListBasedonExamanme(String examname) {
		return registerDao.getToppersListBasedonExamanme(examname);
	}

	@Override
	public List<FilterResultPojo> getquestionidfromfilterpojo(String sid, String examname, String val) {
		return registerDao.getquestionidfromfilterpojo(sid, examname, val);
	}

	@Override
	public int getminTimefromfilterresults(Object examname, int questionId, String val) {
		return registerDao.getminTimefromfilterresults(examname, questionId, val);
	}

	@Override
	public List<SelfassessmentModel> getExamtypeforSelfassessment() {
		return registerDao.getExamtypeforSelfassessment();
	}

	@Override
	public List<SelfassessmentModel> getSelfAsssessmentdetails(String studentid, String examtype) {
		return registerDao.getSelfAsssessmentdetails(studentid, examtype);
	}

	@Override
	public List<QuestionPojo> getStudentDetailsFromUserTable(String studentid) {
		return registerDao.getStudentDetailsFromUserTable(studentid);
	}

	@Override
	public int getmarkforreivewcnt(String examname, String studentid, String subjectid) {
		return registerDao.getmarkforreivewcnt(examname, studentid, subjectid);
	}

	@Override
	public int getExamTypeIdBasedOnExamName(String examname) {
		return registerDao.getExamTypeIdBasedOnExamName(examname);
	}

	@Override
	public int getPatternIdBasedOnExamType(int examtypeid) {
		return registerDao.getPatternIdBasedOnExamType(examtypeid);
	}

	public List<Register> getUserProfile1(String username) {
		return registerDao.getUserProfile1(username);
	}

	public int updateStudentResultsHistory(String studentid, String examname, int qid, String rightanswer,
			String notanswered, String wronganswer, String subid, float actualscore, int questionrowid) {
		return registerDao.updateStudentResultsHistory(studentid, examname, qid, rightanswer, notanswered, wronganswer,
				subid, actualscore, questionrowid);
	}

	public int updateStudentResultsSubjMarks(String studentid, String examname, String subjid, float yourMarks1,
			int totalAnswered, int totalWrongAnswered, int totalnotAnswered) {
		return registerDao.updateStudentResultsSubjMarks(studentid, examname, subjid, yourMarks1, totalAnswered,
				totalWrongAnswered, totalnotAnswered);
	}

	public int checkUserExistOrNot(LoginPojo lp) {
		return registerDao.checkUserExistOrNot(lp);
	}

	public String getUserPassword(LoginPojo lp) {
		return registerDao.getUserPassword(lp);
	}

	public List<Map<String, Object>> getExamInBetDate(String cdate) {
		return registerDao.getExamInBetDate(cdate);
	}

	public int deleteExampaperInTab(String examname) {
		return registerDao.deleteExampaperInTab(examname);
	}

	public void insertQuestionsForTestExams(String examname, int qid, String statechckbox, String state, String branch,
			String classname, String sectionname, int spltsubjecttypeid, String topic, String subtopic,
			int questiontypeidvalue, String startdate, String enddate, String starttime, String endtime,
			String examtime, int noofqnsperqntype, int totalmarks, String negativemarksperqustype,
			int toatlStdsAvailable, String questionlevelid, int examtypeid, String isslotNo) {
		registerDao.insertQuestionsForTestExams(examname, qid, statechckbox, state, branch, classname, sectionname,
				spltsubjecttypeid, topic, subtopic, questiontypeidvalue, startdate, enddate, starttime, endtime,
				examtime, noofqnsperqntype, totalmarks, negativemarksperqustype, toatlStdsAvailable, questionlevelid,
				examtypeid, isslotNo);
	}

	public void insertQuestionsForTestExams1(String examname, int qid, String statechckbox, String state, String branch,
			String classname, String sectionname, int spltsubjecttypeid, String topic, String subtopic,
			int questiontypeidvalue, String startdate, String enddate, String starttime, String endtime,
			String examtime, int noofqnsperqntype, int totalmarks, String negativemarksperqustype,
			int toatlStdsAvailable, String questionlevelid, int examtypeid, int maxid, String isslotNo) {
		registerDao.insertQuestionsForTestExams1(examname, qid, statechckbox, state, branch, classname, sectionname,
				spltsubjecttypeid, topic, subtopic, questiontypeidvalue, startdate, enddate, starttime, endtime,
				examtime, noofqnsperqntype, totalmarks, negativemarksperqustype, toatlStdsAvailable, questionlevelid,
				examtypeid, maxid, isslotNo);
	}

	public List<QuestionPojo> getExams1(String stateid, String locationid, String branchid, String classid,
			String sectionid) {
		return registerDao.getExams1(stateid, locationid, branchid, classid, sectionid);
	}

	public String getEndTimeinTempHostory(String examname, String sid) {
		return registerDao.getEndTimeinTempHostory(examname, sid);
	}

	public String getEndDateinTempHostory(String examname, String sid) {
		return registerDao.getEndDateinTempHostory(examname, sid);
	}

	public String getExamEndDate(String examname) {
		return registerDao.getExamEndDate(examname);
	}

	public List<Register> getStudentDetBaseOnId(String studentid) {
		return registerDao.getStudentDetBaseOnId(studentid);
	}

	public int updateIntoTempHistoryWithSlot(String examstatus, String endtime, String currenttime,
			String examstartdate, String examstartime, String examendtime, String examenddate, String sid,
			String examname) {
		return registerDao.updateIntoTempHistoryWithSlot(examstatus, endtime, currenttime, examstartdate, examstartime,
				examendtime, examenddate, sid, examname);
	}

	public int updateIntoTempHistory(String examstatuses, String endtime, String currenttime, String sid,
			String examname) {
		return registerDao.updateIntoTempHistory(examstatuses, endtime, currenttime, sid, examname);
	}

	public int delTempNotStartedExams(String examNotStartedStatus, String examname) {
		return registerDao.delTempNotStartedExams(examNotStartedStatus, examname);

	}

}
