package COMP5703.cp20.group2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import COMP5703.cp20.group2.domain.drugusage;
import COMP5703.cp20.group2.domain.patient;
import COMP5703.cp20.group2.domain.stroke_lab;

@Mapper
public interface insertMapper {
	
@Insert("insert into patient(PATIENTID,IIM_NO, FULLNAME, AGE, DATEOFBIRTH, "
		+ "GENDER, RACE, SOURCE, DISEASE, ADMISSIONDATE, DISCHARGEDATE, "
		+ "IFHAVEDISEASE, SMOKING, ALCOHOL, SOFTDRINK, EXERCISE) values "
		+ "(#{patientID},#{IIM_NO},#{Fullname}, #{Age}, #{DateOfBirth}, #{Gender}, "
		+ "#{Race},#{Source},#{Disease},#{AdmissionDate},#{DischargeDate},"
		+ "#{Ifhavedisease},#{Smoking},#{Alcohol},#{Softdrink},#{Exercise})")
	void patientInsert(patient patient);

@Insert("insert into stroke_lab(patientID,HBA1C0,HBA1C3,HBA1C12,GLUCOSE0,GLUCOSE3,"
		+ "GLUCOSE12,CHOLEST0,CHOLEST3,CHOLEST12,TRI0,TRI3,TRI12,HDL0,HDL3,HDL12,"
		+ "LDL0,LDL3,LDL12) values (#{patientID},#{HBA1C0},#{HBA1C3},#{HBA1C12},#{Glucose0},"
		+ "#{Glucose3},#{Glucose12},#{Cholest0},#{Cholest3},#{Cholest12},#{TRI0},#{TRI3},#{TRI12},"
		+ "#{HDL0},#{HDL3},#{HDL12},#{LDL0},#{LDL3},#{LDL12})")
    void strokelabInsert(stroke_lab stroke_lab);

@Insert("insert into drugusage(patientID, aspirin,warfarin,clopidogrel) values (#{patientID},"
		+ "#{Aspirin},#{Warfarin},#{clopidogrel})" )
    void drugInsert(drugusage drugusage);



}
