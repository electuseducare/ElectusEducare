package com.educare.admin.sqlStatements;

public class AdminSqlQueries {
	private AdminSqlQueries() {}
	
	public static final String GETDETAILSOFALLUSERSFORADMIN1 = "select * from  users";
	public static final String GETSUBJECTWISERMARKSRANGESFORADMINOFFLINE_QUERY = "select eb.el_branch_name,es.campus from el_offline_exam_results es,el_branch eb where es.campus=eb.el_branch_id and exam_name=? and es.el_subject_id=? group by eb.el_branch_name";
	public static final String UPDATEKEYINSTURESHIS_QUERY = "update el_student_result_history set correct_answer=? where Question_Id=? ";
	public static final String GETSTUDENTNAMES_QUERY = "select user_name,student_id from users where el_class_generated_id=? and el_section_id=?";
	 /*Copy previous created exam pattern with out slot*/
	public static final String GETEXAMNAMEFORCOPYEXAMWITHNOSLOT_QUERY = "select Exam_Name from el_exam where is_slot=? group by Exam_Name ";

	/*** AED State ***/
	public static final String SEARCHSTATESFROMADMIN1_QUERY = "select count(*) from el_state_type where state_type=?";
	public static final String SEARCHSTATESFROMADMIN_QUERY = "select * from el_state_type order by state_type_id asc";
	public static final String INSERTSTATEFROMADMIN_QUERY = "insert into el_state_type(state_type,state_type_id,createddate,modifieddate) values(?,?,?,?)";
	public static final String UPDATESTATE_QUERY = "update el_state_type set state_type=? where state_type_id=?";
	public static final String DELETESTATEFROMADMIN_QUERY = "delete from el_state_type where state_type_id=?";
	public static final String DELETELOCATIONBASEDONSTATE_QUERY = "delete from el_location where state_type_id=?";
	public static final String GETMAXSTATEID_QUERY = "select ifnull(max(state_type_id),0) from el_state_type";
	public static final String GETLASTNUMBERFROMEL_STATE_TYPE_QUERY = "SELECT state_type_id FROM el_state_type ORDER BY state_type_id DESC LIMIT 1";

	/*** AED location ***/
	public static final String SEARCHEXISTLOCATIONFROMADMIN_QUERY = "select * from el_location lc, el_state_type st where lc.state_type_id = st.state_type_id order by lc.el_location_id asc";
	public static final String INSERTLOCATIONFROMADMIN_QUERY = "insert into el_location(el_location_name,el_location_id,createddate,modifieddate,state_type_id) values(?,?,?,?,?)";
	public static final String SEARCHLOCATIONSFROMADMIN1_QUERY = "select count(*) from el_location where el_location_name=? and "
			+ "state_type_id=(select state_type_id from el_state_type where state_type=?)";
	public static final String UPDATELOCATIONFROMADMIN_QUERY = "update el_location set el_location_name=? where el_location_id=?";
	public static final String SEARCHLOCATIONSFROMADMINBASEDONSTATES_QUERY = "select * from el_location where state_type_id=?";
	public static final String DELETEBRANCHBASEDONLOCATION_QUERY = "delete from el_branch where el_location_id=?";
	public static final String GETMAXLOCATIONUSERID_QUERY = "select ifnull(max(el_location_id),0) from el_location";
	public static final String GETLASTNUMBERFROMLOCATION_QUERY = "SELECT el_location_id FROM el_location ORDER BY el_location_id DESC LIMIT 1";
	public static final String DELETELOCATIONFROMADMIN_QUERY = "delete from el_location where el_location_id=?";

	/*** AED Branch ***/
	public static final String SEARCHBRANCHESFROMADMINBASEDONLOCATION_QUERY = "select * from el_branch where el_location_id=?";
	public static final String SEARCHEXISTBRANCHFROMADMIN_QUERY = "select * from el_branch br,el_location lc where br.el_location_id=lc.el_location_id order by el_branch_id asc";
	public static final String SEARCHBRANCHESFROMADMIN1_QUERY = " select count(*) from el_branch where el_branch_name=? "
			+ "and el_location_id=(select el_location_id from el_location where el_location_name=? and state_type_id=?)";
	public static final String INSERTBRANCHFROMADMIN_QUERY = "insert into el_branch(el_branch_name,el_branch_id,createddate,modifieddate,el_location_id) values(?,?,?,?,?)";
	public static final String UPDATEBRANCHFROMADMIN_QUERY = "update el_branch set el_branch_name=? where el_branch_id=?";
	public static final String DELETEBRANCHFROMADMIN_QUERY = "delete from el_branch where el_branch_id=?";
	public static final String GETMAXBRANCHUSERID_QUERY = "select ifnull(max(el_branch_id),0) from el_branch";
	public static final String GETLASTNUMBERFROMBRANCH_QUERY = "SELECT el_branch_id FROM el_branch ORDER BY el_branch_id DESC LIMIT 1";

	/*** AED Class ***/
	public static final String SEARCHEXISTCLASSFROMADMIN_QUERY = "select * from el_class order by el_class_generated_id  asc";
	public static final String INSERTCLASSFROMADMIN_QUERY = "insert into el_class(el_class_name,el_class_generated_id,created_date,modified_date) values(?,?,?,?)";
	public static final String SEARCHCLASSESFROMADMIN1_QUERY = "select count(*) from el_class where el_class_name=?";
	public static final String UPDATECLASSFROMADMIN_QUERY = "update el_class set el_class_name=? where el_class_generated_id=?";
	public static final String DELETECLASSFROMADMIN_QUERY = "DELETE FROM el_class Where el_class_generated_id=?";
	public static final String DELETESUBJECTBASEDONCLASS_QUERY = "delete from el_subject where el_class_generated_id=?";
	public static final String DELETESECTIONBASEDONCLASS_QUERY = "delete from el_section where el_class_generated_id=?";
	public static final String DELETESUJECTTOPICSONCLASS_QUERY = "delete from el_subject_subtopic_type where el_class_generated_id=?";
	public static final String GETMAXCLASSUSERID_QUERY = "select ifnull(max(el_class_generated_id),0) from el_class";
	public static final String GETLASTNUMBERFROMCLASS_QUERY = "SELECT el_class_generated_id FROM el_class ORDER BY el_class_generated_id DESC LIMIT 1";

	/*** AED Section ***/
	public static final String SEARCHEXISTSECTIONFROMADMIN_QUERY = "select * from el_class cl,el_section se where cl.el_class_generated_id=se.el_class_generated_id order by se.el_section_id asc";
	public static final String SEARCHEXISTSECTIONFROMADMIN1_QUERY = "select * from el_class cl,el_section se where cl.el_class_generated_id=se.el_class_generated_id and se.el_class_generated_id=?";
	public static final String INSERTSECTIONFROMADMIN_QUERY = "insert into el_section(el_section_name,el_section_id,createddate,modifieddate, el_class_generated_id) values(?,?,?,?,?)";
	public static final String SEARCHSECTIONFROMADMIN1_QUERY = "select count(*) from el_section where el_section_name=? "
			+ "and el_class_generated_id=(select el_class_generated_id from el_class where el_class_name=?)";
	public static final String UPDATESECTIONFROMADMIN_QUERY = "update el_section set el_section_name=? where el_section_id=?";
	public static final String DELETESECTIONFROMADMIN_QUERY = "delete from el_section where el_section_id=?";
	public static final String GETMAXSECTIONUSERID_QUERY = "select ifnull(max(el_section_id),0) from el_section";
	public static final String GETLASTNUMBERFROMSECTION_QUERY = "SELECT el_section_id FROM el_section ORDER BY el_section_id DESC LIMIT 1";

	/*** AED Subject ***/
	public static final String SEARCHEXISTSUBJECTFROMADMIN_QUERY = "select * from el_class cl, el_subject st where cl.el_class_generated_id = st.el_class_generated_id order by st.el_subject_id asc";
	public static final String SEARCHEXISTSUBJECTFROMADMIN1_QUERY = "select * from el_class cl, el_subject st where cl.el_class_generated_id = st.el_class_generated_id and st.el_class_generated_id=?";
	public static final String INSERTSUBJECTFROMADMIN_QUERY = "insert into el_subject(el_subject_name,el_subject_id,createddate,modifieddate,el_class_generated_id) values(?,?,?,?,?)";
	public static final String SEARCHSUBJECTFROMADMIN1_QUERY = "select count(*) from el_subject where el_subject_name=? "
			+ "and el_class_generated_id=(select el_class_generated_id from el_class where el_class_name=?)";
	public static final String UPDATESUBJECTFROMADMIN_QUERY = "update el_subject set el_subject_name=? where el_subject_id=?";
	public static final String GETTOPICIDSBASEDONSUBJECTID_QUERY = "select subject_topic_type_id from el_subject_topic_type where subject_type_id=?";
	public static final String DELETESUBTOPICSBASEDONTOPICID_QUERY = "delete from el_subject_subtopic_type where subject_topic_type_id=?";
	public static final String DELETETOPICSBASEDONSUBJECTID_QUERY = "delete from el_subject_topic_type where subject_type_id=?";
	public static final String GETMAXSUBJECTUSERID_QUERY = "select ifnull(max(el_subject_id),0) from el_subject";
	public static final String GETLASTNUMBERFROMSUBJECT_QUERY = "SELECT el_subject_id FROM el_subject ORDER BY el_subject_id DESC LIMIT 1";
	public static final String DELETESUBJECTFROMADMIN_QUERY = "delete from el_subject where el_subject_id=?";

	/*** AED Exam Type ***/
	public static final String SEARCHEXAMTYPEFROMADMIN_QUERY = "select * from el_exam_type where Exam_Type_Id not in(0) order by Exam_Type_Id asc";
	public static final String INSERTEXAMTYPEFROMADMIN_QUERY = "insert into el_exam_type(Exam_Type,Exam_Type_Id,CreatedDate) values(?,?,?)";
	public static final String SEARCHEXAMTYPEFROMADMIN1_QUERY = "select count(*) from el_exam_type where Exam_Type=?";
	public static final String UPDATEEXAMTYPEFROMADMIN_QUERY = "update el_exam_type set Exam_Type=? where Exam_Type_Id=?";
	public static final String DELETEEXAMTYPEFROMADMIN_QUERY = "DELETE FROM el_exam_type Where Exam_Type_Id=?";
	public static final String GETMAXEXAMTYPEID_QUERY = "select max(Exam_Type_Id) from el_exam_type";
	public static final String GETLASTNUMBERFROMELEXAMTYPE_QUERY = "SELECT Exam_Type_Id FROM el_exam_type ORDER BY Exam_Type_Id DESC LIMIT 1";

