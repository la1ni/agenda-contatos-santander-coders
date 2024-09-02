package service.agenda_contatos;

import exception.ContatoNaoEncontradoException;
import exception.NaoExistemContatosException;
import exception.TelefoneJaExistenteException;
import model.Contato;

public class AgendaContatosService {

    private static Contato[] contatos;

    public Contato[] criarContato(Contato contato)  throws Exception{
        try {
            int tamanhoAgenda = checarTamanho();
            consultarNumeroExistente(contato.getTelefone());
            Contato[] contatosAtualizados = new Contato[tamanhoAgenda+1];
            contatosAtualizados = copiarContatos(contatos, contatosAtualizados);
            contatosAtualizados[contatos.length] = contato;
            contatos = contatosAtualizados;
            return contatos;
        } catch (NaoExistemContatosException exception){
            contatos = new Contato[1];
            contatos[0] = contato;
            return contatos;
        } catch (Exception e){
            throw e;
        }
    }

    private Contato[] copiarContatos(Contato [] contatos, Contato[] novosContatos){
        for (int i = 0; i < contatos.length; i++){
            novosContatos[i] = contatos[i];
        }
        return novosContatos;
    }

    public Contato[] getContatos() {return contatos;}

    public void consultarNumeroExistente(String telefone) throws Exception {
        try {
            for (Contato contato : contatos) {
                if (contato.getTelefone().equals(telefone)) {
                    throw new TelefoneJaExistenteException();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public int checarTamanho() throws NaoExistemContatosException {
        if (getContatos() == null){
            throw new NaoExistemContatosException();
        }
        return contatos.length;}



    public int indiceDeContatosPorTelefone(String telefone) throws ContatoNaoEncontradoException, NaoExistemContatosException {
        int indice = -1;
        try {
            int tamanho = this.checarTamanho();
            for (int i = 0; i < tamanho; i++){
                if (telefone.equals(contatos[i].getTelefone())) {
                    indice = i;
                    break;
                }
            }
            if (indice == -1){
                throw new ContatoNaoEncontradoException();
            }
            return indice;
        } catch (Exception e) {
            throw e;
        }
    }

    public Contato detalharContato(String telefone) throws Exception {
        try {
            int indice = indiceDeContatosPorTelefone(telefone);
            return contatos[indice];
        } catch (Exception e){
            throw e;
        }
    }

    public Contato[] removerContato(String telefone) throws Exception {
        try {
            int tamanhoAgenda = checarTamanho();
            int indice = indiceDeContatosPorTelefone(telefone);

            Contato[] contatosAtualizados = new Contato[tamanhoAgenda - 1];

            for (int i = 0, j = 0; i < contatos.length; i++) {
                if (i != indice) {
                    contatosAtualizados[j++] = contatos[i];
                }
            }

            contatos = contatosAtualizados.length > 0 ? contatosAtualizados : null;
            return contatos;
        } catch (NaoExistemContatosException | ContatoNaoEncontradoException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Erro ao remover o contato: " + e.getMessage());
        }
    }

    public AgendaContatosService() {
    }
}

