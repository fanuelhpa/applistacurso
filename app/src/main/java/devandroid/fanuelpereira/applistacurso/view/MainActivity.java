package devandroid.fanuelpereira.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.fanuelpereira.applistacurso.R;
import devandroid.fanuelpereira.applistacurso.controller.PessoaController;
import devandroid.fanuelpereira.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController pessoaController;

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

        pessoaController = new PessoaController(MainActivity.this);
        pessoaController.toString();

        pessoa = new Pessoa();
        pessoaController.buscarDados(pessoa);

        //linka os campos da view para o objeto edtTxt
        edtTxtPrimeiroNome = findViewById(R.id.edtTxtPrimeiroNome);
        edtTxtSobrenome = findViewById(R.id.edtTxtSobrenome);
        edtTxtCursoDesejado = findViewById(R.id.edtTxtCursoDesejado);
        edtTxtTelefoneContato = findViewById(R.id.edtTxtTelefoneContato);

        //Preenche os campos com o conteúdo do objeto pessoa
        edtTxtPrimeiroNome.setText(pessoa.getPrimeiroNome());
        edtTxtSobrenome.setText(pessoa.getSobreNome());
        edtTxtCursoDesejado.setText(pessoa.getCursoDesejado());
        edtTxtTelefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtTxtPrimeiroNome.setText("");
                edtTxtSobrenome.setText("");
                edtTxtCursoDesejado.setText("");
                edtTxtTelefoneContato.setText("");
                pessoaController.limparDados();
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

                pessoaController.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", "Objeto Pessoa" + pessoa.toString());
    }
}