	/*** AED Subject Topic ***/
	public static final String GETTOPICSSUBTOPICSFROMQUESTIONS_QUERY = "select qs.exam_type, et.exam_type_id, st.el_subject_id,st.el_subject_name,qs.topic,qs.subtopic,cl.el_class_name,cl.el_class_generated_id, stt.subject_topic_type, CASE when qs.subtopic in(sst.subject_subtopic_type_id) then sst.subject_subtopic_type ELSE '' End as subject_subtopic_type  from el_questions qs left join el_subject st on qs.subject_type=st.el_subject_id left join el_class cl on st.el_class_generated_id=cl.el_class_generated_id left join el_exam_type et on qs.exam_type = et.Exam_Type left join el_subject_topic_type stt on qs.topic=stt.subject_topic_type_id and st.el_subject_id=stt.subject_type_id and cl.el_class_generated_id = stt.el_class_generated_id and et.Exam_Type_Id=stt.exam_type_id left join el_subject_subtopic_type sst on stt.subject_topic_type_id=sst.subject_topic_type_id and stt.el_class_generated_id = sst.el_class_generated_id and stt.subject_type_id=sst.subject_type_id and stt.exam_type_id = sst.exam_type_id and qs.subtopic = sst.subject_subtopic_type_id where cl.el_class_generated_id=? and et.exam_type_id=?   group by qs.topic, qs.subtopic,qs.subject_type,qs.Exam_Type";
	public static final String GETTOPICSSUBTOPICSFROMQUESTIONSALL_QUERY = "select qs.exam_type, et.exam_type_id, st.el_subject_id,st.el_subject_name,qs.topic,qs.subtopic,cl.el_class_name,cl.el_class_generated_id, stt.subject_topic_type, CASE when qs.subtopic in(sst.subject_subtopic_type_id) then sst.subject_subtopic_type ELSE '' End as subject_subtopic_type  from el_questions qs left join el_subject st on qs.subject_type=st.el_subject_id left join el_class cl on st.el_class_generated_id=cl.el_class_generated_id left join el_exam_type et on qs.exam_type = et.Exam_Type left join el_subject_topic_type stt on qs.topic=stt.subject_topic_type_id and st.el_subject_id=stt.subject_type_id and cl.el_class_generated_id = stt.el_class_generated_id and et.Exam_Type_Id=stt.exam_type_id left join el_subject_subtopic_type sst on stt.subject_topic_type_id=sst.subject_topic_type_id and stt.el_class_generated_id = sst.el_class_generated_id and stt.subject_type_id=sst.subject_type_id and stt.exam_type_id = sst.exam_type_id and qs.subtopic = sst.subject_subtopic_type_id where cl.el_class_generated_id=? and et.exam_type_id=? and st.el_subject_id=? group by qs.topic, qs.subtopic,qs.subject_type,qs.Exam_Type";
	public static final String GETSUNBASEONCLASS_QUERY = "select * from el_subject where el_class_generated_id=?";
	public static final String GETCOUNTOFTOPICSAVAILABLE_QUERY = "select count(*) from el_subject_topic_type where el_class_generated_id=? and subject_type_id=? and subject_topic_type_id=? and exam_type_id=?";
	public static final String GETCOUNTOFSUBTOPICSAVAILABLE_QUERY = "select count(*) from el_subject_subtopic_type where exam_type_id =? and el_class_generated_id=? and subject_topic_type_id=? and subject_subtopic_type_id=? and subject_type_id=?";
	public static final String INSERTDATAINTOSUBJECTTOPICTYPETABLE_QUERY = "INSERT INTO el_subject_topic_type (el_class_generated_id, subject_type_id, subject_topic_type_id, subject_topic_type, CreatedDate, ModifiedDate,exam_type_id) VALUES (?,?,?,?,?,?,?)";
	public static final String UPDATEDATAINTOSUBJECTTOPICTYPETABLE_QUERY = "update el_subject_topic_type set subject_topic_type=? where el_class_generated_id=? and subject_type_id=? and subject_topic_type_id=? and exam_type_id=?";
	public static final String INSERTDATAINTOSUBJECTSUBTOPICTYPETABLE_QUERY = "insert into el_subject_subtopic_type(subject_subtopic_type,subject_subtopic_type_id,"
			+ "subject_topic_type_id,CreatedDate,ModifiedDate,el_class_generated_id, subject_type_id, exam_type_id) values(?,?,?,?,?,?, ?,?)";
	public static final String UPDATEDATAINTOSUBJECTSUBTOPICTYPETABLE_QUERY = "update el_subject_subtopic_type set subject_subtopic_type=? where subject_topic_type_id=? and subject_subtopic_type_id=? and el_class_generated_id=? and subject_type_id=? and exam_type_id=?";

	/*** Question Type ***/
	public static final String SEARCHEXISTQUESTIONTYPFROMADMIN_QUERY = "select * from el_question_type";
	public static final String UPDATEQUESTIONTYPEFROMADMIN_QUERY = "update el_question_type set question_type=? where question_type_id=?";

	/*** AED Question Level Type ***/
	public static final String SEARCHQUESTIONLEVELFROMADMIN_QUERY = "select * from el_question_level_type where Question_Level_Type_Id not in(0) order by Question_Level_Type_Id asc";
	public static final String INSERTQUESTIONLEVELFROMADMIN_QUERY = "insert into el_question_level_type(Question_Level_Type,Question_Level_Type_Id,CreatedDate) values(?,?,?)";
	public static final String SEARCHQUESTIONLEVELFROMADMIN1_QUERY = "select count(*) from el_question_level_type where Question_Level_Type=?";
	public static final String UPDATEQUESTIONLEVELFROMADMIN_QUERY = "update el_question_level_type set Question_Level_Type=? where Question_Level_Type_Id=?";
	public static final String DELETEQUESTIONLEVELFROMADMIN_QUERY = "DELETE FROM el_question_level_type Where Question_Level_Type_Id=?";
	public static final String GETMAXQUESTIONLEVELID_QUERY = "select case when  max(Question_Level_Type_Id) is null then '0' else  max(Question_Level_Type_Id) end  from el_question_level_type";
	public static final String GETLASTNUMBERFROMQUESTIONLEVEL_QUERY = "SELECT Question_Level_Type_Id FROM el_question_level_type ORDER BY Question_Level_Type_Id DESC LIMIT 1";

	/*** Filter Criteria ***/
	public static final String GETCLASSIDBASEDONFILENMAE_QUERY = "select cl.el_class_generated_id from el_questions qu,el_subject sb,el_class cl where qu.import_file_name=? and qu.subject_type=sb.el_subject_id and cl.el_class_generated_id=sb.el_class_generated_id";
	public static final String GETEXAMTYPEBASEDONFILENAME_QUERY = "SELECT et.Exam_Type_Id FROM el_questions eq,el_exam_type et where eq.import_file_name=? and eq.Exam_Type=et.Exam_Type;";
	public static final String GETSUBJIDBASEDONFILENAME_QUERY = "SELECT subject_type FROM el_questions where import_file_name=?";
	public static final String GETTOPICIDSBASEDONFILENAME_QUERY = "SELECT topic FROM el_questions where import_file_name=?";

	/*** Student Bulk Update ***/
	public static final String GETUSERNAMEANDEMAIL_QUERY = "select count(*) from users where user_name=? or email=?";
	public static final String INSERTBULKDATAINTOUSERS_QUERY = "INSERT INTO users (student_Id,first_name,last_name,user_name,email,password,phone,status,el_class_generated_id,el_section_id,el_branch_id,state_type_id,el_location_id,created,modified,session_id)"
			+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	public static final String GETUSERNAMEANDEMAIL1_QUERY = "select count(*) from users where user_name=? and email=?";
	public static final String USERROLEIDALREADYEXISTCOUNT_QUERY = "select count(*) from users us,user_role ur where us.user_id=ur.user_id and us.user_name=?";

	/*** AED Admin/AED Lecturer ***/
	public static final String GETDETAILSOFALLADMINFORADMIN1_QUERY = "select * from users us,user_role ur where us.user_id=ur.user_id and ur.role_id=? order by student_id asc ";
	public static final String GETDETAILSOFALLADMINFORADMIN_QUERY = "select * from users";
	public static final String INSERTSTUDENTFROMADMIN_QUERY = "insert into users(student_id,first_name,last_name,user_name,password,state_type_id,el_location_id,el_branch_id,el_class_generated_id,el_section_id,email,phone,created,modified,session_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATESTUDENTDETAILSFROMADMIN_QUERY = "update users set student_id=?, first_name=?, last_name=?, user_name=?, email=?, password=?, phone=?, state_type_id=?, el_location_id=?, el_branch_id=?, el_class_generated_id=?, el_section_id=?, session_id=? where user_id=?";
	public static final String DELETESTUDENTFROMADMIN_QUERY = "delete from users where user_id=?";
	public static final String DELETEUSERFROMUSERROLE_QUERY = "delete from user_role where user_id=?";
	public static final String GETDETAILSOFALLLECTURERFORADMIN_QUERY = "select * from users where student_id regexp '^[L]+' order by student_id asc";

	/*** AED Student ***/
	public static final String GETMAXUSERIDFROMUSERS_QUERY ="select max(user_id) from users";
	public static final String GETUSERNAMENADEMAILOFADMINFROMUSERBASDONCLASSSEC_QUERY = "SELECT * FROM users us,el_class ec,"
			+ "el_section es,el_branch eb,el_location el,el_state_type est where us.el_class_generated_id=ec.el_class_generated_id "
			+ "and us.el_section_id=es.el_section_id and us.el_branch_id=eb.el_branch_id and "
			+ "us.el_location_id=el.el_location_id and us.state_type_id=est.state_type_id and "
			+ "us.el_class_generated_id=? and us.el_section_id=?   order by us.student_id asc";
	public static final String GETDETAILSOFALLUSERSFORADMINBASEDONSTUD_QUERY = "SELECT * FROM users us,el_class ec,"
			+ "el_section es,el_branch eb,el_location el,el_state_type est where us.el_class_generated_id=ec.el_class_generated_id "
			+ "and us.el_section_id=es.el_section_id and us.el_branch_id=eb.el_branch_id and "
			+ "us.el_location_id=el.el_location_id and us.state_type_id=est.state_type_id and "
			+ "us.el_class_generated_id=? and us.el_section_id=? and us.student_id=?  order by us.student_id asc";
	public static final String GETUSERNAMENADEMAILOFADMINFROMUSER_QUERY = "select count(*) from  users where user_name=? or email=?";
	public static final String GETSECTIONSFROMCLASS_QUERY = "select * from el_class cl,el_section se where cl.el_class_generated_id=se.el_class_generated_id and cl.el_class_generated_id=? order by cl.el_class_generated_id";
	public static final String GETMAILID_QUERY = "select * from el_mails";

	/*** Create Exam ***/
	public static final String SEARCHEXAMTYPESFROMADMIN_QUERY = "select * from el_exam_type order by exam_type_id";
	public static final String SEARCHQUESTIONLEVELTYPESFROMADMIN_QUERY = "select * from el_question_level_type order by question_level_type_id";
	public static final String GETSUBJECTSFROMCLASS_QUERY = "select * from el_class cl, el_subject st where cl.el_class_generated_id = st.el_class_generated_id and cl.el_class_generated_id=? order by cl.el_class_generated_id";
	public static final String GETTOPICSINSUBJECT_QUERY = "select * from el_subject_topic_type where subject_type_id in(?) and exam_type_id=?  group by subject_topic_type order by subject_type_id";
	public static final String GETALLSUBTOPICSINSUBJECT1_QUERY = "SELECT st.*,concat(substring_index(tt.subject_topic_type,' ',1),' - ',st.subject_subtopic_type) as topicname FROM el_subject_subtopic_type st,el_subject_topic_type tt where st.exam_type_id=? and  st.subject_type_id=? and st.subject_topic_type_id=tt.subject_topic_type_id and st.exam_type_id=tt.exam_type_id and st.subject_type_id=tt.subject_type_id  group by st.subject_subtopic_type order by st.subject_type_id";
	public static final String GETCOUNTOFTOTALSTUDENTSAVAILABLE_QUERY = "select count(*) from users us where us.el_class_generated_id=? and us.el_section_id in (?) and us.el_branch_id in(?) and us.state_type_id in(?) and us.el_location_id in(?)";
	public static final String INSERTCREATEDEXAMINEXAMTABLE_QUERY = "insert into el_exam(exam_name,state_type_id,location_id,branch_id,class_id,section_id,subject_id,topic_id,"
			+ "subtopic_id,Question_type_id,question_level_type_id,exam_type_id,startdate,enddate,starttime,endtime,"
			+ "testduration,No_Of_Qus_Per_QusType,marks_per_qus_type,Negative_marks,total_marks,total_students_available,"
			+ "createddate,is_marks,is_slot) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String VALIDATEEXAMNAMEINELEXAMTABLE_QUERY = "select * from el_exam where lower(exam_name)=lower(?) group by exam_name";

	/*** AED Access Roles for Admin ***/
	public static final String GETROLESFORADMIN_QUERY = "select * from el_roles_type where role_id != ? order by role_id";
	public static final String GETLISTOFPERMISSIONS_QUERY = "select * from permissions";
	public static final String GETALREADYINSERTEDINPERMISSIONS_QUERY = "select count(*) from role_perm where role_id = ? and perm_id = ? and  student_id = ? ";
	public static final String INSERTPERMISSIONS_QUERY = "insert into role_perm (role_id,perm_id,student_id) values(?,?,?) ";
	public static final String GETLISTOFEDITPERMISSIONS_QUERY = "select pr.* from permissions pr, role_perm rp where pr.perm_id = rp.perm_id and rp.role_id = ?  and  rp.student_id = ? order by pr.perm_id ";
	public static final String UPDATEUSERPERMISSIONS_QUERY = "delete from role_perm where perm_id = ? and role_id = ?  and student_id = ? ";
	public static final String GETUSERIDSBASEDONROLEID_QUERY = "select * from user_role where role_id=?";
	
	/*** User Log Data ***/
	public static final String GETSTUENTIDS_QUERY = "select student_id,user_name from users where student_id like 'ED%'";
	public static final String GETALLAUDITLOGDATA_QUERY = " SELECT * FROM el_auditlogs where student_id=?";

