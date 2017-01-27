package in.beinginnovative.beinginnovativetutorials;

import android.app.Application;
import android.util.Log;

import com.google.firebase.crash.FirebaseCrash;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Global extends Application {

    private static Global global;
    public static LinkedHashMap<String,String> crashData;

    @Override
    public void onCreate() {
        super.onCreate();
        global=this;

        crashData=new LinkedHashMap<>();

            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                Log.e("MSG","EXCEPTION");
                FirebaseCrash.report(paramThrowable);

                //   paramThrowable.printStackTrace();
             //   System.exit(3);
            }
        });
    }

    public static Global getInstance()
    {
        return global;
    }

    public  static void sendReport(Exception e)
    {
        FirebaseCrash.logcat(Log.ERROR,"DATA",crashData.toString());
        FirebaseCrash.report(e);
    }







}
