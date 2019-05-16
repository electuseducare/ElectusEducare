package com.educare.admin.sqlStatements;

public class UserSqlQueries {

	private UserSqlQueries() {}


	/*** Error Analysis ***/
	public static final String GETANALYSIS_QUERY = "select analysis from el_questions where Question_Id= ?";

	/*** Student Bulk Update ***/
	public static final String GETUPDATEUSERIDINUSERROLES_QUERY = "insert into user_role values(?,?)";

	/*** AED Admin / AED Lecturer ***/
	public static final String GETUSERIDFROMUSERS_QUERY = "select user_id from users where user_name= ?";
	public static final String INSERTUSERROLE_QUERY = "INSERT INTO user_role (user_id,role_id) values(?,?)";

	/*** Create Exam ***/
	public static final String INSERTQUESTIONSFORTESTEXAMS_QUERY = "insert into el_exam_paper(exam_name,Question_id,state_type_id,location_id,branch_id,class_id,section_id,"
			+ "subject_id,topic_id,subtopic_id,Question_type_id,startdate,enddate,starttime,endtime,testduration,"
			+ "marks_per_qus_type,Total_marks,Negative_marks,total_students_available,exam_type_id,question_level_type_id,"
			+ "createddate,is_slot) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GETMAXEXAMPAPERID_QUERY = "select max(exam_paper_id) from el_exam_paper";
	public static final String INSERTQUESTIONSFORTESTEXAMS1_QUERY = "insert into el_exam_paper1(exam_name,Question_id,state_type_id,location_id,branch_id,class_id,section_id,"
			+ "subject_id,topic_id,subtopic_id,Question_type_id,startdate,enddate,starttime,endtime,testduration,"
			+ "marks_per_qus_type,Total_marks,Negative_marks,total_students_available,exam_type_id,question_level_type_id,createddate,exam_paper_id,is_slot) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?)";

	/*** Login ***/
	public static final String GETROLEIDFROMUSERROLE_QUERY = "select ur.role_id from users us, user_role ur where us.user_name= ? and us.user_id=ur.user_id";
	public static final String LOGINDETAILS_QUERY = "select * from users where lower(user_name)= lower(?) and binary password= ? and status=?";
	public static final String GETUSERSTATUS_QUERY = "select session_id from users where student_id=?";
	public static final String INSERTAUDITLOGS_QUERY = "insert into el_auditlogs (student_id,username,login_date) values(?,?,?);";
	public static final String GETUSERDETAILS_QUERY = "select * from users where student_id=?";
	public static final String INSERTUSERSTATUS_QUERY = "update users set session_id=? where student_id=?";
	public static final String UPDATELOGOUTTIMEINAUDITLOGS_QUERY = "update el_auditlogs set logout_date=? where student_id=? and username=? and login_date=? ";
	
	/*** Student Profile ***/
	public static final String GETUSERPROFILE1_QUERY = "select ur.*,(select cl.el_class_name from el_class cl "
			+ "where cl.el_class_generated_id = ur.el_class_generated_id) as classname ,"
			+ "(select sc.el_section_name from el_section sc where sc.el_section_id = ur.el_section_id)"
			+ " as sectionname,(select br.el_branch_name from el_branch br where "
			+ "br.el_branch_id = ur.el_branch_id) as branchname,(select lc.el_location_name "
			+ "from el_location lc where lc.el_location_id = ur.el_location_id) as locationname,"
			+ "(select st.state_type from el_state_type st where st.state_type_id = ur.state_type_id) "
			+ "as statename from  users ur where ur.user_name=?";
	public static final String GETUSERPROFILE_QUERY = "select * from users where user_name= ?";
	public static final String GETUSEREXISTINGPASSWORD_QUERY = "select password from users where Student_Id=?";
	public static final String GETSTUDENTDETBASEONID_QUERY = "select * from users where Student_Id=?";
	public static final String CHANGEUSERPASSWORD_QUERY = "update users set password=? where Student_Id=?";
	public static final String UPDATEUSERPROFILE_QUERY = "update users set first_name=?, last_name=?, email=?,phone=?,collegename=? where student_id=?";
	
