package misao.loginprojectwithsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button bt_login;
    EditText et_username;
    EditText et_upassword;
    TextView registerlink;
    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt_login = (Button)findViewById(R.id.logIn);
        et_username = (EditText)findViewById(R.id.userName);
        et_upassword = (EditText)findViewById(R.id.password);
        registerlink = (TextView)findViewById(R.id.register);

        bt_login.setOnClickListener(this);
        registerlink.setOnClickListener(this);

        helper= new DatabaseHelper(Login.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.logIn:

                if(helper.getData(et_username.getText().toString(),et_upassword.getText().toString())!=null) {
                    if (helper.getData(et_username.getText().toString(), et_upassword.getText().toString()).contentEquals("success")){
                        Intent i = new Intent(Login.this, Home.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }}
                else{
                    Toast.makeText(getApplicationContext(),"Username or password is incorrect",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.register:
                Intent i = new Intent(Login.this,Register.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;
        }
    }
}
