package in.beinginnovative.beinginnovativetutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.crash.FirebaseCrash;


public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2;
    String s;
    Global global;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcmcrash_report);

        global=Global.getInstance();

        Button button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i=33;
                try {
                    s = null;
                    s.trim();
                    global.crashData.put("I=",i+"");
                }
                catch (Exception e)
                {

                    global.crashData.put("buttonNull",s+"");
                    global.sendReport(e);
                    /*FirebaseCrash.logcat(Log.ERROR,"TAG",s+"");
                    FirebaseCrash.report(e);*/
                }

            }
        });
    }
}