	/*** Welcome User ***/
	public static final String GETSUBJECTNAMESINSUBJECTTABLE_QUERY = "SELECT * FROM el_exam_paper ep, el_subject sj where ep.exam_name=? and ep.subject_id = sj.el_subject_id  group by ep.subject_id;";
	public static final String GETEXAMCOMPLETIONSTATUS_QUERY = "select elh.Exam_Completion_Status, elh.examname,elh.exam_end_date,elh.exam_end_time from temp_exam_history elh where elh.Student_Id=? and elh.location_id=? and elh.branch_id=? and elh.class_id=? and elh.section_id=? and elh.examname=?  group by elh.examname";
	public static final String GETALLINSTRUCTIONDETAILS_QUERY = "select es.el_subject_name,eq.question_type,ex.No_Of_Qus_Per_QusType,ex.marks_per_qus_type,Negative_marks from el_exam ex,el_subject es,el_question_type eq  "
			+ "where ex.subject_id=es.el_subject_id and eq.question_type_id=ex.Question_type_id and exam_name=?";
	public static final String GETBOOKMARKQUESTIONS_QUERY = "select * from el_bookmark_analysis ba,el_questions eq,el_subject sb where ba.Question_Id=eq.Question_Id and ba.Subject_Type_Id=eq.Subject_Type and  ba.Subject_Type_Id=sb.el_subject_id and eq.Subject_Type=sb.el_subject_id and  ba.Student_Id=? order by ba.CreatedDate desc";

	/*** View Result ***/
	public static final String GETEXAMENDDATE_QUERY = "select enddate from el_exam_paper where exam_name=? group by exam_name";
	public static final String USERRESULTS_QUERY = "select *, sum(Correct_Answers) as Correct_Answers_1 from el_student_results sr, el_subject sb where sr.Student_Id=? and sr.el_subject_id=sb.el_subject_id group by sr.Exam_Name order by sr.CreatedDate desc";
	public static final String GETALLUNATTEMTEDFROMFILTERRESULTPOJO_QUERY = "SELECT elq.*,el1.*,sb.el_subject_name FROM  el_questions elq , el_student_result_history el1, el_subject sb "
			+ "where elq.Question_Id= el1.Question_Id  and el1.Student_ID=? and el1.Exam_Name=? "
			+ "and el1.not_answered= 'NA' and elq.subject_type = sb.el_subject_id and el1.el_subject_id = sb.el_subject_id ";
	public static final String GETALLINCCORRECTFROMFILTERRESULTPOJO_QUERY = "SELECT * FROM  el_questions elq , el_student_result_history el1, el_subject sb  where elq.Question_Id= el1.Question_Id   "
			+ "and el1.Student_ID=? and el1.Exam_Name=? and  el1.wrong_answered != 'null' and elq.subject_type = sb.el_subject_id and el1.el_subject_id = sb.el_subject_id ";
	public static final String GETALLFROMFILTERRESULTPOJO_QUERY = "SELECT elq.*,el1.*,sb.el_subject_name FROM  el_questions elq , el_student_result_history el1, el_subject sb  "
			+ "where elq.Question_Id= el1.Question_Id and el1.Student_ID=? and el1.Exam_Name=? and elq.subject_type = sb.el_subject_id and el1.el_subject_id = sb.el_subject_id ";
	public static final String GETEXAMENDTIME_QUERY = "select endtime from el_exam_paper where exam_name=? group by exam_name";
	public static final String GETQUESTIONIDFROMFILTERPOJO_QUERY = "select el1.Question_Id,el1.*,sb.el_subject_name,th.time_difference,elq.ques from "
			+ "temp_exam_history th,el_questions elq , el_student_result_history el1, el_subject sb "
			+ "where elq.Question_Id= el1.Question_Id and th.question_Id=el1.Question_Id  and elq.subject_type = sb.el_subject_id "
			+ "and el1.el_subject_id = sb.el_subject_id and th.examname=el1.Exam_Name and  el1.Student_ID=? and el1.Exam_Name=? "
			+ "and th.examname=? and th.student_id=? and (el1.right_answered != 'null' and el1.right_answered != '')  group by th.question_Id";
	public static final String GETMINTIMEFROMFILTERRESULTS_QUERY = "select min(th.time_difference)  from temp_exam_history th,el_questions elq , el_student_result_history el1, el_subject sb where"
			+ " elq.Question_Id= el1.Question_Id and th.question_Id=el1.Question_Id  and elq.subject_type = sb.el_subject_id and "
			+ "el1.el_subject_id = sb.el_subject_id and th.examname=el1.Exam_Name and  el1.Exam_Name=?  and th.examname=?   "
			+ "and el1.right_answered != 'null' and th.question_Id=?";
	
