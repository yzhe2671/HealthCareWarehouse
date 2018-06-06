package COMP5703.cp20.group2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface drugMapper {

	//--------------------------HBA1C average------------------------------------
	@Select("select avg(`HBA1C0`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and source=#{username}")
	Double selecthba1c0(@Param("username")String username);
	
	@Select("select avg(`HBA1C3`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and source=#{username}")
	Double selecthba1c3(@Param("username")String username);
	
	@Select("select avg(`HBA1C12`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and source=#{username}")
	Double selecthba1c12(@Param("username")String username);
	
	//--------------------------HBA1C aspirin 1-3
	
	@Select("select avg(`HBA1C0`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and aspirin<=3 and aspirin>=1 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null")
	Double selectAhba1c0_1_3(@Param("username")String username);
	
	@Select("select avg(`HBA1C3`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and aspirin<=3 and aspirin>=1 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null")
	Double selectAhba1c3_1_3(@Param("username")String username);
	
	//---------------------------HBA1C aspirin 3-7
	
	@Select("select avg(`HBA1C0`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectAhba1c0_3_7(@Param("username")String username);
	
	@Select("select avg(`HBA1C3`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectAhba1c3_3_7(@Param("username")String username);
	
	@Select("select avg(`HBA1C12`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectAhba1c12_3_7(@Param("username")String username);
	
	//--------------------------HBA1C aspirin 7-12
	
	@Select("select avg(`HBA1C0`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectAhba1c0_7_12(@Param("username")String username);
	
	@Select("select avg(`HBA1C3`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectAhba1c3_7_12(@Param("username")String username);
	
	@Select("select avg(`HBA1C12`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectAhba1c12_7_12(@Param("username")String username);
	
	//--------------------------HBA1C warfarin 1-3
	
	@Select("select avg(`HBA1C0`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and warfarin<=3 and warfarin>=1 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null")
	Double selectWhba1c0_1_3(@Param("username")String username);
	
	@Select("select avg(`HBA1C3`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and warfarin<=3 and warfarin>=1 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null")
	Double selectWhba1c3_1_3(@Param("username")String username);
	
	//---------------------------HBA1C warfarin 3-7
	
	@Select("select avg(`HBA1C0`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectWhba1c0_3_7(@Param("username")String username);
	
	@Select("select avg(`HBA1C3`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectWhba1c3_3_7(@Param("username")String username);
	
	@Select("select avg(`HBA1C12`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectWhba1c12_3_7(@Param("username")String username);
	
	//--------------------------HBA1C warfarin 7-12
	
	@Select("select avg(`HBA1C0`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectWhba1c0_7_12(@Param("username")String username);
	
	@Select("select avg(`HBA1C3`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectWhba1c3_7_12(@Param("username")String username);
	
	@Select("select avg(`HBA1C12`)from drugusage natural join patient natural join stroke_lab"
			+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
			+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
	Double selectWhba1c12_7_12(@Param("username")String username);
	
	//--------------------------HBA1C clopidogrel 1-3
	
		@Select("select avg(`HBA1C0`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and clopidogrel<=3 and clopidogrel>=1 and source=#{username}"
				+ "and HBA1C0 is not null and HBA1C3 is not null")
		Double selectChba1c0_1_3(@Param("username")String username);
		
		@Select("select avg(`HBA1C3`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and clopidogrel<=3 and clopidogrel>=1 and source=#{username}"
				+ "and HBA1C0 is not null and HBA1C3 is not null")
		Double selectChba1c3_1_3(@Param("username")String username);
		
		//---------------------------HBA1C clopidogrel 3-7
		
		@Select("select avg(`HBA1C0`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
				+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
		Double selectChba1c0_3_7(@Param("username")String username);
		
		@Select("select avg(`HBA1C3`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
				+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
		Double selectChba1c3_3_7(@Param("username")String username);
		
		@Select("select avg(`HBA1C12`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
				+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
		Double selectChba1c12_3_7(@Param("username")String username);
		
		//--------------------------HBA1C clopidogrel 7-12
		
		@Select("select avg(`HBA1C0`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
				+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
		Double selectChba1c0_7_12(@Param("username")String username);
		
		@Select("select avg(`HBA1C3`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
				+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
		Double selectChba1c3_7_12(@Param("username")String username);
		
		@Select("select avg(`HBA1C12`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
				+ "and HBA1C0 is not null and HBA1C3 is not null and HBA1C12 is not null")
		Double selectChba1c12_7_12(@Param("username")String username);
		
		//--------------------------glucose average------------------------------------
		@Select("select avg(`glucose0`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and source=#{username}")
		Double selectglucose0(@Param("username")String username);
		
		@Select("select avg(`glucose3`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and source=#{username}")
		Double selectglucose3(@Param("username")String username);
		
		@Select("select avg(`glucose12`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and source=#{username}")
		Double selectglucose12(@Param("username")String username);
		
		//--------------------------glucose aspirin 1-3
		
		@Select("select avg(`glucose0`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and aspirin<=3 and aspirin>=1 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null")
		Double selectAglucose0_1_3(@Param("username")String username);
		
		@Select("select avg(`glucose3`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and aspirin<=3 and aspirin>=1 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null")
		Double selectAglucose3_1_3(@Param("username")String username);
		
		//---------------------------glucose aspirin 3-7
		
		@Select("select avg(`glucose0`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectAglucose0_3_7(@Param("username")String username);
		
		@Select("select avg(`glucose3`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectAglucose3_3_7(@Param("username")String username);
		
		@Select("select avg(`glucose12`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectAglucose12_3_7(@Param("username")String username);
		
		//--------------------------glucose aspirin 7-12
		
		@Select("select avg(`glucose0`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectAglucose0_7_12(@Param("username")String username);
		
		@Select("select avg(`glucose3`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectAglucose3_7_12(@Param("username")String username);
		
		@Select("select avg(`glucose12`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectAglucose12_7_12(@Param("username")String username);
		
		//--------------------------glucose warfarin 1-3
		
		@Select("select avg(`glucose0`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and warfarin<=3 and warfarin>=1 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null")
		Double selectWglucose0_1_3(@Param("username")String username);
		
		@Select("select avg(`glucose3`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and warfarin<=3 and warfarin>=1 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null")
		Double selectWglucose3_1_3(@Param("username")String username);
		
		//---------------------------glucose warfarin 3-7
		
		@Select("select avg(`glucose0`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectWglucose0_3_7(@Param("username")String username);
		
		@Select("select avg(`glucose3`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectWglucose3_3_7(@Param("username")String username);
		
		@Select("select avg(`glucose12`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectWglucose12_3_7(@Param("username")String username);
		
		//--------------------------glucose warfarin 7-12
		
		@Select("select avg(`glucose0`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectWglucose0_7_12(@Param("username")String username);
		
		@Select("select avg(`glucose3`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectWglucose3_7_12(@Param("username")String username);
		
		@Select("select avg(`glucose12`)from drugusage natural join patient natural join stroke_lab"
				+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
				+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
		Double selectWglucose12_7_12(@Param("username")String username);
		
		//--------------------------glucose clopidogrel 1-3
		
			@Select("select avg(`glucose0`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and clopidogrel<=3 and clopidogrel>=1 and source=#{username}"
					+ "and glucose0 is not null and glucose3 is not null")
			Double selectCglucose0_1_3(@Param("username")String username);
			
			@Select("select avg(`glucose3`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and clopidogrel<=3 and clopidogrel>=1 and source=#{username}"
					+ "and glucose0 is not null and glucose3 is not null")
			Double selectCglucose3_1_3(@Param("username")String username);
			
			//---------------------------glucose clopidogrel 3-7
			
			@Select("select avg(`glucose0`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
					+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
			Double selectCglucose0_3_7(@Param("username")String username);
			
			@Select("select avg(`glucose3`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
					+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
			Double selectCglucose3_3_7(@Param("username")String username);
			
			@Select("select avg(`glucose12`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
					+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
			Double selectCglucose12_3_7(@Param("username")String username);
			
			//--------------------------glucose clopidogrel 7-12
			
			@Select("select avg(`glucose0`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
					+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
			Double selectCglucose0_7_12(@Param("username")String username);
			
			@Select("select avg(`glucose3`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
					+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
			Double selectCglucose3_7_12(@Param("username")String username);
			
			@Select("select avg(`glucose12`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
					+ "and glucose0 is not null and glucose3 is not null and glucose12 is not null")
			Double selectCglucose12_7_12(@Param("username")String username);
			
			
			
			//--------------------------cholest average------------------------------------
			@Select("select avg(`cholest0`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and source=#{username}")
			Double selectcholest0(@Param("username")String username);
			
			@Select("select avg(`cholest3`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and source=#{username}")
			Double selectcholest3(@Param("username")String username);
			
			@Select("select avg(`cholest12`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and source=#{username}")
			Double selectcholest12(@Param("username")String username);
			
			//--------------------------cholest aspirin 1-3
			
			@Select("select avg(`cholest0`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and aspirin<=3 and aspirin>=1 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null")
			Double selectAcholest0_1_3(@Param("username")String username);
			
			@Select("select avg(`cholest3`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and aspirin<=3 and aspirin>=1 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null")
			Double selectAcholest3_1_3(@Param("username")String username);
			
			//---------------------------cholest aspirin 3-7
			
			@Select("select avg(`cholest0`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectAcholest0_3_7(@Param("username")String username);
			
			@Select("select avg(`cholest3`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectAcholest3_3_7(@Param("username")String username);
			
			@Select("select avg(`cholest12`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectAcholest12_3_7(@Param("username")String username);
			
			//--------------------------cholest aspirin 7-12
			
			@Select("select avg(`cholest0`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectAcholest0_7_12(@Param("username")String username);
			
			@Select("select avg(`cholest3`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectAcholest3_7_12(@Param("username")String username);
			
			@Select("select avg(`cholest12`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectAcholest12_7_12(@Param("username")String username);
			
			//--------------------------cholest warfarin 1-3
			
			@Select("select avg(`cholest0`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and warfarin<=3 and warfarin>=1 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null")
			Double selectWcholest0_1_3(@Param("username")String username);
			
			@Select("select avg(`cholest3`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and warfarin<=3 and warfarin>=1 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null")
			Double selectWcholest3_1_3(@Param("username")String username);
			
			//---------------------------cholest warfarin 3-7
			
			@Select("select avg(`cholest0`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectWcholest0_3_7(@Param("username")String username);
			
			@Select("select avg(`cholest3`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectWcholest3_3_7(@Param("username")String username);
			
			@Select("select avg(`cholest12`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectWcholest12_3_7(@Param("username")String username);
			
			//--------------------------cholest warfarin 7-12
			
			@Select("select avg(`cholest0`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectWcholest0_7_12(@Param("username")String username);
			
			@Select("select avg(`cholest3`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectWcholest3_7_12(@Param("username")String username);
			
			@Select("select avg(`cholest12`)from drugusage natural join patient natural join stroke_lab"
					+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
					+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
			Double selectWcholest12_7_12(@Param("username")String username);
			
			//--------------------------cholest clopidogrel 1-3
			
				@Select("select avg(`cholest0`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and clopidogrel<=3 and clopidogrel>=1 and source=#{username}"
						+ "and cholest0 is not null and cholest3 is not null")
				Double selectCcholest0_1_3(@Param("username")String username);
				
				@Select("select avg(`cholest3`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and clopidogrel<=3 and clopidogrel>=1 and source=#{username}"
						+ "and cholest0 is not null and cholest3 is not null")
				Double selectCcholest3_1_3(@Param("username")String username);
				
				//---------------------------cholest clopidogrel 3-7
				
				@Select("select avg(`cholest0`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
						+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
				Double selectCcholest0_3_7(@Param("username")String username);
				
				@Select("select avg(`cholest3`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
						+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
				Double selectCcholest3_3_7(@Param("username")String username);
				
				@Select("select avg(`cholest12`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
						+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
				Double selectCcholest12_3_7(@Param("username")String username);
				
				//--------------------------cholest clopidogrel 7-12
				
				@Select("select avg(`cholest0`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
						+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
				Double selectCcholest0_7_12(@Param("username")String username);
				
				@Select("select avg(`cholest3`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
						+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
				Double selectCcholest3_7_12(@Param("username")String username);
				
				@Select("select avg(`cholest12`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
						+ "and cholest0 is not null and cholest3 is not null and cholest12 is not null")
				Double selectCcholest12_7_12(@Param("username")String username);
				
				
				//--------------------------TRI average------------------------------------
				@Select("select avg(`tri0`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and source=#{username}")
				Double selecttri0(@Param("username")String username);
				
				@Select("select avg(`tri3`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and source=#{username}")
				Double selecttri3(@Param("username")String username);
				
				@Select("select avg(`tri12`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and source=#{username}")
				Double selecttri12(@Param("username")String username);
				
				//--------------------------tri aspirin 1-3
				
				@Select("select avg(`tri0`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and aspirin<=3 and aspirin>=1 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null")
				Double selectAtri0_1_3(@Param("username")String username);
				
				@Select("select avg(`tri3`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and aspirin<=3 and aspirin>=1 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null")
				Double selectAtri3_1_3(@Param("username")String username);
				
				//---------------------------tri aspirin 3-7
				
				@Select("select avg(`tri0`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectAtri0_3_7(@Param("username")String username);
				
				@Select("select avg(`tri3`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectAtri3_3_7(@Param("username")String username);
				
				@Select("select avg(`tri12`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and aspirin<=7 and aspirin>3 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectAtri12_3_7(@Param("username")String username);
				
				//--------------------------tri aspirin 7-12
				
				@Select("select avg(`tri0`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectAtri0_7_12(@Param("username")String username);
				
				@Select("select avg(`tri3`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectAtri3_7_12(@Param("username")String username);
				
				@Select("select avg(`tri12`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and aspirin<=12 and aspirin>7 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectAtri12_7_12(@Param("username")String username);
				
				//--------------------------tri warfarin 1-3
				
				@Select("select avg(`tri0`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and warfarin<=3 and warfarin>=1 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null")
				Double selectWtri0_1_3(@Param("username")String username);
				
				@Select("select avg(`tri3`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and warfarin<=3 and warfarin>=1 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null")
				Double selectWtri3_1_3(@Param("username")String username);
				
				//---------------------------tri warfarin 3-7
				
				@Select("select avg(`tri0`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectWtri0_3_7(@Param("username")String username);
				
				@Select("select avg(`tri3`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectWtri3_3_7(@Param("username")String username);
				
				@Select("select avg(`tri12`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and warfarin<=7 and warfarin>3 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectWtri12_3_7(@Param("username")String username);
				
				//--------------------------tri warfarin 7-12
				
				@Select("select avg(`tri0`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectWtri0_7_12(@Param("username")String username);
				
				@Select("select avg(`tri3`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectWtri3_7_12(@Param("username")String username);
				
				@Select("select avg(`tri12`)from drugusage natural join patient natural join stroke_lab"
						+ " where ifhavedisease = true and warfarin<=12 and warfarin>7 and source=#{username}"
						+ "and tri0 is not null and tri3 is not null and tri12 is not null")
				Double selectWtri12_7_12(@Param("username")String username);
				
				//--------------------------tri clopidogrel 1-3
				
					@Select("select avg(`tri0`)from drugusage natural join patient natural join stroke_lab"
							+ " where ifhavedisease = true and clopidogrel<=3 and clopidogrel>=1 and source=#{username}"
							+ "and tri0 is not null and tri3 is not null")
					Double selectCtri0_1_3(@Param("username")String username);
					
					@Select("select avg(`tri3`)from drugusage natural join patient natural join stroke_lab"
							+ " where ifhavedisease = true and clopidogrel<=3 and clopidogrel>=1 and source=#{username}"
							+ "and tri0 is not null and tri3 is not null")
					Double selectCtri3_1_3(@Param("username")String username);
					
					//---------------------------tri clopidogrel 3-7
					
					@Select("select avg(`tri0`)from drugusage natural join patient natural join stroke_lab"
							+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
							+ "and tri0 is not null and tri3 is not null and tri12 is not null")
					Double selectCtri0_3_7(@Param("username")String username);
					
					@Select("select avg(`tri3`)from drugusage natural join patient natural join stroke_lab"
							+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
							+ "and tri0 is not null and tri3 is not null and tri12 is not null")
					Double selectCtri3_3_7(@Param("username")String username);
					
					@Select("select avg(`tri12`)from drugusage natural join patient natural join stroke_lab"
							+ " where ifhavedisease = true and clopidogrel<=7 and clopidogrel>3 and source=#{username}"
							+ "and tri0 is not null and tri3 is not null and tri12 is not null")
					Double selectCtri12_3_7(@Param("username")String username);
					
					//--------------------------tri clopidogrel 7-12
					
					@Select("select avg(`tri0`)from drugusage natural join patient natural join stroke_lab"
							+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
							+ "and tri0 is not null and tri3 is not null and tri12 is not null")
					Double selectCtri0_7_12(@Param("username")String username);
					
					@Select("select avg(`tri3`)from drugusage natural join patient natural join stroke_lab"
							+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
							+ "and tri0 is not null and tri3 is not null and tri12 is not null")
					Double selectCtri3_7_12(@Param("username")String username);
					
					@Select("select avg(`tri12`)from drugusage natural join patient natural join stroke_lab"
							+ " where ifhavedisease = true and clopidogrel<=12 and clopidogrel>7 and source=#{username}"
							+ "and tri0 is not null and tri3 is not null and tri12 is not null")
					Double selectCtri12_7_12(@Param("username")String username);
	
	
	
	
	
	
}
