package COMP5703.cp20.group2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface habitMapper {
	//----------------------common use------------------
	//count total number of patient from one user
	@Select("select count(patientid) from patient where source=#{username}")
	int counttotalpatient(@Param("username")String username);
	
	//---------------------------smoking-------------------------------------

	//count total number of smoking
		@Select("select count(patientid) from patient where smoking=true and source=#{username}")
		int countsmoking(@Param("username")String username);
		
	//count total number of non-smoking
		@Select("select count(patientid) from patient where smoking=false and source=#{username}")
		int countnonsmoking(@Param("username")String username);
	
	//count number of smoking stroke patient 
	@Select("select count(patientid) from patient where smoking=true "
			+ "and ifhavedisease = true and source=#{username}")
	int countsmokingstroke(@Param("username") String username);
	// number of smoking non stroke patient 
	@Select("select count(patientid) from patient where smoking=true "
			+ "and ifhavedisease = false and source=#{username}")
	int countsmokingnonstroke(@Param("username") String username);
	
	// number of non smoking stroke patient
	@Select("select count(patientid) from patient where smoking=false "
			+ "and ifhavedisease = true and source=#{username}")
	int countnonsmokingstroke(@Param("username") String username);
	// number of non smoking non stroke patient 
	@Select("select count(patientid) from patient where smoking=false "
			+ "and ifhavedisease = false and source=#{username}")
	int countnonsmokingnonstroke(@Param("username") String username);
	
	
	//---------------------------alcohol-------------------------------------
		
		//count total number of alcohol
			@Select("select count(patientid) from patient where alcohol=true and source=#{username}")
			int countalcohol(@Param("username")String username);
			
		//count total number of non-smoking
			@Select("select count(patientid) from patient where alcohol=false and source=#{username}")
			int countnonalcohol(@Param("username")String username);
		
		//count number of smoking stroke patient 
		@Select("select count(patientid) from patient where alcohol=true "
				+ "and ifhavedisease = true and source=#{username}")
		int countalcoholstroke(@Param("username") String username);
		// number of smoking non stroke patient 
		@Select("select count(patientid) from patient where alcohol=true "
				+ "and ifhavedisease = false and source=#{username}")
		int countalcoholnonstroke(@Param("username") String username);
		
		// number of non smoking stroke patient
		@Select("select count(patientid) from patient where alcohol=false "
				+ "and ifhavedisease = true and source=#{username}")
		int countnonalcoholstroke(@Param("username") String username);
		// number of non smoking non stroke patient 
		@Select("select count(patientid) from patient where alcohol=false "
				+ "and ifhavedisease = false and source=#{username}")
		int countnonalcoholnonstroke(@Param("username") String username);
		
		//---------------------------carbonate drink-------------------------------------
		
				//count total number of alcohol
					@Select("select count(patientid) from patient where softdrink=true and source=#{username}")
					int countsoftdrink(@Param("username")String username);
					
				//count total number of non-smoking
					@Select("select count(patientid) from patient where softdrink=false and source=#{username}")
					int countnonsoftdrink(@Param("username")String username);
				
				//count number of smoking stroke patient 
				@Select("select count(patientid) from patient where softdrink=true "
						+ "and ifhavedisease = true and source=#{username}")
				int countsoftdrinkstroke(@Param("username") String username);
				// number of smoking non stroke patient 
				@Select("select count(patientid) from patient where softdrink=true "
						+ "and ifhavedisease = false and source=#{username}")
				int countsoftdrinknonstroke(@Param("username") String username);
				
				// number of non smoking stroke patient
				@Select("select count(patientid) from patient where softdrink=false "
						+ "and ifhavedisease = true and source=#{username}")
				int countnonsoftdrinkstroke(@Param("username") String username);
				// number of non smoking non stroke patient 
				@Select("select count(patientid) from patient where softdrink=false "
						+ "and ifhavedisease = false and source=#{username}")
				int countnonsoftdrinknonstroke(@Param("username") String username);
				
				//---------------------------exercise-------------------------------------
				
				//count total number of alcohol
					@Select("select count(patientid) from patient where exercise=true and source=#{username}")
					int countexercise(@Param("username")String username);
					
				//count total number of non-smoking
					@Select("select count(patientid) from patient where exercise=false and source=#{username}")
					int countnonexercise(@Param("username")String username);
				
				//count number of smoking stroke patient 
				@Select("select count(patientid) from patient where exercise=true "
						+ "and ifhavedisease = true and source=#{username}")
				int countexercisestroke(@Param("username") String username);
				// number of smoking non stroke patient 
				@Select("select count(patientid) from patient where exercise=true "
						+ "and ifhavedisease = false and source=#{username}")
				int countexercisenonstroke(@Param("username") String username);
				
				// number of non smoking stroke patient
				@Select("select count(patientid) from patient where exercise=false "
						+ "and ifhavedisease = true and source=#{username}")
				int countnonexercisestroke(@Param("username") String username);
				// number of non smoking non stroke patient 
				@Select("select count(patientid) from patient where exercise=false "
						+ "and ifhavedisease = false and source=#{username}")
				int countnonexercisenonstroke(@Param("username") String username);
	
	//--------------------------------advanced analysis-----------------------
			
				
				//select total number of stroke patient
				@Select("select count(patientid) from patient where ifhavedisease=true and source=#{username}")
				int countstrokepatient(@Param("username")String username);
				
				//select number of patient with smoking and drinking
				@Select("select count(patientid) from patient where ifhavedisease=true "
						+ "and smoking=true and alcohol=true and source=#{username}")
				int countsmokingdrinking(@Param("username")String username);
				
				//select number of non patient with smoking and drinking
				@Select("select count(patientid) from patient where ifhavedisease=false "
						+ "and smoking=true and alcohol=true and source=#{username}")
				int countsmokingdrinkingnon(@Param("username")String username);
				
				//select number of patient with drinking and sodas
				@Select("select count(patientid) from patient where ifhavedisease=true "
						+ "and softdrink=true and alcohol=true and source=#{username}")
				int countdrinkingsodas(@Param("username")String username);
				
				//select number of non patient with drinking and sodas
				@Select("select count(patientid) from patient where ifhavedisease=false "
						+ "and softdrink=true and alcohol=true and source=#{username}")
				int countdrinkingsodasnon(@Param("username")String username);
				
				//select number of patient with smoking and sodas
				@Select("select count(patientid) from patient where ifhavedisease=true "
						+ "and softdrink=true and smoking=true and source=#{username}")
				int countsmokingsodas(@Param("username")String username);
				
				//select number of non patient with smoking and sodas
				@Select("select count(patientid) from patient where ifhavedisease=false "
						+ "and softdrink=true and smoking=true and source=#{username}")
				int countsmokingsodasnon(@Param("username")String username);
				
				//select number of patient with smoking and sodas and alcohol
				@Select("select count(patientid) from patient where ifhavedisease=true "
						+ "and softdrink=true and smoking=true and alcohol=true and source=#{username}")
				int countsmokingdrinkingsodas(@Param("username")String username);
				
				//select number of non patient with smoking and sodas and alcohol
				@Select("select count(patientid) from patient where ifhavedisease=false "
						+ "and softdrink=true and smoking=true and alcohol=true and source=#{username}")
				int countsmokingdrinkingsodasnon(@Param("username")String username);
				
				
}