	/*** Self performance Analysis ***/
	public static final String GETEXAMTYPEFORSELFASSESSMENT_QUERY = " select ex.Exam_Type,ex.Exam_Type_Id from el_student_results es,el_exam_type ex,el_exam eh  where es.Exam_Name=eh.Exam_Name and ex.Exam_Type_Id=eh.Exam_Type_Id group by eh.Exam_Type_Id";
	public static final String GETSELFASSSESSMENTDETAILS_QUERY = "select * from el_student_results es,el_exam eh,el_exam_type ex where es.Exam_Name=eh.Exam_Name  and ex.Exam_Type_Id=eh.Exam_Type_Id and ex.Exam_Type_Id=? and es.Student_Id=? group by es.Student_Id,es.Exam_Name";

	/*** Ranks ***/
	public static final String GETTOPPERSLISTBASEDONEXAMANME_QUERY = "SELECT s1.Exam_Name,(select concat(u.first_name,' ',u.last_name)  from users u where u.student_id=s1.Student_Id ) as name,s1.total_marks, s1.EXAM_SCORED_MARKS , (select count(DISTINCT s2.EXAM_SCORED_MARKS) from el_student_results s2 where  s2.Exam_Name=? and s2.EXAM_SCORED_MARKS > s1.EXAM_SCORED_MARKS or (s2.EXAM_SCORED_MARKS = s1.EXAM_SCORED_MARKS)  ) as rank1 FROM el_student_results s1 WHERE s1.Exam_Name=? GROUP BY s1.Student_Id having rank1<=100 ORDER BY s1.EXAM_SCORED_MARKS DESC;";
	public static final String GETEXAMNAMESFORTOPRANKS_QUERY = "select sr.Exam_Name,et.Exam_Type from el_student_results sr,el_exam ex,el_exam_type et where sr.Exam_Name=ex.exam_name and ex.exam_type_id=et.Exam_Type_Id group by sr.Exam_Name order by et.Exam_Type_Id";

	/*** Login with OTP ***/
	public static final String RETRIVEEMAILIDFROMUSERNAME_QUERY = "select email from users where user_name=?";
	public static final String RETRIVESTUDENTIDFROMUSERNAME_QUERY = "select * from users where user_name=?";
	public static final String GETEMAILIDFROMUSERNAME_QUERY = "select count(*) from users where user_name=?";
	public static final String UPDATEOTP_QUERY = "update users set otp_code=? where email=? and user_name=?";
	public static final String VALIDATEOTP_QUERY = "select * from users where user_name=? and otp_code=?";
	public static final String GETPASSWORDFROMFORGOTPASSWORDPAGE_QUERY = "select * from users where email=?";

	/*** Registration ***/
	public static final String REGISTER_QUERY = "INSERT INTO users (first_name,last_name,password, user_name, email,phone,status,student_Id,created,modified,collegename) values(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String FINDALL_QUERY = "select * from users where email= ? OR phone= ? OR user_name= ?";

	/*** Delete Exam Paper ***/
	public static final String DELETEEXAMPAPERINTAB_QUERY = "delete from el_exam_paper1 where exam_name=?";
	public static final String GETEXAMINBETDATE_QUERY = "select exam_name, startdate,enddate from el_exam_paper where enddate< ? group by exam_name";
	public static final String DELTEMPNOTSTARTEDEXAMS_QUERY = "delete from temp_exam_history where examname=? and Exam_Completion_Status=?";

