package COMP5703.cp20.group2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import COMP5703.cp20.group2.domain.patient;
import COMP5703.cp20.group2.domain.user;

@Mapper
public interface userMapper {
	
	//check if this user has been registered
	@Select("select username from user where binary username=#{username}")
	String checkexistence(String username);
	
	//check if the username corresponds to the password
	@Select("select username from user where binary username =#{username} "
			+ "and binary user_password=#{password}")
	String checkpassword(@Param("username")String username, @Param("password")String password);
	
	//check if the user has patient in database
	@Select("select count(patientid) from patient where source=#{username}")
	int checkpatientnumber(String username);
	
	
	//insert the user into database after successful registeration
	@Insert("insert into user(username,user_password, firstname, lastname, emailadress)"
			+ " values (#{username}, #{user_password},#{firstname},#{lastname},#{emailadress})")
	void insertuser(user user);
	
	





}
