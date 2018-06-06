package COMP5703.cp20.group2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import COMP5703.cp20.group2.domain.patient;
import COMP5703.cp20.group2.domain.searchmodel.oneIndicatorAndoneStyle;

@Mapper
public interface patientMapper {
	
	//select all patient
	@Select("select * from patient")
	List<patient> findAll();

	//select iim_no and age
	@Select("select iim_no, age from patient")
	@Results({
		@Result(property="IIM_NO", column="IIM_NO"),
		@Result(property="Age", column="Age")})
	List<patient> findtnoandage();
	

	
	
//----------------------------patient existence check
	
	//check the existence of patient
	@Select("select * from patient where iim_no=#{iim_no};")
	patient selectbyid(int iim_no);
	
	//select patientID based on patientID, this is for checking whether the patient already existed
	@Select("select iim_no from patient where iim_no = #{iim_no}")
	Double selectID(double iim_no);
	
	//select patientID based on patientID and source, checking whether the patient of the user already existed
	@Select("select iim_no from patient where iim_no =#{iim_no} and source=#{username}")
	Double selectUserPatient(@Param("iim_no")Double iim_no, @Param("username")String username);
	
	
	
	//--------------------------patientoverview------------------------------------
	//count total number of patient
	@Select("select count(patientid) from patient where source=#{username}")
     int countPatientNo(String username);
	
	//get disease type from user's dataset
	@Select("select distinct(disease) from patient where source=#{username}")
	String selectdisease(@Param("username") String usernme);
	
	//select number of patient based on country
	@Select("select count(patientid) from patient where race like '%chinese%' and source=#{username}")
	int selectChinese(@Param("username")String username);
	
	@Select("select count(patientid) from patient where race like '%australia%' and source=#{username}")
	int selectAustralian(@Param("username")String username);
	
	@Select("select count(patientid) from patient where race like '%japan%' and source=#{username}")
	int selectJapanese(@Param("username")String username);
	
	@Select("select count(patientid) from patient where race like '%russia%' and source=#{username}")
	int selectRussian(@Param("username")String username);
	
	@Select("select count(patientid) from patient where race like '%india%' and source=#{username}")
	int selectIndian(@Param("username")String username);
	
	@Select("select count(patientid) from patient where race like '%korea%' and source=#{username}")
	int selectKorean(@Param("username")String username);
	
	
	//count number of patients who have stroke
	@Select("select count(patientid) from patient where ifhavedisease=true and source=#{username}")
    Double strokepatient(@Param("username")String username);
	
	//count number of patients who don't have stroke
	@Select("select count(iim_no) from patient where ifhavedisease=false and source=#{username}")
    Double nonstrokepatient(@Param("username")String username);
	
	//count average age of stroke patient
	@Select("select avg(age) from patient where ifhavedisease=true and source=#{username}")
    Double averageAge(@Param("username")String username);
	
	//count patient number of different age group
	@Select("select count(patientid) from patient where (age between 60 and 70) and ifhavedisease=true and source=#{username}")
	int agefrom60_70(String username);
	
	@Select("select count(iim_no) from patient where (age between 70 and 80) and ifhavedisease=true and source=#{username}")
	int agefrom70_80(String username);
	
	@Select("select count(iim_no) from patient where (age between 80 and 90) and ifhavedisease=true and source=#{username}")
	int agefrom80_90(String username);
	
	@Select("select count(iim_no) from patient where (age between 90 and 100) and ifhavedisease=true and source=#{username}")
	int agefrom90_100(String username);
	
	//select patient number of male
	@Select("select count(patientID) from patient where (gender='M' or gender='male')  and source=#{username}")
	Double selectmale(@Param("username")String username);
	//select patient number of female
	@Select("select count(patientID) from patient where (gender='F' or gender='female')  and source=#{username}")
	Double selectfemale(@Param("username")String username);
	
	
	//--------------------------lab result select------------------------
	//select avg HDL0 value of particular patient
	@Select("select avg(HDL0) from stroke_lab;")
	Double HDL0selection();
	
	//select  avg HDL3 of particular patient
	@Select("select avg(HDL3) from stroke_lab;")
	Double HDL3selection();
	
	//select  avg HDL12 of particular patient
	@Select("select avg(HDL12) from stroke_lab;")
	Double HDL12selection();
	

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
