#!/bin/bash

# Diretório do repo
mkdir -p bradesco-hbtn-java/log/0

# Criação do arquivo VerificacaoLogin.java
cat << 'EOF' > bradesco-hbtn-java/log/0/VerificacaoLogin.java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerificacaoLogin {

    // Inicialização do logger
    private static final Logger logger = LoggerFactory.getLogger(VerificacaoLogin.class);

    public static void main(String[] args) {
        // Simulação de entradas do usuário
        String usuarioCorreto = "admin";
        String senhaCorreta = "12345";

        // Tentativas de login
        realizarLogin("admin", "12345", usuarioCorreto, senhaCorreta); // Login correto
        realizarLogin("admin", "senhaErrada", usuarioCorreto, senhaCorreta); // Senha incorreta
        realizarLogin("usuarioDesconhecido", "12345", usuarioCorreto, senhaCorreta); // Usuário desconhecido
    }

    public static void realizarLogin(String usuario, String senha, String usuarioCorreto, String senhaCorreta) {
        logger.info("Tentativa de login com o usuário: {}", usuario);

        if (!usuario.equals(usuarioCorreto)) {
            logger.warn("Usuário {} não encontrado!", usuario);
            return;
        }

        if (senha.equals(senhaCorreta)) {
            logger.info("Login bem-sucedido para o usuário: {}", usuario);
        } else {
            logger.error("Senha incorreta para o usuário: {}", usuario);
        }
    }
}
EOF

echo "Arquivo VerificacaoLogin.java criado com sucesso em bradesco-hbtn-java/log/0/"