package com.example.luara.agendaluaraapplication.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.luara.agendaluaraapplication.R;
import com.example.luara.agendaluaraapplication.interfac.AdicionatContato;
import com.example.luara.agendaluaraapplication.model.Pessoa;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdicionarContatoFragment extends Fragment {
    // chamar atributo da interface de listener (boa pratica)
    private AdicionatContato listener;


    public AdicionarContatoFragment() {
        // Required empty public constructor
    }


    // implementar onAttach
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof AdicionatContato){
            listener = (AdicionatContato) context;
        }else{
            throw new ClassCastException("Activity não implementa AdicionarContato");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // nao esquecer de trocar o return por view
        View view = inflater.inflate(R.layout.fragment_adicionar_contato, container, false);

        // instanciar o Botao cadastrar
        Button buttonCadastar = view.findViewById(R.id.btnCadastrar);
        // nao sei pq a variavel e final ?????
        final TextInputEditText editTextNome = view.findViewById(R.id.editNome);
        final TextInputEditText editTextTelefone = view.findViewById(R.id.editTelefone);


        // criar setOnClickListener para escutar o click do botao cadastrar e realizar uma acao
        buttonCadastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // usar metodo criarContato
                criarContato(editTextNome,editTextTelefone);

            }
        });
        return view;
    }
    private void criarContato(TextInputEditText editNome, TextInputEditText editTelefone) {
        Pessoa contato = new Pessoa();
        // preciso converter para string para conseguir passar o nome e telefone
        contato.setNome(editNome.getEditableText().toString());
        contato.setNumeroTel(editTelefone.getEditableText().toString());


        //obs lembre que o listener e a interface AdicionarContato
        listener.criarContatoAcao(contato);

    }

}
