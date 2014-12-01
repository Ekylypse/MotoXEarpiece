package com.dillavouws.motoxearpiece;

/**
 * Created by Anthony on 11/21/2014.
 */

        import android.app.Service;
        import android.content.Context;
        import android.content.Intent;
        import android.media.AudioManager;
        import android.os.IBinder;
        import android.telephony.PhoneStateListener;
        import android.telephony.TelephonyManager;
        import android.widget.Toast;


public class SpeakerFix extends Service{


    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
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
                        Toast.makeText(getApplicationContext(), "+Speaker",
                                Toast.LENGTH_LONG).show();
                        audioManager.setSpeakerphoneOn(false);
                        Toast.makeText(getApplicationContext(), "-Speaker",
                                Toast.LENGTH_LONG).show();

                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    // CALL_STATE_RINGING
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    public void onDestroy() {
    }
}