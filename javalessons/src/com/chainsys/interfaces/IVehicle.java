package com.chainsys.interfaces;

public interface IVehicle {
	//Constant
	public final int MAXSPEED=150;
	abstract void echo();
	abstract void start();
	abstract void move();
	abstract void stop();

}