	/*** Submit Exam ***/
	public static final String GETEXAMNAMESFORSUBMITEXAM_QUERY = "select examname as Exam_Name from temp_exam_history where Exam_Completion_Status='start' group by examname";
	public static final String GETNOTFISHEDSTDSBASEDONEXAMNAME_QUERY = "select th.Student_Id,us.user_name from "
			+ "temp_exam_history th,users us where th.Exam_Completion_Status='start' and th.examname=? and "
			+ "th.Student_Id=us.student_id  group by th.Student_Id";

	/*** Client Logo ***/
	public static final String GETUPLOADCLIENTDETAILS_QUERY = "UPDATE el_client_logo SET school_id=?, logo=?, modifieddate=? WHERE client_logo_id=?;";
	public static final String GETINSERTCLIENTDETAILS_QUERY = "insert into el_client_logo (school_id, logo, createddate, modifieddate) VALUES (?,?,?,?);";
	public static final String GETCLIENTLOGODBSIZE_QUERY = "SELECT * FROM el_client_logo where school_id=?";

	/*** Student Exam Status ***/
	public static final String GETEXAMNAMESFOREXAMSTATUS_QUERY1 = "select Exam_Name from el_exam_paper group by Exam_Name";
	public static final String GETEXAMDETAILSBASEDONEXAMANME_QUERY = "select * from el_exam where exam_name=? group by exam_name";

	/*** Exam Paper ***/
	public static final String GETEXAMNAMESFROMEXAMPAPER_QUERY = "select exam_name as Exam_Name from el_exam_paper group by exam_name";
	public static final String GETDISPLAYQUESTOVIEWQUEPAPER_QUERY = "select * from el_exam_paper ep,el_questions eq,el_subject es where exam_name=? and ep.Question_id=eq.Question_Id and es.el_subject_id=eq.subject_type and eq.subject_type=?";
	public static final String GETSUBJECTIDBASEDONEXAMNAME_QUERY = "select GROUP_CONCAT(distinct(subject_id) SEPARATOR ', ') as subjid from el_exam_paper where exam_name=?";

	/*** Set Exam Pattern ***/
	public static final String GETSETPATTERNVALUE_QUERY = "select * from el_exam_type et left outer join el_exam_pattern ep on et.Exam_Type_Id=ep.Exam_Type_Id where et.Exam_Type_Id!=0 order by et.Exam_Type_Id";
	public static final String GETALLEXAMTYPES_QUERY = "select * from el_exam_type where Exam_Type_Id!=0 order by Exam_Type_Id";
	public static final String GETALLEXAMPATTERNS_QUERY = "select * from el_pattern_type";
	public static final String CHECKEXISTINEXAMPATTERN_QUERY = "select count(*) from el_exam_pattern where Exam_Type_Id=?";
	public static final String INSERTSTARTEXAMPATTERNDATA_QUERY = "insert into el_exam_pattern(Exam_Type_Id,pattern_type_id) values(?,?)";
	public static final String UPDATESTARTEXAMPATTERN_QUERY = "update el_exam_pattern set pattern_type_id=? where Exam_Type_Id=?";

	/*** Client Carousel ***/
	public static final String GETALLCLIENTCAROUSEL_QUERY = "SELECT * FROM  el_client_carousel where  school_id=? order by client_carousel_id";
	public static final String GETMAXROWIDFROMINTROCAROUSEL_QUERY = "SELECT IFNULL(MAX(client_carousel_id), 0) as client_carousel_id  FROM el_client_carousel;";
	public static final String GETINSERTCLIENTCAROUSEL_QUERY = "INSERT INTO el_client_carousel ( client_carousel_image, school_id, createddate, modifieddate) VALUES (?,?,?,?);";
	public static final String DELETECLIENTCAROUSEL_QUERY = "delete from el_client_carousel where client_carousel_id=?";

	/*** Update Key ***/
	public static final String GETEXAMNAMEFORADMINREPORTS_QUERY = "select Exam_Name from el_student_results group by Exam_Name";
	public static final String EDITUPDATEKEYEXAM_QUERY = "select qe.Question_Id,qe.ques,qe.answer,qe.import_file_name from el_exam_paper ep,el_questions qe where ep.exam_name=? and qe.Question_Id=ep.Question_Id order by qe.Question_Id";
	public static final String UPDATEKEYVALUESINQUES_QUERY = "update  el_questions set answer=? where Question_Id=?";
	public static final String GETPASSWORDBASEONID_QUERY = "select password from users where student_id=?";
	public static final String GETSTUDENTIDSBASEEXAM_QUERY = "SELECT * FROM el_student_results where Exam_Name=? group by Student_Id";

	/*** Client Contact Details ***/
	public static final String GETEXISTINGCOUNTFROMCLIENTCONTACTDETTB_QUERY = "select * from el_client_contact_det where school_id=?";
	public static final String GETUPDATECONTACTDET_QUERY = "UPDATE el_client_contact_det SET mobile_number=?,emailid=?, address=?, school_id=?, modifieddate=? WHERE client_contactl_id=?";
	public static final String GETINSERTCONTACTDET_QUERY = "INSERT INTO el_client_contact_det (mobile_number,emailid, address, school_id, createddate) VALUES (?,?,?,?,?)";

	/*** Get student exam count ***/
	public static final String GETSTUDENTSFOREXAM_QUERY = "select distinct(th.Student_Id),upper(concat(us.first_name,' ',us.last_name)) as studentname,us.user_name from  temp_exam_history th,users us where th.examname=? and th.Exam_Completion_Status!=? and us.Student_Id=th.Student_Id";

	/*** SelectDb ***/
	public static final String GETCLIENTLOGOBASEDONSCHOOLID_QUERY = "select ifnull((select logo from el_client_logo where school_id=?),'0')";

	/*** All India Marks Analysis ***/
	public static final String GETSUBJECTSFROMSTUDENTRESULTS_QUERY = "SELECT sb.el_subject_name, sr.total_marks,sb.el_subject_id,sr.subject_total_marks  FROM el_student_results sr, el_subject sb where sr.el_subject_id = sb.el_subject_id and  sr.Exam_Name=?  group by sr.el_subject_id, sr.total_marks";
	public static final String GETUSERDETAILSFROMSTUDENTRESULTS_QUERY = "SELECT sr.Student_Id,sr.studentname, sc.el_section_name, sr.SCORED_MARKS, sb.el_subject_name, "
			+ "sr.campus,sr.state,sr.section,br.el_branch_name, sr.total_marks,sr.el_subject_id,st.state_type,sr.class_id,"
			+ "(select user_name from users us where us.student_id=sr.Student_Id) as username  "
			+ "FROM el_student_results sr, el_section sc,el_subject sb, el_branch br,el_state_type st  where "
			+ "sr.section = sc.el_section_id and sr.el_subject_id = sb.el_subject_id and sr.state=st.state_type_id "
			+ "and sr.campus = br.el_branch_id and sr.Exam_Name=? and sb.el_subject_id=? order by sr.SCORED_MARKS desc";
	public static final String GETSUBJTOTALMARKS_QUERY = "SELECT sum(total_marks) FROM el_exam where exam_name=? and subject_id=?";
	public static final String GETALLINDIAREPORTSUBJECTRANK_QUERY = "SELECT COUNT(DISTINCT s2.SCORED_MARKS) AS CAMPUS_Rank  FROM el_student_results s1, "
			+ "el_student_results s2 where s2.Exam_Name= ? and s1.Exam_Name= ? and s1.Student_Id=? and s2.el_subject_id=? and "
			+ "s1.el_subject_id=? and  (s1.SCORED_MARKS <= s2.SCORED_MARKS) ";
	public static final String GETUSERDETAILSFROMSTUDENTRESULTSINANOTHERSUBJ_QUERY = "SELECT  sr.SCORED_MARKS "
			+ "  FROM el_student_results sr, el_section sc,el_subject sb, el_branch br,el_state_type st "
			+ " where sr.section = sc.el_section_id and sr.el_subject_id = sb.el_subject_id and sr.state=st.state_type_id "
			+ "and sr.campus = br.el_branch_id and sr.Exam_Name=? and sb.el_subject_id=? and sr.campus=? "
			+ "and sr.section=? and sr.state=? and sr.class_id=? and sr.Student_Id=? group by sr.el_subject_id order by sr.SCORED_MARKS desc";
	public static final String GETSCOREDMARKSPERSUBJECT_QUERY = "select SCORED_MARKS from el_student_results where Exam_Name=? and Student_Id=? and el_subject_id=? group by el_subject_id";
	public static final String GETALLINDIARANKBASEDONEXAMNAME_QUERY = "SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS AllIndia_Rank  FROM el_student_results s1, "
			+ "el_student_results s2 where s2.Exam_Name= ? and s1.Exam_Name= ? " + "and s1.Student_Id=?  and   "
			+ "(s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS)";
	public static final String GETALLINDIACAMPUSRANKBASEDONEXAMNAME_QUERY = "SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS campus_Rank  FROM el_student_results s1, "
			+ "el_student_results s2 where s2.Exam_Name= ? and s1.Exam_Name= ? "
			+ "and s1.Student_Id=? and s1.campus=? and s2.campus= ? "
			+ " and  (s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS)";
	public static final String GETALLINDIASTATERANKBASEDONEXAMNAME_QUERY = "SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS campus_Rank  FROM el_student_results s1, "
			+ "el_student_results s2 where s2.Exam_Name= ? and s1.Exam_Name= ? "
			+ "and s1.Student_Id=? and s1.state=? and s2.state=? " + " and   "
			+ "(s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS)";
	public static final String GETALLINDIASECTIONRANKBASEDONEXAMNAME_QUERY = "SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS sec_Rank  FROM el_student_results s1, "
			+ "el_student_results s2 where s2.Exam_Name= ? and s1.Exam_Name=? and s1.Student_Id=? and s1.section=? and s2.section=?  and (s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS) ";

	/*** Student-wise Question-wise Error Report ***/
	public static final String GETQUESTIONIDFROMWISEQERROR_QUERY = "select question_id,exam_paper_id from el_exam_paper  where exam_name=? order by question_id  ";
	public static final String GETSTUDENTWISEQERROR_QUERY = "select eh.student_id,eh.studentname,es.el_section_name,eb.el_branch_name,eh.campus,eh.section from el_student_result_history eh,el_section es,el_branch eb	where exam_name=? and es.el_section_id=eh.section and eb.el_branch_id=eh.campus group by student_id";
	public static final String GETRIGHTVALUEFORERRORREPORT_QUERY = "select right_answered from el_student_result_history where question_id=? and exam_name=? and student_id=? and  campus=?"
			+ " and section=? and exam_paper_id=? group by question_id";
	public static final String GETWRONGVALUEFORERRORREPORT_QUERY = "select wrong_answered from el_student_result_history where question_id=? and exam_name=? and student_id=? and campus=? and section=? and exam_paper_id=? group by question_id";
	public static final String GETNOTANSWEREDVALUEFORERRORREPORT_QUERY = "select not_answered from el_student_result_history where question_id=? and exam_name=? and student_id=? and  campus=? and section=? and exam_paper_id=? group by question_id";

	/*** Subject-wise_Wrong, Right & Un-attempted Counts ***/
	public static final String GETSUBJECTWISERIGHTWRONGCOUNTREPORTFORADMIN_QUERY = "select eh.student_id,eh.studentname,es.el_section_name,eb.el_branch_name,sub.el_subject_name,eh.el_subject_id,eh.section,eh.campus from el_student_result_history eh,el_section es,el_branch eb,el_subject sub where eh.exam_name=? and eh.el_subject_id=? and eh.section=es.el_section_id and eh.campus=eb.el_branch_id and sub.el_subject_id=eh.el_subject_id group by eh.student_id";
	public static final String GETSUBJECTWISEWRONGCOUNT_QUERY = "select count(wrong_answered) as wrong from el_student_result_history where student_id=? and section =? and campus =? and exam_name=? and el_subject_id=? and wrong_answered is not null";
	public static final String GETSUBJECTWISECORRECTCOUNT_QUERY = "select count(right_answered) as rightcount from el_student_result_history where student_id=? and section =? and campus =? and exam_name=? and el_subject_id=? and right_answered is not null";
	public static final String GETSUBJECTWISEUNATTEMPTCOUNT_QUERY = "select count(not_answered) as unattempt from el_student_result_history where student_id=? and section =? and campus =? and exam_name=? and el_subject_id=? and not_answered is not null";

