package com.food.service;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.food.bean.Food;
import com.food.bean.User;
import com.food.dao.FoodDAO;
import com.food.factory.DAOFactory;
import com.food.util.JsonUtil;

@Path("/food")
public class FoodService {
	@Path("/signup")
	@POST
	@Produces("text/html")
	@Consumes(MediaType.APPLICATION_JSON)
	public String signupUser(String jsonUser) throws NumberFormatException,SQLException,JsonParseException,JsonMappingException,IOException
	{
		int count=0;
		User user=null;
		FoodDAO foodDAO=null;
		foodDAO=DAOFactory.getFoodDAO();
		if(jsonUser!=null){
		user=JsonUtil.convertJsonToJava(jsonUser, User.class);
       }
	  // user.setEmail_name(user.getEmail_name());
	   //user.setPassword(user.getPassword());
	   count=foodDAO.signupUser(user);
	   if(count>0)
		   return "User Account created succesfully";
	  else
		 return "User Account Not created" ;
	}
	@Path("/save")
	@POST
	@Produces("text/html")
	
	@Consumes(MediaType.APPLICATION_JSON)
	public String saveFood(String jsonFood ) throws NumberFormatException,SQLException,JsonParseException,JsonMappingException,IOException
	{
		//String temp;
		int count=0;
		Food food=null;
		FoodDAO foodDAO=null;
		foodDAO=DAOFactory.getFoodDAO();
		if(jsonFood!=null){
		food=JsonUtil.convertJsonToJava(jsonFood, Food.class);	
		}
		//food=new Food();
		//food.setFoodName(food.getFoodName());
		//food.setFoodPrice(food.getFoodPrice());
		//foodDAO=DAOFactory.getFoodDAO();
		count=foodDAO.saveFood(food);
	
	if(count>0)
		return "Food Detail Saved successfully";
	else
		return "Food Detail not Saved ,Server Internal Problem";
	}
	
@Path("/getFoodDetail")
@GET
@Produces("application/json")
public List<Food> getFoodDetail() throws SQLException
{
	FoodDAO foodDAO=null;
	foodDAO=DAOFactory.getFoodDAO();
	List <Food> foodList=foodDAO.getFoodDetails();
	return foodList;
	
}
@Path("/checkUserCredential")
@POST
@Produces("text/html")
@Consumes(MediaType.APPLICATION_JSON)
public String checkUserCredential(String jsonUser) throws NumberFormatException, SQLException, JsonParseException, JsonMappingException, IOException
{
	User user=null;
	FoodDAO foodDAO=null;
	foodDAO=DAOFactory.getFoodDAO();
	if(jsonUser!=null)
	user=JsonUtil.convertJsonToJava(jsonUser, User.class);
	int count=foodDAO.checkUserCredential(user);
	if(count>0)
		return "valid";
	else 
		return "invalid";
	
	
}
}
