// Lucas Hideaki Tsuzuku 04251090

package school.sptech;

public class Gincana {
    private String nome;
    private Double premio;
    private Integer qtdInscrito = 0;
    private Boolean ativa = true;

    public Gincana(String nome, Double premio) {
        this.nome = nome;
        this.premio = premio;
    }

    public String getNome() {
        return nome;
    }

    public Double getPremio() {
        return premio;
    }

    public Integer getQtdInscrito() {
        return qtdInscrito;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void inscrever(Integer qtd){
        if (qtd == null || qtd <= 0 || ativa == false){
            return;
        } else {
            System.out.println("Pessoas adicionadas: " + qtd);
         qtdInscrito = qtdInscrito + qtd;
        }
    }

    public Integer remover(Integer qtd){
        if (qtd == null || qtd <= 0 || ativa == false || qtd > qtdInscrito ){
            return null;
        } else {
            qtdInscrito = qtdInscrito - qtd;
            System.out.println("Pessoas removidas: " + qtd);
            System.out.println("Quantidade pessoas sobraram: " + qtdInscrito);
            return qtd;
        }
    }

    public Integer desativar(){
        if (ativa == false){
            return null;
        } else {
            Integer quantosHaviamGincana = qtdInscrito;
            qtdInscrito = 0;
            ativa = false;
            System.out.println("Quantidades de pessoas que estavam na gincana: " + quantosHaviamGincana);
            System.out.println("Quantidades de pessoas agora que desativou: " + qtdInscrito);
            return quantosHaviamGincana;
        }
    }

    public void transferir(Gincana destino, Integer qtdATransferir){

        if(destino == null) {
            return;
        }

        if (destino.ativa == false ||
            destino.getNome() == null ||
            qtdATransferir == null ||
            qtdATransferir <= 0 ||
            qtdATransferir > qtdInscrito ||
            ativa == false ){
            return;
        } else {
            System.out.println("Realizando a transferência ...");
            System.out.println("Quantidade de pessoa na gincana de origem: " + qtdInscrito);
            System.out.println("Quantidade de pessoa na gincana de destino: " + destino.qtdInscrito);
            qtdInscrito = qtdInscrito - qtdATransferir;
            destino.qtdInscrito = destino.qtdInscrito + qtdATransferir;
            System.out.println("Transferência concluída, quantidade de pessoa na gincana de origem: " + qtdInscrito);
            System.out.println("Transferência concluída, quantidade de pessoa na gincana de destino: " + destino.qtdInscrito);
        }
    }

    public Boolean reajustarPremio(Double reajuste){
        if(reajuste == null) {
            return false;
        }

        if(reajuste <= 0){
            return false;
        } else {
            System.out.println("Fazendo reajuste de " + reajuste);
            System.out.println("Prêmio inicial: R$" + premio);
            premio = premio * (1 + reajuste);
            System.out.println("Prêmio após reajuste: R$" + premio);
            return true;
        }
    }

}
