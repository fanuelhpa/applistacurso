package devandroid.fanuelpereira.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    int mark = 0;
    }
}