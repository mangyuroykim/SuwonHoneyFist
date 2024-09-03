package org.SuwonHoneyFist.day12.collection.music.model;

public class DescTitle implements Comparator<Music>{
	
	@Override
	public int compare(Music o1, Music o2) {
		return o1.getTitle().compareTo(o2.getTitle()) * -1 ;
		
	}

}