	/*** Campus Wise Error Report ***/
	public static final String GETALLQIDSINCAMPUSWISE1_QUERY = "SELECT  sr.Question_Id, sr.exam_paper_id FROM el_exam_paper sr  where  sr.Exam_Name=?  order by sr.Question_Id";
	public static final String GETCAMPUSWISEEXAMSTRENGTH_QUERY = "select count(cnt.Student_ID) as EXAM_STRN from (SELECT sr.Student_ID FROM el_student_result_history sr,el_branch br  "
			+ "where  sr.Exam_Name=? and sr.campus=? and sr.campus=br.el_branch_id " + "group by sr.Student_ID) as cnt";
	public static final String GETMAXQUESTIONLENGTH_QUERY = "select count(*) from el_exam_paper where exam_name=? and subject_id=?";
	public static final String GETCOUNTOFALLERRORQUESTIONIDSINCAMPUSWISE_QUERY = "SELECT Count(*) as errorcnt from  el_student_result_history sr,el_branch br  where  sr.Exam_Name=? and sr.campus=? and sr.campus=br.el_branch_id and sr.Question_Id=? and sr.el_subject_id=? and  sr.exam_paper_id=? and sr.wrong_answered is not null";

	/*** STATE-WISE-ERROR-REPORT ***/
	public static final String GETUSERDETAILSFROMSTUDENTRESULTSHISTORYFORSTATE_QUERY = "SELECT br.state_type,br.state_type_id "
			+ "FROM el_student_result_history sr,el_state_type br  where  sr.Exam_Name=? "
			+ "and sr.state=br.state_type_id gro" + "up by br.state_type_id";
	public static final String GETSTATEWISEEXAMSTRENGTH_QUERY = "SELECT count(cnt.Student_ID) as EXAM_STRN FROM (SELECT sr.Student_ID FROM el_student_result_history sr,el_state_type br  "
			+ "	where  sr.Exam_Name=? and sr.state=? and sr.state=br.state_type_id group by sr.Student_ID) as cnt";
	public static final String GETSUBJECTSFROMSTUDENTRESULTSFORSTATE_QUERY = "select sr.el_subject_id,sb.el_subject_name,sr.total_marks,sr.subject_total_marks  from el_student_results sr,el_subject sb "
			+ "where sr.Exam_Name=? and sr.state=? and sr.el_subject_id=sb.el_subject_id group by sr.el_subject_id "
			+ "order by sr.el_subject_id";
	public static final String GETGREATERTHANFOURTYFOURSUBJECTWISEMARKSRANGEREPO_QUERY = "select count(student_id)  from el_student_results  where SCORED_MARKS>=44 and exam_name=? and campus=?";

	/*** Subject-Wise-Marks-Ranges ***/
	public static final String GETSUBJECTWISERMARKSRANGESFORADMIN_QUERY = "select eb.el_branch_name,es.campus from el_student_results es,el_branch eb where es.campus=eb.el_branch_id and exam_name=? and es.el_subject_id=? group by eb.el_branch_name";
	public static final String GETEXAMSTRENGTHFORMARKSRANGEREPO_QUERY = "select count(es.student_id) as eas from el_student_results es where exam_name=? and campus=? and el_subject_id=?";
	public static final String GETEXAMMARKSRANGEGREATERTHANFIFTYREPO_QUERY = "select count(student_id)  from el_student_results  where SCORED_MARKS>=50 and exam_name=? and campus=? and el_subject_id=?";
	public static final String GETEXAMMARKSRANGEGREATERTHANFOURTYYREPO_QUERY = "select count(student_id)  from el_student_results  where SCORED_MARKS>=40 and exam_name=? and campus=? and el_subject_id=?";
	public static final String GETEXAMMARKSRANGEGREATERTHANTHIRTYYREPO_QUERY = "select count(student_id)  from el_student_results  where SCORED_MARKS>=30 and exam_name=? and campus=? and el_subject_id=?";
	public static final String GETEXAMMARKSRANGEGREATERTHANTWENTYYREPO_QUERY = "select count(student_id)  from el_student_results  where SCORED_MARKS>=20 and exam_name=? and campus=? and el_subject_id=?";
	public static final String GETEXAMMARKSRANGELESSTHANTWENTYYREPO_QUERY = "select count(student_id)  from el_student_results  where SCORED_MARKS<20 and exam_name=? and campus=? and el_subject_id=?";

	/*** Subject Wise Highest Marks Report ***/
	public static final String GETSUBJECTWISEHIGHESTCAMPUSNAME_QUERY = "select distinct(eb.el_branch_name), el1.campus from  el_student_results el1,el_branch eb where eb.el_branch_id = el1.campus and el1.Exam_Name=?";
	public static final String GETEXAMSTRENGTH_QUERY = "select count(*) from (SELECT * FROM el_student_results where Exam_Name=? and campus=? group by Student_Id) as tbl";
	public static final String GETTOTALSCOREFORSUBJECTHIGHESTMARKREPO_QUERY = "select max(Exam_Scored_marks) from el_student_results where exam_name=?  and campus=? limit 1";
	public static final String GETSTUDENTIFFORHIGHESTMARKREPORT_QUERY = "select student_id from el_student_results where exam_name=? and campus=? and Exam_Scored_marks=? limit 1";
	public static final String GETALLINDIARANKFORHIGHESTMARKREPORT_QUERY = "SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS AllIndia_Rank  FROM el_student_results s1, el_student_results s2 where s2.Exam_Name= ? and s1.Exam_Name=? and s1.Student_Id=?  and   (s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS)";
	public static final String GETSCOREMARKSFORHIGHESTMARKREPO_QUERY = "select Scored_marks from el_student_results where exam_name=? and  student_id=? and el_subject_id=?";
	public static final String GETSCOREMARKSFORHIGHESTREPORTSUBJECTWISES_QUERY = "select max(scored_marks) from el_student_results where exam_name=? and campus=?  and el_subject_id=? limit 1";
	public static final String GETCAMPUSWISERANKFORSUBJECTHIGHEST_QUERY = "SELECT COUNT(DISTINCT s2.SCORED_MARKS) AS AllIndia_Rank  FROM el_student_results s1, el_student_results s2 where s2.Exam_Name=? and s1.Exam_Name=? "
			+ "and s1.campus=? and s2.campus=? and s1.Student_Id=? and s1.el_subject_id=?  and  s2.el_subject_id=? and   (s1.SCORED_MARKS <= s2.SCORED_MARKS)";
	public static final String GETSTUDENTIFFORHIGHESTMARKREPORTFORSUBJECT_QUERY = "select student_id from el_student_results where exam_name=? and campus=? and Scored_marks=? limit 1";
	public static final String GETSUBJECTRANKINCAMPUSWISESUBJECTTOPPER_QUERY = "SELECT COUNT(DISTINCT s2.SCORED_MARKS) AS AllIndia_Rank  FROM el_student_results s1,el_student_results s2 where s2.Exam_Name=? and s1.Exam_Name=? and s1.campus=? and s2.campus=? and s1.Student_Id=? and s1.el_subject_id=?  and s2.el_subject_id=? and (s1.SCORED_MARKS <= s2.SCORED_MARKS)";

	/*** Above 50% Marks_Subject-wise ***/
	public static final String GETEXAMMARKSRANGEGREATERTHANFOURTYFOURREPO_QUERY = "select count(student_id)  from el_student_results  where SCORED_MARKS>=44 and exam_name=? and campus=? and el_subject_id=?";
	public static final String GETMAXMARKSINSUBJECTWISERANGE_QUERY = "select max(SCORED_MARKS)  from el_student_results  where exam_name=? and campus=? and el_subject_id=?";

	/*** Present & Previous Test Comparative Report ***/
	public static final String GETDETAILSOFPRESENTEXAM_QUERY = "select state_type_id,location_id,branch_id,class_id,section_id from el_exam where exam_name=? group by exam_name";
	public static final String GETPREVIOUSEXAMNAMEFORREPORT_QUERY = "select exam_name,total_marks from el_student_results s2 where (select s1.CreatedDate from el_student_results s1 where s1.Exam_Name =? and s2.Exam_Name !=? group by Exam_Name) > s2.CreatedDate and s2.state in(?)  and s2.el_location_id in(?) and s2.campus in(?) and s2.class_id in(?) and s2.section in(?) group by s2.Exam_Name order by s2.CreatedDate desc limit 1;";
	public static final String GETPREVIOUSEXAMSUBJECTFORREPORT_QUERY = "select st.el_subject_name,sr.el_subject_id from el_student_results sr, el_subject st where sr.el_subject_id = st.el_subject_id and sr.Exam_Name=? group by sr.el_subject_id";
	public static final String GETALLINDIAREPORTSUBJECTRANK1_QUERY = "SELECT COUNT(DISTINCT s2.SCORED_MARKS) AS CAMPUS_Rank  FROM el_student_results s1, el_student_results s2 where s2.Exam_Name=? and s1.Exam_Name=? and s1.Student_Id=? and s2.el_subject_id=? and s1.el_subject_id=? and  (s1.SCORED_MARKS <= s2.SCORED_MARKS) ";
	public static final String GETCOUNTOFSCOREDMARKSFOREXAM2_QUERY = "SELECT count(*)"
			+ " FROM el_student_results sr, el_section sc,el_subject sb, el_branch br,el_state_type st  "
			+ "where sr.section = sc.el_section_id and sr.el_subject_id = sb.el_subject_id and "
			+ "sr.campus = br.el_branch_id and sr.state=st.state_type_id and sr.Exam_Name=? and "
			+ "sr.section=? and sr.state=? and sr.Student_Id=? and sr.campus=? and sr.el_subject_id=? "
			+ "order by sr.SCORED_MARKS desc";
	public static final String GETSCOREDMARKSFOREXAM2_QUERY = "SELECT sr.SCORED_MARKS"
			+ " FROM el_student_results sr, el_section sc,el_subject sb, el_branch br,el_state_type st  "
			+ "where sr.section = sc.el_section_id and sr.el_subject_id = sb.el_subject_id and "
			+ "sr.campus = br.el_branch_id and sr.state=st.state_type_id and sr.Exam_Name=? and "
			+ "sr.section=? and sr.state=? and sr.Student_Id=? and sr.campus=? and sr.el_subject_id=? "
			+ " group by sr.el_subject_id order by sr.SCORED_MARKS desc";

	/*** Below 100 RNK_Subject-wise ***/
	public static final String GETCAMPUSNAMESINSTUDENTRESULTS_QUERY = "select st.el_branch_name,st.el_branch_id from el_student_results sr,el_branch st where sr.Exam_Name=? and st.el_branch_id=sr.campus group by sr.campus";
	public static final String GETEXAMSTRENGTHINCAMPUSWISEBELOW100RANKS_QUERY = "select Count(*) from (select * from el_student_results where Exam_Name=? "
			+ "and campus=? group by Student_Id) as tbl";
	public static final String GETRANKCOUNTINCAMPUSWISEBELOW100RANKS_QUERY = "select  count(*) from (SELECT A.EXAM_SCORED_MARKS, (SELECT COUNT(*)+1  FROM el_student_results B "
			+ "WHERE A.EXAM_SCORED_MARKS<B.EXAM_SCORED_MARKS and A.campus=? and B.campus=?  and A.el_subject_id=?"
			+ " and B.el_subject_id=?) AS rank1 FROM el_student_results A where A.campus=? and A.el_subject_id=?"
			+ " and A.Exam_Name=? having rank1 <=100 ORDER BY  A.EXAM_SCORED_MARKS DESC) as tbl";
	public static final String GETMAXMARKSINCAMPUSWISEBELOW100RANKS_QUERY = "select max(SCORED_MARKS) from el_student_results where campus=? and el_subject_id=? and Exam_Name=?";

	/*** Section wise attendees with averages ***/
	public static final String GETCAMPUSSECTIONFROMSTUDENTRESULTS_QUERY = "select eb.el_branch_name, eb.el_branch_id, sc.el_section_id, sc.el_section_name from el_student_results es,el_branch eb, el_section sc where es.campus=eb.el_branch_id and es.exam_name=? and es.section = sc.el_section_id group by eb.el_branch_id,sc.el_section_id";
	public static final String GETACTUALSTUDENTSPRESENCEPERSECTION_QUERY = "select count(*) as stucount from users ur where ur.el_section_id=? and ur.el_branch_id=?";
	public static final String GETACTUALSTUDENTSPRESENCEPERSECTIONINEXAM_QUERY = "select count(*) from (select * from el_student_results where section=? and exam_name=? and campus=? group by Student_Id) as tbl";
	public static final String GETAVGINSUBJECTSFROMCAMPUSSECTION_QUERY = "select avg(SCORED_MARKS)as submarks_avg  from el_student_results sr where sr.section=? and sr.campus=? and el_subject_id=? and  exam_name=? ";
	public static final String GETAVGINTOTALMARKSFROMCAMPUSSECTION_QUERY = "select avg(EXAM_SCORED_MARKS)as totalmarks_avg  from el_student_results sr where sr.section=? and sr.campus=?  and  exam_name=? ";