	/*** Login Service calls ***/
	public static final String GETUSERPASSWORD_QUERY = "select password from users where lower(user_name)= lower(?);";
	public static final String CHECKUSEREXISTORNOT_QUERY = "select count(*) from users where lower(user_name)= lower(?)";
	
	/*** Admin Submit exam ***/
	public static final String GETSTUDENTDETAILSFROMUSERTABLE_QUERY = "select * from users where student_id=?";

	/*** Result Calculation ***/
	public static final String GETRESULTSFORDISPLAY_QUERY = "select sub.el_subject_name,sr.subject_total_marks,sr.EXAM_SCORED_MARKS,sr.Correct_Answers,sr.wrong_answers,sr.not_answered,sr.negative_marks,sr.SCORED_MARKS,sr.total_marks from el_student_results sr,el_subject sub "
			+ "where sub.el_subject_id=sr.el_subject_id and sr.exam_name=? and sr.student_id=? group by sub.el_subject_name";
	public static final String UPDATESTUDENTRESULTSSUBJMARKS_QUERY = "update el_student_results set Correct_Answers=?,Wrong_Answers=? ,not_answered=?,SCORED_MARKS=? where Student_Id=? and Exam_Name=? and el_subject_id=?";
	public static final String UPDATESTUDENTRESULTSHISTORY_QUERY = "update el_student_result_history set right_answered=?,not_answered=?,wrong_answered=?,actual_score=? where Exam_Name=? and Student_ID=? and Question_Id=? and el_subject_id=? and exam_paper_id=?";
	public static final String GETSUBJECTNAMESINEXAM_QUERY = "select subject_id from el_exam_paper where exam_name=? group by subject_id";
	public static final String UPDATEINTOTEMPHISTORY_QUERY = "update temp_exam_history set Exam_Completion_Status=?,endtime=?,actual_exam_start_time=? where  Student_Id=? and examname=? ";
	public static final String GETCOUNTOFSUBJECTNAMESINEXAM_QUERY = "select count(*) from (select subject_id from el_exam_paper where exam_name=? group by subject_id) as tbl";
	public static final String GETEXAMDATAINTEMPHISTORY_QUERY = "select question_Id,case when selected_answer='' then null else selected_answer end as selected_answer,subjectid,Exam_Completion_Status,exam_paper_id"
			+ " from temp_exam_history where examname=? and Student_Id=? and Exam_Completion_Status=? and subjectid=? ";
	public static final String GETQUSTYPEBASEDONQUESTIONIB_QUERY = "select question_type_id from el_question_type where question_type=(select Question_Type from el_questions where Question_Id=?)";
	public static final String GETSCOREDMARKSINDEMOEXAM_QUERY = "select marks_per_qus_type from el_exam_paper where exam_name=? and Question_type_id=? and subject_id=? group by Question_type_id";
	public static final String GETNEGATIVEMARKSINEXAMPAPER_QUERY = "select Negative_marks from el_exam_paper where exam_name=? and Question_type_id=? and subject_id=? group by Question_type_id";
	public static final String UPDATEEXAMSCOREDMARKS_QUERY = "update el_student_results set EXAM_SCORED_MARKS=? where Student_Id=? and Exam_Name=?";
	public static final String GETCORRECTANSWER_QUERY = "select answer from el_questions where Question_Id= ?";
	public static final String INSERTDATAINTOFILTERRESULT_QUERY = "insert into el_student_result_history(Student_ID,Exam_Name,Question_Id,right_answered,not_answered,wrong_answered,el_subject_id,createddate,modifieddate,correct_answer,marks_per_qus_type,negative_marks,section,campus,state,el_location_id,class_id,actual_score,exam_conducted_date,studentname, exam_paper_id) "
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/*** Temp History ***/
	public static final String GETMARKFORREIVEWCNT_QUERY = "select count(*) from (select * from temp_exam_history where  ( ismark_review='MR')  and examname=? and Student_Id=? and subjectid=? ) as tb";
	public static final String GETINTIALTIMEVALUEINTEMP1_QUERY = "select count(*) from temp_exam_history where  examname=? and Student_Id=? and actual_answer_question_time is not null";
	public static final String GETINTIALTIMEVALUEINTEMP_QUERY = "select  max(actual_answer_question_time)   from temp_exam_history where  examname=? and Student_Id=?";
	public static final String UPDATETEMPHISYPACKAGE1_QUERY = "update temp_exam_history set selected_answer=?, time_taken_value=?,actual_answer_question_time=?, time_difference=? where question_Id=? and Student_Id=? and examname=?  and exam_paper_id=?";
	public static final String GETCOUNTFORUNATTEMPTFOREXAM_QUERY = "select count(selected_answer) from temp_exam_history where selected_answer is not null and not(selected_answer ='') and examname=? and Student_Id=? ";
	public static final String GETUNATTEMPTEDCOUNTFORSUBJ_QUERY = "select count(*) from (select * from temp_exam_history where (selected_answer is null or selected_answer ='') and examname=? and Student_Id=? and subjectid=?) as tb";
	public static final String GETATTEMPTEDCOUNTFORSUBJ_QUERY = "select count(selected_answer) from temp_exam_history where selected_answer is not null and not(selected_answer ='') and examname=? and Student_Id=? and subjectid=?";
	public static final String INSERTMARKFORREVIEWVALUE_QUERY = "update temp_exam_history set ismark_review = ? where examname=? and Student_Id=? and subjectid=? and question_Id=? and exam_paper_id=?";
	public static final String GETMARKFORREVIEWNOTANSWEREDCOUNTFORSUBJ_QUERY = "select count(*) from temp_exam_history where ismark_review = ? and examname=? and Student_Id=? and subjectid=?";
	public static final String GETMARKFORREVIEWANSWEREDCOUNTFORSUBJ_QUERY = "select count(*) from temp_exam_history where ismark_review =? and examname=? and Student_Id=? and subjectid=?";
	public static String GETALLTEMPHISYPACKAGE_QUERY1(String questionid, String examname, String subjectid,
			String studentid, String qrowid) {
		return "select * from  temp_exam_history where question_Id= " + questionid + " and examname = '" + examname
				+ "' " + "and subjectid = '" + subjectid + "' and Student_Id = '" + studentid + "' and exam_paper_id = "
				+ qrowid + " ";
	}

