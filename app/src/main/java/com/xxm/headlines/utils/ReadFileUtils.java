package com.xxm.headlines.utils;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 读取文件工具类
 */
public class ReadFileUtils {

	/**
	 * 读取json文件内容
	 * @param dirFile json文件目录
	 * @return
	 */
	public static String readJsonFile(String dirFile) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		try {
			fileReader = new FileReader(dirFile);
			bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				stringBuilder.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		line = stringBuilder.toString();
		// System.out.println(line);
		return line;
	}

}
