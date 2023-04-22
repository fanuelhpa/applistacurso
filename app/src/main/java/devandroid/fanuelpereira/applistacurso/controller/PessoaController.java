package devandroid.fanuelpereira.applistacurso.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import devandroid.fanuelpereira.applistacurso.model.Pessoa;

public class PessoaController {

    Context context;

    private SharedPreferences sharedPreferences;

    public static final String NOME_PREFERENCES = "pref_listavip";

    private SharedPreferences.Editor listaVip;

    public PessoaController(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = sharedPreferences.edit();
    }

    public void salvar(Pessoa pessoa) {

        Log.i("MVC_Controller", "Salvo: " + pessoa.toString());

        //constrói o objeto baseado no conteúdo presente no arquivo listaVip
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobreNome());
        listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());

        listaVip.apply();;

        Toast.makeText(context, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();
    }

    public Pessoa buscarDados(Pessoa pessoa){

        pessoa.setPrimeiroNome(sharedPreferences.getString("primeiroNome","NA"));
        pessoa.setSobreNome(sharedPreferences.getString("sobrenome", "NA"));
        pessoa.setCursoDesejado(sharedPreferences.getString("cursoDesejado", "NA"));
        pessoa.setTelefoneContato(sharedPreferences.getString("telefoneContato", "NA"));

        return pessoa;
    }

    public void limparDados(){
        listaVip.clear();
        listaVip.apply();
    }

}
