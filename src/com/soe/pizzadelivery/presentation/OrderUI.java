package com.soe.pizzadelivery.presentation;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class OrderUI extends JComponent{

	private ArrayList<JCheckBox> checkboxes;
	private JPanel CHPanel;
	
	private ArrayList<JRadioButton> RadioButtons;
	private ButtonGroup RBGroup;
	private JPanel RBPanel;
	
	private ArrayList<JTextField> TextFields;
	
	private ActionListener listener;
	
	
	public OrderUI(){
		this.setLayout(new BorderLayout());
		
		this.checkboxes = new ArrayList<JCheckBox>();
		this.CHPanel = new JPanel();
		this.CHPanel.setLayout(new GridLayout(3,0));
		this.CHPanel.setBounds(200, 20, 150, 100);
		
		this.RadioButtons = new ArrayList<JRadioButton>();
		this.RBGroup = new ButtonGroup();
		this.RBPanel = new JPanel();
		this.RBPanel.setLayout(new GridLayout(3,0));
		this.RBPanel.setBounds(20, 20, 150, 100);
		
		this.TextFields = new ArrayList<JTextField>();
		
		class OrderListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				setOrderOptions();
			}
		}
		
		this.listener =  new OrderListener();
		
		
		this.createOrderUI();
		
	}

	private void addCheckbox(String text){
		JCheckBox checkbox = new JCheckBox(text);
		checkbox.addActionListener(listener);
		checkboxes.add(checkbox);
	}
	
	private void addRadioButton(String text){
		JRadioButton radio = new JRadioButton(text);
		radio.addActionListener(listener);
		RadioButtons.add(radio);
		RBGroup.add(radio);
	}
	
	private void createTextBox(){
		JTextField text = new  JTextField();
		text.addActionListener(listener);
		TextFields.add(text);		
	}
	
	public void setOrderOptions(){
		Iterator<JCheckBox> checkIterator = checkboxes.iterator();
		while (checkIterator.hasNext()){
			JCheckBox box = checkIterator.next();
			if(box.isSelected())
				System.out.println(box.getText()+" is selected");
		}
		
		Iterator<JRadioButton> radioIterator = RadioButtons.iterator();
		while (radioIterator.hasNext()){
			JRadioButton radio = radioIterator.next();
			if(radio.isSelected())
				System.out.println(radio.getText()+" is selected");
		}
		
		Iterator<JTextField> textIterator = TextFields.iterator();
		while (textIterator.hasNext()){
			System.out.println(textIterator.next().getText());
		}
	}
	
	
	public void createOrderUI(){
		
		
		this.addCheckbox("Pepperoni");
		this.addCheckbox("Anchovies");
		this.addCheckbox("Salame");
		
		Iterator<JCheckBox> checkIterator = checkboxes.iterator();
		
		while(checkIterator.hasNext())
			CHPanel.add(checkIterator.next());
		this.add(CHPanel, BorderLayout.EAST);
	
		this.addRadioButton("small");
		this.addRadioButton("medium");
		this.addRadioButton("big");
		
		Iterator<JRadioButton> radioIterator = RadioButtons.iterator();
		
		while(radioIterator.hasNext())
			RBPanel.add(radioIterator.next());
		this.add(RBPanel, BorderLayout.WEST);
		
		this.createTextBox();
		
		Iterator<JTextField> textIterator = TextFields.iterator();
		
		while(textIterator.hasNext())
			this.add(textIterator.next(), BorderLayout.SOUTH);
	}
	
	
}
