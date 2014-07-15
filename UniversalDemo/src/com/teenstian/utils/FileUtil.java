package com.teenstian.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;


public class FileUtil {

	//Save FilePath
	public static File saveSDCardFolder(String filePathName) {
		File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/LJRFOXStudio/UniversalDemo/" + filePathName + "/");
		return file;
	}
	
	//Get File
	public static String getSDCardFile(String filePathName, String fileName)
	{
		File file = new File(saveSDCardFolder(filePathName), fileName);
		return file.getAbsolutePath();
	}
	
	//isExist File 
	public static boolean isFileExist(String filePathName, String fileName) {
		File file = new File(saveSDCardFolder(filePathName), fileName);
		return file.exists();
	}
	
	
	// ��SD���д����ļ���,�����ļ�,���洢�ļ�(�ֽ���)
	public static void saveFile2SD(Context context, byte[] fileByte, String strFilePathName, String strFileName) throws IOException {
		// �����ļ���
		File filePath = saveSDCardFolder(strFilePathName);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}

		//  �����ļ�
		String file = filePath.getAbsolutePath() + File.separator + strFileName;
		File f = new File(file);
		if (!f.exists()) {
			f.createNewFile();
		}

		// �ֽ������ �ļ�д��SD��
		FileOutputStream fos = new FileOutputStream(f);
		// �ֽ���
		InputStream inStream = new ByteArrayInputStream(fileByte);
		// �ַ���
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream, "gb2312")); //��ֹ���ĳ�������  gb2312 
		// FileInputStream fis = (FileInputStream)inStream;

		System.out.println("fileSave.length---->" + fileByte.length);
		long max = fileByte.length;

		try {
			byte[] buffer = new byte[1024];
			int length = 0;

			while (true) {
				//InputStream �ֽ���
				int temp = inStream.read(buffer, 0, buffer.length);
				if (temp == -1) {
					break;
				}
				fos.write(buffer, 0, temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
				fos.close();

				String strDownloadFilePath = getSDCardFile(strFilePathName, strFileName);
				Toast.makeText(context, "�ļ��ѱ�����: " + strDownloadFilePath, Toast.LENGTH_LONG).show();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	} // -end of _method saveFile2SD()_ by LJ.
	
	public static void createFile2SD(Context context, String strFilePathName, String strFileName) throws IOException {
		//�����ļ���
		File filePath = saveSDCardFolder(strFilePathName);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}

		// �����ļ�
		String file = filePath.getAbsolutePath() + File.separator + strFileName;
		File f = new File(file);
		if (!f.exists()) {
			f.createNewFile();
		}
	}
	
}




