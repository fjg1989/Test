package com.example.lifego;

import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.media.UMImage;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final UMSocialService mController = UMServiceFactory
				.getUMSocialService("com.umeng.share");
		// ���÷�������
		mController.setShareContent("���ˣ�http://www.umeng.com/social");
		// ���÷���ͼƬ, ����2ΪͼƬ��url��ַ
		mController.setShareMedia(new UMImage(this,
				"http://www.umeng.com/images/pic/banner_module_social.png"));
		mController.getConfig().removePlatform(SHARE_MEDIA.RENREN);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mController.openShare(MainActivity.this, false);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