	/*** Order of Attempted Questions ***/
	public static final String GETSTUDENTIDFORQUESTIONANALYSIS_QUERY = " select student_id from temp_exam_history where examname=? group by student_id";
	public static final String GETQUESTIONWISEANALYSISDATA_QUERY = "select ur.first_name,ur.last_name,ur.user_name,ec.el_class_name,ur.Student_Id,es.el_section_name "
			+ " from temp_exam_history tmp,users ur,el_class ec,el_section es "
			+ "where ec.el_class_generated_id=tmp.class_id and tmp.section_id=es.el_section_id and ur.el_section_id=es.el_section_id and ur.el_class_generated_id=ec.el_class_generated_id "
			+ "and tmp.examname=? and ur.student_id in(?) "
			+ "and tmp.Exam_Completion_Status=? group by ur.student_id ";
	public static final String GETAVGTIMEBASEDONEXAMNAME_QUERY = "select round( avg(t1.time_difference),2) as time_difference,eq.import_file_name from temp_exam_history t1 , el_questions  eq where t1.question_Id=eq.Question_Id and t1.examname=? and t1.Exam_Completion_Status=? group by t1.exam_paper_id";
	public static final String GETQUESTIONSCOUNTBASEDONEXAMNAME_QUERY = "select count(*) from el_exam_paper where exam_name=?";
	public static final String GETQUESTIONWISECOUNTFORANALALYSIS_QUERY = "Select count(*) from temp_exam_history where examname=? and Student_Id=?";
	public static final String GETQUESTINONWISETIMEDIFFERENCEVALUES_QUERY = "SELECT actual_answer_question_time as timedifference,question_Id,selected_answer,filenames FROM temp_exam_history where examname=? and Student_Id=? ORDER BY time_taken_value";
	public static final String GETACTUALSTARTTIMEFROMTEMP_QUERY = "select actual_exam_start_time from temp_exam_history where Student_Id=? and examname=?  group by examname";
	public static final String GETCOUNTNEXTQUESTIONTIMETAKENVALUE_QUERY = "select count(*) from(select * from temp_exam_history where examname=? and Student_Id=? and actual_answer_question_time > ?  order by time_taken_value limit 1) as tab";
	public static final String GETNEXTQUESTIONTIMETAKENVALUE_QUERY = "select actual_answer_question_time from temp_exam_history where examname=? and Student_Id=? and actual_answer_question_time >?  order by time_taken_value limit 1;";

	/*** Progress Report ***/
	public static final String GETALLSTUDENTSFROMALLINPUTS_QUERY = "select * from users where state_type_id=? and el_location_id=? and el_branch_id=? and el_class_generated_id=? and el_section_id=?";
	public static final String GETCLASSNAMEFROMCLASSIS_QUERY = "select el_class_name from el_class where  el_class_generated_id=?";
	public static final String GETSECTIONNAMEFROMSECTION_QUERY = "select el_section_name from el_section where  el_section_id=?";
	public static final String GETBRANCHNAMEFROMBRANCH_QUERY = "select el_branch_name from el_branch where  el_branch_id=?";
	public static final String GETLOCATIONNAMEFROMLOCATION_QUERY = "select el_location_name from el_location where  el_location_id=?";
	public static final String GETSTATENAMEFROMSTATE_QUERY = "select state_type from el_state_type where  state_type_id=?";
	public static final String GETSTUDENTAVERAGEREPORTMRKSFORSTUDENT_QUERY = "select distinct(student_id),studentname from el_student_results where class_id=? and section=? and campus=? and state=? and el_location_id=? group by Student_Id;";
	public static final String GETSUBJECTAVERAGEREPORTMRKSFORSTUDENT_QUERY = "select distinct(er.el_subject_id),es.el_subject_name from el_student_results er,el_subject es where class_id=? and section=? and campus=? and state=? and el_location_id=? and er.el_subject_id=es.el_subject_id group by el_subject_id;";
	public static final String GETUSERIDSBASEDONSTUDENTID_QUERY = "select user_name from users where student_id=?";
	public static final String GETEXAMCOUNTFORREPO_QUERY = "select count(distinct(Exam_Name)) from el_student_results where Student_Id=?";
	public static final String GETSUBJECTAVERAGESCOREREPORTMRKSFORSTUDENT_QUERY = "select ifnull(avg(SCORED_MARKS),0.00) from el_student_results where class_id=? and section=? and campus=? and state=? and el_location_id=? and el_subject_id=? and Student_Id=?";
	public static final String GETRANKFORAVERAGE_QUERY = "SELECT COUNT(DISTINCT s2.SCORED_MARKS) AS rank  FROM el_student_results s1, el_student_results s2 where  s1.Student_Id=?  and s2.el_subject_id=? and s1.el_subject_id=? and  (s1.SCORED_MARKS <= s2.SCORED_MARKS) and s1.class_id=? and s2.class_id=?  and s1.section=? and s2.section=? and s1.campus=? and  s2.campus=? and  s1.state=? and s2.state=? and s1.el_location_id=? and s2.el_location_id=?";
	public static final String GETSELECTEDSTUDENTINFORMATION_QUERY = "select user_name, concat(ur.first_name, ' ', ur.last_name) as stuname, cl.el_class_name, "
			+ "sc.el_section_name, st.state_type, lc.el_location_name, br.el_branch_name from "
			+ "el_state_type st, el_location lc, el_branch br, users ur, el_class cl, el_section sc "
			+ "where st.state_type_id = lc.state_type_id and lc.el_location_id =br.el_location_id and "
			+ "ur.state_type_id = st.state_type_id and ur.el_location_id = lc.el_location_id and "
			+ "ur.el_branch_id = br.el_branch_id and ur.student_id=? and "
			+ "ur.el_class_generated_id = cl.el_class_generated_id and ur.el_section_id = sc.el_section_id and "
			+ "cl.el_class_generated_id = sc.el_class_generated_id";
	public static final String GETSUBJECTIDSFORSTUDENT_QUERY = "select sr.el_subject_id, sb.el_subject_name,et.Exam_Type from el_student_results sr, "
			+ "el_exam ex,el_exam_type et, el_subject sb where sr.Exam_Name = ex.exam_name and "
			+ "sr.Student_Id=? and ex.exam_type_id=? and "
			+ "et.Exam_Type_Id = ex.exam_type_id and sb.el_subject_id = sr.el_subject_id and "
			+ "sb.el_subject_id = ex.subject_id group by sr.el_subject_id order by sr.el_subject_id";
	public static final String GETEXAMTYPEANDEXAMNAMEFROMELEXAM_QUERY = "select sr.Exam_Name,sr.exam_conducted_date from el_student_results sr, el_exam ex,el_exam_type et where "
			+ "sr.Exam_Name = ex.exam_name and sr.Student_Id=? and ex.exam_type_id=? "
			+ "and et.Exam_Type_Id = ex.exam_type_id  group by sr.Exam_Name order by sr.exam_conducted_date";
	public static final String GETSTUDENTMARKSPERSUBJECT_QUERY = "select  SCORED_MARKS from el_student_results where Student_Id=? and "
			+ "Exam_Name=? and el_subject_id=?";
	public static final String GETEXAMTOTALMARKSPEREXAM_QUERY = "select EXAM_SCORED_MARKS from el_student_results where Student_Id=? and Exam_Name=? group by Exam_Name";
	public static final String GETEXAMRANKPEREXAM_QUERY = "SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS rank  FROM el_student_results s1, el_student_results s2 "
			+ "where s2.Exam_Name=? and s1.Exam_Name= ? and s1.Student_Id=? and  (s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS)";
	public static final String CALCULATESTUDENTAVERAGEMARKS_QUERY = "select avg(SCORED_MARKS) as avgscoredmarks from el_student_results where Student_Id=? and Exam_Name in( select Exam_Name from el_exam where exam_type_id=?) group by el_subject_id order by el_subject_id";

	/*** Upload Student Records ***/
	public static final String VIEWSTATEASSOCIATELCBR_QUERY = "select st.state_type,st.state_type_id,lc.el_location_name,lc.el_location_id,"
			+ "br.el_branch_name,br.el_branch_id from el_state_type st, el_location lc, el_branch br, "
			+ "el_class where st.state_type_id = lc.state_type_id and lc.el_location_id = br.el_location_id "
			+ "group by lc.el_location_id order by st.state_type_id";

	/*** Upload Offline Key Excel ***/
	public static final String INSERTOFFLINEKEYFROMEXCEL_QUERY = "INSERT INTO el_offline_key(exam_name,class_id,el_subject_id,exam_type_id,question_id,question_key,"
			+ "marks_per_ques_type,negative_marks,question_type_id,Total_Questions, " + "created_date,modified_date) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GETTOTALMARKSFROMEXAMOFFLINE_QUERY = "select sum(marks_per_ques_type) as totalmarks from el_offline_key where exam_name=? ";
	public static final String UPDATETOTALMARKSFROMMEXAMOFFLINE_QUERY = "update el_offline_key set total_marks=? where exam_name=?";
	public static final String GETSUBJECTIDSFROMEXAMOFFLINE_QUERY = "select el_subject_id from el_offline_key where exam_name=? group by el_subject_id";
	public static final String GETSUBJECTTOTALQUSOFFLINE_QUERY = "select count(*) from el_offline_key where exam_name=? and el_subject_id=? and exam_type_id=? ";
	public static final String UPDATESUBJECTTOTALQUSFROMEXAMOFFLINE_QUERY = "update el_offline_key set subject_total_questions=? where exam_name=? and el_subject_id=?";
	public static final String GETQNTYPEIDFROMEXAMOFFLINE_QUERY = "select question_type_id from el_offline_key where exam_name=? and el_subject_id=? group by el_subject_id,question_type_id";
	public static final String GETNUMOFQUSPERQUNSTYPE_QUERY = "select count(*) from el_offline_key where exam_name=? and el_subject_id=? and exam_type_id=? and question_type_id=? ";
	public static final String UPDATENUMOFQUESTIONPERQUSTYPE_QUERY = "update el_offline_key set noof_ques_per_qtype=? where exam_name=? and el_subject_id=? and question_type_id=?";
	public static final String UPDATEQUESTYPETOATLAMARKS_QUERY = "update el_offline_key set question_type_total_marks=? where exam_name=? and el_subject_id=? and question_type_id=?";
	public static final String VALIDATEEXAMNAMEFOROFFLINEKEY_QUERY = "select exam_name from el_offline_key where exam_name=?";
	public static final String DELETEOFFLINEINVALIDKEYENTRIES_QUERY = "delete from el_offline_key where exam_name=?";
	public static final String INSERTOFFLINEKEY_QUERY = "INSERT INTO el_offline_key(exam_name,class_id,el_subject_id,exam_type_id,question_id,question_key,"
			+ "marks_per_ques_type,negative_marks,question_type_id,Total_Questions,subject_total_questions,"
			+ "noof_ques_per_qtype,total_marks,question_type_total_marks,created_date,modified_date) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/*** Upload Offline Key ***/
	public static final String GETEXAMNAMEFROMKEYTABLE_QUERY = "select exam_name from el_offline_key where is_dat_file_generated =? group by exam_name";
	public static final String GETOFFLINEUSERDATABASEDONSTUDENTID_QUERY = "select * from users ur where Student_Id=?";
	public static final String GETOFFLINEUSERDATABASEDONUSERNAME_QUERY = "select * from users ur where user_name=?";
	
	/*** Offline Result Calculation ***/
	public static final String GETEXAMNAMEFOROFFLINE_QUERY = "select exam_name from el_offline_exam_resulthistory where is_result_calculation=? group by exam_name";

    /*** Offline Reports ***/
	