	/*** Dash board user start exam ***/
	public static final String GETTIMEBASEDONSELECTEDEXAM_QUERY = "select testduration from el_exam_paper where exam_name=?  group by exam_name";
	public static final String GETNOOFQUESTIONS_QUERY = "SELECT count(*) FROM el_exam_paper ep where ep.exam_name=? ";
	public static final String GETENDTIMEINEXAMPAPER_QUERY = "SELECT ep.endtime FROM el_exam_paper ep where ep.exam_name=? group by ep.exam_name";
	public static final String GETEXAMTYPEIDBASEDONEXAMNAME_QUERY = "select exam_type_id from el_exam where exam_name=? group by exam_name";
	public static final String GETPATTERNIDBASEDONEXAMTYPE_QUERY = "select Ifnull((select ifnull(pattern_type_id,0) from el_exam_pattern where Exam_Type_Id=? group by pattern_type_id),0)";
	public static final String GETENDTIMEINTEMPHOSTORY_QUERY = "select exam_end_time from temp_exam_history where examname=? and Student_Id=? group by examname";
	public static final String GETENDDATEINTEMPHOSTORY_QUERY = "select exam_end_date from temp_exam_history where examname=? and Student_Id=? group by examname";
	public static final String FINDQUESTIONIDAVAILABLEINBOOKMARK_QUERY = "select count(*) from el_bookmark_analysis ba where ba.student_id= ? and ba.question_id= ? and exam_name=?";
	public static final String UPDATERESUMETIMEINAUDITLOGS_QUERY = "update el_auditlogs set exam_resume_date=? where  student_id=? and username=? and exam_name=?";
	public static final String GETENDTIMEFROMTEMPHISTORYPACKAGE_QUERY = "select elh.endtime from temp_exam_history elh where  elh.Student_Id=? and elh.examname=? and elh.location_id=? and elh.branch_id=? and elh.class_id=? and elh.section_id=?  group by elh.examname";
	public static final String GETDISPLAYQUESTIONS_QUERY = "SELECT * FROM el_exam_paper1 ep,el_questions eq where ep.exam_name=? and ep.Question_id=eq.Question_Id and ep.subject_id=eq.subject_type order by rand()";
	public static final String GETCOUNTOFANSWERSFROMTEMPHISTORYPACKAGE_QUERY = "SELECT count(*) FROM temp_exam_history elh where elh.Student_Id=? and elh.examname=? and elh.location_id=? and elh.branch_id=? and elh.class_id=? and elh.section_id=? and elh.selected_answer is not null";
	public static final String GETCOUNTFOREXISTINGTEMPHISTORY_QUERY = "select count(*) from temp_exam_history where examname=? and Student_Id=? ";
	public static final String GETISJUMBLINGYESORNOBASEDONEXAMNAME_QUERY = "SELECT is_jumbling FROM el_exam_paper where exam_name=? group by exam_name  ";
	public static final String GETCOUNTFOREXISTINGRESULTS_QUERY = "select count(*) from el_student_result_history where Exam_Name=? and Student_Id=?";
	public static final String COUNTOFEXISTINGTEST_QUERY = "select count(exam_name) from el_auditlogs where student_id=? and username=? and login_date=? and exam_name=?";
	public static final String INSERTNEXTROWDATAINAUDITLOGS_QUERY = "insert into el_auditlogs (student_id,username,login_date,exam_name,exam_start_date) values(?,?,?,?,?);";
	public static final String INSERTEXAMSTARTTIME_QUERY = "update el_auditlogs set exam_name=?,exam_start_date=?  where student_id=? and username=? and login_date=? ";
	public static final String DELETETEMPDATABASEDONEXAMNAME_QUERY = "delete  from temp_exam_history where Student_Id=? and examname=?";
	public static final String GETCOUNTOFQUESTIONSINEXAMPAPER_QUERY = "select count(*) from el_exam_paper where exam_name=?";
	public static final String GETLEASTTIMEFROMTEMPHISTORYPACKAGE_QUERY = "select ifnull(MIN(time_taken_value),'00:00:00') from temp_exam_history elh where elh.Student_Id=? and elh.location_id=? and elh.branch_id=? and elh.class_id=? and elh.section_id=? and examname=?";
	public static final String INSERTBOOKMARKANALYSISDATA_QUERY = "INSERT INTO el_bookmark_analysis (Exam_name,Question_Id,Student_Id,Subject_Type_Id,Bookmark_Status_Type_Id,el_class_generated_id,el_branch_id,el_section_id, el_location_id, CreatedDate, Expire_Date) values(?,?,?,?,?,?,?,?,?,?,?)";
	
