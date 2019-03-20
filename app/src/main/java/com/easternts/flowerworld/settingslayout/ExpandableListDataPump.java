package com.easternts.flowerworld.settingslayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
	public static HashMap<String, List<String>> getData()
	{
		HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

		List<String> faq2 = new ArrayList<String>();
		faq2.add("No, the size of the app is comparatively less and it can be easily installed.");

		List<String> faq3 = new ArrayList<String>();
		faq3.add("No, you can access the application without doing any kind of registration or login.");

		List<String> faq4 = new ArrayList<String>();
		faq4.add("There are 13 different types of flower  and each category contains approximatley 10 sub-flowers.");
		List<String> faq7 = new ArrayList<String>();
		faq7.add("FlowerWorld app is the android application where you can consume information about flower in india.\nChildren here can easily learn, play and explore.\nFor their attraction and entertainment it provides  QuizActivity.\n Application is of great fun packaged with knowledge for children.");
		List<String> faq9 = new ArrayList<String>();
		faq9.add("No, you can play quiz without gaining or losing points and marks.");
		List<String> faq10 = new ArrayList<String>();
		faq10.add("No, the quiz won\'t stop.Child can proceed to next question.");
		List<String> faq11 = new ArrayList<String>();
		faq11.add("Select settings of application and checkmark notification providing custom ringtone and duration.");
		List<String> faq12 = new ArrayList<String>();
		faq12.add("The child mark its unfavourite flower by clicking on heart and that can be later viewed in the application\'s unfavourite block.");
		List<String> faq13 = new ArrayList<String>();
		faq13.add("Yes. To do this,simply uncheck the notification checkbox.");
		List<String> faq16 = new ArrayList<String>();
		faq16.add("Application provides 2 ways to get information about the flower.\n1.	Through Play Quiz.\n2.	Through the click on flower image from layout, By clik that user can view the provides detailed description about flower.");


		expandableListDetail.put("Is this application very big or memory consuming?", faq2);
		expandableListDetail.put("Is any type of registration required to enter into this application?",
						faq3);
		expandableListDetail.put(
				"How many types of flower does this app contains?", faq4);
		expandableListDetail.put("What is FlowerWorld all about?", faq7);
		expandableListDetail.put("Does the quiz contains any credits?", faq9);
		expandableListDetail.put(
				"If answer to the quiz is incorrect then will the game stop?",
				faq10);
		expandableListDetail.put("How can user set the notification?", faq11);
		expandableListDetail
				.put("How can a child check its unfavourite flower?",
						faq12);
		expandableListDetail
				.put("If once notification has been set then is it possible to stop it?",
						faq13);
		expandableListDetail
				.put("If child wants to get information about flower then is it possible to get it through the application?",
						faq16);

		return expandableListDetail;
	}
}
