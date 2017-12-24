package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.bean.Food;
import com.food.bean.User;
import com.food.factory.ConnectionFactory;

public class FoodDAO {
private static final String SAVE_FOOD_DETAIL="insert into food_detail values(?,?)";
private static final String GET_FOOD_DETAIL="select * from food_detail";
private static final String CHECK_USER_CREDENTIAL="SELECT  count(*) FROM user_detail WHERE email_name = ? and password= ?";
private static final String CREATE_USER_ACCOUNT="INSERT INTO user_detail(email_name, password) VALUES (?, ?) " ;
PreparedStatement pst=null;
Connection con=null;

public  int signupUser(User user) throws SQLException{
	con=ConnectionFactory.getConnection();
	pst=con.prepareStatement(CREATE_USER_ACCOUNT);
	pst.setString(1,user.getEmail_name());
	pst.setString(2,user.getPassword());
	int count=pst.executeUpdate();
	return count;
}
public int saveFood(Food food) throws SQLException{

	 con=ConnectionFactory.getConnection();
   pst=con.prepareStatement(SAVE_FOOD_DETAIL);
	pst.setString(1, food.getFoodName());
	pst.setFloat(2, food.getFoodPrice());
	int count=pst.executeUpdate();
    return count;
}

public List<Food> getFoodDetails() throws SQLException{
	con=ConnectionFactory.getConnection();
	List<Food> foodList=new ArrayList<Food>();
	   pst=con.prepareStatement(GET_FOOD_DETAIL);
	   ResultSet rs=pst.executeQuery();
	   Food food=null;
	   while(rs.next()){
		   food=new Food();
		   food.setFoodName(rs.getString("food_name"));
		  food.setFoodPrice(rs.getFloat("food_price"));
		  foodList.add(food);
	   }
	   return foodList;
}
public int checkUserCredential(User user) throws SQLException{
	con=ConnectionFactory.getConnection();
	
	   pst=con.prepareStatement(CHECK_USER_CREDENTIAL);
	   pst.setString(1, user.getEmail_name());
		pst.setString(2, user.getPassword());
		
		ResultSet rs=pst.executeQuery();
	
	int count=0;
      
		if(rs.next())
		{
			count=rs.getInt(1);
		}
		
		return count;
	
}
}
