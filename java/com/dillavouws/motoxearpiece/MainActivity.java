package com.dillavouws.motoxearpiece;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.media.AudioManager;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		TelephonyMgr.listen(new TeleListener(),
				PhoneStateListener.LISTEN_CALL_STATE);
	}

	class TeleListener extends PhoneStateListener {
        AudioManager audioManager = (AudioManager)
                getSystemService(Context.AUDIO_SERVICE);
		public void onCallStateChanged(int state, String incomingNumber) {
			super.onCallStateChanged(state, incomingNumber);
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				// CALL_STATE_IDLE;
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				// CALL_STATE_OFFHOOK,
                //Activate loudspeaker
                audioManager.setSpeakerphoneOn(true);
                audioManager.setSpeakerphoneOn(false);
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				// CALL_STATE_RINGING
				break;
			default:
				break;
			}
		}

	}
}