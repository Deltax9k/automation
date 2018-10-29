package org.xlb.automation.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class ImageUtil {
	public static BufferedImage createElementImage(WebElement webElement,
			TakesScreenshot driver) throws IOException {
		// ���webElement��λ�úʹ�С��
		Point location = webElement.getLocation();
		Dimension size = webElement.getSize();
		// ����ȫ����ͼ��
		BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(
				takeScreenshot(driver)));
		// ��ȡwebElement����λ�õ���ͼ��
		BufferedImage croppedImage = originalImage.getSubimage(location.getX(),
				location.getY(), size.getWidth(), size.getHeight());
		return croppedImage;
	}

	private static byte[] takeScreenshot(TakesScreenshot driver) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		return takesScreenshot.getScreenshotAs(OutputType.BYTES);
	}
}