	/*** All India_Marks_Analysis offline ***/
	public static final String GETEXAMNAMEFOROFFLINEREPORTR_QUERY = "select exam_name from el_offline_exam_resulthistory where is_result_calculation=? group by exam_name";
	public static final String GETSUBJECTSFROMSTUDENTRESULTSINCAMPUSOFFLINE_QUERIES =  "select sr.el_subject_id,sb.el_subject_name,sr.total_marks,sr.subject_total_marks  from el_offline_exam_results sr,el_subject sb "
				+ "where sr.Exam_Name=? and sr.campus=? and sr.el_subject_id=sb.el_subject_id group by sr.el_subject_id " + "order by sr.el_subject_id";
	public static final String GETSUBJECTSFROMSTUDENTRESULTSOFFLINE_QUERY = "SELECT sb.el_subject_name, sr.total_marks,sb.el_subject_id,sr.subject_total_marks  FROM el_offline_exam_results sr, el_subject sb where sr.el_subject_id = sb.el_subject_id and  sr.Exam_Name=? group by sr.el_subject_id, sr.total_marks";
	public static final String GETALLINDIAREPORTSUBJECTRANKOFFLINE_QUERY = "SELECT COUNT(DISTINCT s2.SCORED_MARKS) AS CAMPUS_Rank  FROM el_offline_exam_results s1, "
				+ "el_offline_exam_results s2 where s2.Exam_Name= ? and s1.Exam_Name= ? and s1.Student_Id=? and s2.el_subject_id=? and "
				+ "s1.el_subject_id=? and  (s1.SCORED_MARKS <= s2.SCORED_MARKS) ";
	public static final String GETSCOREDMARKSPERSUBJECTOFFLINE_QUERY = "select SCORED_MARKS from el_offline_exam_results where Exam_Name=? and Student_Id=? and el_subject_id=? group by el_subject_id";
	public static final String GETUSERDETAILSFROMSTUDENTRESULTSINANOTHERSUBJOFFLINE_QUERY ="SELECT  sr.SCORED_MARKS "
			+ "  FROM el_offline_exam_results sr, el_section sc,el_subject sb, el_branch br,el_state_type st "
			+ " where sr.section = sc.el_section_id and sr.el_subject_id = sb.el_subject_id and sr.state=st.state_type_id "
			+ "and sr.campus = br.el_branch_id and sr.Exam_Name=? and sb.el_subject_id=? and sr.campus=? and sr.section=? and sr.state=? and sr.class_id=? "
			+ "and sr.Student_Id=?  group by sr.el_subject_id order by sr.SCORED_MARKS desc";
	public static final String GETALLINDIARANKBASEDONEXAMNAMEOFFLINE_QUERY = "SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS AllIndia_Rank  FROM el_offline_exam_results s1, "
				+ "el_offline_exam_results s2 where s2.Exam_Name=? and s1.Exam_Name=? and s1.Student_Id=?  and   "
				+ "(s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS)";
	public static final String GETALLINDIASTATERANKBASEDONEXAMNAMEOFFLINE_QUERY = "SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS campus_Rank  FROM el_offline_exam_results s1, "
				+ "el_offline_exam_results s2 where s2.Exam_Name=? and s1.Exam_Name=? and s1.Student_Id=? and s1.state=? "
				+ "and s2.state=? and  (s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS)";
	public static final String GETALLINDIASECTIONRANKBASEDONEXAMNAMEOFFLINE_QUERY ="SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS sec_Rank  FROM el_offline_exam_results s1, "
			+ "el_offline_exam_results s2 where s2.Exam_Name=? and s1.Exam_Name= ? and s1.Student_Id=? and "
			+ "s1.section=? and s2.section=? and (s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS) ";
	public static final String GETALLINDIACAMPUSRANKBASEDONEXAMNAMEOFFLINE_QUERY = "SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS campus_Rank  FROM el_offline_exam_results s1, el_offline_exam_results s2 where s2.Exam_Name=? and s1.Exam_Name=? and s1.Student_Id=? and s1.campus=? and s2.campus=? and  (s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS)";
	
	/*** Subject-Wise-Marks-Ranges offline ***/
	public static final String GETEXAMSTRENGTHFORMARKSRANGEREPOOFFLINE_QUERY =" select count(es.student_id) as eas from el_offline_exam_results es where exam_name=? and campus=? and el_subject_id=?";
	public static final String GETEXAMMARKSRANGEGREATERTHANFIFTYREPOOFFLINE_QUERY = "select count(student_id)  from el_offline_exam_results  where SCORED_MARKS>=50 and exam_name=? and campus=? and el_subject_id=?";
	public static final String GETEXAMMARKSRANGEGREATERTHANFOURTYYREPOOFFLINE_QUERY ="select count(student_id)  from el_offline_exam_results where SCORED_MARKS>=40 and exam_name=? and campus=? and el_subject_id=?";
	public static final String GETEXAMMARKSRANGEGREATERTHANTHIRTYYREPOOFFLINE_QUERY =  "select count(student_id)  from el_offline_exam_results where SCORED_MARKS>=30 and exam_name=? and campus=? and el_subject_id=?";
	public static final String GETEXAMMARKSRANGEGREATERTHANTWENTYYREPOOFFLINE_QUERY = "select count(student_id)  from el_offline_exam_results  where SCORED_MARKS>=20 and exam_name=? and campus=? and el_subject_id=?";
	public static final String GETEXAMMARKSRANGELESSTHANTWENTYYREPOOFFLINE_QUERY = "select count(student_id)  from el_offline_exam_results  where SCORED_MARKS<20 and exam_name=? and campus=? and el_subject_id=?";
	
	/*** Student-Wise-Question-Wise-Error-Report offline ***/
	public static final String GETQUESTIONIDFROMWISEQERROROFFLINE_QUERY ="select question_id,offline_key_id from el_offline_key where exam_name=? ";
	public static final String GETSTUDENTWISEQERROR_QUERY1 = "select eh.student_id,eh.studentname,es.el_section_name,eb.el_branch_name,eh.campus,eh.section from el_offline_exam_resulthistory eh,el_section es,el_branch eb	where exam_name=? and es.el_section_id=eh.section and eb.el_branch_id=eh.campus group by student_id";
	public static final String ADMINGETQUESTIONIDSFORQERROROFFLINE_QUERY = "SELECT  sr.Question_Id,sr.offline_key_id FROM el_offline_key sr where  sr.Exam_Name=?";
	public static final String GETRIGHTVALUEFORERRORREPORTOFFLINE_QUERY =  "select right_answered from el_offline_exam_resulthistory where question_id=? and exam_name=?  and student_id=? and  campus=? and section=? and offline_key_id=? group by question_id";
	public static final String GETWRONGVALUEFORERRORREPORTOFFLINE_QUERY = "select wrong_answered from el_offline_exam_resulthistory where question_id=? and exam_name=? and student_id=? and campus=? and section=? and offline_key_id=? group by question_id";
	public static final String GETNOTANSWEREDVALUEFORERRORREPORTOFFLINE_QUERY = "select not_answered from el_offline_exam_resulthistory where question_id=? and exam_name=? and student_id=? and  campus=? and section=? and offline_key_id=? group by question_id";
	
	/*** Subject-wise_Wrong, Right & Un-attempted Counts offline ***/
	public static final String GETSUBJECTWISERIGHTWRONGCOUNTREPORTFORADMIN_QUERY1 = "select eh.student_id,eh.studentname,es.el_section_name,eb.el_branch_name,sub.el_subject_name,eh.el_subject_id,eh.section,eh.campus from el_offline_exam_resulthistory eh,el_section es,el_branch eb,el_subject sub where eh.exam_name=? and eh.el_subject_id=? and eh.section=es.el_section_id and eh.campus=eb.el_branch_id and sub.el_subject_id=eh.el_subject_id group by eh.student_id";
	public static final String GETSUBJECTWISEWRONGCOUNTOFFLINE_QUERY = "select count(wrong_answered) as wrong from el_offline_exam_resulthistory where student_id=? and section =? and campus =? and exam_name=? and el_subject_id=? and wrong_answered is not null";
	public static final String GETSUBJECTWISECORRECTCOUNTOFFLINE_QUERY ="select count(right_answered) as rightcount from el_offline_exam_resulthistory where student_id=? and section =? and campus =? and exam_name=? and el_subject_id=? and right_answered is not null";
	public static final String GETSUBJECTWISEUNATTEMPTCOUNTOFFLINE_QUERY = "select count(not_answered) as unattempt from el_offline_exam_resulthistory where student_id=? and section =? and campus =? and exam_name=? and el_subject_id=? and not_answered is not null";

	/*** Campus Wise Error offline Report ***/
	public static final String GETALLQIDSINCAMPUSWISE1OFFLINE_QUERY = "SELECT  sr.Question_Id,sr.offline_key_id FROM el_offline_key sr where  sr.Exam_Name=?";
	public static final String GETCAMPUSWISEEXAMSTRENGTHOFFLINE_QUERY =  "select count(cnt.Student_ID) as EXAM_STRN from (SELECT sr.Student_ID FROM el_offline_exam_resulthistory sr,el_branch br  where  sr.Exam_Name=? and sr.campus=? and sr.campus=br.el_branch_id group by sr.Student_ID) as cnt";
	public static final String GETMAXQUESTIONLENGTHOFFLINE_QUERY ="select count(*) from el_offline_key where exam_name=? and el_subject_id=?";
	public static final String GETCOUNTOFALLERRORQUESTIONIDSINCAMPUSWISEOFFLINE_QUERY = "SELECT Count(*) as errorcnt from  el_offline_exam_resulthistory sr,el_branch br  where  sr.exam_name=? and sr.campus=? and sr.campus=br.el_branch_id and sr.Question_Id=? and sr.el_subject_id=? and  sr.offline_key_id=? and sr.wrong_answered is not null";
	
	/*** State Wise Error offline Report ***/
	public static final String GETSTATEWISEEXAMSTRENGTHOFFLINE_QUERY = "SELECT count(cnt.Student_ID) as EXAM_STRN FROM (SELECT sr.Student_ID FROM el_offline_exam_resulthistory sr,el_state_type br 	where  sr.Exam_Name=? and sr.state=? and sr.state=br.state_type_id group by sr.Student_ID) as cnt";
	public static final String GETSUBJECTSFROMSTUDENTRESULTSFORSTATEOFFLINE_QUERY = "select sr.el_subject_id,sb.el_subject_name,sr.total_marks,sr.subject_total_marks  from el_offline_exam_results sr,el_subject sb where sr.Exam_Name=? and sr.state=? and sr.el_subject_id=sb.el_subject_id group by sr.el_subject_id order by sr.el_subject_id";
	public static final String GETUSERDETAILSFROMSTUDENTRESULTSHISTORYFORSTATEOFFLINE_QUERY = "SELECT br.state_type,br.state_type_id FROM el_offline_exam_resulthistory sr,el_state_type br  where  sr.Exam_Name=? and sr.state=br.state_type_id group by br.state_type_id";

	/*** Subject Wise Highest Marks offline Report ***/
	public static final String GETSUBJECTWISEHIGHESTCAMPUSNAMEOFFLINE_QUERY = "select distinct(eb.el_branch_name), el1.campus from  el_offline_exam_results el1,el_branch eb where eb.el_branch_id = el1.campus and el1.Exam_Name=?";
	public static final String GETTOTALSCOREFORSUBJECTHIGHESTMARKREPOOFFLINE_QUERY = "select max(Exam_Scored_marks) from el_offline_exam_results where exam_name=? and campus=? limit 1";
	public static final String GETSTUDENTIFFORHIGHESTMARKREPORTOFFLINE_QUERY ="select student_id from el_offline_exam_results where exam_name=? and campus=? and Exam_Scored_marks=? limit 1";
	public static final String GETALLINDIARANKFORHIGHESTMARKREPORTOFFLINE_QUERY ="SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS AllIndia_Rank  FROM el_offline_exam_results s1, el_offline_exam_results s2 where s2.Exam_Name=? and s1.Exam_Name=? and s1.Student_Id=?  and   (s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS)";
	public static final String GETSCOREMARKSFORHIGHESTMARKREPOOFFLINE_QUERY ="select Scored_marks from el_offline_exam_results where exam_name=? and  student_id=? and el_subject_id=?";
	public static final String GETCAMPUSWISERANKFORSUBJECTHIGHESTOFFLINE_QUERY = "SELECT COUNT(DISTINCT s2.SCORED_MARKS) AS AllIndia_Rank  FROM el_offline_exam_results s1, el_offline_exam_results s2 where s2.Exam_Name=? and s1.Exam_Name=? and s1.campus=? and s2.campus=? and s1.Student_Id=? and s1.el_subject_id=?  and s2.el_subject_id=? and   (s1.SCORED_MARKS <= s2.SCORED_MARKS)";
	public static final String GETSCOREMARKSFORHIGHESTREPORTSUBJECTWISESOFFLINE_QUERY = "select max(scored_marks) from el_offline_exam_results where exam_name=? and campus=?  and el_subject_id=? limit 1";
	public static final String GETSTUDENTIFFORHIGHESTMARKREPORTFORSUBJECTOFFLINE_QUERY = "select student_id from el_offline_exam_results where exam_name=? and campus=? and Scored_marks=? limit 1";
	public static final String GETSUBJECTRANKINCAMPUSWISESUBJECTTOPPEROFFLINE_QUERY ="SELECT COUNT(DISTINCT s2.SCORED_MARKS) AS AllIndia_Rank  FROM el_offline_exam_results s1, el_offline_exam_results s2 where s2.Exam_Name= ? and s1.Exam_Name= ? and s1.campus=? and s2.campus=? and s1.Student_Id=? and s1.el_subject_id=?  and s2.el_subject_id=? and  (s1.SCORED_MARKS <= s2.SCORED_MARKS);";
	
