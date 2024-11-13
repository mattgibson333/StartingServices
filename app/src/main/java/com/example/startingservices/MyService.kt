import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {



    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}