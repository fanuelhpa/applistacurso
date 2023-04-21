package devandroid.fanuelpereira.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.fanuelpereira.applistacurso.R;
import devandroid.fanuelpereira.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    EditText edtTxtPrimeiroNome;
    EditText edtTxtSobrenome;
    EditText edtTxtCursoDesejado;
    EditText edtTxtTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();

        pessoa.setPrimeiroNome("Fanuel");
        pessoa.setSobreNome("Pereira");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("(31) 99248-6568");

        edtTxtPrimeiroNome = findViewById(R.id.edtTxtPrimeiroNome);
        edtTxtSobrenome = findViewById(R.id.edtTxtSobrenome);
        edtTxtCursoDesejado = findViewById(R.id.edtTxtCursoDesejado);
        edtTxtTelefoneContato = findViewById(R.id.edtTxtTelefoneContato);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        edtTxtPrimeiroNome.setText(pessoa.getPrimeiroNome());
        edtTxtSobrenome.setText(pessoa.getSobreNome());
        edtTxtTelefoneContato.setText(pessoa.getTelefoneContato());
        edtTxtCursoDesejado.setText(pessoa.getCursoDesejado());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtTxtPrimeiroNome.setText("");
                edtTxtSobrenome.setText("");
                edtTxtCursoDesejado.setText("");
                edtTxtTelefoneContato.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(edtTxtPrimeiroNome.getText().toString());
                pessoa.setSobreNome(edtTxtSobrenome.getText().toString());
                pessoa.setCursoDesejado(edtTxtCursoDesejado.getText().toString());
                pessoa.setTelefoneContato(edtTxtTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Log.i("POOAndroid", "Objeto Pessoa" + pessoa.toString());
    }
}