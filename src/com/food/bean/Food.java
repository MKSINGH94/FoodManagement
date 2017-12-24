package com.food.bean;
import javax.validation.constraints.NotNull;

public class Food {
@NotNull	
private String foodName;

@NotNull
private float foodPrice;

public String getFoodName() {
	return foodName;
}
public void setFoodName(String foodName) {
	this.foodName = foodName;
}
public float getFoodPrice() {
	return foodPrice;
}
public void setFoodPrice(float foodPrice) {
	this.foodPrice = foodPrice;
}
}
