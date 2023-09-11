//1. Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo compactado a ser criado e (2) uma pasta. Compactar todos os arquivos e subpastas em um arquivo compactado com extensão zip.

public class Ex1 {
        try (
                FileInputStream fis = new FileInputStream(infile);
                ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("test.zip"));
        ) {
            int bytesRead;
            byte[] buffer = new byte[1024];
            ZipEntry entry = new ZipEntry("data");
            entry.setSize(infile.length());

            zos.putNextEntry(entry);
            while ((bytesRead = fis.read(buffer)) >= 0)
            {
                zos.write(buffer, 0, bytesRead);
            }
            zos.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                ZipInputStream zis = new ZipInputStream(new BufferedInputStream(
                        new FileInputStream(new File("test.zip"))));
        ) {
            ZipEntry entry = zis.getNextEntry();
            System.out.println("Entry size: " + entry.getSize());
            zis.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
