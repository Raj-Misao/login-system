package misao.loginprojectwithsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener{

    Button bt_register;
    EditText et_name;
    EditText et_email;
    EditText et_phone;
    EditText et_pass;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bt_register = (Button)findViewById(R.id.reg);
        et_name = (EditText)findViewById(R.id.uName);
        et_email = (EditText)findViewById(R.id.uEmail);
        et_phone = (EditText)findViewById(R.id.uNumber);
        et_pass = (EditText)findViewById(R.id.uPass);
        helper=new DatabaseHelper(Register.this);
        bt_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.reg:
                String name = et_name.getText().toString();
                String email = et_email.getText().toString();
                String number = et_phone.getText().toString();
                String password = et_pass.getText().toString();

                if(name.contentEquals("") && password.contentEquals("")) {
                    // Toast.makeText()
                }
                else{
                    helper.insert(name,email,number,password);
                    startActivity(new Intent(this,Login.class));
                }

                break;
        }
    }
}
