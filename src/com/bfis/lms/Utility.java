package com.bfis.lms;

import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;


public class Utility {
	public static int[] getScreenSize() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int[] size = { width, height };
		return size;

	}
	public static void setLocationOnCenter(Component f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth = f.getSize().width;
		f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 2);

	}
	public static Font changeFontSize(Font f, int i) {
		return new Font(f.getName(), f.getStyle(), f.getSize() + i);
	}

	
}
