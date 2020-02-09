package com.org.panthers.business;

import java.util.ArrayList;
import java.util.List;

import com.org.panthers.entity.doQuestionFavorite;
import com.org.panthers.framework.busBase;

public class busQuestionFavorite extends busBase{

	public doQuestionFavorite idoQuestionFavorite;

	public busQuestionFavorite() {

		idoQuestionFavorite = new doQuestionFavorite();
	}
	
	public List<busQuestionFavorite> getCollection(List<doQuestionFavorite> alstQuestionFavorites) {

		List<busQuestionFavorite> llstbusQuestionFavorites = new ArrayList<busQuestionFavorite>();

		for (doQuestionFavorite lQuestionFavorite : alstQuestionFavorites) {

			busQuestionFavorite lbusQuestionFavorite = new busQuestionFavorite();
			lbusQuestionFavorite.idoQuestionFavorite = lQuestionFavorite;
			llstbusQuestionFavorites.add(lbusQuestionFavorite);

		}
		return llstbusQuestionFavorites;
	}
}
