package com.soe.pizzadelivery.presentation;

import javax.swing.JFrame;

public class OrderViewer extends JFrame {

	
	public static void main(String[] args){
		
		JFrame frame = new JFrame("Pizza Order");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 350, 350);
		
		frame.add(new OrderUI());
		
		frame.setVisible(true);
	}
}
