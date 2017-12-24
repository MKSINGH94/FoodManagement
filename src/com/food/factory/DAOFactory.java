package com.food.factory;

import com.food.dao.FoodDAO;

public class DAOFactory {
private static FoodDAO foodDAO;
static{
	foodDAO=new FoodDAO();
}
public static FoodDAO getFoodDAO(){
	return foodDAO;
}

}
