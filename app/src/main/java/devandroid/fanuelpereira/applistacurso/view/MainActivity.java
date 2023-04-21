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

    SharedPreferences srdPreferences;
    public static final String NOME_PREFERENCES = "pref_listavip";

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

        srdPreferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = srdPreferences.edit();

        pessoaController = new PessoaController();
        pessoaController.toString();

        pessoa = new Pessoa();

        //constrói o objeto baseado no conteúdo presente no arquivo listaVip
        pessoa.setPrimeiroNome(srdPreferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(srdPreferences.getString("sobrenome",""));
        pessoa.setCursoDesejado(srdPreferences.getString("cursoDesejado",""));
        pessoa.setTelefoneContato(srdPreferences.getString("telefoneContato",""));

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

                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("sobrenome", pessoa.getSobreNome());
                listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
                listaVip.putString("telefoneContato", pessoa.getTelefoneContato());

                listaVip.apply();;

                pessoaController.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", "Objeto Pessoa" + pessoa.toString());
    }
}