	/*** Submit Exam ***/
	public static final String GETSUBJECTWISEMARKSFOREXAM_QUERY = "select sum(total_marks) as total_marks  from el_exam where exam_name=? and subject_id=?";
	public static final String INSERTSTUDENTRESULTS_QUERY = "insert into el_student_results(Student_Id,Exam_Name,el_subject_id,SCORED_MARKS,Total_Questions,Correct_Answers,Total_Time,CreatedDate,studentname,section,campus,state, class_id, el_location_id,Time_Taken,total_marks,total_students_available,exam_conducted_date,negative_marks,wrong_answers,not_answered,subject_total_marks) "
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GETTOTALMARKSANDTOTALAVAILABLESTUDENTS_QUERY = "select sum(total_marks) as total_marks,total_students_available,startdate from el_exam "
			+ "where exam_name=? group by exam_name";
	public static final String GETUPDATEEXAMCOMPLETIONSTATUS_QUERY = "update temp_exam_history elh set elh.Exam_Completion_Status='Finish' where elh.Student_Id=? and elh.examname=? and elh.location_id=? and elh.branch_id=? and elh.class_id=? and elh.section_id=?";
	public static final String UPDATEEXAMENDTIMEINAUDITLOGS_QUERY = "update el_auditlogs set exam_end_date=?  where student_id=? and username=? and  exam_name=?";
	public static final String GETNOOFQUESTIONS1_QUERY = "SELECT count(*) FROM temp_exam_history ep where ep.examname=? and ep.student_id=?";
	
	
}
