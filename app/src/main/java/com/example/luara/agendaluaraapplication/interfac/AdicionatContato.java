package com.example.luara.agendaluaraapplication.interfac;

import com.example.luara.agendaluaraapplication.model.Pessoa;

public interface AdicionatContato {
    // a interface para passar informacao do fragment para activity
    // a interface e implementada na MainActivity e e atributo do fragment
    public void criarContatoAcao(Pessoa pessoa);
}
