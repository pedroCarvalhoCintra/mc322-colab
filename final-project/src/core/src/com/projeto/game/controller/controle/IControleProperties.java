package com.projeto.game.controller.controle;

import com.projeto.game.controller.construtor.gui.IFactoryGui;
import com.projeto.game.model.cidade.ICidade;

public interface IControleProperties {
    public ICidade getCidade();
    public IFactoryGui getFactoryGui();
}
