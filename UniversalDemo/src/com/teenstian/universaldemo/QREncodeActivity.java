package com.teenstian.universaldemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.teenstian.utils.FileUtil;

public class QREncodeActivity extends Activity {

	private EditText qrEdit;
	private Button qrButtonShow;
	private Button qrButtonSave;
	private ImageView qrImage;
	private Bitmap qrCodeBitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qr_encode);

		qrEdit = (EditText) this.findViewById(R.id.qr_encode_edit);
		qrButtonShow = (Button) this.findViewById(R.id.qr_encode_button);
		qrImage = (ImageView) this.findViewById(R.id.qr_encode_image_show);
		qrButtonSave = (Button) this.findViewById(R.id.qr_encode_image_save);

		qrButtonShow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String strQR = qrEdit.getText().toString();
				if("".equalsIgnoreCase(strQR.trim())) {
					Toast.makeText(QREncodeActivity.this, "请输入", Toast.LENGTH_SHORT).show();
					return;
				}
				else {
					try {
						qrCodeBitmap = EncodingHandler.createQRCode(strQR, 350);
					} catch (WriterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					qrImage.setImageBitmap(qrCodeBitmap);
				}
			}
		});

		qrButtonSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault()) ; 
				String datetime = dateformat.format(new Date()) ;
				saveBitmap(datetime, qrCodeBitmap);
			}
		});
	}

	public void saveBitmap(String fileName, Bitmap mBitmap) {
		
		// 创建文件夹
		File filePath = FileUtil.saveSDCardFolder("QRCode");
		if (!filePath.exists()) {
			filePath.mkdirs();
		}

		//  创建文件
		String StrFile = filePath.getAbsolutePath() + File.separator + fileName + ".png";
		File file = new File(StrFile);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileOutputStream fileOutput = null;
		try {
			fileOutput = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		mBitmap.compress(Bitmap.CompressFormat.PNG, 30, fileOutput);

		try {
			fileOutput.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileOutput.close();
			
			String strDownloadFilePath = FileUtil.getSDCardFile(filePath.getAbsolutePath(), fileName + ".jpg");
			Toast.makeText(QREncodeActivity.this, "文件已保存至: " + strDownloadFilePath, Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
