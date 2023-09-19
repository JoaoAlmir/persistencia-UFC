import java.io.*;
import java.security.*;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

//4. Crie uma aplicação em Java que recebe via linha de comando o nome de um arquivo para geração/armazenamento dos hashes  md5, sha1 e sha256 do arquivo especificado. A aplicação deve mostrar o tempo de execução de cada uma dessas operações. Dica: veja o seguinte tutorial: MD5 Hashing in Java | Baeldung



public class Ex4 {
    MessageDigest.getInstance(String Algorithm)

    public void update(byte [] input)

    public byte[] digest()

    public byte[] digest()

    @Test
    public void givenPassword_whenHashing_thenVerifying()
            throws NoSuchAlgorithmException {
        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();

        assertThat(myHash.equals(hash)).isTrue();
    }

    @Test
    public void givenPassword_whenHashingUsingCommons_thenVerifying() {
        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";

        String md5Hex = DigestUtils
                .md5Hex(password).toUpperCase();

        assertThat(md5Hex.equals(hash)).isTrue();
    }
}