	/*** Above 50% Marks_Subject-wise offline ***/
	public static final String GETEXAMSTRENGTHOFFLINE_QUERY ="select count(*) from (SELECT * FROM el_offline_exam_results where Exam_Name=? and campus=? group by Student_Id) as tbl";
	public static final String GETMAXMARKSINSUBJECTWISERANGEOFFLINE_QUERY = "select max(SCORED_MARKS)  from el_offline_exam_results  where exam_name=? and campus=? and el_subject_id=?";
	public static final String GETEXAMMARKSRANGEGREATERTHANFOURTYFOURREPOOFFLINE_QUERY = "select count(student_id)  from el_offline_exam_results  where SCORED_MARKS>=44 and exam_name=? and campus=? and el_subject_id=?";

	/*** Present & Previous Test Comparative Report offline ***/
	public static final String GETDETAILSOFPRESENTEXAMOFFLINE_QUERY ="select state,el_location_id,campus,class_id,section from el_offline_exam_resulthistory where exam_name=? group by exam_name;";
	public static final String GETPREVIOUSEXAMNAMEFORREPORTOFFLINE_QUERY = "select exam_name,total_marks from el_offline_exam_results s2 where (select s1.CreatedDate from el_offline_exam_results s1 where s1.Exam_Name =? and s2.Exam_Name !=? group by Exam_Name) > s2.CreatedDate and s2.state in(?)  and s2.el_location_id in(?) and s2.campus in(?) and s2.class_id in(?) and s2.section in(?) group by s2.Exam_Name order by s2.CreatedDate desc limit 1;";
	public static final String GETALLINDIARANKBASEDONEXAMNAMEOFFLINE1_QUERY = "SELECT COUNT(DISTINCT s2.EXAM_SCORED_MARKS) AS AllIndia_Rank  FROM el_offline_exam_results s1, el_offline_exam_results s2 where s2.Exam_Name=? and s1.Exam_Name=? and s1.Student_Id=?  and (s1.EXAM_SCORED_MARKS <= s2.EXAM_SCORED_MARKS)";
	public static final String GETALLINDIAREPORTSUBJECTRANK1OFFLINE_QUERY = "SELECT COUNT(DISTINCT s2.SCORED_MARKS) AS CAMPUS_Rank  FROM el_offline_exam_results s1, el_offline_exam_results s2 where s2.Exam_Name= ? and s1.Exam_Name=? and s1.Student_Id=? and s2.el_subject_id=? and s1.el_subject_id=? and  (s1.SCORED_MARKS <= s2.SCORED_MARKS) ";
	public static final String GETCOUNTOFSCOREDMARKSFOREXAM2OFFLINE_QUERY = "SELECT count(*) FROM el_offline_exam_results sr, el_section sc,el_subject sb, el_branch br,el_state_type st  where sr.section = sc.el_section_id and sr.el_subject_id = sb.el_subject_id and sr.campus = br.el_branch_id and sr.state=st.state_type_id and sr.Exam_Name=? and sr.section=? and sr.state=? and sr.Student_Id=? and sr.campus=? and sr.el_subject_id=? order by sr.SCORED_MARKS desc";
	public static final String GETSCOREDMARKSFOREXAM2OFFLINE_QUERY = "SELECT sr.SCORED_MARKS  FROM el_offline_exam_results sr, el_section sc,el_subject sb, el_branch br,el_state_type st  "+ "where sr.section = sc.el_section_id and sr.el_subject_id = sb.el_subject_id and sr.campus = br.el_branch_id and sr.state=st.state_type_id and sr.Exam_Name=? and sr.section=? and sr.state=? and sr.Student_Id=? and sr.campus=? and sr.el_subject_id=? order by sr.SCORED_MARKS desc";
	public static final String GETPREVIOUSEXAMSUBJECTFORREPORTOFFLINE_QUERY = "select st.el_subject_name,sr.el_subject_id from el_offline_exam_results sr, el_subject st where sr.el_subject_id = st.el_subject_id and sr.Exam_Name=? group by sr.el_subject_id";
	
	/*** Below 100 RNK_Subject-wise  offline ***/
	public static final String GETEXAMSTRENGTHINCAMPUSWISEBELOW100RANKSOFFLINE_QUERY =  "select Count(*) from (select * from el_offline_exam_results where Exam_Name=? and campus=? group by Student_Id) as tbl";
	public static final String GETRANKCOUNTINCAMPUSWISEBELOW100RANKSOFFLINE_QUERY ="select  count(*) from (SELECT A.EXAM_SCORED_MARKS, (SELECT COUNT(*)+1  FROM el_offline_exam_results B WHERE A.EXAM_SCORED_MARKS<B.EXAM_SCORED_MARKS and A.campus=? and B.campus=? and A.el_subject_id=? and B.el_subject_id=? ) AS rank1 FROM el_offline_exam_results A where A.campus=? and A.el_subject_id=? and A.Exam_Name=? having rank1 <=100 ORDER BY  A.EXAM_SCORED_MARKS DESC) as tbl";
	public static final String GETMAXMARKSINCAMPUSWISEBELOW100RANKSOFFLINE_QUERY = "select max(SCORED_MARKS) from el_offline_exam_results where campus=? and el_subject_id=? and Exam_Name=?";
	public static final String GETCAMPUSNAMESINSTUDENTRESULTSOFFLINE_QUERY = "select st.el_branch_name,st.el_branch_id from el_offline_exam_results sr,el_branch st where sr.Exam_Name=? and st.el_branch_id=sr.campus group by sr.campus";

	/*** Section wise attendees with averages offline ***/
	public static final String GETACTUALSTUDENTSPRESENCEPERSECTIONOFFLINE_QUERY = "select count(*) as stucount from users ur where ur.el_section_id=? and ur.el_branch_id=?";
	public static final String GETACTUALSTUDENTSPRESENCEPERSECTIONINEXAMOFFLINE_QUERY ="select count(*) from (select * from el_offline_exam_results where section=? and exam_name=? and campus=? group by Student_Id) as tbl";
	public static final String GETAVGINSUBJECTSFROMCAMPUSSECTIONOFFLINE_QUERY = "select avg(SCORED_MARKS)as submarks_avg  from el_offline_exam_results sr where sr.section=? and sr.campus=? and el_subject_id=? and  exam_name=? ";
	public static final String GETAVGINTOTALMARKSFROMCAMPUSSECTIONOFFLINE_QUERY = "select avg(EXAM_SCORED_MARKS)as totalmarks_avg  from el_offline_exam_results sr where sr.section=? and sr.campus=?  and  exam_name=? ";
	public static final String GETCAMPUSSECTIONFROMSTUDENTRESULTSOFFLINE_QUERY = "select eb.el_branch_name, eb.el_branch_id, sc.el_section_id, sc.el_section_name from el_offline_exam_results es,el_branch eb, el_section sc where es.campus=eb.el_branch_id and es.exam_name=? and es.section = sc.el_section_id group by eb.el_branch_id,sc.el_section_id";
	
	/*** Slot based copy previous created exam pattern ***/
	public static final String GETEXAMNAMEFORCOPYSLOTEXAM_QUERY = "select Exam_Name from el_exam where is_slot=? group by Exam_Name";
	public static final String GETEXAMNAMEANDEXAMTYPEFORCOPYEXAM_QUERY = "select ex.exam_name,et.exam_type,et.exam_type_id from el_exam ex, el_exam_type et where ex.exam_name=? and ex.exam_type_id = et.exam_type_id group by ex.Exam_Name";
	public static final String GETPREVIOUSSTATESFORCOPYEXAM_QUERY = "select state_type_id from el_exam ex where ex.exam_name=? group by ex.Exam_Name";
	public static final String GETPREVIOUSLOCATIONSFORCOPYEXAM_QUERY = "select location_id from el_exam ex where ex.exam_name=? group by ex.Exam_Name";
	public static final String GETPREVIOUSBRANCHESFORCOPYEXAM_QUERY = "select branch_id from el_exam ex where ex.exam_name=? group by ex.Exam_Name";
	public static final String GETPREVIOUSQUELEVELIDSFORCOPYEXAM_QUERY = "select question_level_type_id from el_exam ex where ex.exam_name=? group by ex.Exam_Name";
	public static final String GETPREVIOUSCLASSIDSFORCOPYEXAM_QUERY = "select class_id from el_exam ex where ex.exam_name=? group by ex.Exam_Name";
	public static final String SECTIONIDS_QUERY = "select section_id from el_exam where exam_name=? group by exam_name ";
	public static final String GETPREVIOUSSECTIONIDSFORCOPYEXAM_QUERY = "select group_concat(distinct sc.el_section_id separator ',')as el_section_id ,group_concat( distinct sc.el_section_name separator ',') as el_section_name from el_exam ex, el_section sc where ex.exam_name=? and ex.class_id=? and sc.el_class_generated_id=? and sc.el_section_id in (?)";
	public static final String GETPREVIOUSSUBJECTSFORCOPYEXAM_QUERY = "select GROUP_CONCAT(el_subject_id SEPARATOR ', ') as subjectids from el_subject where el_subject_id in(select subject_id from el_exam where exam_name=? group by subject_id)";
	public static final String GETSELECTEDCLASSSUBJECTSFORCOPYEXAM_QUERY = "select tab1.el_subject_name,tab1.el_subject_id,(select sum(No_Of_Qus_Per_QusType) from el_exam where subject_id=tab1.el_subject_id and exam_name=? group by subject_id)  as subjectquestions from (select el_subject_id,el_subject_name from el_subject where el_class_generated_id in(select class_id from el_exam where exam_name=? group by exam_name)) as tab1 left join el_exam tab2 on tab1.el_subject_id=tab2.subject_id group by tab1.el_subject_id";
	public static final String GETSELECTEDSUBJECTQNSFORCOPYEXAM_QUERY = "select subject_id, sum(No_Of_Qus_Per_QusType) as subjectquestions from el_exam where exam_name=? group by subject_id";
	public static final String GETSUBJECTNAMEBASEDONSUBJID_QUERY = "select el_subject_name from el_subject where el_subject_id=?";
	public static final String GETSELECTEDTOPICIDSFORCOPYEXAMPERSUBJ_QUERY = "select topic_id from el_exam where exam_name=? and subject_id=? group by exam_name";
	public static final String GETSELECTEDSUBTOPICIDSFORCOPYEXAMPERSUBJ_QUERY = "select subtopic_id from el_exam where exam_name=? and subject_id=? group by exam_name";
	public static final String GETPREVIOUSISMARKSFORCOPYEXAM_QUERY = "select is_marks from el_exam where exam_name=? group by exam_name";
	public static final String GETPREVIOUSQUESTIONSTYPEDATAFORCOPYEXAM_QUERY = "select subject_id,Question_type_id,No_Of_Qus_Per_QusType,marks_per_qus_type,Negative_marks from el_exam where exam_name=? and Question_type_id=?";
	public static final String GETPREVIOUSQTYPEMARKSDATAFORCOPYEXAM_QUERY = "select subject_id,Question_type_id,No_Of_Qus_Per_QusType,marks_per_qus_type,Negative_marks from el_exam where exam_name=? and Question_type_id=? and subject_id=?";
	public static final String GETPREVIOUSQUESTIONTYPEFORCOPYEXAM_QUERY = "select group_concat(Question_type_id SEPARATOR', ') as question_type_id from el_exam where exam_name=? group by subject_id limit 1";
	public static final String GETPREVIOUSMARKSPERQUSTYPEFORCOPYEXAM_QUERY = "select marks_per_qus_type from el_exam where exam_name=? and is_marks=? group by marks_per_qus_type";
	public static final String GETPREVIOUSNEGATIVEMARKSFORCOPYEXAM_QUERY = "select Negative_marks from el_exam where exam_name=? group by exam_name";
	public static final String GETPREVIOUSSTARTTIMEFORCOPYEXAM_QUERY = "select starttime from el_exam where exam_name=? group by exam_name";
	public static final String GETPREVIOUSENDTIMEFORCOPYEXAM_QUERY = "select endtime from el_exam where exam_name=? group by exam_name";
	public static final String GETPREVIOUSTESTDURATIONFORCOPYEXAM_QUERY = "select testduration from el_exam where exam_name=? group by exam_name";
	public static final String GETALLTOPICIDS_QUERY = "select ifnull(group_concat(subject_topic_type_id),0) as topicids FROM el_subject_topic_type where subject_type_id=? and exam_type_id=?";
	public static final String GETALLSUBTOPICIDS_QUERY = "select ifnull(group_concat(subject_subtopic_type_id),0) as subtopicids FROM el_subject_subtopic_type where subject_type_id=? and exam_type_id=?";

