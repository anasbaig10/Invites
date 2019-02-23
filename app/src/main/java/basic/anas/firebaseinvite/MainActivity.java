package basic.anas.firebaseinvite;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appinvite.AppInviteInvitation;

import static com.google.android.gms.appinvite.AppInviteInvitation.getInvitationIds;

public class MainActivity extends AppCompatActivity {
    private static final int Request_Code = 100 ;
    private Button invite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        invite =(Button)findViewById(R.id.invite);
    }

    public void buclick(View view) {
     sendinvite();
    }

    public void sendinvite(){
            Intent intent =new AppInviteInvitation.IntentBuilder("WERP")
                    .setMessage("COME AND JOIN WERP AND MAKE A DIFFERENCE IN SOCIETY" )
                    .setDeepLink(Uri.parse("http://google.com"))
                    .setCallToActionText("invitation cta")
                    .build();
       startActivityForResult(intent, Request_Code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode== Request_Code)
        {

            if(resultCode == RESULT_OK)
            {
                String[] ids = AppInviteInvitation.getInvitationIds(resultCode, data);
                for(String id : ids )
                   System.out.println("MainActivity.onActivityResult"+id);
            }

        }
    }
}
