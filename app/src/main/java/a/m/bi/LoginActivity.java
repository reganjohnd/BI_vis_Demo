 package a.m.bi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.content.Intent;

 public class LoginActivity extends AppCompatActivity {

     CheckBox showpassword;

    private EditText Password;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Password = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.button);
        showpassword = findViewById(R.id.showpassword);

        showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if (b)
                {
                    Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Validate(Password.getText().toString());
            }
        });
    }

    private void Validate(String userPassword)
    {
        if(userPassword.equals("am2020"))
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