	/*** Student exam assign ***/
	public static final String GETEXAMNAMESBASEONDATE_QUERY = "select * from el_exam where enddate>=current_date() group by exam_name";
	public static final String GETCLASSBASEONEXAMNAME_QUERY ="select el.exam_name,cl.el_class_name,cl.el_class_generated_id,es.el_section_name,tbl.secid from (SELECT distinct(SUBSTRING_INDEX(SUBSTRING_INDEX(section_id, ',', n.digit+1), ',', -1)) secid FROM el_exam INNER JOIN (SELECT 0 digit UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3) n ON LENGTH(REPLACE(section_id, ',' , '')) <= LENGTH(section_id)-n.digit and exam_name=?) as tbl , el_exam el,el_section es,el_class cl where exam_name=? and es.el_section_id=tbl.secid and es.el_class_generated_id=el.class_id and el.class_id=cl.el_class_generated_id and es.el_class_generated_id=cl.el_class_generated_id group by tbl.secid";
	public static final String GETEXAMPAPERDETBASEONEXMNAME_QUERY = "select ex.subject_id,ex.Question_id,ex.location_id,ex.branch_id,ex.class_id,ex.class_id,ex.section_id,ex.exam_paper_id,ex.marks_per_qus_type,ex.Negative_marks,ex.Question_type_id,ex.is_jumbling,(select qu.import_file_name from el_questions qu where qu.Question_Id=ex.Question_id) as filename from el_exam_paper ex where ex.exam_name=?";
	public static final String GETALREDYSTUDENTCOUNT_QUERY = "select ifnull(count(*),0) from temp_exam_history where Student_Id=? and examname=?";
	public static final String INSERTINTOTEMPHISTORY_QUERY = "insert into temp_exam_history (Student_Id,examname,subjectid,question_Id,Exam_Completion_Status,location_id,branch_id,class_id,section_id,exam_paper_id,marks_per_qus_type,negative_marks,filenames,question_type_id,is_jumbling) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GETSTUDENTDETAILS_QUERY = "SELECT el_section_id,el_class_generated_id,el_branch_id,el_location_id FROM users where student_id=?";
	public static final String GETEXAMDATABASEDONEXAMNAME_QUERY = "select * from el_exam where exam_name=? group by exam_name";
	public static final String GETCOUNTINTEMPHISTRORY_QUERY = "select ifnull(count(us.Student_Id),0) from users us,temp_exam_history te where us.Student_Id !=te.Student_Id and us.el_class_generated_id=te.class_Id and us.el_class_generated_id=? and us.el_section_id in(?) and us.state_type_id in (?) and us.el_location_id in (?) and us.el_branch_id in (?) and te.examname=?";

	/*** Upload Dat file ***/
	public static final String GETCOUNTFOROFFLINEKEYS_QUERY =  "select count(*) from el_offline_key where exam_name=? ";
	public static final String GETACTUALOFFLINEKEY_QUERY =  "select question_key,el_subject_id,offline_key_id from el_offline_key where question_id=? and exam_name=?";
	public static final String UPDATEKEYSTATUS_QUERY = "update el_offline_key set is_dat_file_generated=? where exam_name=?";
	
	/*** Result calculation ***/
	public static final String GETEXAMNAMEFOROFFLINEOFFLINE_QUERY =  "select exam_name from el_offline_exam_resulthistory where is_result_calculation=? group by exam_name";
	public static final String GETSTUDENTIDSBASEDONEXAMNAME_QUERY ="select distinct(Student_ID) from el_offline_exam_resulthistory where exam_name=?";
	public static final String GETSUBJECTNAMESINOFFLINEEXAM_QUERY =  "select el_subject_id from el_offline_exam_resulthistory where exam_name=? group by el_subject_id";
	public static final String GETCOUNTOFSUBJECTNAMESINOFFLINEEXAM_QUERY =  "select count(*) from (select el_subject_id from el_offline_exam_resulthistory where exam_name=? group by el_subject_id) as tbl";
	public static final String GETTOTALMARKSFOROFFLINEEXAM_QUERY = "select total_marks from el_offline_key where exam_name=? group by exam_name";
	public static final String GETTOTALQUESTIONSINOFFLINEEXAM_QUERY = "select Total_Questions from el_offline_key where exam_name=? group by exam_name";
	public static final String GETOFFLINEEXAMDATAINHISTORY_QUERY =  "select * from el_offline_exam_resulthistory where exam_name=? and Student_ID=? and el_subject_id=?";
	public static final String GETQUSTYPEBASEDONQIDINOFFLINEEXAM_QUERY = "select question_type_id from el_offline_key where exam_name=? and question_id=?";
	public static final String GETCORRECTKEYINKEYSHEET_QUERY = "select question_key from el_offline_key where exam_name=? and question_id=?";
	public static final String INSERTSTUDENTRESULTSFOROFFLINEEXAM_QUERY = "insert into el_offline_exam_results(Student_Id,Exam_Name,el_subject_id,total_marks,Total_Questions,Correct_Answers,Wrong_Answers,not_answered,subject_total_marks,SCORED_MARKS,negative_marks,studentname,class_id,section,campus,state,el_location_id)  "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATEEXAMSCOREDMARKSOFFLINEXAM_QUERY = "update el_offline_exam_results set EXAM_SCORED_MARKS=? where Exam_Name=? and Student_Id=?";
	public static final String UPDATEISRESULTSCALCULATIONSSTATUS_QUERY = "update el_offline_exam_resulthistory set is_result_calculation=? where Student_ID=? and exam_name=?";
	public static final String GETSCOREDMARKSINOFFLINEEXAM_QUERY = "select marks_per_ques_type from el_offline_key where exam_name=? and question_type_id=? and el_subject_id=? group by question_type_id";
	public static final String GETNEGATIVEMARKSINOFFLINEEXAM_QUERY = "select negative_marks from el_offline_key where exam_name=? and question_type_id=? and el_subject_id=? group by question_type_id";

	/*** Offline AllIndiaRank Analysis ***/
	public static final String GETUSERDETAILSFROMSTUDENTRESULTSOFFLINE_QUERY = "SELECT sr.Student_Id,sr.studentname, sc.el_section_name, sr.SCORED_MARKS, sb.el_subject_name, "
			+ "sr.campus,sr.state,sr.section,br.el_branch_name, sr.total_marks,sr.el_subject_id,st.state_type,sr.class_id,"
			+ "(select user_name from users us where us.student_id=sr.Student_Id) as username  "
			+ "FROM el_offline_exam_results sr, el_section sc,el_subject sb, el_branch br,el_state_type st  where "
			+ "sr.section = sc.el_section_id and sr.el_subject_id = sb.el_subject_id and sr.state=st.state_type_id "
			+ "and sr.campus = br.el_branch_id and sr.Exam_Name=? and sb.el_subject_id=? order by sr.SCORED_MARKS desc";

	/*** AdminAccess Roles ***/
	public static final String GETPERMISSIONSFORLOGGEDUSERS_QUERY = "select pr.* from permissions pr, role_perm rp where pr.perm_id = rp.perm_id and  rp.student_id = ? order by pr.perm_id";
	
	/*** CampusWiseErrorReport ***/
	public static final String GETUSERDETAILSFROMSTUDENTRESULTSHISTORY_QUERY ="SELECT br.el_branch_name,br.el_branch_id FROM el_student_result_history sr,el_branch br  where  sr.Exam_Name=? and sr.campus=br.el_branch_id group by br.el_branch_id";
	public static final String GETSUBJECTSFROMSTUDENTRESULTSINCAMPUS_QUERY = "select sr.el_subject_id,sb.el_subject_name,sr.total_marks,sr.subject_total_marks  from el_student_results sr,el_subject sb "
			+ "where sr.Exam_Name=? and sr.campus=? and sr.el_subject_id=sb.el_subject_id group by sr.el_subject_id order by sr.el_subject_id";
	
	/*** Offline CampusWiseErrorReportController ***/
	public static final String GETUSERDETAILSFROMSTUDENTRESULTSHISTORYOFFLINE_QUERY =  "SELECT br.el_branch_name,br.el_branch_id"+ " FROM el_offline_exam_resulthistory sr,el_branch br  where  sr.Exam_Name=? and sr.campus=br.el_branch_id group by br.el_branch_id";
	
	/*** AED  Subject sub topic ***/
	public static final String SEARCHSUBJECTFORCLASSFROMADMIN_QUERY ="select * from el_subject where el_class_generated_id=?";
	public static final String GETTOPICSFROMADMIN_QUERY = "select * from el_subject_topic_type where el_class_generated_id=? and subject_type_id=? ";
	public static final String DELETEDATAINTOSUBJECTSUBTOPICTYPETABLE_QUERY = "delete from el_subject_subtopic_type where subject_subtopic_type=?  and  subject_topic_type_id=? and subject_subtopic_type_id=? ";
	public static final String GETSUBTOPICSFROMADMIN_QUERY =  "select * from el_questions eq where eq.subtopic not in(select stt.subject_subtopic_type_id from el_subject_subtopic_type stt) and eq.subject_type=? and eq.topic=? group by eq.subtopic";
	
	/*** AED subject topic ***/
	public static final String SEARCHTOPICSFORSUBJECTSFROMADMIN_QUERY =  "select * from el_questions eq where eq.topic not in(select stt.subject_topic_type_id from el_subject_topic_type stt)  and eq.subject_type=? group by  eq.topic";
	public static final String GETTOPICNAMEFROMTOPICTABLE_QUERY = "select * from el_subject_topic_type where el_class_generated_id=? and subject_type_id=?  and subject_topic_type_id=? ";
	public static final String DELETEALLDATAINTOSUBJECTSUBTOPICTYPETABLE_QUERY = "delete from el_subject_subtopic_type where subject_topic_type_id=? ";
	public static final String DELETEDATAINTOSUBJECTTOPICTYPETABLE_QUERY ="delete from el_subject_topic_type where subject_topic_type=? and el_class_generated_id=? and subject_type_id=? and subject_topic_type_id=?";
	
	/*** View Offline reports ***/
	public static final String GETEXAMNAMEFOROFFLINEREPORT_QUERIES =  "select exam_name from el_offline_exam_resulthistory where is_result_calculation=? group by exam_name";
	
	/*** Offline analysis ***/
	public static final String VALIDATEEXAMNAMEFOROFFLINE_QUERY = "select exam_name from el_offline_exam_resulthistory where exam_name=?";
	
	/***** Delete exam ******/
	public static final String GETEXAMNAMEFORCOPYEXAM_QUERY = "select Exam_Name from el_exam group by Exam_Name";
	public static final String GETSELECTEXAMNAMEINSTUDENTRESULTS_QUERY = "select count(*) from (select * from el_student_results where Exam_Name=? group by Exam_Name) as tbl";
	public static final String GETSELECTEXAMNAMEINSTUDENTRESULTSHISTORY_QUERY ="select count(*) from (select * from el_student_result_history where Exam_Name=? group by Exam_Name) as tbl";
	public static final String GETDELETEEXAMNAME_QUERY = "delete  from el_exam where exam_name=?";
	public static final String GETDELETEEXAMNAMEINEXAMPAPER_QUERY = "delete  from el_exam_paper where exam_name=?";
	public static final String GETDELETEEXAMNAMEINEXAMPAPER1_QUERY = "delete  from el_exam_paper1 where exam_name=?";
	public static final String GETDELETEEXAMNAMEINTEMPHISTRORY_QUERY = "delete  from temp_exam_history where examname=?";
	
	/*** Set exam with random questions ***/
	public static final String GETEXAMNAMEFORADDCOMPHQUES_QUERY = "select exam_name from el_exam where exam_name not in (select Exam_Name from el_student_results group by exam_name) group by exam_name";
	public static final String UPDATERANDOMQUESTIONSINEXAMPAPER_QUERY = "update el_exam_paper set is_jumbling=? where exam_name=?";
	public static final String GETQUSTYPETOTALMARKS_QUERY = "select sum(marks_per_ques_type) as qustypetotalmarks from el_offline_key where exam_name=? and el_subject_id=? and exam_type_id=? and question_type_id=? ";
	
	
	


}
