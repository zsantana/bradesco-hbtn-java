
public class PersonagemGame {
        private int saudeAtual;
        private String nome;
        private String status;

        public PersonagemGame(){
              this.status = "morto"; 
        }

        public PersonagemGame(int saudeAtual, String nome){
                this.status = "vivo"; 
                this.saudeAtual = saudeAtual;
                this.nome = nome;
        }

        public void tomarDano ( int quantidadeDeDano){
                this.saudeAtual -= quantidadeDeDano;
                if (this.saudeAtual < 0) this.saudeAtual = 0;
                atualizarStatus();
        }

        public void receberCura (int quantidadeDeCura){
                this.saudeAtual += quantidadeDeCura;
                if (this.saudeAtual > 100) this.saudeAtual = 100;
                atualizarStatus();
        }

        private void atualizarStatus() {
                this.status = this.saudeAtual == 0 ? "morto" : "vivo";
        }

        public String getStatus() {
                return status;
        }
        
        public int getSaudeAtual() {
                return saudeAtual;
        }

        public void setSaudeAtual(int saudeAtual) {
                this.saudeAtual = saudeAtual;
        }
        
        public String getNome() {
                return nome;
        }
        public void setNome(String nome) {
                if (nome != null && !nome.isBlank()) {
                         this.nome = nome;
                }
        }

}
    
