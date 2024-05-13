package master.ccm.m2.master1_001;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MonService extends Service {
    public MonService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         super.onStartCommand(intent, flags, startId);

         Runnable task = new Runnable() {
             @Override
             public void run() {
                 for (int i = 0; i < 30; i++) {
                     Log.i("Log numéro " , Integer.toString(i) + "s");
                     try {
                         TimeUnit.SECONDS.sleep(1); // Attendre 1 seconde
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 stopSelf(); // Arrêter le service après 30 logs
             }
         };

        new Thread(task).start();

         return START_STICKY;
    }
}
